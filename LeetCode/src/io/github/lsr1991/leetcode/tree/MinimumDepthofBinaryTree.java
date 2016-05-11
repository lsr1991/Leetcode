package io.github.lsr1991.leetcode.tree;

import java.util.*;

import io.github.lsr1991.leetcode.util.*;

public class MinimumDepthofBinaryTree {
	public int minDepth(TreeNode root) {
		if (root == null) return 0;
		int leftMin = minDepth(root.left);
		int rightMin = minDepth(root.right);
		return (leftMin == 0 || rightMin == 0) ? leftMin + rightMin + 1 : Math.min(leftMin, rightMin) + 1;
	}

	public static void main(String[] args) {
		TreeNode root = new TreeNode(5);
		root.left = new TreeNode(3);
		root.right = new TreeNode(8);
		root.left.left = new TreeNode(1);
//		root.right.right = new TreeNode(7);
		System.out.println(new MinimumDepthofBinaryTree().minDepth(root));
	}
}
