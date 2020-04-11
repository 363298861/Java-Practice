package Leetcode;

public class No61RotateList {
    public static class ListNode {
        int val;
        ListNode next;
        ListNode(int x) { val = x; }
    }

    public ListNode rotateRight(ListNode head, int k){
        if(head == null || head.next == null)
            return head;
        ListNode last = null;
        while(k > 0){
            ListNode secondlast = rotate(head);
            last = secondlast.next;
            secondlast.next = null;
            last.next = head;
            k--;
            head = last;
        }
        return head;
    }

    public ListNode rotate(ListNode head){
        if(head.next.next == null)
            return head;
        return rotate(head.next);
    }

    public ListNode rotateRight2(ListNode head, int k){
        if(head == null || head.next == null)
            return head;
        int l = 0;
        ListNode t = head;
        while(t != null){
            l++;
            t = t.next;
        }

        k %= l;
        ListNode last;
        while(k > 0){
            ListNode secondlast = rotate(head);
            last = secondlast.next;
            secondlast.next = null;
            last.next = head;
            k--;
            head = last;
        }
        return head;
    }


    public static void main(String[] args) {
        ListNode l1 = new ListNode(1);
        l1.next = new ListNode(2);
        l1.next.next = new ListNode(3);
        l1.next.next.next = new ListNode(4);
        l1.next.next.next.next = new ListNode(5);

        No61RotateList t = new No61RotateList();

        ListNode l = t.rotateRight(l1, 3);
        while(l!= null){
            System.out.println(l.val);
            l = l.next;
        }
    }
}
