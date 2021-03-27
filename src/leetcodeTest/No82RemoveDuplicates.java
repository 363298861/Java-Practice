package leetcodeTest;

public class No82RemoveDuplicates {
    public class ListNode {
        int val;
        ListNode next;
        ListNode(int x) { val = x; }
        ListNode(int val, ListNode next) { this.val = val; this.next = next; }
    }

    public ListNode deleteDuplicates(ListNode head) {
        ListNode dummy = new ListNode(0);
        dummy.next = head;
        ListNode l = dummy;
        while(l.next != null){
            if(l.next.next != null && l.next.val == l.next.next.val){
                ListNode tail = l.next;
                while(tail.next != null && tail.val == tail.next.val){
                    tail = tail.next;
                }
                l.next = tail.next;
            }else{
                l = l.next;
            }
        }
        return dummy.next;
    }
}
