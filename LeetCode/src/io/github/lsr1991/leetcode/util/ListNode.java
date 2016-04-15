package io.github.lsr1991.leetcode.util;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class ListNode<Item> {

	public ListNode<Item> next;
	public Item val;
	public ListNode(Item x) { val = x; }
	
	public ListNode(Item[] x) {
		if (x.length != 0) {
			ListNode<Item> head = this;
			head.val = x[0];
			for (int i = 1; i < x.length; i ++) {
				head.next = new ListNode<Item>(x[i]);
				head = head.next;
			}
		}
	}
	
	public void print() {
		ListNode<Item> head = this;
		while (head != null) {
			System.out.print(head.val + " ");
			head = head.next;
		}
		System.out.println();
	}
	
	public String toString() {
		StringBuilder sb = new StringBuilder();
		ListNode<Item> head = this;
		while (head != null) {
			sb.append(head.val + " ");
			head = head.next;
		}
		return sb.toString();
	}
	
	public static void testListNode() {
		Integer[] a = {1,2,3,4,5};
		Integer[] a1 = {1};
		ListNode<Integer> b = new ListNode<Integer>(a1);
		b.print();
		b.print();
	}
	
	public Item[] toArray() {
		List<Item> l = new ArrayList<Item>();
		ListNode<Item> head = this;
		while (head != null) {
			l.add(head.val);
			head = head.next;
		}
		Item[] arr = (Item[])new Object[l.size()];
		return l.toArray(arr);
	}
	
	public static void main(String[] args) {
		// TODO Auto-generated method stub
//		testListNode();
		Integer[] a = {1,2,3,4};
		Object[] b = new ListNode<Integer>(a).toArray();
		System.out.println(Arrays.toString(b));
	}

}
