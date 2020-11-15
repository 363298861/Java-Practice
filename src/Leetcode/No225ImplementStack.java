package Leetcode;

import java.util.LinkedList;
import java.util.Queue;

public class No225ImplementStack {
    Queue<Integer> queue;

    public No225ImplementStack() {
        queue = new LinkedList<>();
    }

    /** Push element x onto stack. */
    public void push(int x) {
        queue.offer(x);
    }

    /** Removes the element on top of the stack and returns that element. */
    public int pop() {
        int res = queue.poll();
        Queue<Integer> tmp = new LinkedList<>();
        while(!queue.isEmpty()){
            tmp.add(res);
            res = queue.poll();
        }
        queue = tmp;
        return res;
    }

    /** Get the top element. */
    public int top() {
        int res = pop();
        queue.add(res);
        return res;
    }

    /** Returns whether the stack is empty. */
    public boolean empty() {
        return queue.isEmpty();
    }
}
