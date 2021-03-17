package Leetcode;

public class No283MoveZeros {
    public void moveZeroes(int[] nums) {
        int z = 0, n = 0;
        while(n < nums.length && z < nums.length){
            if(nums[z] != 0){
                z++;
                continue;
            }
            if(nums[n] == 0){
                n++;
                continue;
            }
            if(n > z){
                nums[z] = nums[n];
                nums[n] = 0;
                z++;
            }
            n++;
        }
    }

    public static void main(String[] args) {
        int[] test = {1, 0, 1};
        No283MoveZeros n = new No283MoveZeros();
        n.moveZeroes(test);
        for(int i : test)
            System.out.println(i);
    }
}
