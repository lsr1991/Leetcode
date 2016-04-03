package io.github.lsr1991.leetcode.util;

public class LinkedListQueue<Item> {

	class Node {
		public Node next;
		public Item item;
	}

	private Node first;
	private Node last;
	private int size = 0;

	public Item dequeue() {
		if (!isEmpty()) {
			Node tmp = first;
			first = first.next;
			size--;
			if (first == null) {
				last = null;
			}
			return tmp.item;
		} else
			return null;

	}

	public void enqueue(Item item) {
		if (last != null) {
			last.next = new Node();
			last = last.next;
			last.item = item;
		} else {
			first = new Node();
			first.item = item;
			last = first;
		}
		size++;
	}

	public boolean isEmpty() {
		return size == 0;
	}

	public int size() {
		return size;
	}

	public static void main(String[] args) {
		LinkedListQueue<Integer> q = new LinkedListQueue<>();
		System.out.println(q.dequeue() + " size:" + q.size() + " isEmpty:"
				+ q.isEmpty());
		q.enqueue(1);
		q.enqueue(2);
		q.enqueue(3);
		System.out.println(q.dequeue() + " size:" + q.size() + " isEmpty:"
				+ q.isEmpty());
		System.out.println(q.dequeue() + " size:" + q.size() + " isEmpty:"
				+ q.isEmpty());
		System.out.println(q.dequeue() + " size:" + q.size() + " isEmpty:"
				+ q.isEmpty());
		System.out.println(q.dequeue() + " size:" + q.size() + " isEmpty:"
				+ q.isEmpty());
	}
}
