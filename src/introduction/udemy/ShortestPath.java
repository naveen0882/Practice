// Grid
// o | o | x | o
// x | o | o | o
// o | o | x | o
// o | o | o | o

//Starting location (0, 1)


package udemy;
import java.io.*;
import java.util.*;

public class ShortestPath {

	public static void main(String[] args) {
		int[][] test = new int[][] {{0, 0, 1, 0}, {1, 0, 0, 0}, {0, 0, 1, 0}, {0, 0, 0, 0}};
	    List<Node> result = shortestDistance(test, 0, 1);
	    for (Node n : result) {
	      System.out.println("Row: " + n.row + ", " + "Col: " + n.col + ", " + "Dist: " + n.distance);
	    }

	}
	
	static class Node {
	    int distance;
	    int row;
	    int col;
	    
	    public Node(int distance,  int row,  int col) {
	      this.distance = distance;
	      this.row = row;
	      this.col = col;
	    }
	  
	} 

	  
	public static List<Node> shortestDistance (int[][] grid, int row, int col) {
	    Queue<Node> tovisit = new LinkedList<Node>();
	    boolean[][] visited = new boolean[grid.length][grid[0].length];
	    
	    List<Node> result = new ArrayList<>();
	    
	    if (grid == null || grid.length ==0) {
	      return result;
	    }
	    
	    visited[row][col] = true;
	    tovisit.add(new Node(0, row, col));
	    
	    while(!tovisit.isEmpty()) {
	      
	      Node currentNode = tovisit.remove();
	      result.add(currentNode);
	      
	      //[(-1, 0), (1, 0), (0, -1), (0, 1)]
	      
	      	      
	      if (!(currentNode.row-1<0) && (grid[currentNode.row-1][currentNode.col]==0) && (!visited[currentNode.row-1][currentNode.col])) {
	        Node childNode = new Node(currentNode.distance+1, currentNode.row-1, currentNode.col);
	        tovisit.add(childNode);
	        visited[currentNode.row-1][currentNode.col] = true;
	      }
	      
	      if (!(currentNode.col-1<0 )&& (grid[currentNode.row][currentNode.col-1]==0) && !visited[currentNode.row][currentNode.col-1]) {
	        Node childNode = new Node(currentNode.distance+1, currentNode.row, currentNode.col-1);
	        tovisit.add(childNode);
	        visited[currentNode.row][currentNode.col-1] = true;
	      }
	      
	      if (!(currentNode.row+1>=grid.length) && grid[currentNode.row+1][currentNode.col]==0 && !visited[currentNode.row+1][currentNode.col]) {
	        Node childNode = new Node(currentNode.distance+1, currentNode.row+1, currentNode.col);
	        tovisit.add(childNode);
	        visited[currentNode.row+1][currentNode.col] = true;
	      }
	      
	      if (!(currentNode.col+1>=grid[0].length) && grid[currentNode.row][currentNode.col+1]==0 && !visited[currentNode.row][currentNode.col+1]) {
	        Node childNode = new Node(currentNode.distance+1, currentNode.row, currentNode.col+1);
	        tovisit.add(childNode);
	        visited[currentNode.row][currentNode.col+1] = true;
	      }
	    
	    }
	    
	    return result;
	  
	}
	  
	  
	public void helper(int distance, int row, int col, Queue<Node> tovisit, int[][] grid, boolean[][] visited ) {
	    if (!(row<0) && (grid[row][col]==0) && (!visited[row][col])) {
	        Node childNode = new Node(distance,row,col);
	        tovisit.add(childNode);
	        visited[row][col] = true;
	    }
	}
	  
}
