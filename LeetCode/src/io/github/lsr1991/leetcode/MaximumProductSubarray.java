package io.github.lsr1991.leetcode;

import io.github.lsr1991.leetcode.util.ListNode;
import io.github.lsr1991.leetcode.util.TestCase;

import java.util.Arrays;
import java.util.HashSet;
import java.util.Iterator;
import java.util.Random;

//
public class MaximumProductSubarray {

	/**
	 * 
	 * @param a
	 * @return
	 */
	public static int solution(int[] a) {
		int maxProductOfSubArrayBeforeI = a[0];
		int maxProductOfSubArrayEndingWithI = a[0];
		int minProductOfSubArrayEndingWithI = a[0];
		for (int i = 1; i < a.length; i++) {
				int tmp1 = maxProductOfSubArrayEndingWithI * a[i];
				int tmp2 = minProductOfSubArrayEndingWithI * a[i];
				maxProductOfSubArrayEndingWithI = Math.max(Math.max(tmp1, tmp2), a[i]);
				minProductOfSubArrayEndingWithI = Math.min(Math.min(tmp1, tmp2), a[i]);
				maxProductOfSubArrayBeforeI = Math.max(maxProductOfSubArrayBeforeI, maxProductOfSubArrayEndingWithI);
		}
		return maxProductOfSubArrayBeforeI;
	}

	public static void runTestCase(TestData[] test) {
		for (int i = 0; i < test.length; i++) {
			test[i].printInput();
			test[i].printOutput();
			System.out.println("My output:");
			System.out.println(solution(test[i].array));
		}
	}

	static class TestData {
		int[] array;
		int expectOutput;

		public TestData(int[] array, int output) {
			this.array = array;
			this.expectOutput = output;
		}

		public void printInput() {
			System.out.println("Input:");
			System.out.println("array:" + Arrays.toString(array));
		}

		public void printOutput() {
			System.out.println("Expected output:");
			System.out.println(expectOutput);
		}
	}

	public static void main(String[] args) {
		TestData[] datas = new TestData[2];
		int[] in1 = { -3, 2, 4 };
		int out1 = 8;
		datas[0] = new TestData(in1, out1);
		int[] in2 = { -1, 0, -1, 2 };
		int out2 = 2;
		datas[1] = new TestData(in2, out2);
		runTestCase(datas);
	}

}
