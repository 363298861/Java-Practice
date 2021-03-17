package Leetcode;

import java.util.*;

public class No300LongestIncreasingSublist {
    int depth = 0;
    public int BFS(int[] nums) {
        int l = nums.length;
        int res = 0;
        if(l == 0) return 0;
        int min = nums[0];
        for(int i = 0; i < l; i++){
            if(nums[i] > min){
                continue;
            }else{
                min = nums[i];
            }
            Queue<Integer> queue = new LinkedList<>();
            int s = 0;
            queue.offer(i);
            while(!queue.isEmpty()) {
                int q = queue.size();
                for (int j = 0; j < q; j++) {
                    int start = queue.poll();
                    for (int k = start + 1; k < l; k++) {
                        if (nums[k] > nums[start]) {
                            queue.offer(k);
                        }
                    }
                }
                s++;
            }
            if(s > res)
                res = s;
        }
        return res;
    }

    public int DFS(int[] nums){
        if(nums.length == 0) return 0;
        List<Integer> list = new ArrayList<>();
        DFShelper(nums, list, 0);
        return depth;
    }

    private void DFShelper(int[] nums, List<Integer> list, int idx){
        //System.out.println(list);
        if(idx > nums.length - 1){
            if(list.size() > depth)
                depth = list.size();
            return;
        }
        boolean added = false;
        for(int i = idx; i < nums.length; i++){
            if(list.isEmpty() || nums[i] > nums[list.get(list.size() - 1)]) {
                list.add(i);
                added = true;
            }
            DFShelper(nums, list, i + 1);
            if(added) {
                added = false;
                list.remove(list.size() - 1);
            }
        }
    }

    public int dp(int[] nums){
        int[] dp = new int[nums.length];
        int res = 0;
        for(int i = 1; i < nums.length; i++){
            for(int j = 0; j < i; j++){
                if(nums[j] < nums[i]){
                    dp[i] = Math.max(dp[i], dp[j] + 1);
                }
            }
            res = Math.max(res, dp[i]);
        }
        return res;
    }

    public int patienceSorting(int[] nums){
        List<Integer> list = new ArrayList<>();
        for(int n : nums){
            int pile = Collections.binarySearch(list, n);
            if(pile < 0) pile = ~pile;
            if(pile == list.size()){
                list.add(n);
            }else{
                list.set(pile, n);
            }
        }
        return list.size();
    }

    public static void main(String[] args) {
        int[] nums = new int[2500];
        for(int i = 0; i < 2500; i++)
            nums[i] = i;
        int[] nums2 = {0, 1, 0, 3, 2, 3};
        int[] nums3 = {0,3,1,6,2,2,7};
        int[] nums4 = {0, 1, 2, 3};
        No300LongestIncreasingSublist n = new No300LongestIncreasingSublist();
        System.out.println(n.DFS(nums));
    }
}
