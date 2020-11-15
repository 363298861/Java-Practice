package Leetcode;

public class No231PowerOfTwo {
    public boolean isPowerOfTwo(int n) {
        if(n < 0) return false;
        int res = 0;
        for(int i = 0; i < 31; i++){
            res += n & 1;
            n >>= 1;
        }
        return res == 1;
    }

    public static void main(String[] args) {
        int a = 1 << 31;
        System.out.println(a);
    }
}
