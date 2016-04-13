package io.github.lsr1991.leetcode.util;

public class ListNode<Item> {

	public ListNode<Item> next;
	public Item val;
	public ListNode(Item x) { val = x; }
	
	public void print() {
		ListNode<Item> head = this;
		while (head != null) {
			System.out.print(head.val + " ");
			head = head.next;
		}
		System.out.println();
	}
	
	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}

}
