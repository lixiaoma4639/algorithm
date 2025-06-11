package 数据结构.link.单向循环链表;


import 数据结构.AbstractList;

/**
 * Created by lixin on 2020/7/19.
 * 链表
 */
public class LinkedList4<E> extends AbstractList<E> {

    private Node<E> firstNode;

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
        if (index == 0){
            Node<E> newFirst = new Node<E>(element , firstNode);

            Node<E> last = (size == 0) ? newFirst : node(size - 1);
            last.next = newFirst;
            firstNode = newFirst;
        } else {
            Node<E> previousNode = node(index - 1);
            //在index的位置插入新的node节点对象
            previousNode.next = new Node<E>(element , previousNode.next);
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
        Node<E> node = firstNode;
        for (int i = 0; i < index; i++) {
            node = node.next;
        }
        return node;
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
        if (index == 0){
            if (size == 1){
                firstNode = null;
            } else {
                Node<E> last = node(size - 1);
                firstNode = firstNode.next;
                last.next = firstNode;
            }
        } else {
            //获取index的上一个节点
            Node<E> previous = node(index - 1);
            //将上一个节点的next指向下一个节点的下一个节点
            previous.next = previous.next.next;
        }
        size--;
    }

    @Override
    public void clear() {
        size = 0;
        firstNode = null;
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

        public Node(E elements, Node<E> next) {
            this.elements = elements;
            this.next = next;
        }

        @Override
        public String toString() {
            StringBuilder stringBuilder = new StringBuilder();
            stringBuilder.append(elements).append("_");
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
        for (int i = 0; i < size; i++) {
            stringBuilder.append(node(i)).append(" | ");
        }
        stringBuilder.append("]");
        return stringBuilder.toString();
    }
}
