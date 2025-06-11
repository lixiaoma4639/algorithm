package 数据结构.stack.list;


import 数据结构.AbstractList;

/**
 * Created by lixin on 2020/6/24.
 *
 * 负责度O(n)  n指的是数据规模
 */
public class ArrayList1<E> extends AbstractList<E> {

    protected E[] elements;
    private static final int DEFAULT_CAPACITY = 10;

    public ArrayList1(int initialCapacity) {
        initialCapacity = Math.max(initialCapacity, DEFAULT_CAPACITY);
        this.elements = (E[]) new Object[initialCapacity];
    }

    public ArrayList1() {
        this(DEFAULT_CAPACITY);
    }

    public E get(int index){
        if (size < 0 || index >= size){
            throw new IndexOutOfBoundsException("角标越界...");
        }
        return elements[index];//复杂度O(1)
    }

    /**
     * 替换某个位置元素
     * @param index
     * @param element
     * @return
     */
    public E set(int index , E element){
        if (size < 0 || index >= size){
            throw new IndexOutOfBoundsException("角标越界...");
        }
        E old = elements[index];
        elements[index] = element;//复杂度O(1)
        return old;
    }

    public void add(E element){
        add(size , element);
    }

    /**
     * 复杂度, 最好O(1) 最坏O(n) 平均(1+2+3+...+n) / n 因此复杂度还是O(n)
     */
    public void add(int index  , E element){
        if (size < 0 || index > size){
            throw new IndexOutOfBoundsException("角标越界...");
        }

        ensureCapacity(index + 1);

        for (int i = size ; i > index; i--) {
            elements[i] = elements[i - 1];
        }
        elements[index] = element;
        size++;
    }

    /**
     * 数组动态扩容
     * @param capacity 保证至少需要多大容器
     *
     *
     * 复杂度, 最好O(1) 最坏O(n) ,绝大多数场景都是O(1) 平均(1+1+1+...+n) / n, 因此复杂度还是O(1)
     */
    @Override
    public void ensureCapacity(int capacity){
        //容器大小够使用
        int oldCapacity = elements.length;
        if (oldCapacity >= capacity) return;

        //容器不够使用,在原有的容器大小基础上扩容0.5倍
        int newCapacity = oldCapacity + (oldCapacity >> 1);
        E[] newElements = (E[]) new Object[newCapacity];
        for (int i = 0; i < elements.length; i++) {
            newElements[i] = elements[i];
        }
        this.elements = newElements;
        System.out.println("扩容由 " + oldCapacity + " 扩大到: " + newCapacity);
    }

    public int size(){
        return size;
    }

    /**
     * 复杂度, 最好O(1) 最坏O(n) 平均(1+2+3+...+n) / n 因此复杂度还是O(n)
     */
    public void remove(int index) {
        if (size < 0 || index >= size){
            throw new IndexOutOfBoundsException("角标越界...");
        }
        for (int i = index + 1; i < size; i++) {
            elements[i - 1] = elements[i];
        }
        //释放元素内存
        elements[--size] = null;

        trim();
    }

    /**
     * 数组缩容
     */
    private void trim() {
        int capacity = elements.length;
        //缩小两倍
        int newCapacity = capacity >> 1;
        if (size >= (newCapacity) || capacity <= DEFAULT_CAPACITY) return;

        //元素不到数组空间的一半, 进行缩容
        E[] newElements = (E[]) new Object[newCapacity];
        for (int i = 0; i < size; i++) {
            newElements[i] = elements[i];
        }
        this.elements = newElements;
        System.out.println("缩容由 " + capacity + " 缩小到: " + newCapacity);
    }

    public void clear(){
        for (int i = 0; i < size; i++) {
            elements[i] = null;
        }
        size = 0;
    }

    public boolean contains(E element){
//        if (size <= 0) return false;
//        for (int i = 0; i < size; i++) {
//            if (elements[i] == element) return true;
//        }
//        return false;
        return indexOf(element) != -1;
    }

    public int indexOf(Object element) {
        if (element == null){
            for (int i = 0; i < size; i++) {
                if (elements[i] == null) return i;
            }
        } else {
            for (int i = 0; i < size; i++) {
                if (element.equals(elements[i])) return i;
            }
        }
        return -1;
    }

    @Override
    public String toString() {
        StringBuilder stringBuilder = new StringBuilder();
        stringBuilder.append("[");
        for (int i = 0; i < size; i++) {
            stringBuilder.append(elements[i]).append(" ");
        }
        stringBuilder.append("]");
        return stringBuilder.toString();
    }
}
