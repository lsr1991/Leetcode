package io.github.lsr1991.leetcode.tree;

import io.github.lsr1991.leetcode.util.TreeNode;

public class ConstructBinaryTreeFromPreorderAndInorderTraversal {

	public TreeNode buildTree(int[] preorder, int[] inorder) {
		if (preorder.length == 0 || preorder.length != inorder.length) return null;
		return buildTree(preorder, inorder, 0, preorder.length-1, 0, inorder.length-1);
	}
	
	private TreeNode buildTree(int[] preorder, int[] inorder, int prelo, int prehi, int inlo, int inhi) {
		if (prelo > prehi) return null;
		int tmp = preorder[prelo];
		int index = find(inorder, tmp, inlo, inhi);
		if (index == -1) return null;
		TreeNode node = new TreeNode(tmp);
		int newPreLo = prelo+1;
		int newPreHi = prelo+index-inlo;
		int newInLo = inlo;
		int newInHi = index-1;
		node.left = buildTree(preorder, inorder, newPreLo, newPreHi, newInLo, newInHi);
		newPreLo = newPreHi+1;
		newPreHi = prehi;
		newInLo = index+1;
		newInHi = inhi;
		node.right = buildTree(preorder, inorder, newPreLo, newPreHi, newInLo, newInHi);
		return node;
	}
	
	private int find(int[] inorder, int key, int lo, int hi) {
		for (int i = lo; i <= hi; i ++) {
			if (inorder[i] ==  key) return i;
		}
		return -1;
	}

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		int[] preorder = {4,5,1,2,3,6,7};
		int[] inorder = {1,5,2,4,6,3,7};
		TreeNode root = new ConstructBinaryTreeFromPreorderAndInorderTraversal().buildTree(preorder, inorder);
		System.out.println(root);
	}

}
