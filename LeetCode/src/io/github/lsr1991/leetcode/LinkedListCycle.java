package io.github.lsr1991.leetcode;

import io.github.lsr1991.leetcode.util.ListNode;
import io.github.lsr1991.leetcode.util.TestCase;

import java.util.Arrays;
import java.util.HashSet;
import java.util.Iterator;
import java.util.Random;

//
public class LinkedListCycle {

	public static boolean solution(ListNode<Integer> head) {
		if (head == null) {
			return false;
		}
		ListNode<Integer> fast = head.next;
		ListNode<Integer> slow = head;
		boolean hasCycle = false;
		while (fast != null && fast.next != null) {
			if (fast == slow) {
				hasCycle = true;
				break;
			}
			fast = fast.next.next;
			slow = slow.next;
		}
		return hasCycle;
	}
	

	public ListNode<Integer> correct(ListNode<Integer> input, int val) {
		return null;
	}

	public static void runTestCase(TestData[] test) {
		for (int i = 0; i < test.length; i++) {
			ListNode<Integer> list1 = new ListNode<Integer>(test[i].listNode1);
			if (test[i].hasCycle) {
				ListNode<Integer> pos = list1;
				while (pos.next != null) {
					pos = pos.next;
				}
				pos.next = list1;
			}
			test[i].printInput();
			test[i].printOutput();
			System.out.println("My output:");
			System.out.println(solution(list1));
		}
	}

	static class TestData {
		Integer[] listNode1;
		boolean hasCycle;
		boolean expectOutput;

		public TestData(Integer[] listNode1, boolean hasCycle, boolean output) {
			this.listNode1 = listNode1;
			this.hasCycle = hasCycle;
			this.expectOutput = output;
		}

		public void printInput() {
			System.out.println("Input:");
			System.out.println("List1:" + Arrays.toString(listNode1));
		}

		public void printOutput() {
			System.out.println("Expected output:");
			System.out.println(expectOutput);
		}
	}

	public static void main(String[] args) {
		TestData[] datas = new TestData[2];
		Integer[] in11 = { 3, 2, 4 };
		boolean in12 = false;
		boolean out1 = false;
		datas[0] = new TestData(in11, in12, out1);
		Integer[] in21 = { 9, 9, 2 };
		boolean in22 = true;
		boolean out2 = true;
		datas[1] = new TestData(in21, in22, out2);

		runTestCase(datas);
	}

}
