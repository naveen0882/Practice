package matrix;

import java.util.*;

/*
Given an m x n integer matrix matrix, if an element is 0, set its entire row and column to 0's.

You must do it in place.

Example 1:

Input: matrix = [[1,1,1],[1,0,1],[1,1,1]]
Output: [[1,0,1],[0,0,0],[1,0,1]]

Example 2:

Input: matrix = [[0,1,2,0],[3,4,5,2],[1,3,1,5]]
Output: [[0,0,0,0],[0,4,5,0],[0,3,1,0]]
*/

public class SetMatrixZero {

	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}
	
	public void setZeroes(int[][] matrix) {
        Set<Integer> rows=new HashSet<>();
        Set<Integer> cols=new HashSet<>();
        
        for(int i=0;i<matrix.length;i++){
            for(int j=0;j<matrix[0].length;j++){
                if(matrix[i][j]==0){
                    rows.add(i);
                    cols.add(j);
                }
            }
        }
        for(int i : rows){
            for(int j=0;j<matrix[0].length;j++){
                matrix[i][j]=0;
            }
        }
        for(int j: cols){
            for(int i=0;i<matrix.length;i++){
                matrix[i][j]=0;
            }
        }
        
    }

}
