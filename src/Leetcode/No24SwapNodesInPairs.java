package Leetcode;

public class No24SwapNodesInPairs {
    public static class ListNode {
        int val;
        ListNode next;
        ListNode(int x) { val = x; }
     }

    public static ListNode swapPairs(ListNode head) {
        if(head == null)
            return null;
        if(head.next != null){
            ListNode temp = head;
            ListNode third = head.next.next;
            head = head.next;
            head.next = temp;
            head.next.next = third;
            head.next.next = swapPairs(head.next.next);
        }
        return head;
    }

    public static void main(String[] args) {
        ListNode l1 = new ListNode(1);
        l1.next = new ListNode(2);
        l1.next.next = new ListNode(3);
        l1.next.next.next = new ListNode(4);
        ListNode l2 = new ListNode(2);
        l2.next = new ListNode(3);
        l2.next.next = new ListNode(4);
        l2.next.next.next = new ListNode(5);
        ListNode l = swapPairs(l2);
        while (l != null) {
            System.out.println(l.val);
            l = l.next;
        }
    }
}
