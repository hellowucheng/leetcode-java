package problems.H0128_最长连续序列;


import org.junit.Assert;
import org.junit.Test;

import java.util.Arrays;
import java.util.HashSet;
import java.util.Set;

public class Solution {

    public int longestConsecutive(int[] nums) {
        Set<Integer> numSet = new HashSet<>();
        for (int num : nums) {
            numSet.add(num);
        }
        int result = 0;
        for (Integer num : numSet) {
            if (!numSet.contains(num - 1)) {
                int cur = num;
                while (numSet.contains(cur)) cur += 1;
                result = Math.max(result, cur - num);
            }
        }
        return result;
    }

    @Test
    public void testLongestConsecutive(){
        Assert.assertEquals(4, longestConsecutive(new int[]{100, 4, 200, 1, 3, 2}));
        Assert.assertEquals(3, longestConsecutive(new int[]{1, 1, 5, 10, 3, 3, 3, 7, 9, 2, 2, 2, 2}));
    }
}
