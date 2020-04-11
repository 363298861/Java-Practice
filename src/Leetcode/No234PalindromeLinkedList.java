package Leetcode;

public class No234PalindromeLinkedList {
    public class ListNode {
        int val;
        ListNode next;
        ListNode(int x) { val = x; }
    }

    public boolean isPalindrome(ListNode head) {
        ListNode fast = head;
        ListNode newHead = null;

        while(fast != null){
            if(fast.next != null){
                fast = fast.next.next;
            }else{
                head = head.next;
                break;
            }
            ListNode next = head.next;
            head.next = newHead;
            newHead = head;
            head = next;
        }
        while(newHead != null){
            if(newHead.val != head.val)
                return false;
            newHead = newHead.next;
            head = head.next;
        }
        return true;
    }
}
