package problems.M0074_搜索二维矩阵;

import org.junit.Assert;
import org.junit.Test;

public class Solution {

    // 每次找矩阵右上角
    public boolean searchMatrix(int[][] matrix, int target) {
        if (matrix == null || matrix.length == 0) {
            return false;
        }
        int rows = matrix.length, cols = matrix[0].length;
        int i = 0, j = cols - 1;
        while (i < rows && j >= 0) {
            if (matrix[i][j] == target) {
                return true;
            }
            else if (matrix[i][j] > target) {
                j -= 1;
            }
            else if (matrix[i][j] < target) {
                i += 1;
            }
        }
        return false;
    }

    @Test
    public void testSearchMatrix(){
        Assert.assertEquals(true, searchMatrix(new int[][]{new int[]{1,2,3}, new int[]{4,5,6}, new int[]{7,8,9}}, 9));
        Assert.assertEquals(true, searchMatrix(new int[][]{new int[]{1,2,3}, new int[]{4,5,6}, new int[]{7,8,9}}, 1));
        Assert.assertEquals(false, searchMatrix(new int[][]{new int[]{1,2,3}, new int[]{4,5,6}, new int[]{7,8,9}}, -1));
    }
}
