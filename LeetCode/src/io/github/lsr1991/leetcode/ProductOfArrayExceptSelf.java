package io.github.lsr1991.leetcode;
import io.github.lsr1991.leetcode.util.TestCase;

import java.util.Arrays;
import java.util.HashSet;
import java.util.Iterator;
import java.util.Random;
//Passed
public class ProductOfArrayExceptSelf extends TestCase<Integer, Integer>{

	@Override
	public Integer[] solution(Integer[] input) {
		Integer[] res = new Integer[input.length];
		Integer left = 1;
		for (int i = 0; i < res.length; i ++) {
			res[i] = left;
			left *= input[i];
		}
		Integer right = 1;
		for (int i = res.length - 1; i >= 0; i --) {
			res[i] *= right;
			right *= input[i]; 
		}
		return res;
	}
	
	@Override
	public Integer[] correct(Integer[] input) {
		Integer[] res = new Integer[input.length];
		for (int i = 0; i < res.length; i ++) {
			res[i] = 1;
			for (int j = 0; j < res.length; j ++) {
				if (j != i) {
					res[i] *= input[j]; 
				}
			}
		}
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
		new ProductOfArrayExceptSelf().test(10);
//		System.out.println(Arrays.toString(new SingleNumber().generateInput(new Random())));
//		ProductOfArrayExceptSelf s = new ProductOfArrayExceptSelf();
//		Integer[] input = s.generateInput(new Random());
//		System.out.println(Arrays.toString(input));
//		System.out.println(Arrays.toString(s.correct(input)));
	}

}
