package io.github.lsr1991.leetcode.array;

public class RotateArray {

	 public void rotate(int[] nums, int k) {
	        int[] res = new int[nums.length];
	        for (int i = 0; i < nums.length; i ++) {
	            res[i] = nums[i];
	        }
	        for (int i = 0; i < nums.length; i ++) {
	            nums[(i+k)%nums.length] = res[i];
	        }
	    }
	 
	 public void rotate2(int[] nums, int k) {
	        int lastOneToMoveForward = (nums.length-1+k)%nums.length;
	        int[] tmp = new int[lastOneToMoveForward+1];
	        int m = 0;
	        int FirstOneToMoveForward = nums.length-1-lastOneToMoveForward;
	        for (int i = FirstOneToMoveForward; i < nums.length; i ++) {
	            tmp[m++] = nums[i];
	        }
	        m = 0;
	        for (int i = FirstOneToMoveForward-1; i >= 0; i --) {
	            nums[nums.length-1-m] = nums[i];
	            m++;
	        }
	        for (int i = 0; i < tmp.length; i ++) {
	            nums[i] = tmp[i];
	        }
	    }
	
	 /**
	  * O(1) space 
	  * @param nums
	  * @param k
	  */
	 public void rotate3(int[] nums, int k) {
	        k = k % nums.length;
	        reverse(nums, 0, nums.length-k-1);
	        reverse(nums, nums.length-k, nums.length-1);
	        reverse(nums, 0, nums.length-1);
	    }
	    
	    private void reverse(int[] nums, int lo, int hi) {
	        while (lo < hi) {
	            int tmp = nums[lo];
	            nums[lo] = nums[hi];
	            nums[hi] = tmp;
	            lo++;
	            hi--;
	        }
	    }
	 
	 
	public static void main(String[] args) {
		// TODO Auto-generated method stub
	}

}
