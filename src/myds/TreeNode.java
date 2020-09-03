package myds;

import java.util.LinkedList;
import java.util.Queue;

public class TreeNode {

    public int val;
    public TreeNode left;
    public TreeNode right;

    public TreeNode(int val) {
        this.val = val;
    }

    /* 层序遍历打印以该节点为根节点的子树 */
    @Override
    public String toString() {
        StringBuilder buffer = new StringBuilder();
        Queue<TreeNode> queue = new LinkedList<>();

        queue.add(this);
        while (!queue.isEmpty()) {
            TreeNode cur = queue.poll();
            if (cur == null){
                buffer.append("#").append(",");
            }
            else {
                buffer.append(val).append(",");
                queue.add(cur.left);
                queue.add(cur.right);
            }
        }
        // 删除末尾逗号
        return buffer.substring(0, buffer.length() - 1);
    }
}
