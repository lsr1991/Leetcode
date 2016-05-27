package io.github.lsr1991.leetcode.array;

public class RotateImage {
	public void rotate(int[][] matrix) {
		if (matrix.length <= 1)
			return;
		rotate(matrix, 0, 0, matrix.length - 1, matrix[0].length - 1);
	}

	private void rotate(int[][] matrix, int top, int left, int bottom, int right) {
		if (top >= bottom)
			return;
		rotate(matrix, top + 1, left + 1, bottom - 1, right - 1);
		for (int i = left; i < right; i++) {
			int tmp = matrix[top][i];
			int d = i - left;
			matrix[top][i] = matrix[bottom - d][left];
			matrix[bottom - d][left] = matrix[bottom][right - d];
			matrix[bottom][right - d] = matrix[top + d][right];
			matrix[top + d][right] = tmp;
		}
	}

	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}

}
