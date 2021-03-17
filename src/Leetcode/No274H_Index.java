package Leetcode;

import java.util.Arrays;
import java.util.Collections;

public class No274H_Index {
    public int hIndex(int[] citations) {
        int h = 0;
        while(true){
            int t = 0;
            for(int i = 0; i < citations.length; i++){
                if (citations[i] > h){
                    t++;
                }
            }
            if(t > h){
                h++;
            }else{
                break;
            }
        }
        return h;
    }

    public int hIndex2(int[] citations){
        int l = citations.length;
        Arrays.sort(citations);
        int i;
        for(i = 0; i < l; i++){
            if(citations[l - i - 1] <= i)
                break;
        }
        return i;
    }

    public static void main(String[] args) {
        int[] test = {3, 0, 6, 1, 5};
        int[] test2 = {1, 1};
        No274H_Index n = new No274H_Index();
        System.out.println(n.hIndex2(test));
    }
}
