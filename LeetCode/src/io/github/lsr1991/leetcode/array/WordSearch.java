package io.github.lsr1991.leetcode.array;

public class WordSearch {

	public boolean exist(char[][] board, String word) {
        int row = board.length;
        int col = board[0].length;
        boolean[][] visited = new boolean[row][col];
        for (int i = 0; i < row; i ++) {
            for (int j = 0; j < col; j ++) {
                if (find(i, j, visited, board, word, 0, row, col)) return true;
            }
        }
        return false;
    }
    
    private boolean find(int x, int y, boolean[][] visited, char[][] board, String word, int begin, int row, int col) {
        if (begin == word.length()) return true;
        if (x < 0 || y < 0 || x >= row || y >= col) return false;
        if (visited[x][y]) return false;
        if (board[x][y] != word.charAt(begin)) return false;
        visited[x][y] = true;
        if (find(x-1, y, visited, board, word, begin+1, row, col)) return true;
        if (find(x+1, y, visited, board, word, begin+1, row, col)) return true;
        if (find(x, y-1, visited, board, word, begin+1, row, col)) return true;
        if (find(x, y+1, visited, board, word, begin+1, row, col)) return true;
        visited[x][y] = false;
        return false;
    }
	
	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}

}
