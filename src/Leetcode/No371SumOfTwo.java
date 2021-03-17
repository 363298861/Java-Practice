package Leetcode;

import java.util.ArrayList;
import java.util.List;

public class No371SumOfTwo {
    public int getSum(int a, int b) {
        int carry = 0;
        List<Integer> list = new ArrayList<>();
        while(a != 0 || b != 0){
            if(carry == 1){
                if((a & 1) == 1 && (b & 1) == 1){
                    list.add(0, 1);
                }else if((a & 1) == 0 && (b & 1) == 0){
                    list.add(0, 1);
                    carry = 0;
                }else{
                    list.add(0, 0);
                }
            }else{
                if((a & 1) == 1 && (b & 1) == 1){
                    list.add(0, 0);
                    carry = 1;
                }else if((a & 1) == 0 && (b & 1) == 0){
                    list.add(0, 0);
                }else{
                    list.add(0, 1);
                }
            }
            a >>>= 1; b >>>= 1;
        }
        if(carry == 1 && list.size() < 32) list.add(0, 1);
        StringBuilder sb = new StringBuilder();
        System.out.println(list);
        for(int i : list)
            sb.append(i);
        return Integer.parseInt(sb.toString(), 2);
    }

    public int getSumModified(int a, int b){
        return b == 0 ? a : getSumModified(a ^ b, (a & b) << 1);
    }

    public static void main(String[] args) {
        No371SumOfTwo n = new No371SumOfTwo();
        System.out.println(n.getSum(-2, 1));
    }
}
