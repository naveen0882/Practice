 package udemy;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.Queue;


public class FindFriendCircles {

  public static void main(String[] args) {
	  int[][] friends = {{1,1,0,0,0}, {1,1,1,0,0}, {0,1,1,0,0}, {0,0,0,1,1}, {0,0,0,1,1}};
	  
	  ArrayList<ArrayList<Integer>> circles = findFriedCircle(friends);
	  
	  for(ArrayList<Integer> list: circles) {
		  System.out.println(list);
	  }
  }
  
  static ArrayList<ArrayList<Integer>> findFriedCircle(int[][] friendMatrix) {
	  ArrayList<ArrayList<Integer>> friends = new ArrayList<>();	  
	  boolean[] visited = new boolean[friendMatrix.length];
	 
	  for (int row=0; row<friendMatrix.length; row++) {
		  if (visited[row] == true) {
			  continue;
		  }
		  
		  visited[row] = true;	  
		  Queue<Integer> friendlist = new LinkedList<>();
		  friendlist.add(row);
		  ArrayList<Integer> circle = new ArrayList<>();
		  while(!friendlist.isEmpty()) {
			  int user = friendlist.poll();
			  circle.add(user);
			  
			  for (int col=0; col<friendMatrix[0].length; col++) {
				  if (friendMatrix[user][col] == 1 && visited[col] != true) {
					  friendlist.add(col);
					  visited[col] = true;	
				  }
			  }
			  
		  }
		  
		  friends.add(circle);
		  
	  }
	  
	  
	  return friends;
	  
  }

}
