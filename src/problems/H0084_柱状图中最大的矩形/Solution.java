package problems.H0084_柱状图中最大的矩形;

import org.junit.Assert;
import org.junit.Test;

public class Solution {

    public int largestRectangleArea(int[] heights) {
        if(heights == null || heights.length == 0){
            throw new RuntimeException("输入为空");
        }
        // 找每根柱子左侧和右侧第一根小于它的柱子
        int[] leftLess = new int[heights.length], rightLess = new int[heights.length];
        leftLess[0] = -1; rightLess[heights.length - 1] = heights.length;
        for (int i = 1; i < heights.length; i++) {
            int l = i - 1;
            while (l >= 0 && heights[l] >= heights[i]) {
                l = leftLess[l];
            }
            leftLess[i] = l;
        }
        for (int i = heights.length - 2; i >= 0; i--) {
            int r = i + 1;
            while (r < heights.length && heights[r] >= heights[i]) {
                r = rightLess[r];
            }
            rightLess[i] = r;
        }
        int area = 0;
        for (int i = 0; i < heights.length; i++) {
            area = Math.max(area, (rightLess[i] - leftLess[i] - 1) * heights[i]);
        }
        return area;
    }

    @Test
    public void testLargestRectangleArea(){
        Assert.assertEquals(5, largestRectangleArea(new int[]{1,2,1,2,3}));
        Assert.assertEquals(1, largestRectangleArea(new int[]{1}));
        Assert.assertEquals(3, largestRectangleArea(new int[]{1,3}));
    }
}
