package Leetcode;

public class No27RemoveElement {
    public int removeElement(int[] nums, int val) {
        int length = 0;
        for(int i = 0; i < nums.length; i++){
            if(nums[i] == val){
                
            }
        }
        return length;
    }

    public static void main(String[] args) {
        int[] t1 = {3, 2, 2, 3};
        int[] t2 = {0,1,2,2,3,0,4,2};
        No27RemoveElement t = new No27RemoveElement();
        System.out.println(t.removeElement(t1, 2));
        System.out.println(t.removeElement(t2, 2));
    }
}
