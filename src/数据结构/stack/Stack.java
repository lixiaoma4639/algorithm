package 数据结构.stack;

import 数据结构.List;
import 数据结构.link.LinkedList;
import 数据结构.stack.list.ArrayList1;

/**
 * Created by lixin on 2020/8/9.
 *
 * 使用链表或者数组都可以实现栈功能
 * class Stack<E> extends ArrayList1<E> {
 * class Stack<E> extends LinkedList<E> {
 */
public class Stack<E>{

    private List<E> mEList = new ArrayList1<>();

    public int size(){
        return mEList.size();
    }

    public boolean isEmpty(){
        return mEList.isEmpty();
    }

    public void push(E element){
        mEList.add(element);
    }

    public void pop(){
        mEList.remove( size() - 1);
    }

    public E top(){
        if (size() == 0){
            return null;
        }
        return mEList.get(size() - 1);
    }


    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append("[");
        for (int i = 0; i < size(); i++) {
            sb.append(mEList.get(i)).append(" , ");
        }
        sb.append("]");
        return sb.toString();
    }
}
