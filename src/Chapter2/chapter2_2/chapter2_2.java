package Chapter2.chapter2_2;

class ListNode {
    int val;
    ListNode next;

    public ListNode (int val) {
        this.val = val;
        this.next = null;
    }
}

public class chapter2_2 {
    public ListNode findKthToLast (ListNode head, int k) {
        if (head == null) {
            return head;
        }

        ListNode l1 = head;
        ListNode l2 = head;
        for (int i = 0; i < k; i++) {
            if (l1 == null) {
                return null;
            }
            l1 = l1.next;
        }

        while (l1 != null) {
            l1 = l1.next;
            l2 = l2.next;
        }

        return l2;
    }
}
