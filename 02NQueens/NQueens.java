import java.util.ArrayList;

class NQueens{


	// int[][] board;
	NQueens(){
		size = 8;

	}
	NQueens(int n){
		size = n;
	}
	public static int size;
	public static boolean notDoneBefore = true;
	public static boolean printNum = false;
	public static String firstSolution = "a";
	public static int numSolutions = -1;

	public void countSolutions(){
		printNum = false;
		numSolutions = numSolutions(size);
	} 

	public int getSolutionCount(){
		return numSolutions;
	}

	public String toString(){
		return firstSolution;
	}

	public static int numSolutions(int size){
		int[][] board = new int[size][size];
		for (int row = 0; row < board.length; row++){
			for (int col = 0; col < board[row].length; col++){
				board[row][col] = 0;
			}
		}
		if (printNum){
			System.out.println(sumList(inputBoard(board, 0)));
			}
		return sumList(inputBoard(board, 0));
	}


	public static void main(String[] args) {
		NQueens n = new NQueens(10);
		n.countSolutions();
		System.out.println(n.toString());
		System.out.println(n.getSolutionCount()); // findSolutions( 8 ));

	}
	public static void solve(){
		notDoneBefore = true;
		System.out.println("number of solutions:");
	}

	public static int[] findPotentialSpots(int[][] board, int row){

		ArrayList<Integer> out = new ArrayList<Integer>();
		for (int spot = 0; spot < board[row].length; spot++){
			if (board[row][spot] == 0){
				out.add(spot);
			}
		}
		return convertIntegers(out);
	}



	public static int[] inputBoard(int[][] board, int row){
		
		int[] potentialSpots = findPotentialSpots(board, row); // implement find valid moves returns array of indicies of valids
		
		if (row == board.length - 1){ // if last row
			int[] finalize = new int[1];
			finalize[0] = potentialSpots.length; // at this point potentialSpots should also be empty
			if (potentialSpots.length >= 1){
				if (notDoneBefore){
					firstSolution = arrayToStringQ(addQueen(board, row, potentialSpots[0]));
					// System.out.println(firstSolution);
					notDoneBefore = false;
				}
				return finalize;
			}
		}
		
		if (potentialSpots.length == 0){
			int[] finalize = new int[1]; // return either empty array or zero
			finalize[0] = 0;
			return finalize;
		}
		int[] out = new int[potentialSpots.length];
		int i = 0;
		for (int column : potentialSpots){  // only do if NOT last row
			out[i] =  sumList(inputBoard(addQueen(board, row,column), row + 1));  // board.addQueen(int col) returns board with queen added at place
			i += 1;
		}
		return out;
	}
	public static String arrayToString(int[][] ary){
		String out = "";
		for (int[] row : ary){
			for (int item : row){
				out += item + ", ";
			}
			out += "\n";
		}
		return out;
	}

	public static String arrayToStringQ(int[][] ary){
		String out = "";
		String piece;
		for (int[] row : ary){
			for (int item : row){
				if (item == 1){
					piece = "_";
				}
				if (item == 2){
					piece = "Q";
				}
				else{
					piece = "_";
				}
				out += piece + " ";
			}
			out += "\n";
		}
		return out;
	}
	public static int[][] addQueen(int[][] inBoard, int rowAdd, int colAdd){
		int[][] board = aryCopy(inBoard);
		for (int row = 0; row < board.length; row++){
			for (int col = 0; col < board[row].length; col++){
				if (row == rowAdd){
					board[row][col] = 1;
				}
				if (col == colAdd){
					board[row][col] = 1;
				}
				if (row + col == rowAdd + colAdd){
					board[row][col] = 1;
				}
				// if (row - col == rowAdd + colAdd){
				// 	board[row][col] = 1;
				// }
				if (col - row == colAdd - rowAdd){
					board[row][col] = 1;
				}


				if (row == rowAdd && col == colAdd){
					board[row][col] = 2;
				}
			}
		}
		return board;
	}
	public static int[][] aryCopy(int[][] inputAry){
		int[][] out = new int[inputAry.length][inputAry[0].length];
		for (int row = 0; row < inputAry.length; row++){
			for (int col = 0; col < inputAry[row].length; col++){
				out[row][col] = inputAry[row][col];
			}
		}
		return out;
	}
	public static int sumList(int[] inputAry){
		int total = 0;
		for (int i : inputAry){
			total += i;
		}
		return total;
	}
	public static int[] convertIntegers(ArrayList<Integer> integers){
    	int[] ret = new int[integers.size()];
    	for (int i=0; i < ret.length; i++){
        	ret[i] = integers.get(i).intValue();
    	}
    	return ret;
	}
}