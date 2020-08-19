package com.xiaowuzei.test.algr.leet;

import java.util.LinkedList;
import java.util.Queue;

public class N225_ImplementStackUsingQueues {
    public static void main(String[] args) {
        MyStack stack = new MyStack();

        stack.push(1);
        stack.push(2);
        // returns 2
        System.out.println(stack.pop());
        // returns 2
        System.out.println(stack.top());
        // returns false
        System.out.println(stack.empty());

    }
}

class MyStack {

    private int top;
    private Queue<Integer> queue;

    /** Initialize your data structure here. */
    public MyStack() {
        queue = new LinkedList<>();
    }

    /** Push element x onto stack. */
    public void push(int x) {
        queue.add(x);
        top = x;
    }

    /** Removes the element on top of the stack and returns that element. */
    public int pop() {
        int count = queue.size();
        while (count > 1) {
            top = queue.poll();
            queue.add(top);
            count--;
        }
        return queue.poll();
    }

    /** Get the top element. */
    public int top() {
        return top;
    }

    /** Returns whether the stack is empty. */
    public boolean empty() {
        return queue.isEmpty();
    }
}

