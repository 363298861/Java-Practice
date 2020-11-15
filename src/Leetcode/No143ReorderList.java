package Leetcode;

import java.util.HashMap;
import java.util.Map;

public class No143ReorderList {

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

    public void reorderList(ListNode head) {
        Map<Integer, ListNode> map = new HashMap<>();
        int n = 0;
        ListNode ptr = head;
        while(ptr != null){
            map.put(n++, ptr);
            ptr = ptr.next;
        }
        //ptr = head;
        for(int i = 0; i < (map.size() - 1) / 2; i++){
            map.get(i).next = map.get(map.size() - 1 -i);
            map.get(i).next.next = map.get(i + 1);
            map.get(map.size() - 2 - i).next = null;
        }
    }

    public void reorderList2(ListNode head){
        ListNode slow = head, fast = head, pre = null;

        while(fast == null || fast.next == null){
            pre = slow;
            slow = slow.next;
            fast = fast.next.next;
        }
        pre.next = null;
        slow = reverse(slow);
        merge(head, slow);
    }

    public ListNode reverseHelper(ListNode head, ListNode newHead){
        if(head == null) return newHead;
        ListNode next = head.next;
        head.next = newHead;
        return reverseHelper(next, head);
    }

    public ListNode reverse(ListNode node){
        //return reverseHelper(node, null);
        ListNode newHead = myReverse(node);
        node.next = null;
        return newHead;
    }

    public ListNode myReverse(ListNode node){
        if(node.next == null) return node;
        ListNode newHead = myReverse(node.next);
        node.next.next = node;
        return newHead;
    }

    public void merge(ListNode n1, ListNode n2){
        while(n1 != null && n2 != null){
            ListNode tmp = n1.next;
            ListNode tmp2 = n2.next;
            n1.next = n2;
            if(tmp != null)
                n2.next = tmp;
            n1 = tmp;
            n2 = tmp2;
        }
    }

    public static void main(String[] args) {
        ListNode l1 = new ListNode(1);
        l1.next = new ListNode(2);
        l1.next.next = new ListNode(3);
        l1.next.next.next = new ListNode(4);
        System.out.println(l1);
        No143ReorderList n = new No143ReorderList();
        ListNode l2 = new ListNode(3);
        l2.next = new ListNode(2);
        l2.next.next = new ListNode(1);
        n.reorderList(l1);
        System.out.println(l1);
    }
}
