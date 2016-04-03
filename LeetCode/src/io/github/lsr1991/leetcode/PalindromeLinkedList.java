package io.github.lsr1991.leetcode;
import io.github.lsr1991.leetcode.util.ListNode;
import io.github.lsr1991.leetcode.util.TestCase;

import java.util.Arrays;
import java.util.HashSet;
import java.util.Iterator;
import java.util.Random;
//Passed
public class PalindromeLinkedList extends TestCase<ListNode<Integer>, Boolean>{

	@Override
	public Boolean[] solution(ListNode<Integer>[] input) {
		Boolean[] res = new Boolean[1];
		ListNode<Integer> head = input[0];
		if (head == null) {
			res[0] = true;
			return res;
		}
		ListNode<Integer> slow = head;
		ListNode<Integer> fast = head;
		while (fast != null && fast.next != null && fast.next.next != null) {
			fast = fast.next.next;
			slow = slow.next;
		}
		ListNode<Integer> formerPart = head;
		ListNode<Integer> latterPart = slow.next;
		ListNode<Integer> reverseLatterPart = reverse(latterPart);
		res[0] = true;
		while (reverseLatterPart != null) {
			if (reverseLatterPart.val != formerPart.val) {
				res[0] = false;
				break;
			}
			reverseLatterPart = reverseLatterPart.next;
			formerPart = formerPart.next;
		}
		return res;
	}
	
	private ListNode<Integer> reverse(ListNode<Integer> head) {
		if (head == null || head.next == null) {
			return head;
		}
		ListNode<Integer> slow = head;
		ListNode<Integer> fast = head.next;
		ListNode<Integer> tmp = null;
		slow.next = null;
		while (fast != null) {
			tmp = fast;
			fast = fast.next;
			tmp.next = slow;
			slow = tmp;
		}
		return slow;
	}
	
	@Override
	public Boolean[] correct(ListNode<Integer>[] input) {
		return null;
	}
	
	@Override
	public ListNode<Integer>[] generateInput(Random r) {
		int n = 10;
//		int[] values = {1, 2, 3, 4, 4, 3, 2, 1};
		int[] values = {1};
		ListNode<Integer> head = new ListNode<Integer>(values[0]); 
		ListNode<Integer> tmp = head;
		for (int i = 1; i < values.length; i ++) {
			tmp.next = new ListNode<Integer>(values[i]);
			tmp = tmp.next;
		}
		ListNode<Integer>[] input = new ListNode[1];
		input[0] = head;
		input[0] = null;
		return input;
	}
	
	public static void main(String[] args) {
//		new PalindromeLinkedList().test(10);
		PalindromeLinkedList s = new PalindromeLinkedList();
		ListNode<Integer>[] input = s.generateInput(new Random());
		System.out.println(Arrays.toString(input));
		System.out.println(Arrays.toString(s.solution(input)));
	}

}
