package problems.M0103_二叉树的锯齿形层次遍历;

import my.ds.BinaryTree;
import my.ds.TreeNode;
import org.junit.Test;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;

public class Solution {

    public List<List<Integer>> zigzagLevelOrder(TreeNode root) {
        if (root == null) {
            return new ArrayList<>();
        }
        List<List<Integer>> result = new ArrayList<>();
        LinkedList<TreeNode> queue = new LinkedList<>();
        boolean zig = true;
        queue.addLast(root);
        while (!queue.isEmpty()) {
            int level = queue.size();
            LinkedList<Integer> tmp = new LinkedList<>();
            for (int i = 0; i < level; i++) {
                TreeNode cur = queue.pollFirst();
                if (cur.left != null) queue.addLast(cur.left);
                if (cur.right != null) queue.addLast(cur.right);
                if (zig) {
                    tmp.addLast(cur.val);
                }
                else {
                    tmp.addFirst(cur.val);
                }
            }
            zig = !zig;
            result.add(tmp);
        }
        return result;
    }

    @Test
    public void testZigZagLevelOrder() {
        System.out.println(zigzagLevelOrder(new BinaryTree("1,2,3,4,5").root));
        System.out.println(zigzagLevelOrder(new BinaryTree("3,9,20,#,#,15,7").root));
    }
}
