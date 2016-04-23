package io.github.lsr1991.leetcode.dynamicprogramming;

public class UniquePaths {

	public int uniquePaths(int m, int n) {
		int[][] res = new int[m][n];
		return getPathCount(0, 0, n - 1, m - 1, res);
	}

	private int getPathCount(int x, int y, int endx, int endy, int[][] res) {
		if (res[y][x] != 0) {
			return res[y][x];
		}
		if (x == endx || y == endy) {
			res[y][x] = 1;
		} else {
			res[y][x] = getPathCount(x + 1, y, endx, endy, res)
					+ getPathCount(x, y + 1, endx, endy, res);
		}
		return res[y][x];
	}

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		System.out.println(new UniquePaths().uniquePaths(3, 7));
	}

}
