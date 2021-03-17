package Leetcode;

public class No167TwoSumSorted {
    public int[] twoSum(int[] numbers, int target) {
        int lo = 0, hi = numbers.length - 1;
        while(lo < hi){
            if(numbers[lo] + numbers[hi] == target)
                return new int[] {lo, hi};
            else if(numbers[lo] + numbers[hi] < target)
                lo++;
            else
                hi--;
        }
        return null;
    }
}
