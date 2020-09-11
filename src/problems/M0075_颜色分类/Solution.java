package problems.M0075_颜色分类;

import my.utils.Show;
import org.junit.Test;

import java.util.Arrays;

public class Solution {

    public void sortColors(int[] nums) {
        if (nums == null || nums.length == 0) {
            return;
        }
        int l = 0, r = nums.length - 1, cur = l;
        while (cur <= r) {
            if (nums[cur] == 1) {
                cur += 1;
            }
            else if (nums[cur] == 0) {
                nums[cur] = nums[l];
                nums[l] = 0;
                l += 1; cur += 1;
            }
            else if (nums[cur] == 2) {
                nums[cur] = nums[r];
                nums[r] = 2;
                r -= 1;
            }
        }
    }

    @Test
    public void testSortColors(){
        int[] nums1 = new int[]{0, 0, 0, 0, 0};
        sortColors(nums1);
        Show.showArray(nums1);

        int[] nums2 = new int[]{1,1,2,0,0,2,1};
        sortColors(nums2);
        Show.showArray(nums2);
    }
}
