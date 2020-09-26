package problems.M0098_验证二叉搜索树;

import my.ds.BinaryTree;
import my.ds.TreeNode;
import org.junit.Assert;
import org.junit.Test;

import java.util.LinkedList;

public class Solution {

    public boolean isValidBST(TreeNode root) {
        long pre = Long.MIN_VALUE;
        LinkedList<TreeNode> stack = new LinkedList();
        while (root != null || !stack.isEmpty()) {
            while (root != null) {
                stack.addLast(root);
                root = root.left;
            }
            root = stack.pollLast();
            if (pre >= root.val) {
                return false;
            }
            pre = root.val;
            root = root.right;
        }
        return true;
    }

    @Test
    public void testIsValidBST(){
        Assert.assertEquals(false, isValidBST(new BinaryTree("1,1,1").root));
        Assert.assertEquals(false, isValidBST(new BinaryTree("1, 2, 3").root));
        Assert.assertEquals(true, isValidBST(new BinaryTree("1").root));
        Assert.assertEquals(true, isValidBST(new BinaryTree("2,1,3").root));
        Assert.assertEquals(true, isValidBST(new BinaryTree("4, 2, 6, 1, 3, 5, 7").root));
        Assert.assertEquals(true, isValidBST(new BinaryTree("-2147483648").root));
    }
}
