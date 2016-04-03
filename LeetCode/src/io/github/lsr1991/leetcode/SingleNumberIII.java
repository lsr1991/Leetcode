package io.github.lsr1991.leetcode;
import io.github.lsr1991.leetcode.util.TestCase;

import java.util.Arrays;
import java.util.HashSet;
import java.util.Iterator;
import java.util.Random;

public class SingleNumberIII extends TestCase<Integer, Integer>{

	@Override
	public Integer[] solution(Integer[] input) {
		Integer[] res = new Integer[1];
		// TODO
		return res;
	}
	
	@Override
	public Integer[] correct(Integer[] input) {
		Integer[] res = new Integer[2];
		HashSet<Integer> set = new HashSet<Integer>();
		for (int i = 0; i < input.length; i ++) {
			if (!set.remove(input[i])) {
				set.add(input[i]);
			}
		}
		Iterator<Integer> it = set.iterator();
		int i = 0;
		while (it.hasNext()) {
		  res[i ++] = it.next();
		}
		return res;
	}
	
	@Override
	public Integer[] generateInput(Random r) {
		int n = 10; // even
		Integer[] input = new Integer[n + 2];
		for (int i = 1; i < n; i += 2) {
			input[i] = r.nextInt();
			input[i - 1] = input[i]; 
		}
		input[n] = 0;
		input[n + 1] = 0;
		Integer single = null;
		while (Arrays.binarySearch(input, single = r.nextInt()) >= 0) {
			// nothing
		}
		input[n] = single;
		while (Arrays.binarySearch(input, single = r.nextInt()) >= 0) {
			// nothing
		}
		input[n + 1] = single;
		shuffle(input, r);
		return input;
	}
	
	public static void main(String[] args) {
//		new SingleNumberIII().test(10);
//		System.out.println(Arrays.toString(new SingleNumber().generateInput(new Random())));
//		SingleNumberIII s = new SingleNumberIII();
//		Integer[] input = s.generateInput(new Random());
//		System.out.println(Arrays.toString(input));
//		System.out.println(Arrays.toString(s.correct(input)));
	}

}
