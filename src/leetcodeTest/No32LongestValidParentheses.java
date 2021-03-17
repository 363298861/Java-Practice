package leetcodeTest;

import java.util.*;

public class No32LongestValidParentheses {
    public int longestValidParentheses(String s) {
        List<Integer> list = new ArrayList<>();
        for(int i = 0; i < s.length(); i++){
            if(list.isEmpty() || list.get(list.size() - 1) > 0){
                if(s.charAt(i) == '(')
                    list.add(-i - 1);
                else
                    list.add(i + 1);
            }else{
                if(s.charAt(i) == '(')
                    list.add(-i - 1);
                else
                    list.remove(list.size() - 1);
            }
        }
        int res = 0;
        list.add(0, 0); list.add(s.length() + 1);
        System.out.println(list);
        for(int i = 0; i < list.size() - 1; i++)
            res = Math.max(res, Math.abs(list.get(i + 1)) - Math.abs(list.get(i)) - 1);
        return res;
    }

    public static void main(String[] args) {
        String test = "()()";
        No32LongestValidParentheses n = new No32LongestValidParentheses();
        System.out.println(n.longestValidParentheses(test));
    }
}
