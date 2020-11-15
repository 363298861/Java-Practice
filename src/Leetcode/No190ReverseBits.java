package Leetcode;

public class No190ReverseBits {
    public int reverseBits(int n) {
        long res = 0;
        String temp = Integer.toBinaryString(n);
        for(int i = temp.length(); i < 32; i++){
            temp = "0" + temp;
        }
        //System.out.println(temp);
        for(int i = 0; i < temp.length(); i++){
            if(temp.charAt(i) == '1')
                res += Math.pow(2, i);
        }
        return (int) res;
    }

    public int reverseBitsModified(int n){
        int res = 0;
        for(int i = 0; i < 32; i++){
            res <<= 1;
            res += n & 1;
            n >>= 1;
        }
        return res;
    }

    public static void main(String[] args) {
        No190ReverseBits n = new No190ReverseBits();
        int a = 8;
        System.out.println(n.reverseBitsModified(a));
    }
}
