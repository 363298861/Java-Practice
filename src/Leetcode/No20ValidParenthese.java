package Leetcode;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class No20ValidParenthese {
    public boolean isValid(String s) {
        Map<Character, Character> brackets = new HashMap<>();
        brackets.put(']', '[');
        brackets.put('}', '{');
        brackets.put(')', '(');

        List<Character> left = new ArrayList<>();

        for(int i = 0; i < s.length(); i++){
            if(brackets.containsValue(s.charAt(i))){
                left.add(s.charAt(i));
            }else{
                if(left.size() == 0)
                    return false;
                if(brackets.get(s.charAt(i)) != left.get(left.size() - 1))
                    return false;
                left.remove(left.size() - 1);
            }
        }
        return left.size() == 0;
    }

    public static void main(String[] args) {
        No20ValidParenthese t = new No20ValidParenthese();
        System.out.println(t.isValid("([{}()[])"));
    }
}
