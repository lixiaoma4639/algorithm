package 数据结构.link;


import 数据结构.AbstractList;

/**
 * Created by lixin on 2020/7/19.
 * 链表虚拟头结点
 */
public class LinkedList3<E> extends AbstractList<E> {

    private Node<E> firstNode;

    public LinkedList3() {
        this.firstNode = new Node<>(null , null);
    }

    @Override
    public E get(int index) {
        return node(index).elements ;
    }

    @Override
    public E set(int index, E element) {
        Node<E> node = node(index);
        E old = node.elements;
        node.elements = element;
        return old;
    }

    @Override
    public void add(int index, E element) {
        rangeCheckAdd(index);

        Node<E> previousNode = index == 0 ? firstNode : node(index - 1);
        //在index的位置插入新的node节点对象
        previousNode.next = new Node<E>(element , previousNode.next);

        size++;
    }

    /**
     * 获取index 位置对应的node节点
     * @param index
     * @return
     */
    private Node<E> node(int index){
        rangeCheck(index);
        Node<E> node = firstNode.next;
        for (int i = 0; i < index; i++) {
            node = node.next;
        }
        return node;
    }

    @Override
    public void ensureCapacity(int capacity) {

    }

    @Override
    public void remove(int index) {
        rangeCheck(index);
        //获取index的上一个节点
        Node<E> previous = index == 0 ? firstNode : node(index - 1);
        //将上一个节点的next指向下一个节点的下一个节点
        previous.next = previous.next.next;
        size--;
    }

    @Override
    public void clear() {
        size = 0;
        firstNode = null;
        System.gc();
    }

    @Override
    public boolean contains(E element) {
        return false;
    }

    @Override
    public int indexOf(Object element) {
        if (element == null){
            Node<E> node = firstNode.next;
            for (int i = 0; i < size; i++) {
                if (node.elements == null) return i;
                node = node.next;
            }
        } else {
            Node<E> node = firstNode.next;
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
        protected void finalize() throws Throwable {
            super.finalize();
            System.out.println("LinkedList释放了...");
        }
    }

    @Override
    public String toString() {
        StringBuilder stringBuilder = new StringBuilder();
        stringBuilder.append("[");
//        for (int i = 0; i < size; i++) {
//            stringBuilder.append(node(i).elements).append(" ");
//        }
        Node<E> node = firstNode.next;
        while (node != null){
            stringBuilder.append(node.elements).append(" ");
            node = node.next;
        }
        stringBuilder.append("]");
        return stringBuilder.toString();
    }
}
