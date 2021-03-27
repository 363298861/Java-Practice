package Leetcode;

import leetcodeTest.No206ReverseLinkedList;

public class No92ReverseLinkedList {
    public static class ListNode {
        int val;
        ListNode next;
        ListNode(int x) { val = x; }
        ListNode(int val, ListNode next) { this.val = val; this.next = next; }
        @Override
        public String toString(){
            if(next == null)
                return val + " ";
            return val + " " + next;
        }
    }

    public ListNode reverseBetween(ListNode head, int left, int right) {
        ListNode dummy = new ListNode(0);
        dummy.next = head;
        ListNode start = dummy, end = dummy;
        int i = 1;
        while(true){
            if(i < left)
                start = start.next;
            if(i <= right + 1) {
                end = end.next;
            }
            if(i == right + 1)
                break;
            i++;
        }
        System.out.println(start.val + " " + end.val);
        ListNode newHead = reverse(start.next, end, right - left + 1);
        start.next = newHead;
        return dummy.next;
    }

    private ListNode reverse(ListNode head, ListNode newHead, int i){
        if(i == 0)
            return newHead;
        ListNode next = head.next;
        head.next = newHead;
        return reverse(next, head, i - 1);
    }

    public static void main(String[] args) {
        ListNode l = new ListNode(1);
        l.next = new ListNode(2);
        l.next.next = new ListNode(3);
        l.next.next.next = new ListNode(4);
        l.next.next.next.next = new ListNode(5);
        l.next.next.next.next.next = new ListNode(6);
        No92ReverseLinkedList n = new No92ReverseLinkedList();
        System.out.println(n.reverseBetween(l, 2, 4));
    }
}
