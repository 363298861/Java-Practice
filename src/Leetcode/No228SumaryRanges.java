package Leetcode;

import java.util.ArrayList;
import java.util.List;

public class No228SumaryRanges {
    public List<String> summaryRanges(int[] nums) {
        List<String> list = new ArrayList<>();
        for(int i = 0; i < nums.length; i++){
            int start = nums[i];
            while(i < nums.length - 1 && nums[i + 1] - nums[i] == 1)
                i++;
            if(nums[i] == start)
                list.add(Integer.toString(start));
            else
                list.add(start + "->" + nums[i]);
        }
        return list;
    }

    public static void main(String[] args) {
        int[] t = {0, 1, 2, 4, 5, 7};
        No228SumaryRanges n = new No228SumaryRanges();
        System.out.println(n.summaryRanges(t));
    }
}
