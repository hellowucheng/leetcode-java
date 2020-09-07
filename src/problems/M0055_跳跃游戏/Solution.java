package problems.M0055_跳跃游戏;

import org.junit.Assert;
import org.junit.Test;

public class Solution {

    public boolean canJump(int[] nums) {
        int longest = 0;
        for (int i = 0; i < nums.length; i++) {
            if (longest < i) {
                return false;
            }
            longest = Math.max(longest, i + nums[i]);
        }
        return true;
    }

    @Test
    public void testCanJump(){
        Assert.assertEquals(true, canJump(new int[]{}));
        Assert.assertEquals(false, canJump(new int[]{1,0,1}));
        Assert.assertEquals(false, canJump(new int[]{0, 1, 2}));
        Assert.assertEquals(true, canJump(new int[]{1,1,1,1,1}));
        Assert.assertEquals(true, canJump(new int[]{4, 0, 0, 0, 0}));
    }
}
