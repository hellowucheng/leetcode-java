package problems.H0124_二叉树中的最大路径和;

import my.ds.BinaryTree;
import my.ds.TreeNode;
import org.junit.Assert;
import org.junit.Test;

public class Solution {

    private int maxPath = Integer.MIN_VALUE;

    private int expand(TreeNode root) {
        if (root == null) {
            return 0;
        }
        int left = Math.max(0, expand(root.left));
        int right = Math.max(0, expand(root.right));
        maxPath = Math.max(maxPath, left + right + root.val);
        return Math.max(left, right) + root.val;
    }

    public int maxPathSum(TreeNode root) {
        expand(root);
        return maxPath;
    }

    @Test
    public void testMaxPathSum(){
        Assert.assertEquals(42, maxPathSum(new BinaryTree("-10,9,20,#,#,15,7").root));
    }
}
