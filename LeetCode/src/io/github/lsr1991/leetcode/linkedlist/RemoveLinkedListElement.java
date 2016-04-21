package io.github.lsr1991.leetcode.linkedlist;

import io.github.lsr1991.leetcode.util.ListNode;
import io.github.lsr1991.leetcode.util.TestCase;

import java.util.Arrays;
import java.util.HashSet;
import java.util.Iterator;
import java.util.Random;

//
public class RemoveLinkedListElement {

	public static ListNode<Integer> solution(ListNode<Integer> input, int val) {
		ListNode<Integer> res = input;
		ListNode<Integer> pos = input;
		ListNode<Integer> pre = null;
		while (pos != null) {
			if (pos.val == val) {
				if (pre == null) {
					res = pos.next;
				} else {
					pre.next = pos.next;
				}
			} else {
				pre = pos;
			}
			pos = pos.next;
		}
		return res;
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
			System.out.println(solution(input, test[i].val));			
		}
	}
	
	static class TestData {
		Integer[] listNode;
		int val;
		Integer[] expectOutput;

		public TestData(Integer[] listNode, int val, Integer[] output) {
			this.listNode = listNode;
			this.val = val;
			this.expectOutput = output;
		}
		
		public void printInput() {
			System.out.println("Input:");
			System.out.println(Arrays.toString(listNode));
			System.out.println(val);
		}
		
		public void printOutput() {
			System.out.println("Expected output:");
			System.out.println(Arrays.toString(expectOutput));
		}
	}

	public static void main(String[] args) {
		TestData[] datas = new TestData[3];
		Integer[] in1 = { 1, 2, 4, 6, 6, 5, 6 };
		Integer[] out11 = {1,2,4,5};
		Integer[] out12 = {1,2,6,6,5,6};
		datas[0] = new TestData(in1, 6, out11);
		datas[1] = new TestData(in1, 4, out12);
		Integer[] in2 = { 1 };
		Integer[] out2 = {};
		datas[2] = new TestData(in2, 1, out2);
		runTestCase(datas);
	}

}


