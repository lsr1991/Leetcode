package io.github.lsr1991.leetcode.array;

public class RemoveDuplicatesfromSortedArray {

	public int removeDuplicates(int[] nums) {
        if (nums.length == 0) return 0;
        int store = 1;
        for (int check = 1; check < nums.length; check ++) {
            if (nums[check] != nums[check-1]) {
                nums[store++] = nums[check];
            }
        }
        return store;
    }
	
	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}

}
