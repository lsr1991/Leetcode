package io.github.lsr1991.leetcode.tree;

import io.github.lsr1991.leetcode.util.TreeNode;

public class KthSmallestElementInaBST {

	class Result {
		int elementOrNodeNumber = 0;
		boolean isElement = false;
		public Result() {};
		public Result(int eleOrNum, boolean isEle) {
			elementOrNodeNumber = eleOrNum;
			isElement = isEle;
		}
	}

	public int kthSmallest(TreeNode root, int k) {
		return findKthSmallest(root, k).elementOrNodeNumber;
	}

	private Result findKthSmallest(TreeNode root, int k) {
		if (root == null) return new Result();
		Result left = findKthSmallest(root.left, k);
		if (left.isElement) {
			return left;
		}
		// then left is node number
		if (left.elementOrNodeNumber == k-1) {
			return new Result(root.val, true);
		} else {
			Result right = findKthSmallest(root.right, k-left.elementOrNodeNumber-1);
			if (right.isElement) return right;
			else return new Result(right.elementOrNodeNumber + left.elementOrNodeNumber + 1, false);
		}
	}

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		TreeNode root = new TreeNode(5);
		root.left = new TreeNode(2);
		root.right = new TreeNode(8);
		root.left.left = new TreeNode(1);
		root.left.right = new TreeNode(3);
		root.right.right = new TreeNode(9);
		System.out.println(new KthSmallestElementInaBST().kthSmallest(root, 3));
	}

}
