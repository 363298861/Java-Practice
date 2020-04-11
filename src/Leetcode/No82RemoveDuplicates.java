package Leetcode;

public class No82RemoveDuplicates {

    public class ListNode {
        int val;
        ListNode next;
        ListNode(int x) { val = x; }
    }

    public ListNode deleteDuplicates(ListNode head) {
        ListNode dummy = new ListNode(1 << 30);
        dummy.next = head;

        ListNode start = dummy;

        while(start != null && start.next != null){
            int tmp = start.next.val;
            if(start.next.next != null && start.next.next.val == tmp){
                ListNode end = start.next;
                while(end.next != null && end.next.val == tmp){
                    end = end.next;
                }
                start.next = end.next;
            }else{
                start = start.next;
            }
        }
        return dummy.next;
    }
}
