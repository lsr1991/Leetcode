package io.github.lsr1991.leetcode.tree;

import java.util.*;

import io.github.lsr1991.leetcode.util.*;

public class BinarySearchTreeIterator {

	static class BSTIterator {
		
		private TreeNode cur = null;
		private LinkedList<TreeNode> stack = new LinkedList<TreeNode>();
		
		public BSTIterator(TreeNode root) {
			while (root != null) {
				stack.add(root);
				root = root.left;
			}
		}

		/** @return whether we have a next smallest number */
		public boolean hasNext() {
			return !stack.isEmpty();
		}

		/** @return the next smallest number */
		public int next() {
			cur = stack.removeLast();
			int val = cur.val;
			TreeNode tmp = cur.right;
		    while (tmp != null) {
		    	stack.add(tmp);
				tmp = tmp.left;	
			}
			return val;
		}
	}

	public static void main(String[] args) {
		TreeNode root = new TreeNode(5);
		root.left = new TreeNode(3);
		root.right = new TreeNode(8);
		root.left.left = new TreeNode(1);
		root.right.right = new TreeNode(10);
		BSTIterator it = new BSTIterator(root);
		while (it.hasNext()) {
			System.out.println(it.next());
		}
	}
}
