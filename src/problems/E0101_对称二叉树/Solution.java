package problems.E0101_对称二叉树;

import myds.BinaryTree;
import myds.TreeNode;
import org.junit.Assert;
import org.junit.Test;

public class Solution {

    private boolean helper(TreeNode l, TreeNode r) {
        if (l == null) return r == null;
        if (r == null) return l == null;
        return l.val == r.val && helper(l.left, r.right) && helper(l.right, r.left);
    }

    public boolean isSymmetric(TreeNode root) {
        if (root == null) {
            return true;
        }
        return helper(root.left, root.right);
    }

    @Test
    public void testIsSymmetric(){
        Assert.assertEquals(true, isSymmetric(null));
        Assert.assertEquals(true, isSymmetric(new BinaryTree("1, #, # ").root));
        Assert.assertEquals(true, isSymmetric(new BinaryTree("1,2,2").root));
        Assert.assertEquals(false, isSymmetric(new BinaryTree("1,2,3").root));
        Assert.assertEquals(true, isSymmetric(new BinaryTree("1,2,2,3,4,4,3").root));
    }
}
