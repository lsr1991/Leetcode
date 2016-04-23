package io.github.lsr1991.leetcode.tree;

import io.github.lsr1991.leetcode.util.TreeNode;

public class LowestCommonAncestorOfBST {

	public TreeNode lowestCommonAncestor(TreeNode root, TreeNode p, TreeNode q) {
		TreeNode max = p.val > q.val ? p : q;
		TreeNode min = p.val < q.val ? p : q;
		return lca(root, max, min);
	}
	
	private TreeNode lca(TreeNode root, TreeNode max, TreeNode min) {
		if (root == null) {
			return null;
		}
		if (min.val > root.val) {
			return lca(root.right, max, min);
		}
		if (max.val < root.val) {
			return lca(root.left, max, min);
		}
		return root;
	}

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		TreeNode root = new TreeNode(5);
		root.left = new TreeNode(2);
		root.right = new TreeNode(6);
		root.left.left = new TreeNode(1);
		root.left.right = new TreeNode(3);
		root.left.right.right = new TreeNode(4);
		System.out.println(new LowestCommonAncestorOfBST()
				.lowestCommonAncestor(root, root.left.left, root.right));
	}

}
