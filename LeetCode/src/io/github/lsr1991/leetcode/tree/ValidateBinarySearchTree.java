package io.github.lsr1991.leetcode.tree;

import java.util.*;

import io.github.lsr1991.leetcode.util.*;

public class ValidateBinarySearchTree {

	public boolean isValidBST(TreeNode root) {
		if (root == null) {
			return true;
		}
		if (!isValidBST(root.left)) {
			return false;
		}
		if (!isValidBST(root.right)) {
			return false;
		}
		boolean res = true;
		if (root.left != null) {
			int maxOfLeft = findMax(root.left);
			res &= maxOfLeft < root.val;
		}
		if (root.right != null) {
			int minOfRight = findMin(root.right);
			res &= minOfRight > root.val;
		}
		return res;
	}

	private int findMax(TreeNode root) {
		TreeNode tmp = null;
		while (root != null) {
			tmp = root;
			root = root.right;
		}
		return tmp.val;
	}

	private int findMin(TreeNode root) {
		TreeNode tmp = null;
		while (root != null) {
			tmp = root;
			root = root.left;
		}
		return tmp.val;
	}

	/**
	 * solution 2 will run faster
	 * TODO
	 * @param root
	 * @return
	 */
	public boolean isValidBST2(TreeNode root) {
		if (root == null) {
			return true;
		}
		if (root.left != null) {
			Integer leftMax = getMax(root.left);
			if (leftMax == null || leftMax > root.val) {
				return false;
			}
		}
		if (root.right != null) {
			Integer rightMin = getMin(root.right);
			if (rightMin == null || rightMin < root.val) {
				return false;
			}
		}
		return true;
	}

	/**
	 * TODO
	 * @param root
	 * @return
	 */
	private Integer getMax(TreeNode root) {
		Integer leftMax = null;
		Integer rightMin = null;
		if (root.right != null) {
			leftMax = getMax(root.right);
			if (leftMax == null || leftMax > root.val) {
				return null;
			}
			else {
				return leftMax;
			}
		}
		if (root.right != null) {
			rightMin = getMin(root.right);
			if (rightMin == null || rightMin < root.val) {
				return null;
			}
		}
		return null;
	}

	/**
	 * TODO
	 * @param root
	 * @return
	 */
	private Integer getMin(TreeNode root) {
		TreeNode tmp = null;
		while (root != null) {
			tmp = root;
			root = root.left;
		}
		return tmp.val;
	}

	public static void main(String[] args) {
		TreeNode root = new TreeNode(5);
		root.left = new TreeNode(3);
		root.right = new TreeNode(8);
		root.left.left = new TreeNode(1);
		root.right.right = new TreeNode(7);
		System.out.println(new ValidateBinarySearchTree().isValidBST2(root));
	}
}
