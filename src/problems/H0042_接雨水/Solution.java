package problems.H0042_接雨水;

import org.junit.Assert;
import org.junit.Test;

public class Solution {

    public int trap(int[] height) {
        if (height.length < 3) {
            return 0;
        }
        int rain = 0, l = 1, r = height.length - 2;
        int maxLeft = height[0], maxRight = height[height.length - 1];
        while (l <= r) {
            maxLeft = Math.max(height[l - 1], maxLeft);
            maxRight = Math.max(height[r + 1], maxRight);
            if (maxLeft <= maxRight) {
                if (maxLeft > height[l]) {
                    rain += (maxLeft - height[l]);
                }
                l += 1;
            }
            else {
                if (maxRight > height[r]) {
                    rain += (maxRight - height[r]);
                }
                r -= 1;
            }
        }
        return rain;
    }

    @Test
    public void testTrap(){
        Assert.assertEquals(0, trap(new int[]{1,2,3,4}));
        Assert.assertEquals(0, trap(new int[]{}));
        Assert.assertEquals(1, trap(new int[]{2,1,3}));
    }
}
