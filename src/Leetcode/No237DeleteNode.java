package Leetcode;

public class No237DeleteNode {

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

    public void deleteNode(ListNode node) {
        ListNode prev = node;
        while(node.next != null){
            node.val = node.next.val;
            prev = node;
            node = node.next;
        }
        prev.next = null;
    }
}
