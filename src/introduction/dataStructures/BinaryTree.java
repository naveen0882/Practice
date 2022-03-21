package dataStructures;

import java.util.Queue; 
import java.util.LinkedList; 

public class BinaryTree {
	Node root;
	
	public BinaryTree() {
		this.root = null;
	}
	
	public BinaryTree(Node root) {
		this.root = root;
	}

	public static class Node {
		int data;
		Node left, right;
		
		public Node(int data) {
			this.data = data;
			this.left = null;
			this.right = null;
		}		
	}
	
	
	 void printPostorder(Node node) 
	    { 
	        if (node == null) 
	            return; 
	  
	        // first recur on left subtree 
	        printPostorder(node.left); 
	  
	        // then recur on right subtree 
	        printPostorder(node.right); 
	  
	        // now deal with the node 
	        System.out.print(node.data + " "); 
	    } 
	  
	    /* Given a binary tree, print its nodes in inorder*/
	    void printInorder(Node node) 
	    { 
	        if (node == null) 
	            return; 
	  
	        /* first recur on left child */
	        printInorder(node.left); 
	  
	        /* then print the data of node */
	        System.out.print(node.data + " "); 
	  
	        /* now recur on right child */
	        printInorder(node.right); 
	    } 
	  
	    /* Given a binary tree, print its nodes in preorder*/
	    void printPreorder(Node node) 
	    { 
	        if (node == null) 
	            return; 
	  
	        /* first print data of node */
	        System.out.print(node.data + " "); 
	  
	        /* then recur on left sutree */
	        printPreorder(node.left); 
	  
	        /* now recur on right subtree */
	        printPreorder(node.right); 
	    } 
	  
	    // Wrappers over above recursive functions 
	    void printPostorder()  {     printPostorder(root);  } 
	    void printInorder()    {     printInorder(root);   } 
	    void printPreorder()   {     printPreorder(root);  } 
	    
	    
	    void printLevelOrder()  
	    { 
	        Queue<Node> queue = new LinkedList<Node>(); 
	        queue.add(root); 
	        while (!queue.isEmpty())  
	        { 
	  
	            /* poll() removes the present head. 
	            For more information on poll() visit  
	            http://www.tutorialspoint.com/java/util/linkedlist_poll.htm */
	            Node tempNode = queue.poll(); 
	            System.out.print(tempNode.data + " "); 
	  
	            /*Enqueue left child */
	            if (tempNode.left != null) { 
	                queue.add(tempNode.left); 
	            } 
	  
	            /*Enqueue right child */
	            if (tempNode.right != null) { 
	                queue.add(tempNode.right); 
	            } 
	        } 
	    } 
	  

	public static void main(String[] args) {
		BinaryTree tree = new BinaryTree(); 
        tree.root = new Node(1); 
        tree.root.left = new Node(2); 
        tree.root.right = new Node(3); 
        tree.root.left.left = new Node(4); 
        tree.root.left.right = new Node(5); 
  
        System.out.println("Preorder traversal of binary tree is "); 
        tree.printPreorder(); 
  
        System.out.println("\nInorder traversal of binary tree is "); 
        tree.printInorder(); 
  
        System.out.println("\nPostorder traversal of binary tree is "); 
        tree.printPostorder(); 
        
        
        BinaryTree tree_level = new BinaryTree(); 
        tree_level.root = new Node(1); 
        tree_level.root.left = new Node(2); 
        tree_level.root.right = new Node(3); 
        tree_level.root.left.left = new Node(4); 
        tree_level.root.left.right = new Node(5); 
  
        System.out.println(""); 
        System.out.println("Level order traversal of binary tree is - "); 
        tree_level.printLevelOrder(); 
	}

}
