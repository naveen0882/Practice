package tree;

import java.util.*;

/*
Given an m x n board of characters and a list of strings words, return all words on the board.

Each word must be constructed from letters of sequentially adjacent cells, 
where adjacent cells are horizontally or vertically neighboring. The same letter cell may not be used more than once in a word.

Example 1:

Input: board = [["o","a","a","n"],["e","t","a","e"],["i","h","k","r"],["i","f","l","v"]], words = ["oath","pea","eat","rain"]
Output: ["eat","oath"]

Example 2:

Input: board = [["a","b"],["c","d"]], words = ["abcb"]
Output: []
*/
public class WordSearch2 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}
	
	public List<String> findWords(char[][] board, String[] words) {
        HashSet<String> res = new HashSet<>();
        
        for(String word: words){
            boolean[][] visited = new boolean[board.length][board[0].length];
            
            int count = 0;
            
            for(int i=0; i<board.length; i++){
                for(int j=0; j<board[0].length; j++){
                    if(board[i][j] == word.charAt(0) && dfs(board, i, j, count, word, visited)){
                        res.add(word);
                        break;
                    }
                }
            }
        }
        List<String> ans = new ArrayList<>(res);
        
        return ans;
    }
    
    public boolean dfs(char[][] board, int i, int j, int count, String word, boolean[][] visited){
        if(count == word.length())
            return true;
        
        if(i<0 || i>=board.length || j<0 || j>=board[0].length || 
           board[i][j] != word.charAt(count) || visited[i][j])
            return false;
        
        visited[i][j] = true;
        
        boolean found = dfs(board, i-1, j, count+1, word, visited) ||
                        dfs(board, i, j+1, count+1, word, visited) ||
                        dfs(board, i+1, j, count+1, word, visited) ||
                        dfs(board, i, j-1, count+1, word, visited);
        
        visited[i][j] = false;
        
        return found;
    }

}
