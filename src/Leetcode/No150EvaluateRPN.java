package Leetcode;

import edu.princeton.cs.algs4.In;

import java.util.Stack;

public class No150EvaluateRPN {
    public int evalRPN(String[] tokens) {
        if(tokens.length == 1) return Integer.parseInt(tokens[0]);
        int head = 0, tail = 0, res = 0;
        String[] newTokens = new String[tokens.length - 2];
        for(int i = 0; i < tokens.length; i++){
            if(tokens[i].length() == 1 && !Character.isDigit(tokens[i].charAt(0))){
                head = i - 2;
                tail = i + 1;
                res = calulate(tokens[i - 2], tokens[i - 1], tokens[i]);
                break;
            }
        }
        System.arraycopy(tokens, 0, newTokens, 0, head);
        newTokens[head] = Integer.toString(res);
        System.arraycopy(tokens, tail, newTokens, head + 1, tokens.length - tail);
        return evalRPN(newTokens);
    }

    public int evalRPNIterative(String[] tokens){
        Stack<Integer> stack = new Stack<>();
        for(int i = 0; i < tokens.length; i++){
            if(tokens[i].equals("+")){
                int t1 = stack.pop();
                int t2 = stack.pop();
                stack.push(t1 + t2);
            }else if(tokens[i].equals("-")){
                int t1 = stack.pop();
                int t2 = stack.pop();
                stack.push(t2 - t1);
            }else if(tokens[i].equals("*")){
                int t1 = stack.pop();
                int t2 = stack.pop();
                stack.push(t2 * t1);
            }else if(tokens[i].equals("/")){
                int t1 = stack.pop();
                int t2 = stack.pop();
                stack.push(t2 / t1);
            }else{
                stack.push(Integer.parseInt(tokens[i]));
            }
        }
        return stack.pop();
    }

    int calulate(String op1, String op2, String op){
        int o1 = Integer.parseInt(op1);
        int o2 = Integer.parseInt(op2);
        if(op.equals("+")) return o1 + o2;
        if(op.equals("-")) return o1 - o2;
        if(op.equals("*")) return o1 * o2;
        if(op.equals("/")) return o1 / o2;
        return 0;
    }

    public static void main(String[] args) {
        No150EvaluateRPN n = new No150EvaluateRPN();
        String[] test = {"3", "4", "-", "5", "+"};
        System.out.println(n.evalRPN(test));
    }
}
