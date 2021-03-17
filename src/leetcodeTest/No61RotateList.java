package leetcodeTest;

public class No61RotateList {
    public static class ListNode {
        int val;
        ListNode next;
        ListNode(int x) { val = x; }
        ListNode(int val, ListNode next) { this.val = val; this.next = next; }
    }

    public ListNode rotateRight(ListNode head, int k) {
        if(head == null) return head;
        ListNode tail = head;
        for(int i = 0; i < k; i++){
            tail = tail.next;
            if(tail == null) {
                tail = head;
                k %= (i + 1);
                i = -1;
            }
        }
        ListNode newTail = head;
        while(tail.next != null){
            newTail = newTail.next;
            tail = tail.next;
        }
        ListNode newHead = newTail.next;
        if(newHead == null) return head;
        newTail.next = null;
        tail.next = head;
        return newHead;
    }
}
