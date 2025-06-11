package 数据结构.link.双向循环链表;


import 数据结构.AbstractList;

/**
 * Created by lixin on 2020/7/19.
 * 双向循环链表
 */
public class LinkedList2Circle<E> extends AbstractList<E> {

    private Node<E> firstNode;
    private Node<E> lastNode;

    /**
     * 复杂度, 最好O(1) 最坏O(n) 平均(1+2+3+...+n) / n 因此复杂度还是O(n)
     */
    @Override
    public E get(int index) {
        return node(index).elements ;
    }

    /**
     * 复杂度, 最好O(1) 最坏O(n) 平均(1+2+3+...+n) / n 因此复杂度还是O(n)
     */
    @Override
    public E set(int index, E element) {
        Node<E> node = node(index);
        E old = node.elements;
        node.elements = element;
        return old;
    }

    /**
     * 复杂度, 最好O(1) 最坏O(n) 平均(1+2+3+...+n) / n 因此复杂度还是O(n)
     */
    @Override
    public void add(int index, E element) {
        rangeCheckAdd(index);

        if (index == size){ //向最后面的节点添加数据
            Node oldLast = lastNode;
            lastNode = new Node<E>(oldLast , element , firstNode);
            if (oldLast == null){ //相当于size == 0 , 添加第一个元素
                firstNode = lastNode;
                firstNode.next = firstNode;
                firstNode.prev = firstNode;
            } else {
                oldLast.next = lastNode;
                firstNode.prev = lastNode;
            }
        } else {
            Node<E> next = node(index);
            Node<E> prev = next.prev;
            Node<E> newNode = new Node<>(prev, element, next);
            next.prev = newNode;
            prev.next = newNode;

            if (next == firstNode){ //相当于index == 0
                //在index = 0 的位置添加
                firstNode = newNode;
            }
        }

        size++;
    }

    /**
     * 获取index 位置对应的node节点
     *
     * 复杂度, 最好O(1) 最坏O(n) 平均(1+2+3+...+n) / n 因此复杂度还是O(n)
     */
    private Node<E> node(int index){
        rangeCheck(index);

        if (index < (size / 2)) {
            Node<E> node = firstNode;
            for (int i = 0; i < index; i++) {
                node = node.next;
            }
            return node;
        } else {
            Node<E> node = lastNode;
            for (int i = size - 1; i > index; i--) {
                node = node.prev;
            }
            return node;
        }
    }

    @Override
    public void ensureCapacity(int capacity) {

    }

    /**
     * 复杂度, 最好O(1) 最坏O(n) 平均(1+2+3+...+n) / n 因此复杂度还是O(n)
     */
    @Override
    public void remove(int index) {
        rangeCheck(index);

        if (size == 1){
            firstNode = null;
            lastNode = null;
        } else {
            Node<E> node = node(index);
            Node<E> next = node.next;
            Node<E> prev = node.prev;
            prev.next = next;
            next.prev = prev;
            if (node == firstNode){  //index == 0 的情况
                firstNode = next;
            }
            if (node == lastNode){ //index = size - 1 的情况
                lastNode = prev;
            }
        }
        size--;
    }

    @Override
    public void clear() {
        size = 0;
        firstNode = null;
        lastNode = null;
        System.gc();
    }


    @Override
    public int indexOf(Object element) {
        if (element == null){
            Node<E> node = firstNode;
            for (int i = 0; i < size; i++) {
                if (node.elements == null) return i;
                node = node.next;
            }
        } else {
            Node<E> node = firstNode;
            for (int i = 0; i < size; i++) {
                if (element.equals(node.elements)) return i;
                node = node.next;
            }
        }
        return ELEMENTS_NOT_FOUND;
    }


    private static class Node<E>{
        E elements;
        Node<E> next;
        Node<E> prev;

        public Node(Node<E> prev , E elements, Node<E> next) {
            this.prev = prev;
            this.elements = elements;
            this.next = next;
        }

        @Override
        public String toString() {
            StringBuilder stringBuilder = new StringBuilder();

            stringBuilder.append(prev == null ? "null" : prev.elements);
            stringBuilder.append("_").append(elements).append("_");
            stringBuilder.append(next == null ? "null" : next.elements);

            return stringBuilder.toString();
        }

        @Override
        protected void finalize() throws Throwable {
            super.finalize();
            System.out.println("LinkedList释放了...");
        }
    }

    @Override
    public String toString() {
        StringBuilder stringBuilder = new StringBuilder();
        stringBuilder.append("[");
        Node<E> node = firstNode;
        for (int i = 0; i < size; i++) {
            stringBuilder.append(node).append(" , ");
            node = node.next;
        }
        stringBuilder.append("]");
        return stringBuilder.toString();
    }
}
