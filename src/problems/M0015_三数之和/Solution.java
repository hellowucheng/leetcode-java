package problems.M0015_三数之和;

import org.junit.Test;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class Solution {

    public List<List<Integer>> threeSum(int[] nums) {
        Arrays.sort(nums);
        List<List<Integer>> result = new ArrayList<>();
        for (int i = 0; i < nums.length; i++) {
            // 跳过重复
            if (i > 0 && nums[i] == nums[i - 1]) {
                continue;
            }
            int l = i + 1, r = nums.length - 1;
            while (l < r) {
                if (nums[i] + nums[l] + nums[r] == 0){
                    result.add(Arrays.asList(nums[i], nums[l], nums[r]));
                    // 跳过重复
                    while (l < r && nums[l] == nums[++l]);
                    while (l < r && nums[r] == nums[--r]);
                }
                else if (nums[i] + nums[l] + nums[r] < 0) {
                    l += 1;
                }
                else if (nums[i] + nums[l] + nums[r] > 0) {
                    r -= 1;
                }
            }
        }
        return result;
    }

    private void print(List<List<Integer>> res){
        StringBuilder sb = new StringBuilder();
        for (List<Integer> re : res) {
            for (Integer integer : re) {
                sb.append(integer).append(" ");
            }
            sb.append("\n");
        }
        System.out.println(sb.toString());;
    }

    @Test
    public void testThreeSum(){
        print(threeSum(new int[]{-1, 1, 0, 1, -1, 2, -1, -4}));;
    }
}
