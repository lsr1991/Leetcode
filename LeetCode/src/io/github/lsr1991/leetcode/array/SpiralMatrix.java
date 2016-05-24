package io.github.lsr1991.leetcode.array;

import java.util.ArrayList;
import java.util.List;

public class SpiralMatrix {

	public List<Integer> spiralOrder(int[][] matrix) {
        List<Integer> res = new ArrayList<Integer>();
        if (matrix.length == 0) return res;
        addOneCircle(res, 0, 0, matrix.length-1, matrix[0].length-1, matrix);
        return res;
    }
    
    private void addOneCircle(List<Integer> res, int top, int left, int bottom, int right, int[][] matrix) {
        if (top > bottom || left > right) return;
        for (int i = left; i <= right; i ++) {
            res.add(matrix[top][i]);
        }
        for (int i = top+1; i <= bottom; i ++) {
            res.add(matrix[i][right]);
        }
        if (top == bottom || left == right) return;
        for (int i = right-1; i >= left; i --) {
            res.add(matrix[bottom][i]);
        }
        for (int i = bottom-1; i >= top+1; i --) {
            res.add(matrix[i][left]);
        }
        addOneCircle(res, top+1, left+1, bottom-1, right-1, matrix);
    }
	
	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}

}
