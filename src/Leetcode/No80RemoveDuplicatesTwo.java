package Leetcode;

public class No80RemoveDuplicatesTwo {
    public int removeDuplicates(int[] nums) {
        int l = nums.length;
        int res = 0;
        for(int i = 0; i < l; i++){
            if(i < l - 1 && nums[i] != nums[i + 1]){
                nums[res] = nums[i];
                res++;
            }else if(i < l - 1 && nums[i] == nums[i + 1]){
                int t = 1;
                while(i + t < l && nums[i] == nums[i + t])
                    t++;
                nums[res] = nums[res + 1] = nums[i];
                i += t - 1;
                res += 2;
            }else{
                nums[res] = nums[i];
                res++;
            }
        }
        return res;
    }

    public static void main(String[] args) {
        int[] arr = {1, 1, 1, 2, 2, 3};
        No80RemoveDuplicatesTwo t = new No80RemoveDuplicatesTwo();
        System.out.println(t.removeDuplicates(arr));
    }
}
