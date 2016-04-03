package io.github.lsr1991.leetcode;
import io.github.lsr1991.leetcode.util.TestCase;

import java.util.Arrays;
import java.util.HashSet;
import java.util.Iterator;
import java.util.Random;
//Passed
public class MissingNumber extends TestCase<Integer, Integer>{

	@Override
	public Integer[] solution(Integer[] input) {
		Integer[] res = new Integer[1];
		int sum = 0;
		for (int i = 0; i < input.length; i ++) {
			sum += input[i];
		}
		res[0] = input.length * (input.length + 1) / 2 - sum;
		return res;
	}
	
	@Override
	public Integer[] correct(Integer[] input) {
		Integer[] res = new Integer[1];
		Arrays.sort(input);
		res[0] = input.length;
		for (int i = 1; i < input.length; i ++) {
			if ((input[i] - input[i-1]) != 1) {
				res[0] = input[i] - 1;
				break;
			}
		}
		return res;
	}
	
	@Override
	public Integer[] generateInput(Random r) {
		int n = 10;
		Integer[] input = new Integer[n];
		int theLossOne = r.nextInt(n+1);
		int i = 0;
		while (i < n) {
			if (i < theLossOne) input[i] = i;
			else input[i] = i + 1; 
			i ++;
		}
		shuffle(input, r);
		return input;
	}
	
	public static void main(String[] args) {
		new MissingNumber().test(10);
//		System.out.println(Arrays.toString(new SingleNumber().generateInput(new Random())));
//		MissingNumber s = new MissingNumber();
//		Integer[] input = s.generateInput(new Random());
//		System.out.println(Arrays.toString(input));
//		System.out.println(Arrays.toString(s.solution(input)));
	}

}
