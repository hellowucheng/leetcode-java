package problems.M0033_搜索旋转排序数组;

import org.junit.Assert;
import org.junit.Test;

public class Solution {

    // 保证没有重复元素
    public int search(int[] nums, int target) {
        int l = 0, r = nums.length - 1;
        while (l <= r){
            int mid = (l + r) / 2;
            if (nums[mid] == target){
                return mid;
            }
            if (nums[l] <= nums[mid]) {
                if (nums[l] <= target && target < nums[mid]) {
                    r = mid - 1;
                }
                else {
                    l = mid + 1;
                }
            }
            else {
                if (nums[mid] < target && target <= nums[r]){
                    l = mid + 1;
                }
                else {
                    r = mid - 1;
                }
            }
        }
        return -1;
    }

    @Test
    public void testSearch(){
        Assert.assertEquals(0, search(new int[]{4,5,6,1,2,3}, 4));
        Assert.assertEquals(1, search(new int[]{2,1}, 1));
        Assert.assertEquals(-1, search(new int[]{}, 1));
        Assert.assertEquals(2, search(new int[]{1,2,3}, 3));
        Assert.assertEquals(-1, search(new int[]{3,1,2}, 5));
    }
}
