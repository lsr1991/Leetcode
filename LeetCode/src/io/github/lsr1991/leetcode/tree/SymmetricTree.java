package io.github.lsr1991.leetcode.tree;

import io.github.lsr1991.leetcode.util.TreeNode;

public class SymmetricTree {

	public boolean isSymmetric(TreeNode root) {
		if (root == null) {
			return true;
		}
		return compare(root.left, root.right);
	}
	
	private boolean compare(TreeNode tree1, TreeNode tree2) {
		if (tree1 == null && tree2 == null) {
			return true;
		} else if (tree1 == null || tree2 == null) {
			return false;
		}
		if (tree1.val != tree2.val) {
			return false;
		}
		return compare(tree1.left, tree2.right) && compare(tree1.right, tree2.left); 
	}
	
	public boolean isSymmetricIter(TreeNode root) {
		if (root == null) {
			return true;
		}
		return true;
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
		System.out.println(new SymmetricTree().isSymmetric(root));
	}

}
