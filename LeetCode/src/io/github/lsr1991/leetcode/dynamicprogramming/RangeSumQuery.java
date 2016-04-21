package io.github.lsr1991.leetcode.dynamicprogramming;


public class RangeSumQuery {
	public static void main(String[] args) {
		int[] nums = {1,3,5,0,-6,2};
		NumArray num = new NumArray(nums);
		System.out.println(num.sumRange(0,5));
		System.out.println(num.sumRange(0,1));
	}
}

class NumArray {

	private int[] sums = null;
	public NumArray(int[] nums) {
		sums = new int[nums.length];
		sums[0] = nums[0];
		for (int i = 1; i < sums.length; i ++) {
			sums[i] = sums[i-1] + nums[i];
		}
	}
	public int sumRange(int i, int j) {
		return i > 0 ? sums[j] - sums[i-1] : sums[j];
	}
}
