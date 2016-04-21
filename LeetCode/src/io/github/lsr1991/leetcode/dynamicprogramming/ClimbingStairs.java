package io.github.lsr1991.leetcode.dynamicprogramming;


public class ClimbingStairs {
	public int climbStairs(int n) {
		if (n == 1) return 1;
		if (n == 2) return 2;
		int Nsub1 = 2;
		int Nsub2 = 1;
		int N = 0;
		for (int i = 3; i <= n; i ++) {
			N = Nsub1 + Nsub2;
			Nsub2 = Nsub1;
			Nsub1 = N;
		}
		return N;
	}
	public static void main(String[] args) {
		System.out.println(new ClimbingStairs().climbStairs(5));
	}
}
