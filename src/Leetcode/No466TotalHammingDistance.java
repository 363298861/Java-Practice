package Leetcode;

public class No466TotalHammingDistance {
    public int totalHammingDistance(int[] nums) {
        int res = 0;
        int l = nums.length;
        for(int i = 0; i < 32; i++){
            int tmp = 0;
            for(int j = 0; j < l; j++){
                tmp += (nums[j] >> i) & 1;
            }
            res += tmp * (l - tmp);
        }
        return res;
    }

    public static void main(String[] args) {
        No466TotalHammingDistance n = new No466TotalHammingDistance();
        int[] test = {4, 14, 2};
        System.out.println(n.totalHammingDistance(test));
    }
}
