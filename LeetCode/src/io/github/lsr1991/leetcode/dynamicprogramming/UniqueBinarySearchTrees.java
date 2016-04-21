package io.github.lsr1991.leetcode.dynamicprogramming;

import io.github.lsr1991.leetcode.util.ListNode;
import io.github.lsr1991.leetcode.util.TestCase;

import java.util.Arrays;
import java.util.HashSet;
import java.util.Iterator;
import java.util.Random;

//
public class UniqueBinarySearchTrees {

	public static int solution(int n) {
        if (n <= 1) {
            return 1;
        }
        int[] t = new int[n+1];
        t[0] = 1;
        t[1] = 1;
        return getT(t, n);
    }
    
    private static int getT(int[] t, int n) {
        if (t[n] != 0) {
            return t[n];
        }
        for (int i = 0; i < n; i ++) {
            t[n] += getT(t, n-i-1)*getT(t, i);
        }
        return t[n];
    }

	public static void runTestCase(TestData[] test) {
		for (int i = 0; i < test.length; i++) {
			test[i].printInput();
			test[i].printOutput();
			System.out.println("My output:");
			System.out.println(solution(test[i].n));
		}
	}

	static class TestData {
		int n;
		int expectOutput;

		public TestData(int n, int output) {
			this.n = n;
			this.expectOutput = output;
		}

		public void printInput() {
			System.out.println("Input:");
			System.out.println("n:" + n);
		}

		public void printOutput() {
			System.out.println("Expected output:");
			System.out.println(expectOutput);
		}
	}

	public static void main(String[] args) {
		TestData[] datas = new TestData[1];
		int in1 = 3;
		int out1 = 5;
		datas[0] = new TestData(in1, out1);
		runTestCase(datas);
	}

}
