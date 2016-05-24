package io.github.lsr1991.leetcode.array;

import java.util.Arrays;
import java.util.HashMap;

public class MajorityElement {

	/**
	 * space O(n)
	 * @param nums
	 * @return
	 */
	public int majorityElement(int[] nums) {
		HashMap<Integer, Integer> map = new HashMap<>();
		if (nums.length == 1 || nums.length == 2) return nums[0];
		double max = Math.ceil((double)nums.length/2);
		for (int i = 0; i < nums.length; i ++) {
			Integer count = null;
			if ((count = map.get(nums[i])) != null) {
				if (count+1 >= max) return nums[i];
				map.put(nums[i], count+1);
			} else {
				map.put(nums[i], 1);
			}
		}
		return 1;
	}

	public int majorityElement2(int[] nums) {
		Arrays.sort(nums);
		return nums[nums.length/2];
	}

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		int[] nums = {1,2,3,4,4,4};
		System.out.println(new MajorityElement().majorityElement(nums));
	}

}
