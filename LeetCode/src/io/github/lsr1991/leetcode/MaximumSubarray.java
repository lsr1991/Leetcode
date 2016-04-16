package io.github.lsr1991.leetcode;

import io.github.lsr1991.leetcode.util.ListNode;
import io.github.lsr1991.leetcode.util.TestCase;

import java.util.Arrays;
import java.util.HashSet;
import java.util.Iterator;
import java.util.Random;

//
public class MaximumSubarray {

	/**
	 * bad solution, use N^2 running time
	 * 
	 * @param a
	 * @return
	 */
	public static int solution(int[] a) {
		if (a.length == 0)
			return 0;
		int[] sum = new int[a.length];
		sum[0] = a[0];
		for (int i = 1; i < sum.length; i++) {
			sum[i] = sum[i - 1] + a[i];
		}
		Integer[][] maxs = new Integer[a.length][a.length];
		return findMax(0, a.length - 1, sum, maxs, a);
	}

	private static int findMax(int i, int j, int[] sum, Integer[][] maxs,
			int[] a) {
		if (maxs[i][j] != null) {
			return maxs[i][j];
		}
		if (i == j)
			return getSum(i, i, sum);
		maxs[i][j - 1] = findMax(i, j - 1, sum, maxs, a);
		if (a[j] <= 0) {
			return maxs[i][j - 1];
		}
		maxs[i + 1][j] = findMax(i + 1, j, sum, maxs, a);
		int c = getSum(i, j, sum);
		return maxs[i][j - 1] > maxs[i + 1][j] ? (maxs[i][j - 1] > c ? maxs[i][j - 1]
				: c)
				: (maxs[i + 1][j] > c ? maxs[i + 1][j] : c);
	}

	private static int getSum(int i, int j, int[] sum) {
		if (i == 0) {
			return sum[j];
		} else {
			return sum[j] - sum[i - 1];
		}
	}

	/**
	 * this problem was discussed by Jon Bentley (Sep. 1984 Vol. 27 No. 9
	 * Communications of the ACM P885)
	 * 
	 * the paragraph below was copied from his paper (with a little
	 * modifications)
	 * 
	 * algorithm that operates on arrays: it starts at the left end (element
	 * A[1]) and scans through to the right end (element A[n]), keeping track of
	 * the maximum sum subvector seen so far. The maximum is initially A[0].
	 * Suppose we've solved the problem for A[1 .. i - 1]; how can we extend
	 * that to A[1 .. i]? The maximum sum in the first I elements is either the
	 * maximum sum in the first i - 1 elements (which we'll call MaxSoFar), or
	 * it is that of a subvector that ends in position i (which we'll call
	 * MaxEndingHere).
	 * 
	 * MaxEndingHere is either A[i] plus the previous MaxEndingHere, or just
	 * A[i], whichever is larger.
	 * 
	 * public static int maxSubArray(int[] A) { 
	 *     int maxSoFar=A[0], maxEndingHere=A[0]; 
	 *     for (int i=1;i<A.length;++i) { 
	 *         maxEndingHere = Math.max(maxEndingHere+A[i], A[i]); 
	 *         maxSoFar = Math.max(maxSoFar, maxEndingHere); 
	 *     } 
	 *     return maxSoFar; 
	 * }
	 * 
	 * @param a
	 * @return
	 */

	public static int solution2(int[] a) {
		int maxSubArraySumUntilI = a[0];
		int maxSumOfArrayEndingWithI = a[0];
		for (int i = 1; i < a.length; i++) {
			maxSumOfArrayEndingWithI = Math.max(
					maxSumOfArrayEndingWithI + a[i], a[i]);
			maxSubArraySumUntilI = Math.max(maxSubArraySumUntilI,
					maxSumOfArrayEndingWithI);
		}
		return maxSubArraySumUntilI;
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
		int out1 = 6;
		datas[0] = new TestData(in1, out1);
		int[] in2 = { -1, 0, -1, 2 };
		int out2 = 2;
		datas[1] = new TestData(in2, out2);
		runTestCase(datas);
	}

}
