package Leetcode;

import java.util.ArrayList;
import java.util.List;
import java.util.Stack;

public class No155MinStack {

    public static class MinStack {

        Stack<Integer> stack;
        int min;
        /** initialize your data structure here. */

        public MinStack() {
            stack = new Stack<>();
            min = Integer.MAX_VALUE;
        }

        public void push(int x) {
            if(x <= min){
                stack.push(min);
                min = x;
            }
            stack.push(x);
        }

        public void pop() {
            if(stack.pop() == min)
                min = stack.pop();
        }

        public int top() {
            return stack.peek();
        }

        public int getMin() {
            return min;
        }
    }

    public static void main(String[] args) {
        MinStack m = new MinStack();
        m.push(3);
        m.push(1);
        m.push(5);
        System.out.println(m.getMin());

    }
}
