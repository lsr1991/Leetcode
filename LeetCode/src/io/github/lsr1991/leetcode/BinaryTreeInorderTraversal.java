package io.github.lsr1991.leetcode;

import io.github.lsr1991.leetcode.util.TestCase;
import io.github.lsr1991.leetcode.util.TreeNode;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Random;
import java.util.Stack;
//Passed
public class BinaryTreeInorderTraversal extends TestCase<TreeNode, Integer> {

	@Override
	public Integer[] solution(TreeNode[] input) {
		TreeNode root = input[0];
		List<Integer> resInList = new ArrayList<Integer>();
		Stack<TreeNode> stack = new Stack<TreeNode>();
		TreeNode tmp = root;
		while (!stack.isEmpty() || tmp != null) {
			if (tmp == null) {
				tmp = stack.pop();
				resInList.add(tmp.val);
				tmp = tmp.right;
				continue;
			}
			stack.push(tmp);
			tmp = tmp.left;
		}
		Integer[] res = new Integer[resInList.size()];
		resInList.toArray(res);
		return res;
	}

	@Override
	public Integer[] correct(TreeNode[] input) {
		List<Integer> resInList = new ArrayList<Integer>();
		TreeNode root = input[0];
		TreeNode.inorderTraversalTree(root, resInList);
		Integer[] res = new Integer[resInList.size()];
		resInList.toArray(res);
		return res;
	}

	@Override
	public TreeNode[] generateInput(Random r) {
		Integer[] a = { 1, 2, 3, 4, 5, 6, 7, 8 };
		TreeNode[] input = new TreeNode[1];
		TreeNode root = TreeNode.generateRandomTree(a, r);
		input[0] = root;
		return input;
	}

	public static void main(String[] args) {
		new BinaryTreeInorderTraversal().test(10);
		// System.out.println(Arrays.toString(new
		// SingleNumber().generateInput(new Random())));
//		BinaryTreeInorderTraversal s = new BinaryTreeInorderTraversal();
//		TreeNode[] input = s.generateInput(new Random());
//		System.out.println(Arrays.toString(input));
//		System.out.println(Arrays.toString(s.correct(input)));
	}

}
