import java.io.BufferedReader;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.util.Scanner;

/* Author: Timothy Bender
 * Nov 18, 2019
 * CSCI: 132 - Data Structures and Algorithms
*/

public class SolveMaze {
	private String filename;
	private int[] size;
	private int[] position;
	private char[][] maze;
	
	SolveMaze() throws IOException{
		filename = "maze1.txt"; 				//filename
		this.size = this.measureMaze();  		//gets an array containing the size of the maze
		this.maze = new char[size[0]][size[1]]; // creates the maze array of appropriate size
		this.constructArray(size, filename); 	//fills the character maze array with appropriate characters
		this.position = this.getStartPos(maze, size); //finds the starting coordinates and starting hand coordinates
		this.solveMaze(maze,position[0],position[1],position[2],position[3]); //finally we call solvemaze and let it work
	}
	
	public void solveMaze(char[][] maze, int xLoc, int yLoc, int handLocationX, int handLocationY) {
		//base case, if we are on top of the finish 
		if(maze[xLoc][yLoc] == 'F') {
			maze[xLoc][yLoc] = 'O';
			System.out.println("Maze solved!!!!");
			this.printMaze();
	    	return;
	    }

		else {
			maze[xLoc][yLoc] = 'O';
			
			int sleepDuration =700; //change this to speed up/slow down the program
									//if  set to zero, only the solution will be printed out
			try {
		    	Thread.sleep(sleepDuration);
		    } catch (InterruptedException e) {
		    	e.printStackTrace();
		    }
			if(sleepDuration != 0) {
				//System.out.println("XPos: " + xLoc);
				//System.out.println("YPos: " + yLoc);
				//System.out.println("HandX: " + handLocationX);
				//System.out.println("HandY: " + handLocationY);
				this.printMaze();
			}
			
			//'.' 'x' 'F' are all universally acceptable spots to move.
			
			//facing right
			try {
				if (handLocationY > yLoc) {
					//turn out of maze Protection
					if(handLocationY == size[1]-1 && (maze[handLocationX][handLocationY] == '.' || maze[handLocationX][handLocationY] == 'x' || maze[handLocationX][handLocationY] == 'F')) {		    
		    			solveMaze(maze,xLoc,yLoc,handLocationX,handLocationY-2);	
					}
				    //if your hand is on a . x or F turn right.
					else if(maze[handLocationX][handLocationY] == '.' || maze[handLocationX][handLocationY] == 'x' || maze[handLocationX][handLocationY] == 'F') {
				   		maze[xLoc][yLoc] = 'x';
				   		solveMaze(maze,xLoc,yLoc+1,handLocationX-1,handLocationY);
				   	}//if your hand is on a wall, and a . x or F is in front of you, move forward
				   	else if((maze[xLoc + 1][yLoc] == '.' || maze[xLoc+1][yLoc] == 'x'|| maze[handLocationX][handLocationY] == 'F') && maze[handLocationX][handLocationY] == '#') { //if facing right and spot in front is open, move forward.
			    		maze[xLoc][yLoc] = 'x';
			    		solveMaze(maze,xLoc+1,yLoc,handLocationX+1,handLocationY);
			    	} //if there is a wall in front of you, and your hand is on a wall turn
				   	else if(maze[xLoc+1][yLoc] == '#' && maze[handLocationX][handLocationY] == '#') {
				   		solveMaze(maze,xLoc,yLoc,handLocationX+1,handLocationY-1);
				   	}
			   }
					    
			    //facing left	
			    else if(handLocationY < yLoc) {
			    	//turning out of the maze protection here.... //if its about to turn onto the edge of the maze, it will turn around 
			    	if(handLocationY == 0 && (maze[handLocationX][handLocationY] == '.' || maze[handLocationX][handLocationY] == 'x' || maze[handLocationX][handLocationY] == 'F')) {		    
			    			solveMaze(maze,xLoc,yLoc,handLocationX,handLocationY+2);	
			    	}
			    	else if(maze[handLocationX][handLocationY] == '.' || maze[handLocationX][handLocationY] == 'x' || maze[handLocationX][handLocationY] == 'F') { 
			    		maze[xLoc][yLoc] = 'x';
			    		solveMaze(maze,xLoc,yLoc-1,handLocationX+1,handLocationY);
			    	}
			    	//if facing left, and your hand is on a wall, and theres a spot open in front of you, move forward
			    	else if((maze[xLoc-1][yLoc] == '.' || maze[xLoc-1][yLoc] == 'x' || maze[xLoc-1][yLoc] == 'F') && maze[handLocationX][handLocationY] == '#') {
			    		maze[xLoc][yLoc] = 'x';
			    		solveMaze(maze,xLoc-1,yLoc,handLocationX-1,handLocationY);
			    		}
			    	//if you hit a wall turn right
			    	else if(maze[xLoc -1][yLoc] == '#' && maze[handLocationX][handLocationY] == '#') {
			    		solveMaze(maze,xLoc,yLoc,handLocationX-1,handLocationY+1);
			    		}
			    	}
			    
			    //facing up
			    else if(xLoc < handLocationX) {
			    	//if you are about to run out of the array, turn around
			    	if(handLocationX == size[0]-1 && (maze[handLocationX][handLocationY] == '.' || maze[handLocationX][handLocationY] == 'x' || maze[handLocationX][handLocationY] == 'F')) {		    
		    			solveMaze(maze,xLoc,yLoc,handLocationX-2,handLocationY);	
			    	}
			    	else if(maze[handLocationX][handLocationY] == '.' || maze[handLocationX][handLocationY] == 'x' || maze[handLocationX][handLocationY] == 'F') {
			    		maze[xLoc][yLoc] = 'x';
			    		solveMaze(maze,xLoc+1,yLoc,handLocationX,handLocationY+1);
			    	}
			    	//if you can move forward, then do so
			    	else if((maze[xLoc][yLoc-1] == '.' || maze[xLoc][yLoc-1] == 'x' || maze[xLoc][yLoc-1] == 'F') && maze[handLocationX][handLocationY] == '#') {
			    		maze[xLoc][yLoc] = 'x';
			    		solveMaze(maze,xLoc,yLoc-1,handLocationX,handLocationY-1);
			    	}
			    	//if you run into a  corner turn left
			    	else if(maze[xLoc][yLoc-1] == '#' && maze[handLocationX][handLocationY] == '#') {
			    		solveMaze(maze,xLoc,yLoc,handLocationX-1,handLocationY-1);
			    	}
			    	
			    }
			    
			    //facing down
			    else if(xLoc > handLocationX) {
			    	//turn out of maze protection
			    	if(handLocationX == 0 && (maze[handLocationX][handLocationY] == '.' || maze[handLocationX][handLocationY] == 'x' || maze[handLocationX][handLocationY] == 'F')) {		    
		    			solveMaze(maze,xLoc,yLoc,handLocationX+2,handLocationY);	
			    	}
			    	//if you can turn right, do so
			    	if(maze[handLocationX][handLocationY] == '.' || maze[handLocationX][handLocationY] == 'x' || maze[handLocationX][handLocationY] == 'F') {
			    		maze[xLoc][yLoc] = 'x';
			    		solveMaze(maze,xLoc-1,yLoc,handLocationX,handLocationY-1);
			    	}
			    	//if you can move forward do so
			    	else if((maze[xLoc][yLoc +1] == '.' || maze[xLoc][yLoc+1] == 'x' || maze[xLoc][yLoc+1] == 'F' || maze[xLoc][yLoc+1] == 'F') && maze[handLocationX][handLocationY] == '#') {
			    		maze[xLoc][yLoc] = 'x';
			    		solveMaze(maze,xLoc,yLoc+1,handLocationX,handLocationY+1);
			    	}
			    	//if you run into a wall, and must turn right, do so.
			    	else if(maze[xLoc][yLoc + 1] == '#' && maze[handLocationX][handLocationY] == '#') {
			    		solveMaze(maze,xLoc,yLoc,handLocationX+1,handLocationY+1);
			    		}
			    	}  
			    	
			    }
			catch (ArrayIndexOutOfBoundsException exception){
				System.out.println("Array Index Out of Bounds Failure");
				return;
				}
			}   
	}
		//static method to print the maze
	public void printMaze() {
		try {
			for(int y = 0; y < size[1];y++) {
				for(int x = 0; x < size[0];x++) {
					System.out.print(maze[x][y]);
					System.out.print(" ");
					if(x == size[0] - 1)
						System.out.print("\n");
				}
			}
			System.out.println("\n");
		} 
		catch(ArrayIndexOutOfBoundsException exception) {
			System.out.println("Array index out of bounds error");
		}
	}
	//will return the starting position, and starting hand position in an int array
	public int[] getStartPos(char[][] maze,int[] size) {
		int[] start = new int[4];
		for(int y = 0; y < size[1];y++) {
			for(int x = 0; x < size[0];x++) {
				if(y == 0) {
					if(maze[x][y] == '.') {
						start[0] = x;
						start[1] = y;
						start[2] = x-1;
						start[3] = y;
					}
				}
				else if(y == size[1]-1) {
					if(maze[x][y] == '.') {
						start[0] = x;
						start[1] = y;
						start[2] = x+1;
						start[3] = y;
					}
				}
				else if(x == 0) {
					if(maze[x][y] == '.') {
						start[0] = x;
						start[1] = y;
						start[2] = x;
						start[3] = y+1;
					}
				}
				else if(x == size[0]-1) {
					if(maze[x][y] == '.') {
						start[0] = x;
						start[1] = y;
						start[2] = x;
						start[3] = y-1;
					}
				}
			}
		}
		return start;
	}
	
	//this method will iterate through the input file and determine the dimensions of the maze
	public int[] measureMaze() throws IOException{
		BufferedReader reader = new BufferedReader(new FileReader(this.filename));
		int[] lines = new int[2];
		lines[1] = 1; 
		lines[0] = (reader.readLine().replaceAll(" ", "")).length();
		while (reader.readLine() != null) {
		    lines[1]++;
		}
		reader.close();
		return lines;
	}
	
	//this method will fill the character array
	public void constructArray(int[] size,String filename) throws FileNotFoundException {
		Scanner sc = new Scanner(new File(filename));
		for (int y = 0; y < this.size[1]; y++) {
		    String line = sc.nextLine().replaceAll(" ", "");
		    for (int x = 0; x < this.size[0]; x++) {
		        this.maze[x][y] = line.charAt(x);
		    	
		    }
		}

	}
}
