package leetcodeTest;

import java.util.Stack;

public class No20ValidParenthsis {
    public boolean isValid(String s) {
        Stack<Character> stack = new Stack<>();
        for(int i = 0; i < s.length(); i++){
            if(s.charAt(i) == '(' || s.charAt(i) == '{' || s.charAt(i) == '['){
                stack.push(s.charAt(i));
            }else{
                if(stack.isEmpty()) return false;
                char t = stack.pop();
                if(s.charAt(i) == ')' && t == '(') continue;
                if(s.charAt(i) == '}' && t == '{') continue;
                if(s.charAt(i) == ']' && t == '[') continue;
                return false;

            }
        }
        return stack.isEmpty();
    }
}
