package problems.H0023_合并k个排序链表;

import myds.LinkedList;
import myds.ListNode;
import org.junit.Test;

import java.util.Comparator;
import java.util.PriorityQueue;

public class Solution {

    public ListNode mergeKLists(ListNode[] lists) {
        PriorityQueue<ListNode> minHeap = new PriorityQueue<>(Comparator.comparingInt(a -> a.val));
        for (ListNode list : lists) {
            if (list != null){
                minHeap.add(list);
            }
        }
        ListNode cur, head;
        cur = head = new ListNode();
        while (!minHeap.isEmpty()) {
            ListNode tmp = minHeap.poll();
            if (tmp.next != null) {
                minHeap.add(tmp.next);
            }
            cur.next = tmp;
            cur = cur.next;
        }
        return head.next;
    }

    @Test
    public void testMergeKLists(){
        LinkedList l1 = new LinkedList();
        LinkedList l2 = new LinkedList(1, 3, 5);
        LinkedList l3 = new LinkedList(2, 4, 6);

        System.out.println(mergeKLists(new ListNode[]{l1.head}));
        System.out.println(mergeKLists(new ListNode[]{l1.head, l2.head}));
        System.out.println(mergeKLists(new ListNode[]{l1.head, l2.head, l3.head}));
    }
}
