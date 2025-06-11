package 数据结构;

/**
 * Created by lixin on 2020/7/19.
 */
public abstract class AbstractList<E> implements List<E>{

    public int size;

    public int size(){
        return size;
    }

    @Override
    public boolean isEmpty(){
        return size == 0;
    }

    @Override
    public void ensureCapacity(int capacity) {

    }

    @Override
    public boolean contains(E element) {
        return indexOf(element) != ELEMENTS_NOT_FOUND;
    }

    public void add(E elements){
        add(size , elements);
    }

    //protected 代表子类可以使用
    public void indexOutOfBounds(){
        throw new IndexOutOfBoundsException("角标越界...");
    }

    public void rangeCheck(int index){
        if (size < 0 || index >= size){
            indexOutOfBounds();
        }
    }

    public void rangeCheckAdd(int index){
        if (size < 0 || index > size){
            indexOutOfBounds();
        }
    }


}
