package Leetcode;

public class No203RemoveElementInLL {


    public static class ListNode {
        int val;
        ListNode next;
        ListNode() {}
        ListNode(int val) { this.val = val; }
        ListNode(int val, ListNode next) { this.val = val; this.next = next; }

        @Override
        public String toString(){
            String res = "";
            res += val + ", ";
            ListNode p = next;
            while(p != null) {
                res += p.val + ", ";
                p = p.next;
            }
            return res;
        }
    }


    public ListNode removeElements(ListNode head, int val) {
        ListNode dummy = new ListNode(val - 1);
        dummy.next = head;
        ListNode ptr = dummy;

        while(ptr.next != null){
            if(ptr.next.val == val){
                ptr.next = ptr.next.next;
            }else
                ptr = ptr.next;
        }
        return dummy.next;
    }

    public ListNode removeElementsRecursion(ListNode head, int val){
        if(head == null) return head;
        head.next = removeElementsRecursion(head.next, val);
        if(head.val == val) return head.next;
        return head;
    }
}
