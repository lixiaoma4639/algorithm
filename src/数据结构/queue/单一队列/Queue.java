package 数据结构.queue.单一队列;

import 数据结构.List;
import 数据结构.link.双向链表.LinkedList2;

/**
 * 时间 : 2020/8/13
 * 创建 : xin.li
 * 描述 : 队列
 */
public class Queue<E> {
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
     * 入队
     * @param element
     */
    public void enQueue(E element){
        list.add(element);
    }

    /**
     * 出队
     */
    public E deQueue(){
        E front = front();
        list.remove(0);
        return front;
    }

    /**
     * 获取头元素
     */
    public E front(){
        return list.get(0);
    }

}
