package problems.M0130_被围绕的区域;

import my.ds.UnionFindSet;
import my.utils.Show;
import org.junit.Test;

public class Solution {

    public void solve(char[][] board) {
        if (board == null || board.length == 0) {
            return;
        }
        int row = board.length, col = board[0].length;
        UnionFindSet ufs = new UnionFindSet(row * col + 1);
        for (int i = 0; i < row; i++) {
            for (int j = 0; j < col; j++) {
                if (board[i][j] == 'O') {
                    // 位于边界
                    if (i == 0 || j == 0 || i == row - 1 || j == col - 1) {
                        ufs.union(i * col + j, row * col);
                    }
                    else {
                        for (int[] direction : new int[][]{{-1, 0}, {0, -1}, {1, 0}, {0, 1}}) {
                            int offsetX = direction[0], offsetY = direction[1];
                            if (board[i + offsetX][j + offsetY] == 'O') {
                                ufs.union((i + offsetX) * col + j + offsetY, i * col + j);
                            }
                        }
                    }
                }
            }
        }
        for (int i = 1; i < row - 1; i++) {
            for (int j = 1; j < col -1; j++) {
                if (!ufs.isConnected(i * col + j, row * col)) {
                    board[i][j] = 'X';
                }
            }
        }
    }

    @Test
    public void testSolve() {
        char[][] board;

        board = new char[][]{{'X', 'X', 'X', 'X'}, {'X', 'O', 'O', 'X'}, {'X', 'X', 'O', 'X'}, {'X', 'O', 'X', 'X'}};
        solve(board);
        Show.showMatrix(board);

        board = new char[][]{{'X', 'O', 'X', 'X'}, {'X', 'X', 'X', 'X'}, {'X', 'X', 'X', 'X'}, {'X', 'X', 'X', 'X'}};
        solve(board);
        Show.showMatrix(board);
    }

}
