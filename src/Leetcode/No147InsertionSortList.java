package Leetcode;

public class No147InsertionSortList {

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

    public ListNode insertionSortList(ListNode head) {
        if(head == null) return null;
        ListNode nhead = head, cur = head.next;
        head.next = null;
        while(cur != null){
            ListNode tmp = cur;
            cur = cur.next;
            nhead = insert(nhead, tmp);
        }
        return nhead;
    }

    public ListNode insert(ListNode head, ListNode node){
        if(node == null) return head;
        ListNode dummy = new ListNode(0, head);
        ListNode p = dummy;
        while(p.next != null && p.next.val < node.val){
            p = p.next;
        }
        ListNode next = p.next;
        p.next = node;
        node.next = next;
        return dummy.next;
    }

    public static void main(String[] args) {
        ListNode l = new ListNode(4);
        l.next = new ListNode(3);
        l.next.next = new ListNode(2);
        l.next.next.next = new ListNode(1);
        System.out.println(l);
        No147InsertionSortList n = new No147InsertionSortList();
        ListNode sorted = n.insertionSortList(l);
        System.out.println(sorted);
    }
}
