package Leetcode;

import java.util.PriorityQueue;

public class No703KthLargestElement {
    PriorityQueue<Integer> pq;
    int k;
    public No703KthLargestElement(int k, int[] nums) {
        this.k = k;
        pq = new PriorityQueue<>();
        for(int i : nums){
            pq.offer(i);
            if(pq.size() > k) pq.poll();
        }
    }

    public int add(int val) {
        pq.offer(val);
        if(pq.size() > k)
            pq.poll();
        return pq.peek();
    }
}
