package problems.M0011_盛最多水的容器;

import org.junit.Assert;
import org.junit.Test;

public class Solution {

    public int maxArea(int[] height) {
        int l = 0, r = height.length - 1, area = 0;
        while (l < r){
            area = Math.max(area, Math.min(height[l], height[r]) * (r - l));
            if (height[l] <= height[r]){
                l += 1;
            }
            else {
                r -= 1;
            }
        }
        return area;
    }

    @Test
    public void testMaxArea(){
        Assert.assertEquals(4, maxArea(new int[]{1,2,3,4}));
        Assert.assertEquals(49, maxArea(new int[]{1,8,6,2,5,4,8,3,7}));
    }
}
