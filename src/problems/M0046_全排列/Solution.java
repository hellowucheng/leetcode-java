package problems.M0046_全排列;

import org.junit.Test;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class Solution {

    public List<List<Integer>> helper(List<Integer> nums) {
        if (nums.size() <= 1) {
            return Arrays.asList(nums);
        }
        List<List<Integer>> res = new ArrayList<>();
        for (int i = 0; i < nums.size(); i++) {
            List<Integer> copy = new ArrayList<>(nums);
            int tmp = copy.get(0);
            copy.set(0, copy.get(i));
            copy.set(i, tmp);
            for (List<Integer> list : helper(copy.subList(1, copy.size()))) {
                List<Integer> x = new ArrayList<>();
                x.add(copy.get(0));
                x.addAll(list);
                res.add(x);
            }
        }
        return res;
    }

    public List<List<Integer>> permute(int[] nums) {
        List<Integer> list = new ArrayList<>();
        for (int num : nums) {
            list.add(num);
        }
        return helper(list);
    }

    @Test
    public void testPermute(){
        System.out.println(permute(new int[]{}));
        System.out.println(permute(new int[]{1}));
        System.out.println(permute(new int[]{1,2}));
        System.out.println(permute(new int[]{1,2,3}));
    }
}
