package leetcodeTest;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class No66PlusOne {
    public int[] plusOne(int[] digits) {
        int carry = 1;
        List<Integer> res = new ArrayList<>();
        for(int i = digits.length - 1; i >= 0; i--){
            int sum = digits[i] + carry;
            res.add(sum % 10);
            carry = sum / 10;
        }
        if(carry != 0) res.add(carry);
        int[] r = new int[res.size()];
        for(int i = res.size() - 1; i >= 0; i--)
            r[res.size() - 1 - i] = res.get(i);
        return r;
    }
}
