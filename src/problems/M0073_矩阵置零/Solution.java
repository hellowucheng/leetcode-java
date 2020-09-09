package problems.M0073_矩阵置零;

import my.utils.Show;
import org.junit.Test;

import java.util.Arrays;

public class Solution {

    public void setZeroes(int[][] matrix) {
        if (matrix == null || matrix.length == 0){
            return;
        }
        int rows = matrix.length, cols = matrix[0].length;
        boolean rowZero = false, colZero = false;
        for (int i = 0; i < rows; i++) {
            if (matrix[i][0] == 0) {
                colZero = true;
            }
        }
        for (int i = 0; i < cols; i++) {
            if (matrix[0][i] == 0) {
                rowZero = true;
            }
        }

        for (int i = 0; i < rows; i++) {
            for (int j = 0; j < cols; j++) {
                if (matrix[i][j] == 0) {
                    matrix[i][0] = 0;
                    matrix[0][j] = 0;
                }
            }
        }

        for (int i = 1; i < rows; i++) {
            for (int j = 1; j < cols; j++) {
                if (matrix[i][0] == 0 || matrix[0][j] == 0) {
                    matrix[i][j] = 0;
                }
            }
        }
        if (rowZero) {
            for (int i = 0; i < cols; i++) {
                matrix[0][i] = 0;
            }
        }
        if (colZero) {
            for (int i = 0; i < rows; i++) {
                matrix[i][0] = 0;
            }
        }
    }

    @Test
    public void testSetZeros(){
        int[][] matrix = new int[][]{{1,1,1}, {1,0,1}, {1,1,1}};
        setZeroes(matrix);
        Show.showMatrix(matrix);

        int[][] matrix2 = new int[][]{{0,1,2,0},{3,4,5,2},{1,3,1,5}};
        setZeroes(matrix2);
        Show.showMatrix(matrix2);
    }
}
