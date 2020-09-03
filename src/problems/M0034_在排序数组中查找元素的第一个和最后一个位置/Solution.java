package problems.M0034_在排序数组中查找元素的第一个和最后一个位置;

import org.junit.Test;

import java.util.Arrays;

public class Solution {

    private int leftBound(int[] nums, int target) {
        int l = 0, r = nums.length - 1;
        while (l <= r) {
            int mid = (l + r) / 2;
            if (nums[mid] == target) {
                r = mid - 1;
            }
            else if (nums[mid] > target) {
                r = mid - 1;
            }
            else if (nums[mid] < target) {
                l = mid + 1;
            }
        }
        if (r + 1 == nums.length) {
            return -1;
        }
        if (nums[r + 1] == target){
            return r + 1;
        }
        return -1;
    }

    private int rightBound(int[] nums, int target) {
        int l = 0, r = nums.length - 1;
        while (l <= r){
            int mid = (l + r) / 2;
            if (nums[mid] <= target){
                l = mid + 1;
            }
            else if (nums[mid] > target){
                r = mid - 1;
            }
        }
        return l <= 0 || nums[l - 1] != target ? -1 : l - 1;
    }

    public int[] searchRange(int[] nums, int target) {
        return new int[]{leftBound(nums, target), rightBound(nums, target)};
    }

    @Test
    public void testSearchRange(){
        System.out.println(Arrays.toString(searchRange(new int[]{1,2,2,3,3,4,4,4,5,5}, 4)));
        System.out.println(Arrays.toString(searchRange(new int[]{1,2,3}, 4)));
        System.out.println(Arrays.toString(searchRange(new int[]{1,2,3}, 0)));
        System.out.println(Arrays.toString(searchRange(new int[]{}, 1)));
    }
}
