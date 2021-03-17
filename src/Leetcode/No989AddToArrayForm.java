package Leetcode;

import java.util.ArrayList;
import java.util.List;

public class No989AddToArrayForm {
    public List<Integer> addToArrayForm(int[] A, int K) {
        List<Integer> res = new ArrayList<>();
        int i = 0;
        int carry = 0;
        while(i < A.length || K > 0){
            int sum = carry;
            if(i < A.length) sum += A[A.length - 1 - i++];
            if(K > 0) {
                sum += K % 10;
                K = K / 10;
            }
            carry = sum / 10;
            sum = sum % 10;
            res.add(0, sum);
        }
        if(carry == 1) res.add(0, 1);
        return res;

    }

    public static void main(String[] args) {
        int[] test = {1, 2, 0, 0};
        No989AddToArrayForm n = new No989AddToArrayForm();
        System.out.println(n.addToArrayForm(test, 34));
    }
}
