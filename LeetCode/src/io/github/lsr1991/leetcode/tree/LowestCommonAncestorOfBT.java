package io.github.lsr1991.leetcode.tree;

import io.github.lsr1991.leetcode.util.TreeNode;

public class LowestCommonAncestorOfBT {

	private boolean isExist(TreeNode root, TreeNode node) {
		if (root == null) {
			return false;
		}
		if (root == node) {
			return true;
		}
		return isExist(root.left, node) || isExist(root.right, node);
	}
	
	public TreeNode lowestCommonAncestor(TreeNode root, TreeNode p, TreeNode q) {
		if (!isExist(root, p) || !isExist(root, q)) return null;
		return lca(root, p, q);
	}
	
	private TreeNode lca(TreeNode root, TreeNode p, TreeNode q) {
		if (root == null) {
			return null;
		}
		if (root == q || root == p) {
			return root;
		}
		TreeNode x = lca(root.left, p, q);
		if (x != null && x != p && x != q) return x;
		TreeNode y = lca(root.right, p, q);
		if (y != null && y != p && y != q) return y;
		if (x != null && y != null) return root;
		else return x == null ? y : x;
	}
	

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		TreeNode root = new TreeNode(5);
		root.left = new TreeNode(2);
		root.right = new TreeNode(6);
		root.left.left = new TreeNode(1);
		root.left.right = new TreeNode(3);
		root.left.right.right = new TreeNode(4);
		System.out.println(new LowestCommonAncestorOfBT()
				.lowestCommonAncestor(root, root.left.left, root.right));
	}

}
