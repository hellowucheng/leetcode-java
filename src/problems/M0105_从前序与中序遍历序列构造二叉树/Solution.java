package problems.M0105_从前序与中序遍历序列构造二叉树;

import my.ds.BinaryTree;
import my.ds.TreeNode;
import org.junit.Test;

import java.util.Arrays;


public class Solution {

    private int indexOf(int[] nums, int val) {
        for (int i = 0; i < nums.length; i++) {
            if (nums[i] == val) {
                return i;
            }
        }
        return -1;
    }

    public TreeNode buildTree(int[] preorder, int[] inorder) {
        if (preorder.length == 0) {
            return null;
        }
        TreeNode root = new TreeNode(preorder[0]);
        int mid = indexOf(inorder, preorder[0]);
        root.left = buildTree(Arrays.copyOfRange(preorder, 1, mid + 1), Arrays.copyOfRange(inorder, 0,  mid));
        root.right = buildTree(Arrays.copyOfRange(preorder, mid + 1, preorder.length), Arrays.copyOfRange(inorder, mid + 1, inorder.length));
        return root;
    }

    @Test
    public void testBuildTree(){
        TreeNode root = buildTree(new int[]{1,2,4,5,3,6,7}, new int[]{4,2,5,1,6,3,7});
        System.out.println(root);
    }
}
