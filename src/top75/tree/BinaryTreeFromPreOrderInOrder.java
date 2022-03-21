package tree;

/*
Given two integer arrays preorder and inorder where preorder is the preorder traversal of a binary tree and 
inorder is the inorder traversal of the same tree, construct and return the binary tree.

Example 1:

Input: preorder = [3,9,20,15,7], inorder = [9,3,15,20,7]
Output: [3,9,20,null,null,15,7]

Example 2:

Input: preorder = [-1], inorder = [-1]
Output: [-1]
 */
public class BinaryTreeFromPreOrderInOrder {

	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}
	
	public TreeNode buildTree(int[] preorder, int[] inorder) {
	    int n = preorder.length - 1;
	    return buildTree_(preorder, inorder, 0, n, 0, n);
	}
	
	public TreeNode buildTree_(int[] preorder, int[] inorder, int psi, int pei, int isi, int iei) {
	    if (isi > iei) return null;

	    int idx = isi;
	    while (inorder[idx] != preorder[psi]) idx++;
	    int close = idx - isi;

	    TreeNode node = new TreeNode();
	    node.val = preorder[psi];
	    node.left = buildTree_(preorder, inorder, psi + 1, psi + close, isi, idx - 1);
	    node.right = buildTree_(preorder, inorder, psi + close + 1, pei, idx + 1, iei);
	    return node;
	}

}
