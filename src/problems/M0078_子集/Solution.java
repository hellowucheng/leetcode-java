package problems.M0078_子集;

import org.junit.Test;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;

public class Solution {

    public List<List<Integer>> subsets(int[] nums) {
        List<List<Integer>> result = new LinkedList<>();
        for (int i = 0; i < (1 << nums.length); i++) {
            int k = i, j = 0;
            List<Integer> sub = new LinkedList<>();
            while (k != 0) {
                if ((k & 1) == 1){
                    sub.add(nums[j]);
                }
                j += 1;
                k >>= 1;
            }
            result.add(sub);
        }
        return result;
    }

    @Test
    public void testSubsets(){
        System.out.println(subsets(new int[]{1,2}));
        System.out.println(subsets(new int[]{1,2,3}));
    }
}
