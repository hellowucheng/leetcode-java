package problems.M0019_删除链表的倒数第N个节点;

import my.ds.LinkedList;
import my.ds.ListNode;
import org.junit.Test;

public class Solution {

    public ListNode removeNthFromEnd(ListNode head, int n) {
        // 快慢指针
        // 必须保证有倒数第N个节点
        ListNode fast = head;
        for (int i = 0; i < n - 1; i++) {
            fast = fast.next;
        }
        ListNode slow = head, prev = null;
        while (fast.next != null){
            prev = slow;
            fast = fast.next;
            slow = slow.next;
        }
        if (slow == head){
            return head.next;
        }
        else {
            prev.next = slow.next;
            return head;
        }
    }

    @Test
    public void testRemoveNthFromEnd(){
        LinkedList list1 = new LinkedList(1,2,3,4,5,6,7);
        System.out.println(removeNthFromEnd(list1.head, 1));

        LinkedList list2 = new LinkedList(1,2,3,4,5,6,7);
        System.out.println(removeNthFromEnd(list2.head, 2));

        LinkedList list3 = new LinkedList(1,2,3,4,5,6,7);
        System.out.println(removeNthFromEnd(list3.head, 7));
    }
}
