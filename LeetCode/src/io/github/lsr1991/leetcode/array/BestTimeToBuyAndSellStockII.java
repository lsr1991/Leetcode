package io.github.lsr1991.leetcode.array;

public class BestTimeToBuyAndSellStockII {

	public int maxProfit(int[] prices) {
        int[] peakAndValleyPoints = new int[prices.length];
        int size = 0;
        if (prices.length <= 1) return 0;
        for (int i = 0; i < prices.length; i ++) {
            if (i > 0 && i < prices.length-1) {
                if (prices[i] == prices[i-1] && prices[i] == prices[i+1]) continue; // flat point, not store
                else if (prices[i] >= prices[i-1] && prices[i] >= prices[i+1]) {
                    peakAndValleyPoints[size++] = prices[i]; // peak point, store the price as a positive value
                } else if (prices[i] <= prices[i-1] && prices[i] <= prices[i+1]) {
                    peakAndValleyPoints[size++] = -prices[i]; // valley point, store the price as a negative value
                }
            } else if (i == 0) {
                if (prices[i] > prices[i+1]) {
                    peakAndValleyPoints[size++] = prices[i];
                } else if (prices[i] < prices[i+1]) {
                    peakAndValleyPoints[size++] = -prices[i];
                } else continue;
            } else {
                if (prices[i] > prices[i-1]) {
                    peakAndValleyPoints[size++] = prices[i];
                } else if (prices[i] < prices[i-1]) {
                    peakAndValleyPoints[size++] = -prices[i];
                } else continue;
            }
        }
        int profit = 0;
        for (int i = 1; i < size; i ++) {
            if (peakAndValleyPoints[i] > 0 && peakAndValleyPoints[i-1] <= 0) {
                profit += (peakAndValleyPoints[i] + peakAndValleyPoints[i-1]);
            }
        }
        return profit;
    }
	
	/**
	 * more efficient one 
	 * @param prices
	 * @return
	 */
	public int maxProfit2(int[] prices) {
        if (prices.length <= 1) return 0;
        int[] changes = new int[prices.length-1];
        for (int i = 1; i < prices.length; i ++) {
            changes[i-1] = prices[i] - prices[i-1];
        }
        int profit = 0;
        for (int i = 0; i < changes.length; i ++) {
            if (changes[i] > 0) {
                profit += changes[i];
            }
        }
        return profit;
    }
	
	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}

}
