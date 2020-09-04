package problems.H0041_缺失的第一个正数;

import org.junit.Assert;
import org.junit.Test;

public class Solution {

    public int firstMissingPositive(int[] nums) {
        for (int i = 0; i < nums.length; i++) {
            while (1 <= nums[i] && nums[i] <= nums.length && nums[i] != nums[nums[i] - 1]) {
                int tmp = nums[nums[i] - 1];
                nums[nums[i] - 1] = nums[i];
                nums[i] = tmp;
            }
        }
        for (int i = 0; i < nums.length; i++) {
            if (nums[i] - 1 != i){
                return i + 1;
            }
        }
        return nums.length + 1;
    }

    @Test
    public void testFirstMissingPositive(){
        Assert.assertEquals(1, firstMissingPositive(new int[]{2,3}));
        Assert.assertEquals(2, firstMissingPositive(new int[]{1,3,4}));
        Assert.assertEquals(3, firstMissingPositive(new int[]{1,2}));
        Assert.assertEquals(1, firstMissingPositive(new int[]{}));
    }
}
