package io.github.lsr1991.leetcode.array;

public class ContainerWithMostWater {
	
	/**
	 * reference:http://blog.csdn.net/wzy_1988/article/details/17248209
	 * @param height
	 * @return
	 */

	public int maxArea(int[] height) {
        int res = 0;
        if (height.length <= 1) return 0;
        int l = 0;
        int r = height.length-1;
        while (l < r) {
            if (height[l] <= height[r]) {
                int size = height[l]*(r-l);
                if (size > res) {
                    res = size;
                }
                l++;
            } else {
                int size = height[r]*(r-l);
                if (size > res) {
                    res = size;
                }
                r--;
            }
        }
        return res;
    }
	
	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}

}
