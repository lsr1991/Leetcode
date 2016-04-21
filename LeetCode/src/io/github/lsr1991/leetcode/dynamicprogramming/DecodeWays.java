package io.github.lsr1991.leetcode.dynamicprogramming;

import io.github.lsr1991.leetcode.util.ListNode;
import io.github.lsr1991.leetcode.util.TestCase;

import java.util.Arrays;
import java.util.HashSet;
import java.util.Iterator;
import java.util.Random;

//
public class DecodeWays {

	/**
	 * use recursion
	 * 
	 * @param s
	 * @return
	 */
	public static int solution(String s) {
		int[] t = new int[s.length() + 1];
		for (int i = 0; i < t.length; i++) {
			t[i] = -1;
		}
		return t(0, s, t);
	}

	private static int t(int i, String s, int[] t) {
		if (t[i] != -1) {
			return t[i];
		}
		if (i > s.length() - 1) {
			t[i] = 1;
		} else if (i == s.length() - 1) {
			if (s.charAt(i) == '0') {
				t[i] = 0;
			} else {
				t[i] = 1;
			}
		} else if (s.charAt(i) == '1') {
			t[i] = t(i + 1, s, t) + t(i + 2, s, t);
		} else if (s.charAt(i) == '2') {
			if (s.charAt(i + 1) > '6') {
				t[i] = t(i + 1, s, t);
			} else {
				t[i] = t(i + 1, s, t) + t(i + 2, s, t);
			}
		} else if (s.charAt(i) == '0') {
			t[i] = 0;
		} else {
			t[i] = t(i + 1, s, t);
		}
		return t[i];
	}

	/**
	 * use iteration
	 * 
	 * @param s
	 * @return
	 */
	public static int solution2(String s) {
		if (s.length() == 0) {
			return 0;
		}
		int[] t = new int[s.length()];
		char s0 = s.charAt(0);
		char s1 = s.charAt(1);
		if (s0 == '0') {
			return 0;
		} else if (s0 == '1') {
			if (s1 == '0') {
				t[0] = t[1] = 1;
			} else {
				t[0] = 1;
				t[1] = 2;
			}
		} else if (s0 == '2') {
			if (s1 > '6' || s1 == '0') {
				t[0] = t[1] = 1;
			} else {
				t[0] = 1;
				t[1] = 2;
			}
		} else {
			if (s1 == '0') {
				return 0;
			} else {
				t[0] = t[1] = 1;
			}
		}
		for (int i = 2; i < t.length; i++) {
			char pre = s.charAt(i - 1);
			char cur = s.charAt(i);
			if (cur == '0') {
				if (pre == '1' || pre == '2') {
					t[i] = t[i - 2];
				} else {
					t[i] = 0;
				}
			} else {
				if (pre == '1') {
					t[i] = t[i - 1] + t[i - 2];
				} else if (pre == '2') {
					if (cur > '6') {
						t[i] = t[i - 1];
					} else {
						t[i] = t[i - 1] + t[i - 2];
					}
				} else {
					t[i] = t[i - 1];
				}
			}
		}
		return t[s.length() - 1];
	}

	/**
	 * cannot understanding why it is true
	 * 
	 * @param s
	 * @return
	 */
	public static int correct(String s) {
		int n = s.length();
		if (n == 0)
			return 0;

		int[] memo = new int[n + 1];
		memo[n] = 1;
		memo[n - 1] = s.charAt(n - 1) != '0' ? 1 : 0;

		for (int i = n - 2; i >= 0; i--)
			if (s.charAt(i) == '0')
				continue;
			else
				memo[i] = (Integer.parseInt(s.substring(i, i + 2)) <= 26) ? memo[i + 1]
						+ memo[i + 2]
						: memo[i + 1];

		return memo[0];
	}

	public static void runTestCase(TestData[] test) {
		for (int i = 0; i < test.length; i++) {
			test[i].printInput();
			test[i].printOutput();
			System.out.println("My output:");
			System.out.println(solution2(test[i].s));
		}
	}

	static class TestData {
		String s;
		int expectOutput;

		public TestData(String s, int output) {
			this.s = s;
			this.expectOutput = correct(s);
		}

		public void printInput() {
			System.out.println("Input:");
			System.out.println("s:" + s);
		}

		public void printOutput() {
			System.out.println("Expected output:");
			System.out.println(expectOutput);
		}
	}

	public static void main(String[] args) {
		TestData[] datas = new TestData[1];
		String in1 = "101010101010101010101010101010101010101010101010101010101010101010101010101010101010101010101010101010101010101010101010101010101010101010101010101010101010101010101010101010101010101010101010101010101010101010101010101010101010101010101010101010101010101010101010101010101010101010101010101010101010101010101010101010101010101010101010101010101010101010101010101010101010101010101010101010101010101010101010101010101010101010101010101010101010101010101010101010101010101010101010101010101010101010101010101010101010101010101010101010101010101010101010101010101010101010101010101010101010101010101010101010101010101010101010101010101010101010101010101010101010101010101010101010101010101010101010101010101010101010101010101010101010101010101010101010101010101010101010101010101010101010101010101010101010101010101010101010101010101010101010101010101010101010101010101010101010101010101010101010101010101010101010101010101010101010101010101010101010101010101010101010101010101010101010101010101010101010101010101010101010101010101010101010101010101010101010101010101010101010101010101010101010101010101010101010101010101010101010101010101010101010101010101010101010101010101010101010101010101010101010101010101010101010101010101010101010101010101010101010101010101010101010101010101010101010101010101010101010101010101010101010101010101010101010101010101010101010101010101010101010101010101010101010101010101010101010101010101010101010101010101010101010101010101010101010101010101010101010101010101010101010101010101010101010101010101010101010101010101010101010101010101010101010101010101010101010101010101010101010101010101010101010101010101010101010101010101010101010101010101010101010101010101010101010101010101010101010101010101010101010101010101010101010101010101010101010101010101010101010101010101010101010101010101010101010101010101010101010101010101010101010101010101010101010101010101010101010101010101010101010101010101010101010101010101010101010101010101010101010101010101010101010101010101010101010101010101010101010101010101010101010101010101010101010101010101010101010101010";
		int out1 = 2;
		datas[0] = new TestData(in1, out1);
		runTestCase(datas);
	}

}
