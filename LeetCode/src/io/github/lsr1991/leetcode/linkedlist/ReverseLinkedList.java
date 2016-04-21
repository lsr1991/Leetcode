package io.github.lsr1991.leetcode.linkedlist;

import io.github.lsr1991.leetcode.util.ListNode;
import io.github.lsr1991.leetcode.util.TestCase;

import java.util.Arrays;
import java.util.HashSet;
import java.util.Iterator;
import java.util.Random;

//
public class ReverseLinkedList {

	public static ListNode<Integer> solution(ListNode<Integer> input) {
		ListNode<Integer> dummy = new ListNode<Integer>(0);
		ListNode<Integer> tmp = null;
		while (input != null) {
			tmp = input.next;
			input.next = dummy.next;
			dummy.next = input;
			input = tmp;
		}
		return dummy.next;
	}
	
	public static ListNode<Integer> solution2(ListNode<Integer> input) {
		return doReverse(input, null);
	}
	
	private static ListNode<Integer> doReverse(ListNode<Integer> head, ListNode<Integer> newHead) {
		if (head == null) {
			return newHead;
		}
		ListNode<Integer> tmp = head.next;
		head.next = newHead;
		return doReverse(tmp, head);
	}

	public ListNode<Integer> correct(ListNode<Integer> input, int val) {
		return null;
	}

	public static void runTestCase(TestData[] test) {
		for (int i = 0; i < test.length; i++) {
			ListNode<Integer> input = new ListNode<Integer>(test[i].listNode);
			test[i].printInput();
			test[i].printOutput();
			System.out.println("My output:");
			System.out.println(solution2(input));
		}
	}

	static class TestData {
		Integer[] listNode;
		Integer[] expectOutput;

		public TestData(Integer[] listNode, Integer[] output) {
			this.listNode = listNode;
			this.expectOutput = output;
		}

		public void printInput() {
			System.out.println("Input:");
			System.out.println(Arrays.toString(listNode));
		}

		public void printOutput() {
			System.out.println("Expected output:");
			System.out.println(Arrays.toString(expectOutput));
		}
	}

	public static void main(String[] args) {
		TestData[] datas = new TestData[4];
		Integer[] in1 = { 1, 2, 4, 5, 6, 6 };
		Integer[] out11 = { 6,6,5,4,2,1 };
		datas[0] = new TestData(in1, out11);
		Integer[] in2 = { 1 };
		Integer[] out2 = { 1 };
		datas[1] = new TestData(in2, out2);
		Integer[] in3 = {};
		Integer[] out3 = {};
		datas[2] = new TestData(in3, out3);
		Integer[] in4 = { 1, 2 };
		Integer[] out4 = { 2,1 };
		datas[3] = new TestData(in4, out4);
		runTestCase(datas);
	}

}
