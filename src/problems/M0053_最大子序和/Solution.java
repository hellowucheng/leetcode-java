package problems.M0053_最大子序和;

import org.junit.Assert;
import org.junit.Test;

public class Solution {

    public int maxSubArray(int[] nums) {
        if (nums == null || nums.length == 0) {
            return 0;
        }
        int b = 0, s = nums[0];
        for (int num : nums) {
            b = b > 0 ? b + num : num;
            s = Math.max(s, b);
        }
        return s;
    }

    @Test
    public void testMaxSubArray(){
        Assert.assertEquals(0, maxSubArray(new int[]{}));
        Assert.assertEquals(-1, maxSubArray(new int[]{-1}));
        Assert.assertEquals(-1, maxSubArray(new int[]{-1, -1, -1}));
        Assert.assertEquals(3, maxSubArray(new int[]{1, 1, -1, 2}));
        Assert.assertEquals(6, maxSubArray(new int[]{-2,1,-3,4,-1,2,1,-5,4}));
    }
}
