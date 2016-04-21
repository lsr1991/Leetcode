package io.github.lsr1991.leetcode.dynamicprogramming;
import io.github.lsr1991.leetcode.util.TestCase;

import java.util.Arrays;
import java.util.HashSet;
import java.util.Iterator;
import java.util.Random;

public class BestTimeToBuyAndSellStockII extends TestCase<Integer, Integer>{

	@Override
	public Integer[] solution(Integer[] input) {
		Integer[] res = new Integer[input.length];
		// TODO
		return res;
	}
	
	@Override
	public Integer[] correct(Integer[] input) {
		Integer[] res = new Integer[input.length];
		return res;
	}
	
	@Override
	public Integer[] generateInput(Random r) {
		int n = 10; // even
		Integer[] input = new Integer[n];
		for (int i = 0; i < n; i ++) {
			input[i] = r.nextInt(4) + 1;
		}
		return input;
	}
	
	public static void main(String[] args) {
		new BestTimeToBuyAndSellStockII().test(10);
//		System.out.println(Arrays.toString(new SingleNumber().generateInput(new Random())));
//		ProductOfArrayExceptSelf s = new ProductOfArrayExceptSelf();
//		Integer[] input = s.generateInput(new Random());
//		System.out.println(Arrays.toString(input));
//		System.out.println(Arrays.toString(s.correct(input)));
	}

}
