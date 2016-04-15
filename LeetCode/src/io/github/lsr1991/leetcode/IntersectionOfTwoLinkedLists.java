package io.github.lsr1991.leetcode;

import io.github.lsr1991.leetcode.util.ListNode;
import io.github.lsr1991.leetcode.util.TestCase;

import java.util.Arrays;
import java.util.HashSet;
import java.util.Iterator;
import java.util.Random;

//
public class IntersectionOfTwoLinkedLists {

	public static ListNode<Integer> solution(ListNode<Integer> head1,
			ListNode<Integer> head2) {
		ListNode<Integer> dummy1 = new ListNode<Integer>(0);
		dummy1.next = head1;
		ListNode<Integer> dummy2 = new ListNode<Integer>(0);
		dummy2.next = head2;
		ListNode<Integer> pos1 = dummy1;
		ListNode<Integer> pos2 = dummy2;
		ListNode<Integer> inter = null;
		while (pos1.next != null && pos2.next != null) {
			pos1 = pos1.next;
			pos2 = pos2.next;
		}
		ListNode<Integer> longer = null;
		ListNode<Integer> tail1 = null;
		ListNode<Integer> tail2 = null;
		if (pos1.next == null && pos2.next == null) {
			pos1 = head1;
			pos2 = head2;
		} else {
			if (pos1.next == null) {
				tail1 = pos1;
				pos1 = head1;
				longer = pos2;
				pos2 = head2;
				while (longer.next != null) {
					longer = longer.next;
					pos2 = pos2.next;
				}
				tail2 = longer;
			} else {
				tail2 = pos2;
				pos2 = head2;
				longer = pos1;
				pos1 = head1;
				while (longer.next != null) {
					longer = longer.next;
					pos1 = pos1.next;
				}
				tail1 = longer;
			}
		}
		if (tail1 != tail2) {
			return null;
		}
		// System.out.println(pos1);
		// System.out.println(pos2);
		while (pos1 != null) {
			if (pos1 == pos2) {
				inter = pos1;
				break;
			}
			pos1 = pos1.next;
			pos2 = pos2.next;
		}
		return inter;
	}

	public ListNode<Integer> correct(ListNode<Integer> input, int val) {
		return null;
	}

	public static void runTestCase(TestData[] test) {
		for (int i = 0; i < test.length; i++) {
			ListNode<Integer> list1 = new ListNode<Integer>(test[i].listNode1);
			ListNode<Integer> list2 = new ListNode<Integer>(test[i].listNode2);
			ListNode<Integer> pos1 = list1;
			if (test[i].inter != 0) {
				int count = 1;
				while (pos1 != null) {
					if (count == test[i].inter) {
						break;
					}
					pos1 = pos1.next;
					count++;
				}
				ListNode<Integer> pos2 = list2;
				while (pos2 != null && pos2.next != null) {
					pos2 = pos2.next;
				}
				pos2.next = pos1;
			}
			test[i].printInput();
			test[i].printOutput();
			System.out.println("My output:");
			System.out.println(solution(list1, list2));
		}
	}

	static class TestData {
		Integer[] listNode1;
		Integer[] listNode2;
		int inter;
		Integer[] expectOutput;

		public TestData(Integer[] listNode1, Integer[] listNode2, int inter,
				Integer[] output) {
			this.listNode1 = listNode1;
			this.listNode2 = listNode2;
			this.inter = inter;
			this.expectOutput = output;
		}

		public void printInput() {
			System.out.println("Input:");
			System.out.println("List1:" + Arrays.toString(listNode1));
			System.out.println("List2:" + Arrays.toString(listNode2));
			System.out.println("Inter:" + inter + "th of list1");
		}

		public void printOutput() {
			System.out.println("Expected output:");
			System.out.println(Arrays.toString(expectOutput));
		}
	}

	public static void main(String[] args) {
		TestData[] datas = new TestData[4];
		Integer[] in11 = { 1, 2, 4, 5, 6, 6 };
		Integer[] in12 = { 1, 3, 5 };
		Integer[] out11 = { 4, 5, 6, 6 };
		Integer[] out12 = { 5, 6, 6 };
		Integer[] out13 = {};
		datas[0] = new TestData(in11, in12, 3, out11);
		datas[1] = new TestData(in11, in12, 4, out12);
		datas[2] = new TestData(in11, in12, 0, out13);
		Integer[] in21 = { 1 };
		Integer[] in22 = { 2 };
		Integer[] out2 = { 1 };
		datas[3] = new TestData(in21, in22, 1, out2);
		runTestCase(datas);
	}

}
