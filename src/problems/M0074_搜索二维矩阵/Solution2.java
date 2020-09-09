package problems.M0074_搜索二维矩阵;

import org.junit.Assert;
import org.junit.Test;

public class Solution2 {

    // 可以将二维矩阵摊平，做二分查找
    public boolean searchMatrix(int[][] matrix, int target) {
        if (matrix == null || matrix.length == 0) {
            return false;
        }
        int rows = matrix.length, cols = matrix[0].length;
        int length = rows * cols;
        int l = 0, r = length - 1;
        while (l <= r) {
            int mid = (l + r) / 2;
            int val = matrix[mid / cols][mid % cols];
            if (val == target) {
                return true;
            }
            else if (val > target) {
                r = mid - 1;
            }
            else if (val < target) {
                l = mid + 1;
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
