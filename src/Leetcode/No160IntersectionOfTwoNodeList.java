package Leetcode;

public class No160IntersectionOfTwoNodeList {

    public class ListNode {
        int val;
        ListNode next;
        ListNode(int x) {
            val = x;
            next = null;
        }
    }
    public ListNode getIntersectionNode(ListNode headA, ListNode headB) {
        ListNode pa = headA;
        while(pa != null){
            ListNode pb = headB;
            while(pb != null){
                if(pa == pb) return pa;
                pb = pb.next;
            }
            pa = pa.next;
        }
        return null;
    }

    public ListNode getIntersectionNodeModified(ListNode headA, ListNode headB){
        ListNode pa = headA;
        ListNode pb = headB;

        while(pa != pb){
            if(pa == null) pa = headB;
            else pa = pa.next;
            if(pb == null) pb = headA;
            else pb = pb.next;
        }
        return pa;
    }
}
