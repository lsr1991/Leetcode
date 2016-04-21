package io.github.lsr1991.leetcode.linkedlist;

import io.github.lsr1991.leetcode.util.ListNode;
import io.github.lsr1991.leetcode.util.TestCase;

import java.util.Arrays;
import java.util.HashSet;
import java.util.Iterator;
import java.util.Random;

//
public class SortList {

	public static ListNode<Integer> solution(ListNode<Integer> head) {
		if (head == null || head.next == null) {
			return head;
		}
		ListNode<Integer> lHead = head;
		ListNode<Integer> mid = getMiddle(head);
		ListNode<Integer> rHead = mid.next;
		mid.next = null;
		lHead = solution(lHead);
		rHead = solution(rHead);
		return merge(lHead, rHead);
	}

	private static ListNode<Integer> getMiddle(ListNode<Integer> head) {
		ListNode<Integer> fast = head.next;
		ListNode<Integer> slow = head;
		while (fast != null && fast.next != null) {
			fast = fast.next.next;
			slow = slow.next;
		}
		return slow;
	}
	
	private static ListNode<Integer> merge(ListNode<Integer> lHead, ListNode<Integer> rHead) {
		ListNode<Integer> dummy = new ListNode<Integer>(0);
		ListNode<Integer> pos = dummy;
		while (lHead != null && rHead != null) {
			if (lHead.val > rHead.val) {
				pos.next = rHead;
				rHead = rHead.next;
			} else {
				pos.next = lHead;
				lHead = lHead.next;
			}
			pos = pos.next;
		}
		if (lHead != null) {
			pos.next = lHead;
		}
		if (rHead != null) {
			pos.next = rHead;
		}
		return dummy.next;
	}
	

	public ListNode<Integer> correct(ListNode<Integer> input, int val) {
		return null;
	}

	public static void runTestCase(TestData[] test) {
		for (int i = 0; i < test.length; i++) {
			ListNode<Integer> list1 = new ListNode<Integer>(test[i].listNode1);
			test[i].printInput();
			test[i].printOutput();
			System.out.println("My output:");
			System.out.println(solution(list1));
		}
	}

	static class TestData {
		Integer[] listNode1;
		Integer[] expectOutput;

		public TestData(Integer[] listNode1, 
				Integer[] output) {
			this.listNode1 = listNode1;
			this.expectOutput = output;
		}

		public void printInput() {
			System.out.println("Input:");
			System.out.println("List1:" + Arrays.toString(listNode1));
		}

		public void printOutput() {
			System.out.println("Expected output:");
			System.out.println(Arrays.toString(expectOutput));
		}
	}

	public static void main(String[] args) {
		TestData[] datas = new TestData[3];
		Integer[] in11 = { 3, 2, 4 };
		Integer[] out1 = {2,3,4};
		datas[0] = new TestData(in11,out1);
		Integer[] in21 = { 9,9,2};
		Integer[] out2 = {2,9,9};
		datas[1] = new TestData(in21,  out2);
		Integer[] in31 = { 9,9,9,9};
		Integer[] out3 = {9,9,9,9};
		datas[2] = new TestData(in31, out3);
		
		runTestCase(datas);
	}

}
