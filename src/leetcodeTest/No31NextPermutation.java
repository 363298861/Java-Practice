package leetcodeTest;

import java.util.Arrays;
import java.util.Collections;

public class No31NextPermutation {
    public void nextPermutation(int[] nums) {
        for(int i = nums.length - 1; i >= 0; i--){
            if(i == 0 || nums[i - 1] < nums[i]){
                Arrays.sort(nums, i, nums.length);
                if(i != 0) {
                    for(int j = i; j < nums.length; j++){
                        if(nums[j] > nums[i - 1]){
                            int tmp = nums[j];
                            nums[j] = nums[i - 1];
                            nums[i - 1] = tmp;
                            break;
                        }
                    }
                }
                break;
            }
        }
    }

    public static void main(String[] args) {
        No31NextPermutation n = new No31NextPermutation();
        int[] test = {2, 3, 1};
        n.nextPermutation(test);
        for(int i : test) System.out.println(i);
    }
}
