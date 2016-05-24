package io.github.lsr1991.leetcode.tree;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;

import io.github.lsr1991.leetcode.util.TreeNode;

public class BinaryTreeZigzagLevelOrderTraversal {

	class Element {
		TreeNode node;
		int level;
		public Element(TreeNode node, int level) {
			this.level =  level;
			this.node = node;
		}
	}
	
	public List<List<Integer>> zigzagLevelOrder(TreeNode root) {
		List<List<Integer>> res = new ArrayList<>();
		LinkedList<Element> queue = new LinkedList<Element>();
		queue.add(new Element(root, 0));
		while (!queue.isEmpty()) {
			Element tmp = queue.removeFirst();
			List<Integer> tmpList = null;
			if (res.size() <= tmp.level) {
				tmpList = new LinkedList<Integer>();
				res.add(tmpList);
			} else {
				tmpList = res.get(tmp.level);
			}
			if ((tmp.level & 1) == 1) { // odd, so right to left
				tmpList.add(0, tmp.node.val);
			} else { // even, so left to right
				tmpList.add(tmp.node.val);
			}
			if (tmp.node.left != null) {
				queue.add(new Element(tmp.node.left, tmp.level+1));
			}
			if (tmp.node.right != null) {
				queue.add(new Element(tmp.node.right, tmp.level+1));
			}
		}
		return res;
	}

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		TreeNode root = new TreeNode(5);
		root.left = new TreeNode(2);
		root.right = new TreeNode(8);
		root.left.left = new TreeNode(1);
		root.left.right = new TreeNode(3);
		root.right.right = new TreeNode(9);
		List<List<Integer>> res = new BinaryTreeZigzagLevelOrderTraversal().zigzagLevelOrder(root);
		for (List<Integer> list : res) {
			for (Integer ele : list) {
				System.out.print(ele + ",");
			}
			System.out.println();
		}
	}

}
