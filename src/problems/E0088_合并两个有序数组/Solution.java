package problems.E0088_合并两个有序数组;

import my.utils.Show;
import org.junit.Test;

public class Solution {
    public void merge(int[] nums1, int m, int[] nums2, int n) {
        int k = m + n - 1;
        while (m > 0 && n > 0) {
            if (nums1[m-1] >= nums2[n-1]) {
                nums1[k--] = nums1[--m];
            }
            else {
                nums1[k--] = nums2[--n];
            }
        }
        while (n > 0) {
            nums1[k--] = nums2[--n];
        }
    }

    @Test
    public void testMerge(){
        int[] nums1 = new int[]{0};
        int[] nums2 = new int[]{1};
        merge(nums1, 0, nums2, 1);
        Show.showArray(nums1);

        nums1 = new int[]{1,3,5,0,0,0};
        nums2 = new int[]{2,4,6};
        merge(nums1, 3, nums2, 3);
        Show.showArray(nums1);

        nums1 = new int[]{4,5,6,0,0,0};
        nums2 = new int[]{1,2,3};
        merge(nums1, 3, nums2, 3);
        Show.showArray(nums1);
    }
}
