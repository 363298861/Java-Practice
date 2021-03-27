package leetcodeTest;

public class No75SortColour {
    public void sortColors(int[] nums) {
        int n1 = 0, n2 = nums.length - 1;
        for(int i = 0; i <= n2; i++){
            if(nums[i] == 0 && i != n1){
                nums[i] = nums[n1];
                nums[n1] = 0;
                n1++; i--;
            }else if(nums[i] == 2){
                nums[i] = nums[n2];
                nums[n2] = 2;
                n2--; i--;
            }
        }
    }

    public static void main(String[] args) {
        int[] test = {2, 0, 1};
        No75SortColour n = new No75SortColour();
        n.sortColors(test);
        for(int i : test)
            System.out.print(i + " ");
    }
}
