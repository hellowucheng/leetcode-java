package my.ds;

public class ListNode {
    public int val;
    public ListNode next;

    public ListNode() {
    }

    public ListNode(int val) {
        this.val = val;
    }

    @Override
    public String toString() {
        return next == null ? val+"" : val + " -> " + next;
    }
}
