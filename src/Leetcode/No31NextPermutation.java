package Leetcode;

import java.util.Arrays;
import java.util.Collections;

public class No31NextPermutation {
    public void nextPermutation(int[] nums) {
        int l = nums.length;
        int k = -1, t = -1;
        for(int i = l - 1; i > 0; i--){
            if(nums[i - 1] < nums[i]){
                k = i - 1;
                break;
            }
        }
        if(k == -1){
           for(int i = 0; i < l / 2; i++){
               int tm = nums[i];
               nums[i] = nums[l - 1 - i];
               nums[l - 1 - i] = tm;
           }
            return;
        }
        for(int i = l - 1; i > 0; i--){
            if(nums[i] > nums[k]){
                t = i;
                break;
            }
        }
        int tmp = nums[k];
        nums[k] = nums[t];
        nums[t] = tmp;
        for(int i = k + 1; i < (l - 1 - k) / 2 + k + 1; i++){
            int tmp2 = nums[l - 1 - (i - k - 1)];
            nums[l - 1 - (i - k - 1)] = nums[i];
            nums[i] = tmp2;
        }
    }

    public static void main(String[] args) {
        int[] a = {3, 2, 1};
        Collections.reverse(Arrays.asList(a));
        for(int i : a)
            System.out.println(i);
    }
}
