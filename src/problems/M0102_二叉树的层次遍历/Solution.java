package problems.M0102_二叉树的层次遍历;

import my.ds.BinaryTree;
import my.ds.TreeNode;
import org.junit.Test;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;

public class Solution {

    public List<List<Integer>> levelOrder(TreeNode root) {
        if (root == null) {
            return new ArrayList<>();
        }
        List<List<Integer>> result = new ArrayList<>();
        LinkedList<TreeNode> queue = new LinkedList<>();
        queue.addLast(root);
        while (!queue.isEmpty()) {
            int level = queue.size();
            List<Integer> tmp = new ArrayList<>();
            for (int i = 0; i < level; i++) {
                TreeNode cur = queue.pollLast();
                tmp.add(cur.val);
                if (cur.left != null) queue.addLast(cur.left);
                if (cur.right != null) queue.addLast(cur.right);
            }
            result.add(tmp);
        }
        return result;
    }

    @Test
    public void testLevelOrder(){
        System.out.println(levelOrder(new BinaryTree("1,2, 3,4 ,5").root));
        System.out.println(levelOrder(new BinaryTree().root));
        System.out.println(levelOrder(new BinaryTree("1").root));
    }
}
