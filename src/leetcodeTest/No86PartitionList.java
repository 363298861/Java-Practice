package leetcodeTest;

public class No86PartitionList {
    public class ListNode {
        int val;
        ListNode next;
        ListNode(int x) { val = x; }
        ListNode(int val, ListNode next) { this.val = val; this.next = next; }
    }

    public ListNode partition(ListNode head, int x) {
        ListNode dummy = new ListNode(0);
        dummy.next = head;
        ListNode first = dummy, second = null, tail = dummy;
        while(tail.next != null && first.next != null){
            if(first.next.val < x)
                first = first.next;
            else{
                if(second == null){
                    second = first.next;
                    tail = second;
                    }
                    while(tail.next != null && tail.next.val >= x) {
                        tail = tail.next;
                    }
                if(tail.next != null){
                    first.next = tail.next;
                    tail.next = tail.next.next;
                    first.next.next = second;
                    first = first.next;
                }
            }
        }
        return dummy.next;
    }
    public ListNode partition2(ListNode head, int x){
        ListNode smallhead = new ListNode(0), bighead = new ListNode(0);
        ListNode small = smallhead, big = bighead;
        while(head != null){
            if(head.val < x){
                small.next = head;
                small = small.next;
            }else{
                big.next = head;
                big = big.next;
            }
            head = head.next;
        }
        small.next = bighead.next;
        big.next = null;
        return smallhead.next;
    }

}
