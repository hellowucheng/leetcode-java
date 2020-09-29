package problems.E0104_二叉树的最大深度;

import my.ds.BinaryTree;
import my.ds.TreeNode;
import org.junit.Assert;
import org.junit.Test;

public class Solution {

    public int maxDepth(TreeNode root) {
        return root == null ? 0 : Math.max(maxDepth(root.left), maxDepth(root.right)) + 1;
    }

    @Test
    public void testMaxDepth(){
        Assert.assertEquals(0, maxDepth(null));
        Assert.assertEquals(1, maxDepth(new BinaryTree("1").root));
        Assert.assertEquals(2, maxDepth(new BinaryTree("1, 2").root));
        Assert.assertEquals(3, maxDepth(new BinaryTree("1, 2, #, 3, 4").root));
        Assert.assertEquals(4, maxDepth(new BinaryTree("1,2,#,3,#,4").root));
    }
}
