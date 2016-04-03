package io.github.lsr1991.leetcode;

import io.github.lsr1991.leetcode.util.TestCase;
import io.github.lsr1991.leetcode.util.TreeNode;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.LinkedList;
import java.util.List;
import java.util.Random;
import java.util.Stack;
//Passed
public class BinaryTreePostorderTraversal extends TestCase<TreeNode, Integer> {

	/**
	 * 1. the current accessed node (the 'tmp' variable in the following program) should be put into the 
	 * stack when you want to access its child nodes. 
	 * 2. the node whose value has been collected should be stored (the 'tmp2' variable) for later comparing.
	 * 3. when the value of a node has been collected, it should continue the poping process, because it should 
	 * return to the parent to get the parent's right node for comparing with 'tmp2', if they are equal, then 
	 * all subtrees of the parent node have been collected, otherwise the parent's right subtree has not been accessed.  
	 */
	@Override
	public Integer[] solution(TreeNode[] input) {
		TreeNode root = input[0];
		List<Integer> resInList = new ArrayList<Integer>();
		Stack<TreeNode> stack = new Stack<TreeNode>();
		TreeNode tmp = root;
		TreeNode tmp2 = null;
		while (!stack.isEmpty() || tmp != null) {
			if (tmp == null) {
				tmp = stack.pop();
				if (tmp.right != null && tmp2 != tmp.right) {
					stack.push(tmp);
					tmp = tmp.right;
				} else {
					resInList.add(tmp.val);
					tmp2 = tmp;
					tmp = null;
				}
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
		TreeNode.postorderTraversalTree(root, resInList);
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
		new BinaryTreePostorderTraversal().test(10);
		// System.out.println(Arrays.toString(new
		// SingleNumber().generateInput(new Random())));
//		BinaryTreeInorderTraversal s = new BinaryTreeInorderTraversal();
//		TreeNode[] input = s.generateInput(new Random());
//		System.out.println(Arrays.toString(input));
//		System.out.println(Arrays.toString(s.correct(input)));
	}

}
