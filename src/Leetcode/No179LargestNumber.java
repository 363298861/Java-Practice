package Leetcode;

import java.util.Arrays;
import java.util.Comparator;

public class No179LargestNumber {

    static class Cmp implements Comparator<Integer>{

        @Override
        public int compare(Integer o1, Integer o2) {
            String a = Integer.toString(o1);
            String b = Integer.toString(o2);
            String s1 = a + b;
            String s2 = b + a;
            return s1.compareTo(s2);
        }
    }
    public String largestNumber(int[] nums) {
        String res = "";
        nums = Arrays.stream(nums).
                boxed().
                sorted(new Cmp().reversed()). // sort descending
                mapToInt(i -> i).
                toArray();
        StringBuilder sb = new StringBuilder();
        for(int i : nums){
            sb.append(i);
        }
        return sb.toString().replaceFirst("^0+(?!$)", "");
    }

    public static void main(String[] args) {
        int[] test = {824,938,1399,5607,6973,5703,9609,4398,8247};
        test = Arrays.stream(test).
                boxed().
                sorted(new Cmp().reversed()). // sort descending
                mapToInt(i -> i).
                toArray();
        for(int i : test) System.out.print(i + ", ");
        System.out.println();
        No179LargestNumber n = new No179LargestNumber();
        System.out.println(n.largestNumber(test));
    }
}
