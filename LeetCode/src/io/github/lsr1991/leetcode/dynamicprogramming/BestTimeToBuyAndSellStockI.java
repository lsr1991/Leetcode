package io.github.lsr1991.leetcode.dynamicprogramming;


public class BestTimeToBuyAndSellStockI {
	public int maxProfit(int[] prices) {
		if (prices.length < 2) return 0;
		int minPrice = Integer.MAX_VALUE;
		int maxProfit = 0;
		for (int i = 0; i < prices.length; i ++) {
			maxProfit = Math.max(maxProfit, prices[i] - minPrice);
			if (prices[i] < minPrice) minPrice = prices[i];
		}
		return maxProfit;
	}

	public static void main(String[] args) {
		int[] a = {1,2,3,2,1};
		System.out.println(new BestTimeToBuyAndSellStockI().maxProfit(a));
	}
}
