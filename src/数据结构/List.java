package 数据结构;

/**
 * Created by lixin on 2020/7/19.
 */
public interface List<E>{

    public static final int ELEMENTS_NOT_FOUND = -1;

    public E get(int index);

    /**
     * 替换某个位置元素
     * @param index
     * @param element
     * @return
     */
    public E set(int index , E element);

    public void add(E element);

    public void add(int index  , E element);

    /**
     * 数组动态扩容
     * @param capacity 保证至少需要多大容器
     */
    void ensureCapacity(int capacity);

    public boolean isEmpty();

    public int size();

    public void remove(int index) ;

    public void clear();

    public boolean contains(E element);

    public int indexOf(Object element);
}
