package io.github.lsr1991.leetcode.dynamicprogramming;

public class MinimumPathSum {

	public int minPathSum(int[][] grid) {
		if (grid.length == 0) {
			return 0;
		}
		int m = grid.length;
		int n = grid[0].length;
		int[][] minSums = new int[m][n];
		for (int i = 0; i < m; i ++) {
			for (int j = 0; j < n; j ++) {
				minSums[i][j] = -1;
			}
		}
		return getMinPathSum(0, 0, n-1, m-1, minSums, grid);
	}
	
	private int getMinPathSum(int x, int y, int endX, int endY, int[][] minSums, int[][] grid) {
		if (minSums[y][x] != -1) {
			return minSums[y][x];
		}
		if (x == endX && y == endY) {
			minSums[y][x] = grid[y][x];
		} else if (x == endX) {
			minSums[y][x] = getMinPathSum(x, y+1, endX, endY, minSums, grid) + grid[y][x];
		} else if (y == endY) {
			minSums[y][x] = getMinPathSum(x+1, y, endX, endY, minSums, grid) + grid[y][x];
		} else {
			minSums[y][x] = Math.min(getMinPathSum(x+1, y, endX, endY, minSums, grid), getMinPathSum(x, y+1, endX, endY, minSums, grid)) + grid[y][x];
		}
		return minSums[y][x];
	}

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		int[][] a = {{1,2,2},{0,0,3},{0,4,0}};
		int[][] a2 = {{1}};
		System.out.println(new MinimumPathSum().minPathSum(a2));
	}

}
