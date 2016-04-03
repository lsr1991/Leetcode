package io.github.lsr1991.leetcode;
import io.github.lsr1991.leetcode.util.TestCase;

import java.util.Arrays;
import java.util.HashSet;
import java.util.Random;
// Passed
public class SingleNumber extends TestCase<Integer, Integer>{

	// XOR fits the associative law and commutative law
	// a^b = b^a
	// (a^b)^c = a^(b^c)
	@Override
	public Integer[] solution(Integer[] input) {
		Integer[] res = new Integer[1];
		res[0] = 0;
		for (int i = 0; i < input.length; i ++) {
			res[0] ^= input[i];
		}
		return res;
	}
	
	@Override
	public Integer[] correct(Integer[] input) {
		Integer[] res = new Integer[1];
		HashSet<Integer> set = new HashSet<Integer>();
		for (int i = 0; i < input.length; i ++) {
			if (!set.remove(input[i])) {
				set.add(input[i]);
			}
		}
		res[0] = set.iterator().next();
		return res;
	}
	
	@Override
	public Integer[] generateInput(Random r) {
		int n = 10; // even
		Integer[] input = new Integer[n + 1];
		for (int i = 1; i < n; i += 2) {
			input[i] = r.nextInt();
			input[i - 1] = input[i]; 
		}
		input[n] = 0;
		Integer single = null;
		while (Arrays.binarySearch(input, single = r.nextInt()) >= 0) {
			// nothing
		}
		input[n] = single;
		shuffle(input, r);
		return input;
	}
	
	public static void main(String[] args) {
		new SingleNumber().test(10);
//		System.out.println(Arrays.toString(new SingleNumber().generateInput(new Random())));
//		SingleNumber s = new SingleNumber();
//		Integer[] input = s.generateInput(new Random());
//		System.out.println(Arrays.toString(input));
//		System.out.println(Arrays.toString(s.correct(input)));
	}

}
