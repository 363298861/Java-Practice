package leetcodeTest;

public class No83RemoveDuplicates {
    public class ListNode {
        int val;
        ListNode next;
        ListNode(int x) { val = x; }
        ListNode(int val, ListNode next) { this.val = val; this.next = next; }
    }
    public ListNode deleteDuplicates(ListNode head) {
        ListNode l = head;
        if(l == null) return l;
        while(l.next != null){
            if(l.val == l.next.val){
                l.next = l.next.next;
            }else{
                l = l.next;
            }
        }
        return head;
    }
}
