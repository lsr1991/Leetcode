package io.github.lsr1991.leetcode.tree;

import io.github.lsr1991.leetcode.util.TreeNode;

public class BalancedBinaryTree {

	public boolean isBalanced(TreeNode root) {
		return getHeight(root) != -1;
	}
	
	public int getHeight(TreeNode root) {
		if (root == null) {
			return 0;
		}
		int left = getHeight(root.left);
		int right = getHeight(root.right);
		if (left == -1 || right == -1 || Math.abs(left - right) > 1) {
			return -1;
		}
		return Math.max(left, right) + 1;
	}
	

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		TreeNode root = new TreeNode(1);
		root.left = new TreeNode(2);
		root.right = new TreeNode(3);
		root.left.left = new TreeNode(4);
		root.left.right = new TreeNode(5);
		root.left.right.right = new TreeNode(5);
		System.out.println(new BalancedBinaryTree().isBalanced(root));
	}

}
