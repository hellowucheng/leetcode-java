package problems.E0021_合并两个有序链表;

import my.ds.LinkedList;
import my.ds.ListNode;
import org.junit.Test;

public class Solution {
    public ListNode mergeTwoLists(ListNode l1, ListNode l2) {
        if (l1 == null) return l2;
        if (l2 == null) return l1;

        if (l1.val <= l2.val){
            l1.next = mergeTwoLists(l1.next, l2);
            return l1;
        }
        else {
            l2.next = mergeTwoLists(l1, l2.next);
            return l2;
        }
    }

    @Test
    public void testMergeTwoLists(){
        LinkedList l1 = new LinkedList(1, 3, 5);
        LinkedList l2 = new LinkedList(2, 4, 6);
        LinkedList l3 = new LinkedList();

        System.out.println(mergeTwoLists(l1.head, l2.head));
        System.out.println(mergeTwoLists(l1.head, l3.head));
    }
}
