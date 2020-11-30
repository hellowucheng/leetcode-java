package problems.E0001_两数之和;

import org.junit.Test;

import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;

public class Solution {

    /* 哈希表加速查找 */
    public int[] twoSum(int[] nums, int target) {
        Map<Integer, Integer> indexMap = new HashMap<>();
        for (int i = 0; i < nums.length; i++) {
            if (indexMap.containsKey(target - nums[i])) {
                return new int[]{i, indexMap.get(target - nums[i])};
            }
            indexMap.put(nums[i], i);
        }
        return new int[]{-1, -1};
    }

    @Test
    public void testTwoSum(){
        int[] nums = {1,4,13,5,10};
        System.out.println(Arrays.toString(twoSum(nums, 14)));
        System.out.println(Arrays.toString(twoSum(nums, 11)));
        System.out.println(Arrays.toString(twoSum(nums, 20)));
    }
} 
