package Chapter2.chapter2_7;

class ListNode {
    int val;
    ListNode next;

    public ListNode (int val) {
        this.val = val;
        this.next = null;
    }
}

public class chapter2_7 {
    public ListNode findIntersection (ListNode l1, ListNode l2) {
        if (l1 == l2) {
            return l1;
        }

        ListNode tail = l1;
        while (tail.next != null) {
            tail = tail.next;
        }
        tail.next = l2;

        ListNode inter = findLoop(l1);
        tail.next = null;

        return inter;
    }

    public ListNode findLoop (ListNode head) {
        if (head == null) {
            return head;
        }

        ListNode slow = head;
        ListNode fast = head.next;

        while (slow != fast) {
            if (fast != null && fast.next != null) {
                slow = slow.next;
                fast = fast.next.next;
            } else {
                return null;
            }
        }

        slow = head;
        fast = fast.next;

        while (slow != fast) {
            slow = slow.next;
            fast = fast.next;
        }

        return slow;
    }
}
