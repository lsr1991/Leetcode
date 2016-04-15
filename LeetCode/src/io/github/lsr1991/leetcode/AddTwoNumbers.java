package io.github.lsr1991.leetcode;

import io.github.lsr1991.leetcode.util.ListNode;
import io.github.lsr1991.leetcode.util.TestCase;

import java.util.Arrays;
import java.util.HashSet;
import java.util.Iterator;
import java.util.Random;

//
public class AddTwoNumbers {

	public static ListNode<Integer> solution(ListNode<Integer> headA, ListNode<Integer> headB) {
		ListNode<Integer> dummyA = new ListNode<Integer>(0);
		ListNode<Integer> dummyB = new ListNode<Integer>(0);
		dummyA.next = headA;
		dummyB.next = headB;
		int upAdd = 0;
		while (dummyA.next != null && dummyB.next != null) {
			int sum = dummyA.next.val + dummyB.next.val + upAdd;
			if (sum >= 10) {
				upAdd = 1;
				sum = sum % 10;
			} else {
				upAdd = 0;
			}
			dummyA.next.val = sum;
			dummyA = dummyA.next;
			dummyB = dummyB.next;
		}
		if (dummyA.next == null && dummyB.next == null) {
			if (upAdd == 1) {
				dummyA.next = new ListNode<Integer>(1);
			}
		} else if (dummyA.next == null) {
			dummyA.next = dummyB.next;
			while (dummyA.next != null) {
				int sum = dummyA.next.val + upAdd;
				if (sum == 10) {
					upAdd = 1;
					sum = 0;
				} else {
					upAdd = 0;
				}
				dummyA.next.val = sum;
				dummyA = dummyA.next;
			}
			if (upAdd == 1) {
				dummyA.next = new ListNode<Integer>(1);
			}
		} else {
			while (dummyA.next != null) {
				int sum = dummyA.next.val + upAdd;
				if (sum == 10) {
					upAdd = 1;
					sum = 0;
				} else {
					upAdd = 0;
				}
				dummyA.next.val = sum;
				dummyA = dummyA.next;
			}
			if (upAdd == 1) {
				dummyA.next = new ListNode<Integer>(1);
			}
		}
		return headA;
	}

	
	public static ListNode<Integer> solution2(ListNode<Integer> headA, ListNode<Integer> headB) {
		ListNode<Integer> dummy = new ListNode<Integer>(0);
		ListNode<Integer> head = dummy;
		int upAdd = 0;
		while (headA != null || headB != null || upAdd != 0) {
			int sum = 0;
			if (headA != null) {
				sum += headA.val;
				headA = headA.next;
			}
			if (headB != null) {
				sum += headB.val;
				headB = headB.next;
			}
			sum += upAdd;
			if (sum >= 10) {
				sum -= 10;
				upAdd = 1;
			} else {
				upAdd = 0;
			}
			head.next = new ListNode<Integer>(sum);
			head = head.next;
		}
		return dummy.next;
	}

	public ListNode<Integer> correct(ListNode<Integer> input, int val) {
		return null;
	}

	public static void runTestCase(TestData[] test) {
		for (int i = 0; i < test.length; i++) {
			ListNode<Integer> list1 = new ListNode<Integer>(test[i].listNode1);
			ListNode<Integer> list2 = new ListNode<Integer>(test[i].listNode2);
			test[i].printInput();
			test[i].printOutput();
			System.out.println("My output:");
			System.out.println(solution2(list1, list2));
		}
	}

	static class TestData {
		Integer[] listNode1;
		Integer[] listNode2;
		Integer[] expectOutput;

		public TestData(Integer[] listNode1, Integer[] listNode2, 
				Integer[] output) {
			this.listNode1 = listNode1;
			this.listNode2 = listNode2;
			this.expectOutput = output;
		}

		public void printInput() {
			System.out.println("Input:");
			System.out.println("List1:" + Arrays.toString(listNode1));
			System.out.println("List2:" + Arrays.toString(listNode2));
		}

		public void printOutput() {
			System.out.println("Expected output:");
			System.out.println(Arrays.toString(expectOutput));
		}
	}

	public static void main(String[] args) {
		TestData[] datas = new TestData[3];
		Integer[] in11 = { 3, 2, 4 };
		Integer[] in12 = { 1,2};
		Integer[] out1 = {4,4,4};
		datas[0] = new TestData(in11, in12,out1);
		Integer[] in21 = { 9,9,2};
		Integer[] in22 = {6,7,4,3};
		Integer[] out2 = {5,7,7,3};
		datas[1] = new TestData(in21, in22, out2);
		Integer[] in31 = { 9,9,9,9};
		Integer[] in32 = {1};
		Integer[] out3 = {0,0,0,0,1};
		datas[2] = new TestData(in31, in32, out3);
		
		runTestCase(datas);
	}

}
