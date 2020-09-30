package problems.E0108_将有序数组转换为二叉搜索树;

import my.ds.TreeNode;
import org.junit.Test;

import java.util.Arrays;

public class Solution {

    public TreeNode sortedArrayToBST(int[] nums) {
        if (nums.length == 0) {
            return null;
        }
        int mid = nums.length / 2;
        TreeNode root = new TreeNode(nums[mid]);
        root.left = sortedArrayToBST(Arrays.copyOfRange(nums, 0, mid));
        root.right = sortedArrayToBST(Arrays.copyOfRange(nums, mid + 1, nums.length));
        return root;
    }

    @Test
    public void testSortedArrayToBST() {
        System.out.println(sortedArrayToBST(new int[]{1,2,3}));
        System.out.println(sortedArrayToBST(new int[]{1,2,3,4,5,6,7}));
    }
}
