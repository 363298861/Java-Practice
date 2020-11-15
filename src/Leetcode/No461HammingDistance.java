package Leetcode;

public class No461HammingDistance {
    public int hammingDistance(int x, int y) {
        int t = x ^ y;
        int res = 0;
        for(; t > 0; t >>= 1){
            res += t & 1;
        }
        return res;
    }

    public static void main(String[] args) {
        No461HammingDistance n = new No461HammingDistance();
        System.out.println(n.hammingDistance(1, 4));
    }
}
