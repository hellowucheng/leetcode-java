package my.ds;

import java.util.Arrays;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;
import java.util.stream.Collectors;

public class BinaryTree {

    public TreeNode root;

    public BinaryTree() {
    }

    public BinaryTree(TreeNode root) {
        this.root = root;
    }

    public BinaryTree(String raw) {
        if (raw != null && !raw.isEmpty() && !raw.trim().isEmpty()){
            deserialize(raw);
        }
    }

    public String serialize() {
        return root.toString();
    }

    public void deserialize(String raw) {
        List<String> elemList = Arrays.stream(raw.split(",")).map(elem -> elem.trim()).collect(Collectors.toList());
        if (elemList.isEmpty() || elemList.get(0).equals("#")) {
            return;
        }
        root = new TreeNode(Integer.parseInt(elemList.get(0)));

        Queue<TreeNode> nodeQ = new LinkedList<>();
        nodeQ.add(root);

        Queue<String> valQ = new LinkedList<>();
        for (int i = 1; i < elemList.size(); i++) {
            valQ.add(elemList.get(i));
        }

        while (!nodeQ.isEmpty()) {
            TreeNode cur = nodeQ.poll();
            String leftVal = valQ.poll(), rightVal = valQ.poll();
            if (leftVal == null || leftVal.equals("#")) {
                cur.left = null;
            }
            else {
                cur.left = new TreeNode(Integer.parseInt(leftVal));
                nodeQ.add(cur.left);
            }
            if (rightVal == null || rightVal.equals("#")) {
                cur.right = null;
            }
            else {
                cur.right = new TreeNode(Integer.parseInt(rightVal));
                nodeQ.add(cur.right);
            }
        }
    }

    @Override
    public String toString() {
        return serialize();
    }
}
