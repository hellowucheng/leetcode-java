package problems.M0079_单词搜索;

import org.junit.Assert;
import org.junit.Test;

public class Solution {

    private boolean dfs(int i, int j, int ptr, int row, int col, String word, char[][] board, boolean[][] visited) {
        if (ptr == word.length()){
            return true;
        }
        int[][] direction = {{-1, 0}, {1, 0}, {0, -1}, {0, 1}};
        visited[i][j] = true;
        for (int[] vec : direction) {
            int dx = vec[0], dy = vec[1];
            if (dx + i < row && dx + i >= 0 && dy + j < col && dy + j >= 0){
                if (!visited[i + dx][j + dy] && word.charAt(ptr) == board[i + dx][j + dy]){
                    if (dfs(i + dx, j + dy, ptr + 1, row, col, word, board, visited)){
                        return true;
                    }
                }
            }
        }
        visited[i][j] = false;
        return false;
    }

    public boolean exist(char[][] board, String word) {
        if(board == null || word == null || board.length == 0 || word.isEmpty()){
            throw new NullPointerException("char数组或word为空");
        }
        int row = board.length, col = board[0].length;
        boolean[][] visited = new boolean[row][col];
        for (int i = 0; i < row; i++) {
            for (int j = 0; j < col; j++) {
                if (word.charAt(0) == board[i][j]) {
                    if(dfs(i, j, 1, row, col, word, board, visited)){
                        return true;
                    }
                }
            }
        }
        return false;
    }

    @Test
    public void testExist(){
        char[][] board = new char[][]{{'A','B','C','E'}, {'S','F','C','S'}, {'A','D','E','E'}};
//        Assert.assertEquals(true, exist(board, ""));
        Assert.assertEquals(true, exist(board, "ABCCE"));
        Assert.assertEquals(true, exist(board, "SEE"));
        Assert.assertEquals(false, exist(board, "ABCB"));
        Assert.assertEquals(false, exist(board, "AZ"));
        Assert.assertEquals(true, exist(board, "F"));
    }
}
