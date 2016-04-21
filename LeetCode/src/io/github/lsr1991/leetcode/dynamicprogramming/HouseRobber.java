package io.github.lsr1991.leetcode.dynamicprogramming;


public class HouseRobber {
	public int rob(int[] nums) {
		if (nums.length == 0) return 0;
		int sumsIsub2 = 0;
		int sumsIsub1 = nums[0];
		int sumsI = sumsIsub1;
		for (int i = 2; i <= nums.length; i ++) {
			sumsI = Math.max(sumsIsub1, sumsIsub2 + nums[i-1]);
			sumsIsub2 = sumsIsub1;
			sumsIsub1 = sumsI;
		}
		return sumsI;
	}
	public static void main(String[] args) {
		int[] nums = {1,2,3,2,1};
		System.out.println(new HouseRobber().rob(nums));
	}
}
