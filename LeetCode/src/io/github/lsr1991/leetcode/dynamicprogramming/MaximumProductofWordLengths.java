package io.github.lsr1991.leetcode.dynamicprogramming;

import io.github.lsr1991.leetcode.util.TestCase;
import io.github.lsr1991.leetcode.util.TreeNode;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Random;
import java.util.Stack;
//Passed
public class MaximumProductofWordLengths extends TestCase<String, Integer> {

	@Override
	public Integer[] solution(String[] input) {
		int[] wordInBits = getWordBits(input);
		int max = 0;
		for (int i = 0; i < wordInBits.length; i ++) {
			for (int j = i + 1; j < wordInBits.length; j ++) {
				if ((wordInBits[j] & wordInBits[i]) == 0) { // no common
					int product = input[i].length() * input[j].length();
					if (product > max) {
						max = product;
					}
				}
			}
		}
		Integer[] res = new Integer[1];
		res[0] = max;
		return res;
	}
	
	private int[] getWordBits(String[] words) {
		int[] wordInBits = new int[words.length];
		for (int i = 0; i < words.length; i ++) {
			wordInBits[i] = 0;
			for (int j = 0; j < words[i].length(); j ++) {
				wordInBits[i] = setBit(wordInBits[i], words[i].charAt(j) - 'a');
			}
		}
		return wordInBits;
	}
	
	private int setBit(int i, int index) {
		return i | (1 << index);
	}

	@Override
	public Integer[] correct(String[] input) {
		int max = 0;
		for (int i = 0; i < input.length; i ++) {
			outer:
			for (int j = i + 1; j < input.length; j ++) {
				for (int k = 0; k < input[i].length(); k ++) {
					for (int l = 0; l < input[j].length(); l ++) {
						if (input[j].charAt(l) == input[i].charAt(k)) {
							continue outer;
						}
					}
				}
				int product = input[j].length() * input[i].length();
				if (product > max) max = product;
			}
		}
		Integer[] res = new Integer[1];
		res[0] = max;
		return res;
	}

	@Override
	public String[] generateInput(Random r) {
		int n = 10;
		String[] input = new String[n];
		for (int i = 0; i < input.length; i ++) {
			char[] tmp = new char[(r.nextInt(5) + 1)];
			for (int j = 0; j < tmp.length; j ++) {
				tmp[j] = (char)(r.nextInt(26) + 'a');
			}
			input[i] = new String(tmp);
		}
		return input;
	}

	public static void main(String[] args) {
		new MaximumProductofWordLengths().test(10);
		// System.out.println(Arrays.toString(new
		// SingleNumber().generateInput(new Random())));
//		MaximumProductofWordLengths s = new MaximumProductofWordLengths();
//		String[] input = s.generateInput(new Random());
//		System.out.println(Arrays.toString(input));
//		System.out.println(Arrays.toString(s.correct(input)));
	}

}
