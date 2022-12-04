package com.example.demo.entity;

import java.util.Stack;

/**
 * @program: springboot_01
 * @description:
 * @author: guoyiguang
 * @create: 2021-05-04 11:30
 **/
public class MyQueue {

    Stack<Integer> stack1;
    Stack<Integer> stack2;

    public MyQueue() {
        stack1 = new Stack<>();
        stack2 = new Stack<>();
    }

    public void push(int x){
        stack1.push(x);
    }

    public int pop(){
        if (empty()) {
            return -1;
        }

        // 将stack1 的内容 扔到 stack2 里
        // 不知道循环次数，所以用 while
        while(!stack1.isEmpty()){
            stack2.push(stack1.pop());
        }
        return  stack2.pop();

    }

    public boolean empty(){

        return stack1.isEmpty() && stack2.isEmpty();

    }
}
