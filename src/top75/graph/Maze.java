package graph;

import java.io.*;
import java.util.*;
import java.text.*;
import java.math.*;
import java.util.regex.*;

/*
Write a function solveMaze() that 
1. gets a new maze
2. solves the maze with any valid path from the START position at the TOP LEFT square to the END position at the BOTTOM RIGHT square
3. submits any correct solution (I.e. any collection of valid coordinates that goes sequentially from START to END)

int[][] maze1 = new int[][] {
   START->{1, 1, 1, 0, 0},
          {1, 1, 0, 1, 1},
          {1, 0, 1, 0, 1},
          {1, 1, 1, 1, 1},
          {1, 0, 1, 1, 0},
          {1, 1, 1, 0, 1},
          {1, 0, 1, 1, 1},->END\
}

boolean[][] visited = new boolean[][] 

boolean isMaze(int[][] grid, int row, int col) {
    if (visited[i][j])
    
}

1 - represents a valid square
0 - represents an obstacle

The START position is TOP LEFT (0,0) square and the END position is the BOTTOM RIGHT square.
You can move in the 4 cardinals directions - TOP, LEFT, BOTTH and RIGHT. Diagonal Moves are NOT allowed


You are provided access to a Helper interface with the following methods

public interface MazeHelper {

1. MazeInfo getNewMaze();
class MazeInfo {
    String mazeId;
    int height;
    int width;
} 
//NOTE that this does not return the maze array

2. boolean isValidPosition(String mazeId, int row, int column); 
// returns true if coordinate is a valid position

3. boolean checkMazeSolution(String mazeId, int [][] mazePathSolution); 
// returns true if mazePathSolution which is any valid set of coordinates leading from
// START position to END position
}

*/

public class Maze {

    public static void main(String args[] ) throws Exception {
    // Call Solve Maze here
    
    }
    
    /*Write a function solveMaze() that 
1. gets a new maze
2. solves the maze with any valid path from the START position at the TOP LEFT square to the END position at the BOTTOM RIGHT square
3. submits any correct solution (I.e. any collection of valid coordinates that goes sequentially from START to END)*/

    /*... solveMaze(...) {
    }*/
   
    
    public static class MazeInfo {
        String mazeId;
        int height;
        int width;
        
        public MazeInfo(String mazeId, int height, int width) {
            this.mazeId = mazeId; this.height = height; this.width = width; 
        }
    }

    // Use this interface MazeHelper to solve the problem
    public interface MazeHelper {
        MazeInfo getNewMaze();
        
        boolean isValidPosition(String mazeId, int row, int column) throws Exception;
        
        boolean checkMazeSolution(String mazeId, int[][] mazePathSolution) throws Exception;
    }

    // Assume that the following implementation is CORRECT and NOT visible to you
    public static class MazeHelperImpl implements MazeHelper {
        private static int[][] maze = new int[][] {
                                    {1, 1, 1, 0, 0},
                                    {1, 1, 0, 1, 1},
                                    {1, 0, 1, 0, 1},
                                    {1, 1, 1, 1, 1},
                                    {1, 0, 1, 1, 0},
                                    {1, 1, 1, 0, 1},
                                    {1, 0, 1, 1, 1},
                                };
        
        @Override
        public MazeInfo getNewMaze() {
            return new MazeInfo("foo", maze.length, maze[0].length);
        }
    
        @Override
        public boolean isValidPosition(String mazeId, int row, int column) throws Exception {
            if (!mazeId.equals("foo")) {
                throw new Exception("MazeId not found");
            }
            if (row >= 0 && row < maze.length && column >=0 && column < maze[0].length) {
                return maze[row][column] == 1;
            }
            return false;
        }
    
        
        @Override
        public boolean checkMazeSolution(String mazeId, int[][] mazePathSolution) throws Exception {
            if (!mazeId.equals("foo")) {
                throw new Exception("MazeId not found");
            }

            if (mazePathSolution[0].length != 2) {
                System.out.println("Invalid maze path solution format");
                return false;
            }
            
            //Check start coordinate
            if (mazePathSolution[0][0] != 0 || mazePathSolution[0][1] != 0) {
                System.out.println("Invalid start position");
                return false;
            }
            
            //Check end coordinate
            if ((mazePathSolution[mazePathSolution.length-1][0] != maze.length -1) || (mazePathSolution[mazePathSolution.length-1][1] != maze[0].length -1)) {
                System.out.println("Invalid end position");
                return false;
            }

            for (int currentPos = 1; currentPos < mazePathSolution.length; currentPos++) {
                int previousPos = currentPos - 1;
                if (!isValidPosition(mazeId, mazePathSolution[currentPos][0], mazePathSolution[currentPos][1])) {
                    System.out.println("Invalid position " + mazePathSolution[currentPos][0] + "," + mazePathSolution[currentPos][1]);
                    return false;
                }
                if ((Math.abs(mazePathSolution[currentPos][0] - mazePathSolution[previousPos][0]) + 
                        Math.abs(mazePathSolution[currentPos][1] - mazePathSolution[previousPos][1])) != 1) {
                    System.out.println("Invalid neighbor " + mazePathSolution[currentPos][0] + "," + mazePathSolution[currentPos][1] + " to " 
                        + mazePathSolution[previousPos][0] + "," + mazePathSolution[previousPos][1]);
                    return false;
                }
            }

            return true;
        }
    } 
}