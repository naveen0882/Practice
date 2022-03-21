package dynamic_programming;

/*
There is a robot on an m x n grid. The robot is initially located at the top-left corner (i.e., grid[0][0]). 
The robot tries to move to the bottom-right corner (i.e., grid[m - 1][n - 1]). 
The robot can only move either down or right at any point in time.

Given the two integers m and n, return the number of possible unique paths that the robot can take to reach the bottom-right corner.

The test cases are generated so that the answer will be less than or equal to 2 * 109.

Example 1:

Input: m = 3, n = 7
Output: 28

Example 2:

Input: m = 3, n = 2
Output: 3
Explanation: From the top-left corner, there are a total of 3 ways to reach the bottom-right corner:
1. Right -> Down -> Down
2. Down -> Down -> Right
3. Down -> Right -> Down
 
*/
public class UniquePaths {

	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}
	
	public int uniquePaths(int m, int n) {
        Integer[][] map = new Integer[m][n];
        
        //only 1 way to get to ith row, 0th column (move down)
        for(int i = 0; i < m; i++){
            map[i][0] = 1;
        }
        
        //only 1 way to get to ith column, 0th row (move right)
        for(int j= 0; j < n; j++){
            map[0][j]=1;
        }
        
        //x ways to get to ith row, jth column (# of ways to get to
        //ith - 1 row, jth column + # of ways to get to jth - 1 column
        //ith column
        for(int i = 1;i < m; i++){
            for(int j = 1; j < n; j++){
                map[i][j] = map[i - 1][j] + map[i][j - 1];
            }
        }

        return map[m - 1][n - 1];
    }

}
