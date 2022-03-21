package tree;

import java.util.*;

/*
Serialization is the process of converting a data structure or object into a sequence of bits 
so that it can be stored in a file or memory buffer, or transmitted across a network connection 
link to be reconstructed later in the same or another computer environment.

Design an algorithm to serialize and deserialize a binary tree. 
There is no restriction on how your serialization/deserialization algorithm should work. 
You just need to ensure that a binary tree can be serialized to a string and this string 
can be deserialized to the original tree structure.

Clarification: The input/output format is the same as how LeetCode serializes a binary tree. 
You do not necessarily need to follow this format, so please be creative and come up with different approaches yourself.

Example 1:

Input: root = [1,2,3,null,null,4,5]
Output: [1,2,3,null,null,4,5]

Example 2:

Input: root = []
Output: []

 */
public class SerializeBinaryTree {

	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}
	
	 // Encodes a tree to a single string.
    public String serialize(TreeNode root) {
        if(root == null) return "";
        
        Queue<TreeNode> queue = new LinkedList<>();
        queue.add(root);
        
        List<Integer> list = new ArrayList<>();
        
        while(!queue.isEmpty()) {
            TreeNode front = queue.poll();
            
            if(front == null) {
                list.add(null);
                continue;
            }
            
            list.add(front.val);
            
            queue.add(front.left);
            queue.add(front.right);
        }
        String s = list.toString();
        return s;
    }

    // Decodes your encoded data to tree.
    public TreeNode deserialize(String data) {
        if(data.length() == 0) return null;
        List<String> list = Arrays.asList(data.substring(1, data.length()-1).split(", "));
        
        Queue<TreeNode> queue = new LinkedList<>();
        TreeNode root = new TreeNode(Integer.parseInt(list.get(0)));
        queue.add(root);
        if(data.length() == 1) return root;
        int idx = 1;
        
        while(!queue.isEmpty()) {
            TreeNode front = queue.poll();
            
            if(!list.get(idx).equals("null")) {
                TreeNode leftnode = new TreeNode(Integer.parseInt(list.get(idx)));
                front.left = leftnode;
                queue.add(leftnode);
            } else 
                front.left = null;
            
            idx++;
            
            if(!list.get(idx).equals("null")) {
                TreeNode rightnode = new TreeNode(Integer.parseInt(list.get(idx)));
                front.right = rightnode;
                queue.add(rightnode);
            } else 
                front.right = null;
				
            idx++;   
        }
        return root;
    }
}
