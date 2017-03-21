import java.util.Scanner;
import java.io.File;
import java.io.FileNotFoundException;

public class USACO{

	private int[][] land;
	private int startx, starty, endx, endy, seconds;
	
	public int[][] elevations;
	
	public USACO(){
		
	}
	public int silver(String filename){
		importFile(filename);

		int[][] sols = solutions(land, seconds);
		return sols[endx][endy];
	}

	public int bronze(String filename){
		return stomp(filename);


	}
	public static void main(String[] args) {
		USACO x = new USACO(); //does not have to do anything. 
		System.out.println(x.silver("ctravel.in"));
		System.out.println(x.bronze("file.txt"));
	}
	public void importFile(String filename){

		File f = new File(filename);
		Scanner s = null;
		try{
		    s = new Scanner(f);
		}catch (FileNotFoundException e){
		    System.out.println("file not found");
		}

		int ro = s.nextInt();
		int co = s.nextInt();

		seconds = s.nextInt();

		land = new int[ro][co];

		String next = s.nextLine();
		
		for(int i = 0; i < ro; i++){
		    String l = s.nextLine();
		    for(int in = 0; in < l.length(); in++){
				if(l.charAt(in) == '.'){
			    	land[i][in] = 0;
				}else{
			    	land[i][in] = -1;
				}
		    }
		}
		startx = s.nextInt()-1;
		starty = s.nextInt()-1;
		endx = s.nextInt()-1;
		endy = s.nextInt()-1;


		land[startx][starty] = 1;
	}
	public static int[][] solutions( int[][] map , int steps){
		int[][] out = new int[map.length][map[0].length];
		int count = 0;

		while (count < steps){
			for (int row = 0; row < map.length; row ++){
				for (int col = 0; col < map[0].length; col++){
					if (map[row][col] == -1){
					}
					else {
						for (int i = 0; i < map[row][col]; i++){
							out = addAdjacent(out, row, col);
						}
					}
				}
			}
			count += 1;
			map = out;
		}

		return out;
	}

	public static int[][] addAdjacent(int[][] in, int addRow, int addCol){

		int[][] copyIn = new int[in.length][in[0].length];
		for (int row = 0; row < in.length; row++){
			for (int col = 0; col < in[row].length; col ++ ){
				copyIn[row][col] = in[row][col];
			}
		}

		if (addRow + 1 >= 0 && addRow + 1 < in.length){
			if (in[addRow + 1][addCol] == -1){
			}
			else{
				copyIn[addRow + 1][addCol] += 1;
			}
		} 
		if (addRow - 1 >= 0 && addRow - 1 < in.length){
			if (in[addRow - 1][addCol] == -1){
			}
			else{
				copyIn[addRow - 1][addCol] += 1;
			}
		} 
		if (addCol + 1 >= 0 && addCol + 1 < in[0].length){
			if (in[addRow][addCol + 1] == -1){
			}
			else{
				copyIn[addRow][addCol + 1] += 1;
			}
		} 
		if (addCol - 1 >= 0 && addCol - 1 < in[0].length){
			if (in[addRow][addCol - 1] == -1){
			}
			else{

				copyIn[addRow][addCol - 1] += 1;
			}
		}

		return copyIn;
	}

	public int stomp(String filename){

		// File f = new File(filename);
		// Scanner s = null;
		// try{
		//     s = new Scanner(f);
		// }catch (FileNotFoundException e){
		//     System.out.println("file not found");
		// }

	
	File f = new File(filename);
	Scanner s = null;
	try{
		s = new Scanner(f);
	}catch (FileNotFoundException e){
		System.out.println("file not found");
	}
	
	int ro = s.nextInt();
	int co = s.nextInt();
	elevations = new int[ro][co];
	int el = s.nextInt();
    int nc = s.nextInt();

    for(int r = 0; r < elevations.length; r++){
		for (int c = 0; c < elevations[r].length; c++){
			elevations[r][c] = s.nextInt();
		}
	}
	
	for (int z = 0; z <= nc; z++){
	    while(s.hasNextInt()){
		stomp(s.nextInt(), s.nextInt(), s.nextInt());
		}
	}
	for (int i = 0; i < elevations.length; i++){
	    for (int x = 0; x < elevations[i].length; x++){
		if(elevations[i][x] >= el){
		    elevations[i][x] = 0;
		}else{
		    elevations[i][x] = el - elevations[i][x];
		}
	    }
	}
	int vol = 0;
	for(int r = 0; r < elevations.length; r++){
	    for(int c = 0; c < elevations[r].length; c++){
		vol = vol + elevations[r][c];
	    }
	}
	return vol*72*72;
    }


	public static String toString(int[][] twoDArray){
    	String o = "";
		for (int[] row : twoDArray) {
			for (int e : row){
				o += e;
				o += " ";
			}
			o += "\n";
		}
    	return o;
	}

	public void stomp(int row, int col, int depth){
		
		int biggest = 0;
		for (int findRow = row - 1; findRow < row + 2; findRow++){
			for (int findCol = col - 1; findCol < col + 2; findCol++){
				if (elevations[findRow][findCol] > biggest){
					biggest = elevations[findRow][findCol];
				}
			}	
		}
		for (int findRow = row - 1; findRow < row + 2; findRow++){
			for (int findCol = col - 1; findCol < col + 2; findCol++){
				if (elevations[findRow][findCol] > biggest - depth){
					elevations[findRow][findCol] = biggest - depth;
				}
			}
		}	
	}

	public String name(){
		return "Lorenzo Schneiderman 6";
	}

}