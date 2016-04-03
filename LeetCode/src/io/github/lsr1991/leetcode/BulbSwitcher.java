package io.github.lsr1991.leetcode;
import io.github.lsr1991.leetcode.util.TestCase;

import java.util.Arrays;
import java.util.HashSet;
import java.util.Iterator;
import java.util.Random;
//Passed
public class BulbSwitcher extends TestCase<Integer, Integer>{

	@Override
	public Integer[] solution(Integer[] input) {
		int n = input[0];
		Integer[] res = new Integer[1];
		res[0] = (int)Math.sqrt(n);
		return res;
	}
	
	@Override
	public Integer[] correct(Integer[] input) {
		int n = input[0];
		Integer[] res = new Integer[1];
		boolean[] bulbs = new boolean[n];
		for (int i = 0; i < bulbs.length; i ++) {
			bulbs[i] = true;
		}
		for (int i = 2; i <= n; i ++) {
			for (int j = i-1; j < bulbs.length; j += i) {
				bulbs[j] ^= true;
			}
//			System.out.println(Arrays.toString(bulbs));
		}
//		System.out.println("correct:" + Arrays.toString(bulbs));
		res[0] = 0;
		for (int i = 0; i < bulbs.length; i ++) {
			res[0] += bulbs[i] ? 1 : 0;
		}
		return res;
	}
	
	@Override
	public Integer[] generateInput(Random r) {
		Integer[] input = new Integer[1];
		input[0] = r.nextInt(10000);
//		input[0] = 5;
		return input;
	}
	
	public static void main(String[] args) {
		new BulbSwitcher().test(10);
//		System.out.println(Arrays.toString(new SingleNumber().generateInput(new Random())));
//		BulbSwitcher s = new BulbSwitcher();
//		Integer[] input = s.generateInput(new Random());
//		System.out.println(Arrays.toString(input));
//		System.out.println(Arrays.toString(s.solution(input)));
	}

}
