package io.github.lsr1991.leetcode.tree;

import java.util.LinkedList;

import io.github.lsr1991.leetcode.util.TreeNode;

public class SumRootToLeafNumbers {

	class Result {
		int curNum = 0;
		int sum = 0;
	}

	public int sumNumbers(TreeNode root) {
		if (root == null)
			return 0;
		Result res = new Result();
		visit(root, res);
		return res.sum;
	}

	/**
	 * visit a subTree, and calulate the sum and current path number
	 * 
	 * @param root
	 * @param res
	 */
	private void visit(TreeNode root, Result res) {
		if (root == null)
			return;
		res.curNum += root.val;
		if (root.left == null && root.right == null) {
			res.sum += res.curNum;
			res.curNum -= root.val;
			return;
		}
		res.curNum *= 10;
		if (root.left != null) {
			visit(root.left, res);
		}
		if (root.right != null) {
			visit(root.right, res);
		}
		res.curNum /= 10;
		res.curNum -= root.val;
	}

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		TreeNode root = new TreeNode(5);
		root.left = new TreeNode(2);
		root.right = new TreeNode(8);
		root.left.left = new TreeNode(1);
		root.left.right = new TreeNode(3);
		root.right.right = new TreeNode(9);
		System.out.println(new SumRootToLeafNumbers().sumNumbers(root));
	}

}
