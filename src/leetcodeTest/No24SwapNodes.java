package leetcodeTest;

public class No24SwapNodes {
    public class ListNode {
        int val;
        ListNode next;
        ListNode() {}
        ListNode(int val) { this.val = val; }
        ListNode(int val, ListNode next) { this.val = val; this.next = next; }
    }
    public ListNode swapPairs(ListNode head) {
        ListNode dummy = new ListNode(0);
        dummy.next = head;
        ListNode p = dummy;
        while(p.next != null){
            ListNode left = p.next, right = p.next.next;
            if(right == null) break;
            p.next = right;
            left.next = right.next;
            right.next = left;
            p = left;
        }
        return dummy.next;
    }
}
