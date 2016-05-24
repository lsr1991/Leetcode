package io.github.lsr1991.leetcode.array;

import java.util.Arrays;

public class RemoveElement {

	public int removeElement(int[] nums, int val) {
		int k = 0;
		for (int i = 0; i < nums.length; i ++) {
			if (nums[i] != val) {
				nums[k++] = nums[i]; 
			}
		}
		return k;
	}

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		int[] nums = {3,2,2,3,3,2};
		System.out.println(new RemoveElement().removeElement(nums, 2));
		System.out.println(Arrays.toString(nums));
	}

}
