package Leetcode;

public class No445AddTwoNum {
    public static class ListNode {
        int val;
        ListNode next;
        ListNode(int x) { val = x; }
        @Override
        public String toString(){
            String res = "";
            if(next != null)
                res += val + ", " + next;
            if(next == null)
                res += val;
            return res;
        }
    }

    public ListNode addTwoNumbers(ListNode l1, ListNode l2) {
        l1 = reverse(l1);
        l2 = reverse(l2);
        ListNode res = new ListNode(0);
        ListNode p = res;
        int carry = 0;
        while(l1 != null || l2!= null){
            int sum = p.val;
            if(l1 != null) {
                sum += l1.val;
                l1 = l1.next;
            }
            if(l2 != null){
                sum += l2.val;
                l2 = l2.next;
            }
            carry = sum / 10;
            sum = sum % 10;
            p.val = sum;
            if(carry > 0 || l1 != null || l2 != null){
                p.next = new ListNode(carry);
                p = p.next;
            }
        }
        return reverse(res);
    }

    public ListNode reverse(ListNode l){
        ListNode oldHead = l;
        ListNode newHead = reverseList(l);
        oldHead.next = null;
        return newHead;
    }


    public ListNode reverseList(ListNode l){
        if(l.next == null)
            return l;
        ListNode next = l.next;
        ListNode head = reverseList(l.next);
        next.next = l;
        return head;
    }

    public static void main(String[] args) {
        ListNode l = new ListNode(1);
        l.next = new ListNode(2);
        l.next.next = new ListNode(3);
        l.next.next.next = new ListNode(4);
        l.next.next.next.next = new ListNode(5);
        System.out.println(l);
        No445AddTwoNum n = new No445AddTwoNum();
        System.out.println(n.reverse(l));
    }
}
