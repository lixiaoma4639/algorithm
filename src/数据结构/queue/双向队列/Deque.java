package 数据结构.queue.双向队列;

import 数据结构.List;
import 数据结构.link.双向链表.LinkedList2;

/**
 * 时间 : 2020/8/13
 * 创建 : xin.li
 * 描述 : 双端队列
 */
public class Deque<E> {
    private List<E> list = new LinkedList2<>();

    public int size(){
        return list.size();
    }

    public boolean isEmpty(){
        return list.isEmpty();
    }

    public void clear(){
        list.clear();
    }

    /**
     * 从队尾入队
     * @param element
     */
    public void enQueueRear(E element){
        list.add(element);
    }

    /**
     * 从队头出队
     */
    public E deQueueFront(){
        E front = list.get(0);
        list.remove(0 );
        return front;
    }


    /**
     * 从队头入队
     */
    public void enQueueFront(E element){
        list.add(0 , element);
    }

    /**
     * 从队尾出队
     */
    public E deQueueRear(){
        E rear = list.get(list.size() - 1);
        list.remove(list.size() - 1);
        return rear;
    }

    /**
     * 获取头元素
     */
    public E front(){
        return list.get(0);
    }

    /**
     * 获尾元素
     */
    public E rear(){
        return list.get(list.size() - 1);
    }
}
