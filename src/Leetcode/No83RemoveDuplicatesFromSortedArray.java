package Leetcode;

public class No83RemoveDuplicatesFromSortedArray {
    public class ListNode {
        int val;
        ListNode next;
        ListNode(int x) { val = x; }
    }

    public ListNode deleteDuplicates(ListNode head) {
        if(head == null || head.next == null)
            return head;
        int ele = head.val;
        ListNode p = head;
        while(p.next != null){
            if(p.next.val == ele){
                p.next = p.next.next;
            }else{
                ele = p.next.val;
                p = p.next;
            }
        }
        return head;
    }
}

