package Chapter2.chapter2_6;

class ListNode {
    int val;
    ListNode next;

    public ListNode (int val) {
        this.val = val;
        this.next = null;
    }
}

public class chapter2_6 {
    public boolean isPalindrome (ListNode head) {
        if (head == null || head.next == null) {
            return true;
        }

        ListNode last = reverse(head);
        while (head != null) {
            if (head.val != last.val) {
                return false;
            }
            head = head.next;
            last = last.next;
        }
        return true;
    }

    private ListNode reverse(ListNode head) {
        if (head == null || head.next == null) {
            return head;
        }

        ListNode pre = head;
        ListNode curt = head.next;
        head.next = null;
        while (curt != null) {
            ListNode temp = curt.next;
            curt.next = pre;
            pre = curt;
            curt = temp;
        }

        return pre;
    }
}
