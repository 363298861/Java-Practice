package Leetcode;

public class No86PartitionList {
    public static class ListNode {
        int val;
        ListNode next;
        ListNode(int x) { val = x; }
    }

    public ListNode partition(ListNode head, int x) {
        ListNode dummy = new ListNode(0);
        dummy.next = head;
        ListNode tmp = dummy;
        ListNode newhead = null, newtail = null;

        while(tmp.next != null){
            if(tmp.next.val >= x){
                int t = tmp.next.val;
                tmp.next = tmp.next.next;
                if(newtail == null){
                    newtail = new ListNode(t);
                    newhead = newtail;
                }else{
                    newtail.next = new ListNode(t);
                    newtail = newtail.next;
                }
            }else{
                tmp = tmp.next;
            }
        }
        tmp.next = newhead;
        return dummy.next;
    }
}
