package Leetcode;

import java.util.LinkedList;
import java.util.Queue;

public class No45JumpGame {
    public class Node{
        public int n;
        public int pos;
        public int lev;
        public Node(int n, int pos, int lev) {
            this.n = n;
            this.pos = pos;
            this.lev = lev;
        }
        @Override
        public String toString(){
            return (n + " " + pos + " " + lev);
        }
    }
    public int jump(int[] nums) {
        if(nums.length == 1) return 0;
        Queue<Node> queue = new LinkedList<>();
        queue.offer(new Node(nums[0], 0, 0));
        int res = 0;
        while(!queue.isEmpty()){
            Node n = queue.poll();
            System.out.println(n);
            for(int i = n.pos + 1; i <= n.pos + n.n; i++){
                if(n.pos + n.n < nums.length - 1 && n.n != 0)
                    queue.offer(new Node(nums[i], i, n.lev + 1));
                else if (n.pos + n.n >= nums.length - 1){
                    if(res == 0 || n.lev + 1 < res)
                        res = n.lev + 1;
                }
            }
        }
        return res;
    }

    public int jump2(int[] nums){
        int lop = 0, hip = 0, lo = 0, hi = 0;
        int res = 0;
        while(hi < nums.length - 1) {
            for (int i = lop; i <= hip; i++) {
                if(nums[i] == 0)
                    lo = i;
                else
                    lo = i + 1;
                hi = Math.max(hi, i + nums[i]);
            }
            lop = lo;
            hip = hi;
            res++;
        }
        return res;
    }

    public static void main(String[] args) {
        int[] nums = {5,6,4,4,6,9,4,4,7,4,4,8,2,6,8,1,5,9,6,5,2,7,9,7,9,6,9,4,1,6,8,8,4,4,2,0,3,8,5};
        No45JumpGame n = new No45JumpGame();
        System.out.println(n.jump2(nums));
    }
}
