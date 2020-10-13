package problems.E0136_只出现一次的数字;

import org.junit.Assert;
import org.junit.Test;

public class Solution {

    public int singleNumber(int[] nums) {
        int result = 0;
        for (int num : nums) {
            result = result ^ num;
        }
        return result;
    }

    @Test
    public void testSingleNumber() {
        Assert.assertEquals(1, singleNumber(new int[]{1, 2, 2, 3, 3}));
        Assert.assertEquals(2, singleNumber(new int[]{1, 3, 4, 3, 4, 2, 1, 5, 5}));
    }
}
