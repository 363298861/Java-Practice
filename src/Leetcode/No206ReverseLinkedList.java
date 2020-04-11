package Leetcode;

public class No206ReverseLinkedList {

    public static class ListNode {
        int val;
        ListNode next;
        ListNode(int x) { val = x; }
    }

    public static ListNode reverseList(ListNode head){
        return reverseListRecursively(head, null);
    }

    public static ListNode reverseListRecursively(ListNode head, ListNode newhead) {
        if(head == null)
            return newhead;
        ListNode next = head.next;
        head.next = newhead;
        return reverseListRecursively(next, head);
    }

    public static ListNode reverseListIteratively(ListNode head){
        ListNode newhead = null;
        while(head != null){
            ListNode next = head.next;
            head.next = newhead;
            newhead = head;
            head = next;
        }
        return newhead;
    }

    public static void main(String[] args) {
        ListNode head = new ListNode(3);
        head.next = new ListNode(4);
        head.next.next = new ListNode(5);
        head.next.next.next = new ListNode(6);
        head.next.next.next.next = new ListNode(7);
        ListNode n = head;
        while(head != null){
            System.out.print(head.val + " ");
            head = head.next;
        }
        System.out.println();
        ListNode l = reverseListIteratively(n);
        while(l != null){
            System.out.print(l.val + " ");
            l = l.next;
        }
        System.out.println();
    }
}
