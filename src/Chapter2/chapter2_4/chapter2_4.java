package Chapter2.chapter2_4;

class ListNode {
    int val;
    ListNode next;

    public ListNode (int val) {
        this.val = val;
        this.next = null;
    }
}

public class chapter2_4 {
    //insert less to head and insert greater to tail
    public ListNode partition (ListNode node, int x) {
        if (node == null || node.next == null) {
            return null;
        }

        ListNode head = node;
        ListNode tail = node;

        while (node != null) {
            ListNode next = node.next;
            if (node.val < x) {
                node.next = head;
                head = node;
            } else {
                tail.next = node;
                tail = node;
            }
            node = next;
        }

        return head;
    }
}
