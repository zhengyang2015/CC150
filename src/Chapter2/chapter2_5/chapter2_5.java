package Chapter2.chapter2_5;

class ListNode {
    int val;
    ListNode next;

    public ListNode (int val) {
        this.val = val;
        this.next = null;
    }
}

public class chapter2_5 {
    //add l1 and l2 return result as list
    public ListNode addList (ListNode l1, ListNode l2) {
        if (l1 == null || l2 == null) {
            return null;
        }

        int carry = 0;
        ListNode dummy = new ListNode(0);
        ListNode result = null;
        while (l1 != null && l2 != null) {
            int sum = l1.val + l2.val + carry;
            int value = sum % 10;
            carry = sum / 10;

            if (result == null) {
                result = new ListNode(value);
                dummy.next = result;
            } else {
                result.next = new ListNode(value);
                result = result.next;
            }
        }

        while (l1 != null) {
            int sum = l1.val + carry;
            int value = sum % 10;
            carry = sum / 10;

            result.next = new ListNode(value);
            result = result.next;
        }

        while (l2 != null) {
            int sum = l2.val + carry;
            int value = sum % 10;
            carry = sum / 10;

            result.next = new ListNode(value);
            result = result.next;
        }

        if (carry != 0) {
            result.next = new ListNode(carry);
        }

        return dummy.next;
    }

    //follow up question
    public ListNode addList2 (ListNode l1, ListNode l2) {
        //padding the shorter list with 0
        int len1 = length(l1);
        int len2 = length(l2);

        if (len1 < len2) {
            l1 = padding(l1, len2 - len1, 0);
        } else {
            l2 = padding(l2, len1 - len2, 0);
        }

        return addList(l1, l2);
    }

    private ListNode padding(ListNode l, int len, int num) {
        ListNode head = l;
        for (int i = 0; i < len; i++) {
            ListNode curt = new ListNode(num);
            curt.next = head;
            head = curt;
        }
        return head;
    }

    private int length(ListNode l) {
        int len = 0;
        while (l != null) {
            len++;
            l = l.next;
        }
        return len;
    }
}
