package Leetcode;

import java.util.Arrays;
import java.util.Collections;
import java.util.PriorityQueue;


public class No215KthLargestElement {
    public int findKthLargest(int[] nums, int k) {
        Arrays.sort(nums);
        return nums[nums.length - k];
    }

    public int findKthLargestPQ(int[] nums, int k){
        PriorityQueue<Integer> pq = new PriorityQueue<>();
        for(int i : nums){
            pq.offer(i);
            if(pq.size() > k)
                pq.poll();
        }
        return pq.peek();
    }

    public int findKthLargestSelection(int[] nums, int k){
        int lo = 0, hi = nums.length - 1;
        while(lo < hi){
            int j = partition(nums, lo, hi);
            if(j == k) return nums[j];
            else if(j < k) lo = j + 1;
            else hi = j - 1;
        }
        return nums[k];
    }

    private int partition(int[] nums, int lo, int hi){
        int i = lo, j = hi + 1;
        while(true){
            while(nums[++i] < nums[lo]){
                if(i == hi) break;
            }
            while(nums[--j] > nums[lo]){
                if(j == lo) break;
            }
            if(i >= j) break;
            swap(nums, i, j);
        }
        swap(nums, lo, j);
        return j;
    }

    private void swap(int[] nums, int lo, int hi){
        int tmp = nums[lo];
        nums[lo] = nums[hi];
        nums[hi] = tmp;
    }

    public static void main(String[] args) {
        No215KthLargestElement n = new No215KthLargestElement();
        int[] test1 = {3, 1, 2};
        System.out.println(n.findKthLargestSelection(test1, 1));
    }
}
