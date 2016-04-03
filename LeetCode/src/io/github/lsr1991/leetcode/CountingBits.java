package io.github.lsr1991.leetcode;
import io.github.lsr1991.leetcode.util.TestCase;

import java.util.Arrays;
import java.util.Random;
//Passed
public class CountingBits extends TestCase<Integer, Integer>{

	@Override
	public Integer[] solution(Integer[] input) {
		Integer[] res = new Integer[input[0] + 1];
		res[0] = 0;
		for (int i = 1; i < res.length; i++) {
			if ((i & 1) == 0) {
				res[i] = res[i >> 1];
			} else {
				res[i] = res[i - 1] + 1;
			}
		}
		return res;
	}
	
	@Override
	public Integer[] correct(Integer[] input) {
		Integer[] res = new Integer[input[0] + 1];
		for (int i = 0; i < res.length; i++) {
			res[i] = 0;
			String binary = Integer.toBinaryString(i);
			for (int j = 0; j < binary.length(); j++) {
				if (binary.charAt(j) == '1')
					res[i]++;
			}
		}
		return res;
	}
	
	@Override
	public Integer[] generateInput(Random r) {
		Integer[] input = new Integer[1];
		input[0] = r.nextInt(100);
		return input;
	}
	
	public static void printArray(int[] res, int start, int end) {
		for (int i = start; i < end; i++) {
			System.out.print(res[i] + " ");
		}
		System.out.println();
	}

	public static void main(String[] args) {
		new CountingBits().test(10);
	}

}
