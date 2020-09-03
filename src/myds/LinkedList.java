package myds;

public class LinkedList {

    public ListNode head;

    public LinkedList(int...data) {
        ListNode cur = head = new ListNode();
        for (int i = 0; i < data.length; i++, cur = cur.next) {
            cur.next = new ListNode(data[i]);
        }
        head = head.next;
    }

    @Override
    public String toString() {
        return head + "";
    }
}
