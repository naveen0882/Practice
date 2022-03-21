package tree;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

/*
Given the root of a binary tree, return the level order traversal of its nodes' values. (i.e., from left to right, level by level).

Example 1:

Input: root = [3,9,20,null,null,15,7]
Output: [[3],[9,20],[15,7]]

Example 2:

Input: root = [1]
Output: [[1]]

Example 3:

Input: root = []
Output: []

 */
public class BinaryTreeLevelOrderTraversal {

	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}
	
	public List<List<Integer>> levelOrder(TreeNode root) {
        List<List<Integer>> result = new ArrayList<List<Integer>>();

        if(root == null) {
            return result;
        }
        
        Queue<TreeNode> queue = new LinkedList<TreeNode>();
        
        queue.add(root);
        
        List<Integer> tempList = new ArrayList<Integer>();
        tempList.add(root.val);
        result.add(tempList);
        
        while(!queue.isEmpty()) {
            Queue<TreeNode> currentLevel = new LinkedList<TreeNode>();
            
            List<Integer> list = new ArrayList<Integer>();
            
            while(!queue.isEmpty()) {
                TreeNode current = queue.remove();
                
                if(current.left != null) {
                    currentLevel.add(current.left);
                    list.add(current.left.val);
                }
                
                if(current.right != null) {
                    currentLevel.add(current.right);
                    list.add(current.right.val);
                }
            }
            
            if(list.size() > 0) {
                result.add(list);
            }

            queue = currentLevel;
        }
        
        return result;
    }

}
