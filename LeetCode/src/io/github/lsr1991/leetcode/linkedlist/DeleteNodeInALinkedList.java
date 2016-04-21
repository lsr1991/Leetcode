package io.github.lsr1991.leetcode.linkedlist;

import io.github.lsr1991.leetcode.util.ListNode;
import io.github.lsr1991.leetcode.util.TestCase;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashSet;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.List;
import java.util.Random;

//
public class DeleteNodeInALinkedList extends TestCase<ListNode<Integer>, Integer> {

	@Override
	public Integer[] solution(ListNode<Integer>[] input) {
		ListNode<Integer> deleteNode = input[1];
		deleteNode.val = deleteNode.next.val;
		deleteNode.next = deleteNode.next.next;
		return getValues(input[0]);
	}

	@Override
	public Integer[] correct(ListNode<Integer>[] input) {
		ListNode<Integer> head = input[0];
		ListNode<Integer> deleteNode = input[1];
		if (head == deleteNode) {
			return getValues(head.next);
		}
		ListNode<Integer> tmp = head;
		while (tmp != null && tmp.next != deleteNode) {
			tmp = tmp.next;
		}
		if (tmp == null) return null;
		tmp.next = deleteNode.next;
		return getValues(head);
	}
	
	@Override
	public ListNode<Integer>[] copy(ListNode<Integer>[] input) {
		ListNode<Integer> head1 = input[0];
		ListNode<Integer> delete1 = input[1];
		ListNode<Integer> head2 = new ListNode<Integer>(head1.val);
		ListNode<Integer> delete2 = null;
		ListNode<Integer> tmp = head2;
		while (head1.next != null) {
			head1 = head1.next;
			tmp.next = new ListNode<Integer>(head1.val);
			if (head1 == delete1) {
				delete2 = tmp.next;
			}
			tmp = tmp.next;
		}
		ListNode<Integer>[] copy = new ListNode[input.length];
		copy[0] = head2;
		copy[1] = delete2;
		return copy;
	}

	private Integer[] getValues(ListNode<Integer> head) {
		List<Integer> list = new ArrayList<Integer>();
		while (head != null) {
			list.add(head.val);
			head = head.next;
		}
		Integer[] values = new Integer[list.size()];
		list.toArray(values);
		return values;
	}
	
	@Override
	public ListNode<Integer>[] generateInput(Random r) {
		int n = 10;
		ListNode<Integer> head = new ListNode<Integer>(r.nextInt(20));
//		System.out.print(head.val + " ");
		int toBeDeleted = r.nextInt(n-2) + 2;
		ListNode<Integer> deleteNode = null;
		ListNode<Integer> tmp = head;
		for (int i = 2; i <= n; i++) {
			if (i == toBeDeleted) {
				deleteNode = new ListNode<Integer>(r.nextInt(20));
				tmp.next = deleteNode;
			} else {
				tmp.next = new ListNode<Integer>(r.nextInt(20));
			}
//			System.out.print(tmp.next.val + " ");
			tmp = tmp.next;
		}
//		System.out.println();
//		System.out.println("delete:" + toBeDeleted);
		ListNode<Integer>[] input = new ListNode[2];
		input[0] = head;
		input[1] = deleteNode;
		return input;
	}

	public static void main(String[] args) {
		new DeleteNodeInALinkedList().test(10);
//		DeleteNodeInALinkedList s = new DeleteNodeInALinkedList();
//		ListNode<Integer>[] input = s.generateInput(new Random());
//		System.out.println(Arrays.toString(input));
//		System.out.println(Arrays.toString(s.correct(input)));
	}

}
