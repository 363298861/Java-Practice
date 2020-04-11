package Leetcode;

public class No66PlusOne {
    public int[] plusOne(int[] digits) {
        boolean allNine = true;
        for(int i = 0; i < digits.length; i++){
            if(digits[i] != 9) {
                allNine = false;
                break;
            }
        }
        if(allNine){
            int[] res = new int[digits.length + 1];
            res[0] = 1;
            return res;
        }
        for(int i = digits.length - 1; i >= 0; i--){
            if(digits[i] != 9){
                digits[i]++;
                break;
            }else{
                digits[i] = 0;
            }
        }
        return digits;
    }

    public static void main(String[] args) {
        int[] a = {9, 9, 9 ,9};
        No66PlusOne t = new No66PlusOne();
        int[] b = t.plusOne(a);
        for(int i = 0; i < b.length; i++)
            System.out.println(b[i]);
    }
}
