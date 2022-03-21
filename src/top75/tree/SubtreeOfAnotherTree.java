package tree;

/*
Given the roots of two binary trees root and subRoot, return true if there is a subtree 
of root with the same structure and node values of subRoot and false otherwise.

A subtree of a binary tree tree is a tree that consists of a node in tree and all of this node's descendants. 
The tree tree could also be considered as a subtree of itself.

Example 1:

Input: root = [3,4,5,1,2], subRoot = [4,1,2]
Output: true

Example 2:

Input: root = [3,4,5,1,2,null,null,null,null,0], subRoot = [4,1,2]
Output: false
 */
public class SubtreeOfAnotherTree {

	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}
	
	/**
	   * Time O(n)
	   * Space O(h)
	   */
	  public boolean isSubtree(TreeNode root, TreeNode subRoot) {
	    if (root == null) return false;
	    if (dfs(root, subRoot)) return true;
	    return isSubtree(root.left, subRoot) || isSubtree(root.right, subRoot);
	  }

	  /**
	   * Time O(n)
	   * Space O(h)
	   *   - Each element costs constant space O(1).
	   *     And the size of the stack is exactly the depth of DFS.
	   *     So in the worst case, it costs O(h) to maintain the system stack,
	   *     where h is the maximum depth of DFS.
	   */
	  public boolean dfs(TreeNode root, TreeNode subRoot) {
	    if (root == null && subRoot == null) return true;
	    if (root == null || subRoot == null) return false;
	    if (root.val != subRoot.val) return false;
	    return dfs(root.left, subRoot.left) && dfs(root.right, subRoot.right);
	  }
	
	boolean containsTree(TreeNode t1, TreeNode t2) {
		if(t2 == null) { //the empty tree is always a subtree
			return true;
		}
		return subTree(t1, t2);
	}
	///////

	boolean subTree(TreeNode r1, TreeNode r2) {
		if(r1 == null) {
			return false; //big tree empty & subtree still not found
		}
		if(r1.val == r2.val) {
			if(matchTree(r1, r2)) return true;
		}
		return (subTree(r1.left, r2) || subTree(r1.right, r2));
	}

	boolean matchTree(TreeNode r1, TreeNode r2) {
		if(r2 == null && r1 == null) //if both are empty
			return true; //nothing left in the subtree

		//if one, but not both, are empty
		if(r1 == null || r2 == null) {
			return false;
		}

		if(r1.val != r2.val)
			return false; //data doesn't match
		return (matchTree(r1.left, r2.left) && matchTree(r1.right, r2.right));
	}

}
