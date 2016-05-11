package io.github.lsr1991.leetcode.tree;

import io.github.lsr1991.leetcode.util.TreeNode;

public class FlattenBinaryTreetoLinkedList {

	public void flatten(TreeNode root) {
		flattenAndReturnLast(root);
	}

	private TreeNode flattenAndReturnLast(TreeNode root) {
		if (root == null)
			return null;
		if (root.left == null && root.right == null) {
			return root;
		}
		TreeNode leftLast = null;
		TreeNode rightLast = null; 
		if (root.right != null) {
		    rightLast = flattenAndReturnLast(root.right);
			if (root.left != null) {
			    leftLast = flattenAndReturnLast(root.left);
				leftLast.right = root.right;
				root.right = root.left;
				root.left = null;
			}
			return rightLast;
		} else {
		    leftLast = flattenAndReturnLast(root.left);
			root.right = root.left;
			root.left = null;
			return leftLast;
		}
	}
	

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		TreeNode root = new TreeNode(5);
		root.left = new TreeNode(2);
		root.right = new TreeNode(6);
		root.left.left = new TreeNode(1);
		root.left.right = new TreeNode(3);
		root.left.right.right = new TreeNode(4);
		new FlattenBinaryTreetoLinkedList().flatten(root);
		while (root != null) {
			System.out.println(root.val);
			root = root.right;
		}
	}

}
