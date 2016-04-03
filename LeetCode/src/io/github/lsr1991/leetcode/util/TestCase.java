package io.github.lsr1991.leetcode.util;

import java.util.Arrays;
import java.util.Random;

public abstract class TestCase<Input, Output> {
	public void test(int num) {
		boolean isPassed = true;
		outer: for (int i = 0; i < num; i++) {
			Input[] in1 = generateInput(new Random());
			Input[] in2 = copy(in1);
			Output[] res1 = solution(in1);
			Output[] res2 = correct(in2);
			if (res1.length != res2.length) {
				isPassed = false;
				System.out.println("size of output != answer !!!");
				print(res1, res2);
				break outer;
			}
			for (int j = 0; j < res1.length; j ++) {
				if (!res1[j].equals(res2[j])) {
					isPassed = false;
					print(res1, res2);
					break outer;
				}
			}
		}
		System.out.println(isPassed ? "Passed!" : "");
	}
	
	public void print(Output[] res1, Output[] res2) {
		System.out.println("output: " + Arrays.toString(res1));
		System.out.println("answer: " + Arrays.toString(res2));
	}
	
	public void shuffle(Input[] input, Random r) {
		for (int i = 0; i < input.length; i ++) {
			exch(input, i, r.nextInt(input.length));
		}
	}
	
	private void exch(Input[] input, int i, int j) {
		Input tmp = input[i];
		input[i] = input[j];
		input[j] = tmp;
	}
	
	public abstract Input[] generateInput(Random r);

	public Input[] copy(Input[] input1) {
		return Arrays.copyOf(input1, input1.length);
	}

	public abstract Output[] correct(Input[] input);

	public abstract Output[] solution(Input[] input);
}
