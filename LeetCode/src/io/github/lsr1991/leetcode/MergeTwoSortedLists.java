package io.github.lsr1991.leetcode;
import io.github.lsr1991.leetcode.util.ListNode;
import io.github.lsr1991.leetcode.util.TestCase;

import java.util.Arrays;
import java.util.HashSet;
import java.util.Iterator;
import java.util.Random;
//
public class MergeTwoSortedLists extends TestCase<ListNode, ListNode>{

	/**
	 * this solution is ugly, use solution2 instead!
	 */
	@Override
	public ListNode<Integer>[] solution(ListNode[] input) {
		ListNode<Integer> list1 = input[0];
		ListNode<Integer> list2 = input[1];
		ListNode<Integer>[] res = new ListNode[1];
		if (list1 == null) {
			res[0] = list2;
			return res;
		}
		if (list2 == null) {
			res[0] = list1;
			return res;
		}
		if (list2.val > list1.val) {
			res[0] = list1;
		} else {
			res[0] = list2;
		}
		ListNode<Integer> pos1 = list1;
		ListNode<Integer> pos2 = list2;
		ListNode<Integer> prePos2 = null;
		int i = 0;
		while (pos1 != null) {
			while (pos2 != null && pos1.val >= pos2.val) {
				prePos2 = pos2;
				pos2 = pos2.next;
			}
			if (prePos2 != null) {
				prePos2.next = pos1;
			}
			ListNode<Integer> tmp = pos1;
			pos1 = pos2;
			pos2 = tmp;
//			System.out.println((i++) + "th merge:");
//			System.out.print("pos2:");
//			pos2.print();
//			System.out.print("list2:");
//			list2.print();
		}
		res[0].print();
		return res;
	}
	
	public ListNode<Integer>[] solution2(ListNode[] input) {
		ListNode<Integer> list1 = input[0];
		ListNode<Integer> list2 = input[1];
		ListNode<Integer> dummy = new ListNode<Integer>(0);
		ListNode<Integer>[] res = new ListNode[1];
		res[0] = dummy;
		while (list1 != null && list2 != null) {
			if (list1.val > list2.val) {
				dummy.next = list2;
				list2 = list2.next;
			} else {
				dummy.next = list1;
				list1 = list1.next;
			}
			dummy = dummy.next;
		}
		if (list1 != null) {
			dummy.next = list1;
		}
		if (list2 != null) {
			dummy.next = list2;
		}
		res[0] = res[0].next;
		return res;
	}
	
	@Override
	public ListNode<Integer>[] correct(ListNode[] input) {
		return null;
	}
	
	@Override
	public ListNode<Integer>[] generateInput(Random r) {
		int n = 10;
		/* case 1 */
		int[] values = {3, 4, 7, 8, 12};
		int[] values2 = {1, 2, 5, 10, 11};
		/* case 2 */
//		int[] values = {1};
//		int[] values2 = {2};
//		int[] values = {1};
		ListNode<Integer> head = new ListNode<Integer>(values[0]); 
		ListNode<Integer> tmp = head;
		for (int i = 1; i < values.length; i ++) {
			tmp.next = new ListNode<Integer>(values[i]);
			tmp = tmp.next;
		}
		ListNode<Integer>[] input = new ListNode[2];
		input[0] = head;
		head.print();
		ListNode<Integer> head2 = new ListNode<Integer>(values2[0]); 
		ListNode<Integer> tmp2 = head2;
		for (int i = 1; i < values2.length; i ++) {
			tmp2.next = new ListNode<Integer>(values2[i]);
			tmp2 = tmp2.next;
		}
		input[1] = head2;
		head2.print();
//		input[0] = null;
		return input;
	}
	
	public static void main(String[] args) {
//		new MergeTwoSortedLists().test(10);
		MergeTwoSortedLists s = new MergeTwoSortedLists();
		ListNode[] input = s.generateInput(new Random());
		System.out.println(Arrays.toString(input));
		System.out.println(Arrays.toString(s.solution2(input)));
	}

}
