package Chapter2.chapter2_3;

class ListNode {
    int val;
    ListNode next;

    public ListNode (int val) {
        this.val = val;
        this.next = null;
    }
}

public class chapter2_3 {
    //only give the access to the delete node, not the head
    //so just copy the next node to the delete node and then delete next node
    public void deleteMid (ListNode node) {
        if (node == null || node.next == null) {
            return;
        }
        ListNode next = node.next;
        node.val = next.val;
        node.next = next.next;
    }
}
