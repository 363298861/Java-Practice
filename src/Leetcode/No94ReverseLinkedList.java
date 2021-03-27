package Leetcode;


public class No94ReverseLinkedList {


    private boolean stop;
    private ListNode left;

    public static class ListNode {
        int val;
        ListNode next;
        ListNode(int x) { val = x; }
    }

    public static ListNode reverseBetween(ListNode head, int m, int n) {

        ListNode dummy = new ListNode(0);
        dummy.next = head;
        ListNode pre = dummy;
        for(int i = 0; i < m - 1; i++){
            pre = pre.next;
        }
        ListNode start = pre.next;
        ListNode next = pre.next.next;

        for(int i = 0; i < n - m; i++){

            start.next = next.next;
            next.next = pre.next;
            pre.next = next;
            next = start.next;
        }
        return dummy.next;
    }

    public void recursion(ListNode right, int m, int n){
        if(n == 1)
            return;
        right = right.next;

        if(m > 1)
            left = left.next;

        recursion(right, m - 1, n - 1);

        if(left == right || left.next == right){
            stop = true;
        }
        if(!stop){
            int t = left.val;
            left.val = right.val;
            right.val = t;
            left = left.next;
        }
    }

    public ListNode reverseBetweenR(ListNode head, int m, int n){
        left = head;
        stop = false;
        recursion(head, m, n);
        return head;
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
        No94ReverseLinkedList t = new No94ReverseLinkedList();
        ListNode l = t.reverseBetweenR(n, 2, 4);
        while(l != null){
            System.out.print(l.val + " ");
            l = l.next;
        }
        System.out.println();
    }
}
