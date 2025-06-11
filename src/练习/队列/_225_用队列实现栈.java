package 练习.队列;

import java.util.ArrayDeque;
import java.util.Deque;

/**
 * 日期 : 2020/8/17.
 * 创建 : xin.li
 * 描述 : https://leetcode-cn.com/problems/implement-stack-using-queues/
 */
class _225_用队列实现栈 {

    public static void main(String[] args) {
        MyStack myStack = new MyStack();
        for (int i = 0; i < 5; i++) {
            myStack.push(i);
        }

        System.out.println("myStack.top() = " + myStack.top());
        while (!myStack.empty()){
            System.out.println(myStack.pop());
        }
    }

    static class MyStack {

        private Deque<Integer> deque ;

        /** Initialize your data structure here. */
        public MyStack() {

            deque = new ArrayDeque<>();
        }

        //    尾3 2 1 0 头
        /** Push element x onto stack. */
        public void push(int x) {
            deque.addLast(x);
        }

        /** Removes the element on top of the stack and returns that element. */
        public int pop() {
            return deque.removeLast();
        }

        /** Get the top element. */
        public int top() {
            return deque.getLast();
        }

        /** Returns whether the stack is empty. */
        public boolean empty() {
            return deque.isEmpty();
        }


    }

}
