package problems.E0026_删除排序数组中的重复项;

import org.junit.Assert;
import org.junit.Test;

public class Solution {

    public int removeDuplicates(int[] nums) {
        if (nums.length == 0){
            return 0;
        }
        int l = 0, r = 0;
        while (r < nums.length) {
            if (nums[r] != nums[l]){
                nums[++l] = nums[r];
            }
            r += 1;
        }
        return l + 1;
    }

    @Test
    public void testRemoveDuplicates(){
        Assert.assertEquals(5, removeDuplicates(new int[]{1,1,2,2,3,3,3,4,5}));
        Assert.assertEquals(0, removeDuplicates(new int[]{}));
        Assert.assertEquals(1, removeDuplicates(new int[]{1}));
    }
}
