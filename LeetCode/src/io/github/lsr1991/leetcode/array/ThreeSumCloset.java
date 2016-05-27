package io.github.lsr1991.leetcode.array;

import java.util.Arrays;

public class ThreeSumCloset {

	/**
	 * O(n^2logn)
	 * @param nums
	 * @param target
	 * @return
	 */
	public int threeSumClosest(int[] nums, int target) {
        Arrays.sort(nums);
        int min = Integer.MAX_VALUE;
        int sum = 0;
        for (int i = 0; i < nums.length-2; i ++) {
            for (int j = i+1; j < nums.length-1; j ++) {
                int key = target - (nums[i] + nums[j]);
                int index = binarySearch(nums, j+1, nums.length-1, key);
                if (index == -1) return target; // find the key
                if (index == j) index = j+1;
                int res = Math.abs(nums[index] - key);
                if (res <= min) {
                    min = res;
                    sum = nums[i] + nums[j] + nums[index];
                }
            }
        }
        return sum;
    }
    
    private int binarySearch(int[] nums, int lo, int hi, int key) {
        if (lo >= hi) {
            if (nums[lo] == key) return -1;
            else if (nums[lo] > key) {
                if (lo == 0) return lo;
                else {
                    return key-nums[lo-1] > nums[lo]-key ? lo : lo-1;
                }
            } else {
                if (lo == nums.length-1) return lo;
                else {
                    return key-nums[lo] > nums[lo+1]-key ? lo+1 : lo;
                }
            }
        }
        int mid = (lo + hi)/2;
        if (nums[mid] == key) return -1;
        else if (nums[mid] > key) return binarySearch(nums, lo, mid-1, key);
        else return binarySearch(nums, mid+1, hi, key);
    }
	
    /**
     * O(n^2)
     * @param nums
     * @param target
     * @return
     */
    public int threeSumClosest2(int[] nums, int target) {
        Arrays.sort(nums);
        int closestDiff = nums[0] + nums[1] + nums[2] - target;
       for (int i = 0; i < nums.length-2; i ++) {
           int diff = twoSumClosestDiff(nums, target-nums[i], i+1);
           if (diff == 0) return target;
           if (Math.abs(diff) < Math.abs(closestDiff)) {
               closestDiff = diff;
           }
       }
       return target+closestDiff;
    }
    private int twoSumClosestDiff(int[] nums, int target, int start) {
        int l = start;
        int r = nums.length-1;
        int closestDiff = nums[start] + nums[start+1] - target;
        while (l < r) {
            int diff = nums[l] + nums[r] - target;
            if (diff == 0) return 0;
            if (Math.abs(diff) < Math.abs(closestDiff)) {
                closestDiff = diff;
            }
            if (diff > 0) {
                r--;
            } else {
                l++;
            }
        }
        return closestDiff;
    }
    
	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}

}
