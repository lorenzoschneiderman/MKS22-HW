// KnightBoard.java

class KnightBoard{
	
	public static int dimX, dimY;
	public static boolean solved;
	public static String solution;

	KnightBoard(int x, int y){
		dimX = x;	
		dimY = y;
		solved = false;
		solution = "not solved yet";
	}
	
	public static void main(String[] args) {
		KnightBoard a = new KnightBoard(7, 7);
		a.solve();
		System.out.println(solution);
	}

	public String toString(){
		if (solved){
			return solution;
		}
	return "not solved";
	}

	public static void solve(){
		int rowsY = dimY;
		int colsX = dimX;
		int[][] board = new int[rowsY][colsX];
		for (int row = 0; row < board.length; row++){
			for (int col = 0; col < board[row].length; col++){
				board[row][col] = 0;
			}
		}
		passBoolean(board, 0, 0, 1);
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
			// System.out.println(arrayToString(board));
			// solution = arrayToString(board);
			solution = arrayToString(addKnight(board, row, col, step));
			return true;
		}
		return( passBoolean( addKnight(board , row, col, step),  row + 1,  col + 2, step + 1) ||
				passBoolean( addKnight(board , row, col, step),  row + 1,  col - 2, step + 1) ||
				passBoolean( addKnight(board , row, col, step),  row + 2,  col + 1, step + 1) ||
				passBoolean( addKnight(board , row, col, step),  row + 2,  col - 1, step + 1) ||
				passBoolean( addKnight(board , row, col, step),  row - 1,  col + 2, step + 1) ||
				passBoolean( addKnight(board , row, col, step),  row - 1,  col - 2, step + 1) ||
				passBoolean( addKnight(board , row, col, step),  row - 2,  col + 1, step + 1) ||
				passBoolean( addKnight(board , row, col, step),  row - 2,  col - 1, step + 1));
		
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