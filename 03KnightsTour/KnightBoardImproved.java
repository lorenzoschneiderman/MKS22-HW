// KnightBoard.java
import java.util.ArrayList;

class KnightBoardImproved{
	

	public static int dimX = 0;
	KnightBoardImproved(int x, int y){
		// implement solve dims as per instructions 

	}
	public static void main(String[] args) {
		solve(7, 7);
	}
	public String toString(){
		return "";
	}

	public static void solve(int rowsY, int colsX){
		int[][] board = new int[rowsY][colsX];
		for (int row = 0; row < board.length; row++){
			for (int col = 0; col < board[row].length; col++){
				board[row][col] = 0;
			}
		}
		System.out.println(arrayToString(board));
		System.out.println(passBoolean(board, 0, 0, 1));
		// solve then print out board
	}	

	public static boolean onAGoodSpot(int[][] board, int row, int col){
		if (row < 0 || row >= board.length){
			return false;
		}
		if (col < 0 || col >= board[row].length){
			return false;
		}
		if (board[row][col] == 0){
			return true;
		}
		else{
			return false;
		}
	}
	public static boolean passBoolean(int[][] board, int row, int col, int step){

		if (!onAGoodSpot(board, row, col)){
			return false;
		}
		if (step == board[0].length * board.length ){ // if step is final
			System.out.println(arrayToString(board));
			return true;
		}
		ArrayList<int[]> sortedCoordinates = findSortedCoors(board, row, col);
		System.out.println(sortedCoordinates.size());
		return( chainORswithThaFunctionCall(board, row, col, step, sortedCoordinates));
				// passBoolean( addKnight(board , row, col, step),  row + 1,  col + 2, step + 1) ||
				// passBoolean( addKnight(board , row, col, step),  row + 1,  col - 2, step + 1) ||
				// passBoolean( addKnight(board , row, col, step),  row + 2,  col + 1, step + 1) ||
				// passBoolean( addKnight(board , row, col, step),  row + 2,  col - 1, step + 1) ||
				// passBoolean( addKnight(board , row, col, step),  row - 1,  col + 2, step + 1) ||
				// passBoolean( addKnight(board , row, col, step),  row - 1,  col - 2, step + 1) ||
				// passBoolean( addKnight(board , row, col, step),  row - 2,  col + 1, step + 1) ||
				// passBoolean( addKnight(board , row, col, step),  row - 2,  col - 1, step + 1));
		
	}

	public static ArrayList<int[]> findSortedCoors(int[][] board, int row, int col){
		int[][] possibleMoves = {{row + 1, col + 2, numMoves(board, row + 1, col +2)},
		{row + 1, col - 2, numMoves(board, row + 1, col - 2)},
		{row + 2, col + 1, numMoves(board, row + 2, col + 1)},
		{row + 2, col - 1, numMoves(board, row + 2, col - 1)},
		{row - 1, col + 2, numMoves(board, row - 1, col + 2)},
		{row - 1, col - 2, numMoves(board, row - 1, col - 2)},
		{row - 2, col + 1, numMoves(board, row - 2, col + 1)},
		{row - 2, col - 1, numMoves(board, row - 2, col - 1)}};
		ArrayList<int[]> out = new ArrayList<int[]>();
		for (int point = 0; point < possibleMoves.length; point++){            // for every potential move
			int search = 0;
			System.out.println("star");
			while(search < out.size() + 1){
			// for(int search = 0; search < out.size() + 1 ; search++){            // for every slot made in out plus 1
				if (search >= out.size()){
					System.out.println("reached the end");
					int[] entry = {possibleMoves[point][0], possibleMoves[point][1]};
					out.add(entry);
					search = 999;
				System.out.println("reached tlmaahhood");

				}
				// System.out.println(possibleMoves[point]);
				else if( possibleMoves[point][2] < out.get(search)[2]){    // 
					int[] entry = {possibleMoves[point][0], possibleMoves[point][1]};
					out.add(search,entry);
					search = 999;
				}
				else{
					search += 1;
				}
			}
		}

		
		return out;

	}

	public static int numMoves(int[][] board, int row, int col){
		int count = 0;
		try{
		if (board[row + 1][col + 2] == 0){
			count += 1;
		}
		}catch(Exception e){
		}
		try{
		if (board[row + 1][col - 2] == 0){
			count += 1;
		}
		}catch(Exception e){
		}
		try{
		if (board[row + 2][col + 1] == 0){
			count += 1;
		}
		}catch(Exception e){
		}
		try{
		if (board[row + 2][col - 1] == 0){
			count += 1;
		}
		}catch(Exception e){
		}
		try{
		if (board[row - 1][col + 2] == 0){
			count += 1;
		}
		}catch(Exception e){
		}
		try{
		if (board[row - 1][col - 2] == 0){
			count += 1;
		}
		}catch(Exception e){
		}
		try{
		if (board[row - 2][col + 1] == 0){
			count += 1;
		}
		}catch(Exception e){
		}
		try{
		if (board[row - 2][col - 1] == 0){
			count += 1;
		}
		}catch(Exception e){
		}
		return count;
	}

	public static boolean chainORswithThaFunctionCall(int[][] board, int row, int col, int step, ArrayList<int[]> sortedCoordinates){
		for (int[] coors : sortedCoordinates){
			if (passBoolean( addKnight(board , row, col, step),  coors[0],  coors[1], step + 1)){
				return true;
			}
		}
		return false;
	}

	public static int[][] addKnight(int[][] board, int rowAdd, int colAdd, int step){
		int[][] outArray = new int[board.length][board[0].length];
		for (int row = 0; row < board.length; row++){
			for (int col = 0; col < board[row].length; col++){
				outArray[row][col] = board[row][col];
				if (row == rowAdd && col == colAdd){
					outArray[row][col] = step;
				}
			}
		}
		return outArray;
	}

	public static String arrayToString(int[][] array){
		String out = "";
		for (int row = 0; row < array.length; row++){
			for (int col = 0; col < array[row].length; col ++){
				if ( array[row][col] < 10 ){
					out += " " + array[row][col] + " ";
				}
				else{
					out += array[row][col] + " ";	
				}
			}
			out += "\n";
		}
		return out;
	}
}