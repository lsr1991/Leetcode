package io.github.lsr1991.leetcode.array;

import java.util.Arrays;
import java.util.HashSet;

public class ContainsDuplicate {

	public boolean containsDuplicate(int[] nums) {
		HashSet<Integer> set = new HashSet<Integer>();
		for (int i = 0; i < nums.length; i ++) {
			if (set.contains(nums[i])) {
				return true;
			} else {
				set.add(nums[i]);
			}
		}
		return false;
	}
	
	public boolean containsDuplicate2(int[] nums) {
		Arrays.sort(nums);
		for (int i = 1; i < nums.length; i ++) {
			if (nums[i] == nums[i-1]) {
				return true;
			}
		}
		return false;
	}

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		int[] a = {1,2,3,4,2,6,7};
		int[] b = {1,2,3,4,5,6,7,8};
		System.out.println(new ContainsDuplicate().containsDuplicate2(a));
		System.out.println(new ContainsDuplicate().containsDuplicate2(b));
	}

}
