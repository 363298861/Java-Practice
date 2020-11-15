package Leetcode;

public class No148SortList {

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

    public ListNode sortList(ListNode head) {
        if(head == null) return null;
        if(head.next == null) return head;
        ListNode fast = head, slow = head, midpoint = head;

        while(fast != null && fast.next != null){
            midpoint = slow;
            slow = slow.next;
            fast = fast.next.next;
        }
        midpoint.next = null;

        ListNode t1 = sortList(head);
        ListNode t2 = sortList(slow);
        return merge(t1, t2);
    }

    ListNode merge(ListNode l1, ListNode l2){

        ListNode dummy = new ListNode(0, null);
        ListNode p = dummy;
        while(l1 != null && l2 != null){
            if(l1.val > l2.val){
                p.next = l2;
                l2 = l2.next;
            }else{
                p.next = l1;
                l1 = l1.next;
            }
            p = p.next;
        }
        if(l1 == null)
            p.next = l2;
        else
            p.next = l1;
        return dummy.next;
    }

    public static void main(String[] args) {
        ListNode l = new ListNode(1);
        l.next = new ListNode(3);
        l.next.next = new ListNode(5);
        ListNode n = new ListNode(2);
        //n.next = new ListNode(4);
        //n.next.next = new ListNode(6);
        No148SortList sl = new No148SortList();
        ListNode ln = sl.merge(l, n);
        System.out.println(ln);
    }

}
