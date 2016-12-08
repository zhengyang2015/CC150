package Chapter2.chapter2_1;

import java.util.HashSet;
import java.util.Set;

class ListNode {
    int val;
    ListNode next;

    public ListNode (int val) {
        this.val = val;
        this.next = null;
    }
}

public class chapter2_1 {
    //remove duplicates from unsorted linked list
    //allow to use extra buffer space, space O(N), time O(N)
    public ListNode removeDuplicate (ListNode head) {
        if (head == null || head.next == null) {
            return head;
        }

        ListNode dummy = new ListNode(0);
        dummy.next = head;
        head = dummy;

        Set<Integer> set = new HashSet<Integer>();
        while (head.next != null) {
            if (set.contains(head.next.val)) {
                head.next = head.next.next;
            } else {
                set.add(head.next.val);
                head = head.next;
            }
        }

        return dummy.next;
    }

    //not allow to use extra buffer space, space O(1), time O(N^2)
    public ListNode removeDuplicate2 (ListNode head) {
        if (head == null || head.next == null) {
            return head;
        }

        ListNode slow = head;
        ListNode fast = head;

        while (slow.next != null) {
            while (fast.next != null) {
                if (fast.next.val == slow.val) {
                    fast.next = fast.next.next;
                } else {
                    fast = fast.next;
                }
            }
            slow = slow.next;
            fast = slow;
        }

        return head;
    }
}
