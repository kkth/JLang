package com.kun;

import java.util.Stack;

public class QueueByStack_232 {
    Stack<Integer> stackPush;
    Stack<Integer> stackPop;

    public QueueByStack_232() {
        stackPush = new Stack<>();
        stackPop = new Stack<>();
    }

    public void push(int x) {
        if(stackPush.isEmpty()) {
            while(!stackPop.isEmpty()){
                stackPush.push(stackPop.pop());
            }
        }

        stackPush.push(x);
    }

    public int pop() {
        if(stackPop.isEmpty()){
           while(!stackPush.isEmpty()){
               stackPop.push(stackPush.pop());
           }
        }
        return stackPop.pop();
    }

    public int peek() {
        if(stackPop.isEmpty()){
            while(!stackPush.isEmpty()){
                stackPop.push(stackPush.pop());
            }
        }
        int x = -1;
        try {
            x = stackPop.peek();
        } catch (Exception e) {
           x = -1;
        }

        return x;
    }

    public boolean empty() {
        return stackPop.isEmpty() && stackPush.isEmpty();
    }

    public static void main(String[] args) {
        QueueByStack_232 obj = new QueueByStack_232();
        obj.push(1);
        int param_2 = obj.pop();
        int param_3 = obj.peek();
        boolean param_4 = obj.empty();
        System.out.println(param_2);
        System.out.println(param_3);
        System.out.println(param_4);
    }
}

/**
 * Your MyQueue object will be instantiated and called as such:
 * MyQueue obj = new MyQueue();
 * obj.push(x);
 * int param_2 = obj.pop();
 * int param_3 = obj.peek();
 * boolean param_4 = obj.empty();
 */
