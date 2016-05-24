package io.github.lsr1991.leetcode.array;

import java.util.Arrays;

public class TwoSum {

	
	public int[] twoSum(int[] nums, int target) {
		int[] res = new int[2];
		for (int i = 0; i < nums.length; i ++) {
			for (int j = i+1; j < nums.length; j ++) {
				if (nums[i] + nums[j] == target) {
					res[0] = i;
					res[1] = j;
					return res;
				}
			}
		}
		return null;
	}
	
	
	/**
	 * cannot use this solution because it cannot return the original indexs of the found elements
	 * @param nums
	 * @param target
	 * @return
	 */
	public int[] twoSum2(int[] nums, int target) {
		Arrays.sort(nums);
		int[] res = new int[2];
		for (int i = 0; i < nums.length; i ++) {
			int matched = binarySearch(nums, target-nums[i], i+1, nums.length-1);
			if (matched != -1) {
				res[0] = nums[i];
				res[1] = nums[matched];
				return res;
			}
		}
		return null;
	}
	
	private int binarySearch(int[] nums, int key, int lo, int hi) {
		if (lo > hi) return -1;
		int mid = (lo + hi)/2;
		if (nums[mid] == key) return mid;
		else if (nums[mid] < key) return binarySearch(nums, key, lo, mid-1);
		else return binarySearch(nums, key, mid+1, hi);
	}

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		int[] nums = {7,2,3,4,5,6,1};
		System.out.println(Arrays.toString(new TwoSum().twoSum(nums, 8)));
	}

}
