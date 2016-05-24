package io.github.lsr1991.leetcode.array;

public class MoveZeroes {

	public void moveZeroes(int[] nums) {
		int store = 0;
		for (int check = 0; check < nums.length; check++) {
			if (nums[check] != 0) {
				nums[store++] = nums[check];
			}
		}
		for (int i = store; i < nums.length; i++) {
			nums[i] = 0;
		}
	}

	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}

}
