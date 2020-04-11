package Leetcode;

public class No142LinkedListCyclesTwo {
    public static class ListNode {
        int val;
        ListNode next;
        ListNode(int x) { val = x; }
    }

    public ListNode detectCycle(ListNode head) {

        if(head == null || head.next == null)
            return null;

        ListNode slow = head, fast = head;
        do{
            slow = slow.next;
            if(fast.next == null)
                return null;
            fast = fast.next.next;
        }while (slow != null && fast != null && slow != fast);

        if(slow == null || fast == null)
            return null;

        slow = head;
        while(slow != fast){
            slow = slow.next;
            fast = fast.next;
        }
        return slow;
    }
}
