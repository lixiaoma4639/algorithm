package 练习.队列;

import java.util.Stack;

/**
 * 时间 : 2020/8/13
 * 创建 : xin.li
 * 描述 : https://leetcode-cn.com/problems/implement-queue-using-stacks/
 */
public class _232_用栈实现队列 {

    public static void main(String[] args) {
        _232_用栈实现队列 queue = new _232_用栈实现队列();
        queue.push(1);
        queue.push(2);
        queue.push(3);
        queue.push(4);
        queue.push(5);

        System.out.println(queue.pop());
        System.out.println(queue.peek());
        queue.push(6);

        while (!queue.empty()){
            System.out.print(queue.pop());
        }
    }

    private final Stack<Integer> inStack = new Stack<>();
    private final Stack<Integer> outStack = new Stack<>();

    /** 入队 */
    public void push(int x) {
        inStack.push(x);
    }

    /** 出队 */
    public int pop() {
        checkStack();
        return outStack.pop();
    }

    /** 获取队头元素 */
    public int peek() {
        checkStack();
        return outStack.peek();
    }

    /** 判断队列是否为空 */
    public boolean empty() {
        return inStack.empty() && outStack.empty();
    }

    private void checkStack(){
        if (outStack.empty()){
            while (!inStack.empty()){
                //inStack不为空,将元素移动到outStack
                outStack.push(inStack.pop());
            }
        }
    }
}
