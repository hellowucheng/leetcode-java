package problems.M0048_旋转图像;

import my.utils.Show;
import org.junit.Test;

public class Solution {

    // 转置 + 反转每一行
    public void rotate(int[][] matrix) {
        for (int i = 0; i < matrix.length; i++) {
            for (int j = 0; j < i; j++) {
                int tmp = matrix[i][j];
                matrix[i][j] = matrix[j][i];
                matrix[j][i] = tmp;
            }
        }
        for (int i = 0; i < matrix.length; i++) {
            int l = 0, r = matrix[i].length - 1;
            while (l < r){
                int tmp = matrix[i][l];
                matrix[i][l] = matrix[i][r];
                matrix[i][r] = tmp;
                l += 1;
                r -= 1;
            }
        }
    }

    @Test
    public void testRotate() {
        int[][] matrix;
        matrix = new int[][]{};
        rotate(matrix);
        Show.showMatrix(matrix);

        matrix = new int[][]{{1}};
        rotate(matrix);
        Show.showMatrix(matrix);

        matrix = new int[][]{{1,2}, {3,4}};
        rotate(matrix);
        Show.showMatrix(matrix);

        matrix = new int[][]{{1,2,3}, {4,5,6}, {7,8,9}};
        rotate(matrix);
        Show.showMatrix(matrix);
    }
}
