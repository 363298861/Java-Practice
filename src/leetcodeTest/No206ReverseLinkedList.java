package leetcodeTest;

public class No206ReverseLinkedList {
    public class ListNode {
        int val;
        ListNode next;
        ListNode(int x) { val = x; }
        ListNode(int val, ListNode next) { this.val = val; this.next = next; }
    }

    public ListNode reverseList(ListNode head){
        return reverse(head, null);
    }

    public ListNode reverse(ListNode head, ListNode newHead) {
        if(head == null)
            return newHead;
        ListNode next = head.next;
        head.next = newHead;
        return reverse(next, head);
    }

    public ListNode reverseIterative(ListNode head){
        ListNode newHead = null;
        while(head != null){
            ListNode next = head.next;
            head.next = newHead;
            newHead = head;
            head = next;
        }
        return newHead;
    }
}
