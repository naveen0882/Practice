package tree;

/*
Given the root of a binary search tree, and an integer k, 
return the kth smallest value (1-indexed) of all the values of the nodes in the tree.

Example 1:

Input: root = [3,1,4,null,2], k = 1
Output: 1

Example 2:

Input: root = [5,3,6,2,4,null,null,1], k = 3
Output: 3
*/
public class KthSmallestInBST {

	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}
	
	private int val = 0;
	  private int count = 0;
	  
	  public int kthSmallest(TreeNode root, int k) {
	    dfs(root, k);
	    return val;
	  }

	  /**
	   * Time O(n)
	   * Space O(h)
	   *   - Each element costs constant space O(1).
	   *     And the size of the stack is exactly the depth of DFS.
	   *     So in the worst case, it costs O(h) to maintain the system stack,
	   *     where h is the maximum depth of DFS.
	   */
	  public void dfs(TreeNode node, int k) {
	    if (node == null) return;
	    dfs(node.left, k);
	    if (++count == k) {
		  this.val = node.val;
		  return;
	    }
	    dfs(node.right, k);
	  }

}
