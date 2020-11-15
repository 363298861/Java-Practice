package Leetcode;

import java.util.ArrayList;
import java.util.List;

public class No229MajorityElement {
    public List<Integer> majorityElement(int[] nums) {
        List<Integer> list = new ArrayList<>();
        int count1 = 0, count2 = 0, first = 0, second = 0;
        for(int i : nums){
            if(first == i){
                count1++;
            }else if(second == i){
                count2++;
            }else if(count1 == 0){
                first = i;
                count1++;
            }else if(count2 == 0){
                second = i;
                count2++;
            }else {
                count1--;
                count2--;
            }
        }
        int firstn = 0, secondn = 0;
        for(int i : nums){
            if(i == first)
                firstn++;
            if(i == second)
                secondn++;
        }
        if(count1 > 0 && firstn > nums.length / 3)
            list.add(first);
        if(count2 > 0 && secondn > nums.length / 3)
            list.add(second);
        return list;
    }

    public static void main(String[] args) {
        int[] t = {3, 2 ,3};
        No229MajorityElement n = new No229MajorityElement();
        System.out.println(n.majorityElement(t));
    }
}
