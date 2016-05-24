package io.github.lsr1991.leetcode.array;

public class FindMinimumInRotatedSortedArray {

	 public int findMin(int[] nums) {
	        int l = 0; 
	        int r = nums.length-1;
	        if (nums[l] <= nums[r]) return nums[l];
	        int mid;
	        while(l < r-1) {
	            mid = (l+r)/2;
	            if (nums[mid] > nums[l]) {
	                l = mid;
	            } else {
	                r = mid;
	            }
	        }
	        return nums[r];
	    }
	
	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}

}
