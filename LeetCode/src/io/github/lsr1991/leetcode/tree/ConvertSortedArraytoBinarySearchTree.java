package io.github.lsr1991.leetcode.tree;

import io.github.lsr1991.leetcode.util.TreeNode;

public class ConvertSortedArraytoBinarySearchTree {

	public TreeNode sortedArrayToBST(int[] nums) {
		return sortedArrayToBST(nums, 0, nums.length -1);
	}
	
	private TreeNode sortedArrayToBST(int[] nums, int lo, int hi) {
		if (lo > hi) {
			return null;
		}
		int mid = (lo + hi) / 2;
		TreeNode root = new TreeNode(nums[mid]);
		root.left = sortedArrayToBST(nums, lo, mid-1);
		root.right = sortedArrayToBST(nums, mid + 1, hi);
		return root;
	}

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		int[] nums = {1,2,3,4,5,6,7,8};
		System.out.println(new ConvertSortedArraytoBinarySearchTree()
				.sortedArrayToBST(nums));
	}

}
