package Leetcode;

public class No25ReverseNodes {

    public class ListNode {
        int val;
        ListNode next;
        ListNode() {}
        ListNode(int val) { this.val = val; }
        ListNode(int val, ListNode next) { this.val = val; this.next = next; }
    }

    public ListNode reverseKGroup(ListNode head, int k) {
        ListNode start = head, end = head;
        ListNode dummy = new ListNode(0);
        dummy.next = head;
        ListNode p = dummy;
        int tmp = k;
        while(tmp > 1 && end != null){
            end = end.next;
            tmp--;
        }

        while(end != null){
            ListNode newStart = end.next;
            p.next = reverse(start, k);
            p = start;
            start.next = newStart;
            start = newStart;
            end = start;
            for(int i = 1; i < k; i++){
                if(end == null) break;
                end = end.next;
            }
        }
        return dummy.next;
    }

    public ListNode reverse(ListNode head, int k){
        if(k == 1){
            return head;
        }
        ListNode next = head.next;
        ListNode newHead = reverse(next, k - 1);
        next.next = head;
        return newHead;
    }

    public ListNode reverseKGroup2(ListNode head, int k){
        int n = 0;
        for(ListNode i = head; i != null; i = i.next)
            n++;

        ListNode dummy = new ListNode(0);
        dummy.next = head;
        ListNode next;
        for(ListNode prev = dummy, tail = head; n >= k; n -= k){
            for(int i = 1; i < k; i++){
                next = tail.next.next;
                tail.next.next = prev.next;
                prev.next = tail.next;
                tail.next = next;
            }
            prev = tail;
            tail = prev.next;
        }
        return dummy.next;
    }
}
