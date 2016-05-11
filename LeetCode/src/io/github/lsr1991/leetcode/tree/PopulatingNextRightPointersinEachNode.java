package io.github.lsr1991.leetcode.tree;

import io.github.lsr1991.leetcode.util.TreeNode;

public class PopulatingNextRightPointersinEachNode {

	private static class TreeLinkNode {
		public int val;
		public TreeLinkNode left;
		public TreeLinkNode right;
		public TreeLinkNode next;

		public TreeLinkNode(int val) {
			this.val = val;
		}
	}

	public void connect(TreeLinkNode root) {
		if (root == null)
			return;
		if (root.left != null) {
			root.left.next = root.right;
		}
		if (root.next != null) {
			root.right.next = root.next.left;
		}
		connect(root.left);
		connect(root.right);
	}

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		TreeNode root = new TreeNode(1);
		root.left = new TreeNode(2);
		root.right = new TreeNode(2);
		root.left.left = new TreeNode(4);
		root.right.right = new TreeNode(4);
		TreeNode root2 = new TreeNode(1);
		root2.left = new TreeNode(2);
		root2.right = new TreeNode(3);
		root2.left.left = new TreeNode(4);
		// System.out.println(new
		// PopulatingNextRightPointersinEachNode().connect(root);(root));
	}

}
