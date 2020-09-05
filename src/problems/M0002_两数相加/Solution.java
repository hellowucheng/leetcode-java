package problems.M0002_两数相加;

import my.ds.LinkedList;
import my.ds.ListNode;
import org.junit.Test;

public class Solution {

    /* 单链表构建 + 加法进位处理 */
    public ListNode addTwoNumbers(ListNode l1, ListNode l2) {
        ListNode cur, head;
        cur = head = new ListNode();

        int cin = 0;
        while (cin != 0 || l1 != null || l2 != null){
            int val1 = l1 == null ? 0 : l1.val;
            int val2 = l2 == null ? 0 : l2.val;
            cur.next = new ListNode((val1 + val2 + cin) % 10);
            cin = (val1 + val2 + cin) / 10;

            if (l1 != null) l1 = l1.next;
            if (l2 != null) l2 = l2.next;
            cur = cur.next;
        }
        return head.next;
    }

    @Test
    public void testAddTwoNumbers(){
        LinkedList l1 = new LinkedList(2,4,3);
        LinkedList l2 = new LinkedList(5,6,4);
        System.out.println(addTwoNumbers(l1.head, l2.head));
    }
}
