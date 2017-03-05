import java.util.*;
import java.io.*;

public class Maze {

  
    
  private char[][] maze;
  private boolean animate;

  public static void main(String[]args){
    Maze maze = new Maze("data3.dat");//true animates the maze.  
    maze.setAnimate(true);
    maze.solve();
    System.out.println(maze);
  }

  public Maze(String filename){
    animate = false;
    try{
      File file = new File(filename);
      Scanner in = new Scanner(file);
      int rows = 1, cols = in.nextLine().length();
      while (in.hasNextLine()){
	      in.nextLine();
        rows++;
      }
      maze = new char[ rows ][ cols ];
      in = new Scanner( file );
      int upTo = 0;
      while ( in.hasNextLine() ) {
        String line = in.nextLine();
        char[] charArray = line.toCharArray();
        maze[ upTo ] = charArray;
        upTo++;
      }
    }
    catch (Exception e) {
    }  
  }            

  public void setAnimate(boolean b) {
    animate = b;
  }

  public void clearTerminal() {
    System.out.println("\033[2J\033[1;1H");
  }
  public boolean solve(){
    int[] startLocation = initializeStart();
    maze[ startLocation[0] ][ startLocation[1] ] = ' ';
    return solve( startLocation[0],startLocation[1]);
  }

  private int[] initializeStart(){
	for (int r = 0; r < maze.length; r++) {
	    for (int c = 0; c < maze[r].length; c++) {
		    if (maze[r][c] == 'S') {
		      int[] startLocation = new int[2];
		      startLocation[0] = r;
		      startLocation[1] = c;
		      return startLocation;
        }
	    }
    }
	int[] nothing = {-1,-1};
	return nothing;
  }

  private boolean solve(int row, int col){
    if(animate){
      System.out.println("\033[2J\033[1;1H"+this);
      wait(20);
    }
    if (maze[row][col] == 'E'){
      return true;
    }
    if ( canwalk( row, col )) {
	    maze[ row ][ col ] = '@';
      int[][] posibilities = { { 0,1 }, { 0,-1 }, { 1,0 }, { -1,0 } };
	    for (int[] move : posibilities) {
		    if ( solve( row + move[0], col + move[1] )) {
          return true;
		    }
	    }
	    maze[ row ][ col ] = '.';
    }
    return false;
  }

  private boolean canwalk(int row, int col) {
    return maze[ row ][ col ] == ' ' || 
           maze[ row ][ col ] == 'S' || 
           maze[ row ][ col ] == 'E';
  }

  private void wait(int millis){ //ADDED SORRY!
    try {
      Thread.sleep(millis);
    }
    catch (InterruptedException e){}
  }

  public String toString(){
    String o = "";
      for (char[] row : maze) {
        for (char e : row)
          o += e;
          o += "\n";
      }
    return o;
  }

}