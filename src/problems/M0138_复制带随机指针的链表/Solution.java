package problems.M0138_复制带随机指针的链表;

public class Solution {
    private class Node{
        int val;
        Node next;
        Node random;

        public Node(int val) {
            this.val = val;
        }
    }

    public Node copyRandomList(Node head) {
        if (head == null) {
            return null;
        }
        Node cur = head;
        // 直接在创建新节点并链在原链表节点后
        while (cur != null) {
            Node newNode = new Node(cur.val);
            newNode.next = cur.next;
            cur.next = newNode;
            cur = newNode.next;
        }
        // 更新新节点的random指针
        cur = head;
        while (cur != null) {
            cur.next.random = cur.random != null ? cur.random.next : null;
            cur = cur.next.next;
        }

        cur = head;
        Node newHead = head.next, newPtr = head.next;
        while (cur != null) {
            cur.next = newPtr.next;
            newPtr.next = newPtr.next != null ? newPtr.next.next : null;
            cur = cur.next;
            newPtr = newPtr.next;
        }
        return newHead;
    }
}
