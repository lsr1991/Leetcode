package io.github.lsr1991.leetcode.tree;

import java.util.*;

import io.github.lsr1991.leetcode.util.*;

public class BinaryTreeLevelOrderTraversal {
	
	static class IndexNode  {
		TreeNode node;
		int level;
		public IndexNode (TreeNode node, int level) {
			this.node = node;
			this.level = level;
		}
	}
	public List<List<Integer>> levelOrder(TreeNode root) {
		List<List<Integer>> res = new ArrayList<List<Integer>>();
		if (root == null) {
			return res;
		}
		LinkedList<IndexNode> q = new LinkedList<IndexNode>();
		q.add(new IndexNode(root, 0));
		while (!q.isEmpty()) {
			IndexNode tmp = q.removeFirst();
			if (res.size() > tmp.level) {
				res.get(tmp.level).add(tmp.node.val);
			} else {
				List<Integer> l = new ArrayList<Integer>();
				l.add(tmp.node.val);
				res.add(l);
			}
			if (tmp.node.left != null) {
				q.add(new IndexNode(tmp.node.left, tmp.level + 1));
			}
			if (tmp.node.right != null) {
				q.add(new IndexNode(tmp.node.right, tmp.level + 1));
			}
		}
		return res;
	}

	public static void main(String[] args) {
		TreeNode root = new TreeNode(1);
		root.left = new TreeNode(2);
		root.right = new TreeNode(2);
		root.left.left = new TreeNode(4);
		root.right.right = new TreeNode(4);
		List<List<Integer>> res = new BinaryTreeLevelOrderTraversal().levelOrder(root);
		for (int i = 0; i < res.size(); i ++) {
			List<Integer> l = res.get(i);
			for (int j = 0; j < l.size(); j ++) {
				System.out.print(l.get(j) + " ");
			}
			System.out.println();
		}
	}
}
