package Leetcode;

public class No109LinkedListToBST {


    public class ListNode {
        int val;
        ListNode next;
        ListNode() {}
        ListNode(int val) { this.val = val; }
        ListNode(int val, ListNode next) { this.val = val; this.next = next; }
    }

    public class TreeNode {
        int val;
        TreeNode left;
        TreeNode right;
        TreeNode() {}
        TreeNode(int val) { this.val = val; }
        TreeNode(int val, TreeNode left, TreeNode right) {
            this.val = val;
            this.left = left;
            this.right = right;
        }
    }

    public TreeNode sortedListToBST(ListNode head) {
        if(head == null) return null;
        return sortedListToBST(head, null);
    }

    public TreeNode sortedListToBST(ListNode head, ListNode tail){
        ListNode slow = head;
        ListNode fast = head;
        if(head == tail) return null;
        while(fast != tail && fast.next != tail){
            fast = fast.next.next;
            slow = slow.next;
        }
        TreeNode thead = new TreeNode(slow.val);
        thead.left = sortedListToBST(head, slow);
        thead.right = sortedListToBST(slow.next, tail);
        return thead;
    }
}
