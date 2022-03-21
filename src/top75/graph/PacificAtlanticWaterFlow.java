package graph;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

/*
There is an m x n rectangular island that borders both the Pacific Ocean and Atlantic Ocean. 
The Pacific Ocean touches the island's left and top edges, and the Atlantic Ocean touches the island's right and bottom edges.

The island is partitioned into a grid of square cells. 
You are given an m x n integer matrix heights where heights[r][c] represents the height above sea level of the cell at coordinate (r, c).

The island receives a lot of rain, and the rain water can flow to neighboring cells 
directly north, south, east, and west if the neighboring cell's height is less than or equal to the current cell's height. 
Water can flow from any cell adjacent to an ocean into the ocean.

Return a 2D list of grid coordinates result where result[i] = [ri, ci] denotes that rain water can 
flow from cell (ri, ci) to both the Pacific and Atlantic oceans.

Example 1:

Input: heights = [[1,2,2,3,5],[3,2,3,4,4],[2,4,5,3,1],[6,7,1,4,5],[5,1,1,2,4]]
Output: [[0,4],[1,3],[1,4],[2,2],[3,0],[3,1],[4,0]]

Example 2:

Input: heights = [[2,1],[1,2]]
Output: [[0,0],[0,1],[1,0],[1,1]]
 */
public class PacificAtlanticWaterFlow {

	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}
	
	public List<int[]> pacificAtlantic(int[][] matrix) {
        List<int[]> result = new LinkedList<>();
        
        //error checking
        if(matrix == null || matrix.length == 0 || matrix[0].length == 0) {
            return result;
        }
        
        int n = matrix.length;
        int m = matrix[0].length;
        
        boolean[][] pacific = new boolean[n][m];
        boolean[][] atlantic = new boolean[n][m];
        
        for(int i = 0; i < n; i++) {
            dfs(matrix, pacific, Integer.MIN_VALUE, i, 0);
            dfs(matrix, atlantic, Integer.MIN_VALUE, i, m - 1);
        }
        
        for(int i = 0; i < m; i++) {
            dfs(matrix, pacific, Integer.MIN_VALUE, 0, i);
            dfs(matrix, atlantic, Integer.MIN_VALUE, n - 1, i);
        }
        
        for(int i = 0; i < n; i++) {
            for(int j = 0; j < m; j++) {
                if(pacific[i][j] && atlantic[i][j]) {
                    result.add(new int[] {i, j});
                }
            }
        }
        
        return result;
    }
    
    
    public void dfs(int[][] matrix, boolean[][] visited, int height, int x, int y) {
        int n = matrix.length;
        int m = matrix[0].length;
        
        if(x < 0 || x >= n || y < 0 || y >= m || visited[x][y] || matrix[x][y] < height) {
            return;
        }
        
        visited[x][y] = true;
        
        dfs(matrix, visited, matrix[x][y], x + 1, y);
        dfs(matrix, visited, matrix[x][y], x - 1, y);
        dfs(matrix, visited, matrix[x][y], x, y + 1);
        dfs(matrix, visited, matrix[x][y], x, y - 1);
    }
    
    // BFS
    int[][] dirs = new int[][]{{1,0},{0,1},{-1,0},{0,-1}};
    public List<List<Integer>> pacificAtlantic2(int[][] heights) {
        int m = heights.length, n = heights[0].length;
        
        boolean[][] pacific = new boolean[m][n];
        boolean[][] atlantic = new boolean[m][n];
        
        Queue<int[]> pQueue = new LinkedList<>();
        Queue<int[]> aQueue = new LinkedList<>();
        
        for (int i = 0; i < m; i++) {
            pQueue.offer(new int[]{i, 0});
            pacific[i][0] = true;
            aQueue.offer(new int[]{i, n-1});
            atlantic[i][n-1] = true;
        }
        
        for (int i = 0; i < n; i++) {
            pQueue.offer(new int[]{0, i});
            pacific[0][i] = true;
            aQueue.offer(new int[]{m-1, i});
            atlantic[m-1][i] = true;
        }
        bfs(heights, pQueue, pacific);
        bfs(heights, aQueue, atlantic);
        
        List<List<Integer>> res = new ArrayList<>();
        
        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) {
                if (pacific[i][j] && atlantic[i][j]) {
                    res.add(Arrays.asList(i, j));
                }
            }
        }
        return res;
    }
    
    private void bfs(int[][] heights, Queue<int[]> queue, boolean[][] visited) {
        int m = heights.length, n = heights[0].length;
        while (!queue.isEmpty()) {
            int[] pos = queue.poll();
            for (int[] dir : dirs) {
                int x = pos[0] + dir[0];
                int y = pos[1] + dir[1];
                if (x < 0 || x >= m || y < 0 || y >= n || 
                    visited[x][y] || heights[x][y] < heights[pos[0]][pos[1]]) {
                    continue;
                }
                visited[x][y] = true;
                queue.offer(new int[]{x, y});
            }
        }
    }


}
