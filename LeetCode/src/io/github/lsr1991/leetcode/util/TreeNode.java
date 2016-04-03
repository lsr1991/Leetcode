package io.github.lsr1991.leetcode.util;

import java.util.List;
import java.util.Random;

public class TreeNode {
	public TreeNode left;
	public TreeNode right;
	public int val;
	public TreeNode(int x) {
		val = x;
	}
	
	public static void preorderTraversalTree(TreeNode root, List<Integer> resInList) {
		if (root == null) {
			return;
		}
		resInList.add(root.val);
		preorderTraversalTree(root.left, resInList);
		preorderTraversalTree(root.right, resInList);
	}
	
	public static void inorderTraversalTree(TreeNode root, List<Integer> resInList) {
		if (root == null) {
			return;
		}
		inorderTraversalTree(root.left, resInList);
		resInList.add(root.val);
		inorderTraversalTree(root.right, resInList);
	}
	
	public static void postorderTraversalTree(TreeNode root, List<Integer> resInList) {
		if (root == null) {
			return;
		}
		postorderTraversalTree(root.left, resInList);
		postorderTraversalTree(root.right, resInList);
		resInList.add(root.val);
	}
	
	public static TreeNode generateRandomTree(Integer[] a, Random r) {
		if (a.length == 0) return null;
		LinkedListQueue<TreeNode> q = new LinkedListQueue<TreeNode>();
		TreeNode root = new TreeNode(a[0]);
		q.enqueue(root);
		TreeNode tmp = null;
		int i = 1;
		while (i < a.length) {
			if (q.isEmpty()) {
				tmp.left = new TreeNode(a[i++]);
				q.enqueue(tmp.left);
			} else {
				tmp = q.dequeue();
				if (r.nextInt() > 0) {
					tmp.left = new TreeNode(a[i++]);
					q.enqueue(tmp.left);
				}
				if (i == a.length) break;
				if (r.nextInt() > 0) {
					tmp.right = new TreeNode(a[i++]);
					q.enqueue(tmp.right);
				}
			}
		}
		return root;
	}
	
}
