package Leetcode;

import java.util.Stack;

public class No227BasicCalculator {
    public int calculate(String s) {
        Stack<Integer> stack = new Stack<>();
        char sign = '+';
        int num = 0;
        for(int i = 0; i < s.length(); i++){
            if(Character.isDigit(s.charAt(i))){
                num = num * 10 + s.charAt(i) - '0';
            }
            if(!Character.isDigit(s.charAt(i)) && s.charAt(i) != ' ' || i == s.length() - 1){
                if(sign == '+')
                    stack.push(num);
                if(sign == '-')
                    stack.push(-num);
                if(sign == '*')
                    stack.push(stack.pop() * num);
                if(sign == '/')
                    stack.push(stack.pop() / num);
                sign = s.charAt(i);
                num = 0;
            }
        }
        int res = 0;
        for(int i : stack) {
            res += i;
        }
        return res;
    }


    public static void main(String[] args) {
        String s = "3 + 2 * 2 ";
        No227BasicCalculator n = new No227BasicCalculator();
        System.out.println(n.calculate(s));
    }
}
