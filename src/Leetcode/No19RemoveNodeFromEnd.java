package Leetcode;

public class No19RemoveNodeFromEnd {
    public static ListNode removeNthFromEnd(ListNode head, int n) {

        ListNode end = head;
        int length = 1;
        while(end.next != null){
            end = end.next;
            length++;
        }
        if(length == n)
            return head.next;
        int i = 1;
        ListNode nth = head.next;
        ListNode nthPrev = head;
        while(i < length - n ){
            nthPrev = nthPrev.next;
            nth = nthPrev.next;
            i++;
        }
        nthPrev.next = nth.next;
        return head;
    }

    public static class ListNode {
        int val;
        ListNode next;
        ListNode(int x) { val = x; }
    }

    public ListNode removeNthFromEnd2(ListNode head, int n){
        ListNode start = new ListNode(0);
        ListNode slow = start, fast = start;
        start.next = head;

        for(int i = 0; i <= n; i++){
            fast = fast.next;
        }

        while(fast != null){
            fast = fast.next;
            slow = slow.next;
        }
        slow.next = slow.next.next;
        return head;
    }

    public static void main(String[] args) {
        ListNode l1 = new ListNode(1);
        l1.next = new ListNode(2);
        l1.next.next = new ListNode(3);
        l1.next.next.next = new ListNode(4);
        l1.next.next.next.next = new ListNode(5);

        l1 = removeNthFromEnd(l1, 1);
        while(l1!= null){
            System.out.println(l1.val);
            l1 = l1.next;
        }
    }
}
