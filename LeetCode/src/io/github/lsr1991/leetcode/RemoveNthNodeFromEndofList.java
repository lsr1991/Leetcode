package io.github.lsr1991.leetcode;

import io.github.lsr1991.leetcode.util.ListNode;
import io.github.lsr1991.leetcode.util.TestCase;

import java.util.Arrays;
import java.util.HashSet;
import java.util.Iterator;
import java.util.Random;

//
public class RemoveNthNodeFromEndofList {

	public static ListNode<Integer> solution(ListNode<Integer> head, int n) {
		ListNode<Integer> dummy = new ListNode<Integer>(0);
		dummy.next = head;
		ListNode<Integer> pos1 = dummy;
		int count = 0;
		while (pos1.next != null) {
			pos1 = pos1.next;
			count ++;
			if (count == n) {
				break;
			}
		}
		ListNode<Integer> pos2 = dummy;
		while (pos1.next != null) {
			pos1 = pos1.next;
			pos2 = pos2.next;
		}
		pos2.next = pos2.next.next;
		return dummy.next;
	}

	public ListNode<Integer> correct(ListNode<Integer> input, int val) {
		return null;
	}

	public static void runTestCase(TestData[] test) {
		for (int i = 0; i < test.length; i++) {
			ListNode<Integer> list = new ListNode<Integer>(test[i].listNode);
			test[i].printInput();
			test[i].printOutput();
			System.out.println("My output:");
			System.out.println(solution(list, test[i].n));
		}
	}

	static class TestData {
		Integer[] listNode;
		int n;
		Integer[] expectOutput;

		public TestData(Integer[] listNode, int n,
				Integer[] output) {
			this.listNode = listNode;
			this.n = n;
			this.expectOutput = output;
		}

		public void printInput() {
			System.out.println("Input:");
			System.out.println("List1:" + Arrays.toString(listNode));
			System.out.println("nth:" + n);
		}

		public void printOutput() {
			System.out.println("Expected output:");
			System.out.println(Arrays.toString(expectOutput));
		}
	}

	public static void main(String[] args) {
		TestData[] datas = new TestData[2];
		Integer[] in1 = { 1, 2, 4, 5, 6, 6 };
		Integer[] out1 = {1,2,4,6,6};
		datas[0] = new TestData(in1, 3,out1);
		Integer[] in2 = { 1};
		Integer[] out2 = {};
		datas[1] = new TestData(in2, 1, out2);
		runTestCase(datas);
	}

}
