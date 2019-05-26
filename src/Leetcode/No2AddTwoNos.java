package Leetcode;

public class No2AddTwoNos {

    public class ListNode {
       int val;
       ListNode next;
       ListNode(int x) { val = x; }
    }

    public ListNode addTwoNumbers(ListNode l1, ListNode l2) {
        int carry = 0;
        ListNode ln = new ListNode(0);
        ListNode l3 = l1, l4 = l2, res = ln;

        while (l3 != null || l4 != null){
            int x = l3 != null ? l3.val : 0;
            int y = l4 != null ? l4.val : 0;
            int sum = x + y + carry;
            carry = sum / 10;
            ln.next = new ListNode(sum % 10);
            l3 = l3 != null ? l3.next : l3;
            l4 = l4 != null ? l4.next : l4;
            ln = ln.next;
        }
        if(carry > 0)
            ln.next = new ListNode(1);

        return res.next;
    }
}
//From this program I learned that I can use a variable to point to initial object, and use another variable to point the same thing,
// then we can change one of the variable and the other one doesn't change.