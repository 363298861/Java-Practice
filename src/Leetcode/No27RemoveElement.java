package Leetcode;

public class No27RemoveElement {
    public int removeElement(int[] nums, int val) {
        int length = 0;
        for(int i = 0; i < nums.length; i++){
            int gap = 0;
            while (i + gap < nums.length && nums[i + gap] == val){
                gap++;
            }
            if(gap == 0){
                nums[length] = nums[i];
                length++;

            }else if(i + gap < nums.length){
                nums[length] = nums[i + gap];
                i += gap - 1;
            }
        }
        return length;
    }

    public static void main(String[] args) {
        int[] t1 = {3, 2, 2, 3};
        int[] t2 = {0,1,2,2,3,0,4,2};
        No27RemoveElement t = new No27RemoveElement();
        System.out.println(t.removeElement(t1, 2));
        for(int i = 0; i < t1.length; i++)
            System.out.print(t1[i] + ", ");
        System.out.println();
        System.out.println(t.removeElement(t2, 2));
        for(int i = 0; i < t2.length; i++)
            System.out.print(t2[i] + ", ");
    }
}
