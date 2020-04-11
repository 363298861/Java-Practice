package Leetcode;

public class No167TwoSumSorted {
    public int[] twoSum(int[] numbers, int target) {

        for(int i = 0; i < numbers.length; i++){
            int n = target - numbers[i];
            if(n == numbers[i]){
                return new int[] {i, i + 1};
            }
            if(n > numbers[i] && i != numbers.length - 1){
                for(int j = i + 1; j < numbers.length; j++){
                    if(numbers[j] == n)
                        return new int[] {i, j};
                }
            }
        }
        return null;
    }
}
