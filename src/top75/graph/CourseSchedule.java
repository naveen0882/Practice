package graph;

import java.util.*;

/*
There are a total of numCourses courses you have to take, labeled from 0 to numCourses - 1. 
You are given an array prerequisites where prerequisites[i] = [ai, bi] indicates 
that you must take course bi first if you want to take course ai.

For example, the pair [0, 1], indicates that to take course 0 you have to first take course 1.
Return true if you can finish all courses. Otherwise, return false.

Example 1:

Input: numCourses = 2, prerequisites = [[1,0]]
Output: true
Explanation: There are a total of 2 courses to take. 
To take course 1 you should have finished course 0. So it is possible.

Example 2:

Input: numCourses = 2, prerequisites = [[1,0],[0,1]]
Output: false
Explanation: There are a total of 2 courses to take. 
To take course 1 you should have finished course 0, and to take course 0 you should also have finished course 1. So it is impossible.

 */
public class CourseSchedule {

	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}
	
	public boolean canFinish(int numCourses, int[][] prerequisites) {
	    
		int[] indegree = new int[numCourses];
		Map<Integer, List<Integer>> map = new HashMap<>();
		Set<Integer> visited = new HashSet<>();
		    
		for(int i=0; i<numCourses; i++){
		    map.put(i, new LinkedList<Integer>());
		}
		    
		    

		for(int i=0; i<prerequisites.length; i++){
		    indegree[prerequisites[i][0]]++;
		    map.get(prerequisites[i][1]).add(prerequisites[i][0]);
		}
		    
		Queue<Integer> queue = new LinkedList<>();

		for(int i=0; i<indegree.length; i++){
		    if(indegree[i]==0) queue.offer(i);
		}
		    
		int count =0;
		    
		while(!queue.isEmpty()){
		    int curr = queue.poll();
		        count++;
		        
		    for(int item : map.get(curr)){
		        if(!visited.contains(item) && --indegree[item]==0){
		            queue.offer(item);
		            visited.add(item);
		        }
		    }
		    
		}
		    
		return count == numCourses;
		    
	}

}
