package Leetcode;

public class No23MergeKSortedArray {
    public class ListNode {
        int val;
        ListNode next;
        ListNode() {}
        ListNode(int val) { this.val = val; }
        ListNode(int val, ListNode next) { this.val = val; this.next = next; }
    }

    public ListNode mergeKLists(ListNode[] lists) {
        ListNode[] ptrs = new ListNode[lists.length];
        for(int i = 0; i < lists.length; i++)
            ptrs[i] = lists[i];
        ListNode res = new ListNode(0);
        ListNode p = res;
        int emtpy = 0;
        while(emtpy < lists.length){
            emtpy = 0;
            int min = Integer.MAX_VALUE, idx = 0;
            for(int i = 0; i < ptrs.length; i++){
                if(ptrs[i] == null){
                    emtpy++;
                    continue;
                }
                if(ptrs[i].val < min){
                    min = ptrs[i].val;
                    idx = i;
                }
            }
            if(emtpy == lists.length) break;
            p.next = ptrs[idx];
            p = p.next;
            ptrs[idx] = ptrs[idx].next;
        }
        return res.next;
    }
    private boolean existNode(ListNode[] ptrs){
        for(ListNode l : ptrs) {
            if (l != null) return true;
        }
        return false;
    }
}
