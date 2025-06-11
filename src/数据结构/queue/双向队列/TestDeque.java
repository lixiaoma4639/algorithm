package 数据结构.queue.双向队列;

import java.util.LinkedList;

/**
 * 时间 : 2020/8/13
 * 创建 : xin.li
 * 描述 :
 */
public class TestDeque {

    public static void main(String[] args) {
        Deque<Integer> deque = new Deque<>();
        deque.enQueueFront(2);
        deque.enQueueFront(1);
        deque.enQueueFront(0);
        deque.enQueueRear(3);
        deque.enQueueRear(4);
        deque.enQueueRear(5);

        System.out.println(deque.front());
        System.out.println(deque.rear());
        while (!deque.isEmpty()){
            System.out.print(deque.deQueueRear());
        }
    }
}
