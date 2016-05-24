package io.github.lsr1991.leetcode.tree;

import io.github.lsr1991.leetcode.util.TreeNode;

public class HouseRobberIII {

	/**
	 * for a tree has subtrees, it can easily be divided into subproblems.
	 * rob_root = max(rob_L + rob_R, no_rob_L + no_rob_R + root.val)
	 * no_rob_root = rob_L + rob_R
	 * rob_root means he can rob all nodes of the root tree
	 * no_rob_root means he can rob all nodes of the root tree except the root node
	 * @param root
	 * @return
	 */
	
	public int rob(TreeNode root) {
		if (root == null) return 0;
        return robRoot(root); 
    }
	
	private int robRoot(TreeNode root) {
		if (root == null) return 0;
		return Math.max(robRoot(root.left) + robRoot(root.right), root.val + noRobRoot(root.left) + noRobRoot(root.right));
	}
	
	private int noRobRoot(TreeNode root) {
		if (root == null) return 0;
		return robRoot(root.left) + robRoot(root.right);
	}

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		TreeNode root = new TreeNode(1);
		root.left = new TreeNode(2);
		root.right = new TreeNode(3);
		root.left.left = new TreeNode(4);
		root.left.right = new TreeNode(5);
		root.left.right.right = new TreeNode(5);
		System.out.println(new HouseRobberIII().rob(root));
	}

}
