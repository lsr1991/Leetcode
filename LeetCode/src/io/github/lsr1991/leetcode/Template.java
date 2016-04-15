package io.github.lsr1991.leetcode;
import io.github.lsr1991.leetcode.util.TestCase;

import java.util.Arrays;
import java.util.HashSet;
import java.util.Iterator;
import java.util.Random;
@Deprecated
public class Template extends TestCase<Integer, Integer>{

	@Override
	public Integer[] solution(Integer[] input) {
		return null;
	}
	
	@Override
	public Integer[] correct(Integer[] input) {
		return null;
	}
	
	@Override
	public Integer[] generateInput(Random r) {
		int n = 10;
		return null;
	}
	
	public static void main(String[] args) {
		new Template().test(10);
		Template s = new Template();
		Integer[] input = s.generateInput(new Random());
		System.out.println(Arrays.toString(input));
		System.out.println(Arrays.toString(s.correct(input)));
	}

}
