package io.github.lsr1991.leetcode.dynamicprogramming;

import io.github.lsr1991.leetcode.util.ListNode;
import io.github.lsr1991.leetcode.util.TestCase;

import java.util.*;

//
public class Triangle {

	/**
	 * use recursion
	 * 
	 * @param s
	 * @return
	 */
	public static int solution(List<List<Integer>> triangle) {
		if (triangle.size() == 1) {
			return triangle.get(0).get(0);
		}
		Integer[][] mins = new Integer[triangle.size()][];
		for (int i = 0; i < mins.length; i ++) {
			mins[i] = new Integer[i+1];
		}
		return getMin(mins, triangle, 1, 0);
	}

	private static int getMin(Integer[][] mins, List<List<Integer>> triangle, int level, int topIndex) {
		if (mins[level-1][topIndex] != null) {
			return mins[level-1][topIndex];
		}
		if (level == triangle.size()) {
			mins[level-1][topIndex] = triangle.get(level-1).get(topIndex);
		} else {
			mins[level-1][topIndex] = Math.min(getMin(mins, triangle, level+1, topIndex), getMin(mins, triangle, level +1, topIndex + 1)) + triangle.get(level-1).get(topIndex);
		}
		return mins[level-1][topIndex];
	}
	
	public static int solution2(List<List<Integer>> triangle) {
		int[] mins = new int[triangle.size()];
		for (int i = 0; i < mins.length; i ++) {
			mins[i] = triangle.get(triangle.size()-1).get(i);
		}
		for (int i = mins.length - 1; i >= 1; i --) {
			for (int j = 0; j < i; j ++) {
				mins[j] = Math.min(mins[j], mins[j+1]) + triangle.get(i-1).get(j);
			}
		}
		return mins[0];
	}


	public static void runTestCase(TestData[] test) {
		for (int i = 0; i < test.length; i++) {
			test[i].printInput();
			test[i].printOutput();
			System.out.println("My output:");
			System.out.println(solution2(test[i].triangle));
		}
	}

	static class TestData {
		List<List<Integer>> triangle;
		int expectOutput;

		public TestData(List<List<Integer>> triangle, int output) {
			this.triangle = triangle;
			this.expectOutput = output;
		}

		public void printInput() {
			System.out.println("Input:");
			System.out.println("triangle:" + triangle);
		}

		public void printOutput() {
			System.out.println("Expected output:");
			System.out.println(expectOutput);
		}
	}

	public static void main(String[] args) {
		TestData[] datas = new TestData[1];
		List<List<Integer>> in1 = new ArrayList<List<Integer>>();
		
		Integer[][] l = {{2},{3, 4},{6,5,7},{4,1,8,3}};
		for (int i = 0; i < l.length; i ++) {
			in1.add(Arrays.asList(l[i]));
		}
		int out1 = 11;
		datas[0] = new TestData(in1, out1);
		runTestCase(datas);
	}

}
