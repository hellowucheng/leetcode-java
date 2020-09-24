package problems.M0094_二叉树的中序遍历;

import my.ds.BinaryTree;
import my.ds.TreeNode;
import org.junit.Test;
import sun.reflect.generics.tree.Tree;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Stack;

public class Solution {

//    public List<Integer> inorderTraversal(TreeNode root) {
//        if (root != null) {
//            List<Integer> list = new ArrayList<>();
//            list.addAll(inorderTraversal(root.left));
//            list.add(root.val);
//            list.addAll(inorderTraversal(root.right));
//            return list;
//        }
//        return new ArrayList<>();
//    }

    public List<Integer> inorderTraversal(TreeNode root) {
        List<Integer> result = new ArrayList<>();
        Stack<TreeNode> stack = new Stack<>();
        while (!stack.isEmpty() || root != null) {
            while (root != null) {
                stack.add(root);
                root = root.left;
            }
            root = stack.pop();
            result.add(root.val);
            root = root.right;
        }
        return result;
    }

    @Test
    public void testInorderTraversal(){
        // 根据层序遍历序列构建二叉树
        BinaryTree st = new BinaryTree("1,2,3");
        System.out.println(inorderTraversal(st.root));

        BinaryTree st2 = new BinaryTree();
        st2.deserialize("1,2,3,4,5,6,7");
        System.out.println(inorderTraversal(st2.root));
    }
}
