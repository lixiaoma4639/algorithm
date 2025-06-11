package 数据结构.queue.双向循环队列;

/**
 * 日期 : 2020/8/15.
 * 创建 : xin.li
 * 描述 : 单一循环队列
 */
class CircleDeque<E> {

    /**
     * 队列的第一个元素
     */
    private int font;

    private int size;

    private E[] elements;

    private static final int DEFAULT_CAPACITY = 10;

    public CircleDeque() {
        elements = (E[]) new Object[DEFAULT_CAPACITY];
    }


    public int size(){
        return size;
    }

    public boolean isEmpty(){
        return size == 0;
    }

    public void clear(){
        for (int i = 0; i < size; i++) {
            elements[trueIndex(i)] = null;
        }
        font = 0;
        size = 0;
    }

    /**
     * 动态扩容
     * @param capacity
     */
    public void ensureCapacity(int capacity){
        //容器大小够使用
        int oldCapacity = elements.length;
        if (oldCapacity >= capacity) return;

        //容器不够使用,在原有的容器大小基础上扩容0.5倍
        int newCapacity = oldCapacity + (oldCapacity >> 1);
        E[] newElements = (E[]) new Object[newCapacity];

        // [null , null , null , null , null , 5 , 6 , 7 , 8 , 9]
        // font = 5 ,
        for (int i = 0; i < size; i++) {
            //扩容后需要将font 置为0 , 从新移动元素到数组最前端
            newElements[i] = elements[ trueIndex(i)];
        }
        this.elements = newElements;
        System.out.println("扩容由 " + oldCapacity + " 扩大到: " + newCapacity);

        //重置font
        font = 0;
    }

    /**
     * 将队列中的显示索引转换为数组的真实索引
     * 获取元素的真实索引index
     */
    private int trueIndex(int index){
        index += font;
        if (index  < 0){
            //如果index < 0, 那么这时的循环队列对应的index就应该循环到数组的另一端
            return (index + elements.length) % elements.length;
        }
//        return (index)  % elements.length;
        return index - (index >= elements.length ? elements.length : 0);
    }

    /**
     * 从末尾入队
     */
    public void enQueueRear(E element){
        ensureCapacity(size + 1);
        elements[trueIndex(size)] = element;
        size++;
    }

    /**
     * 从队头出队
     */
    public E deQueueFont(){
        E fontElement = elements[font];
        elements[font] = null;
        //出队一个元素以后font向后移动一位
        font = trueIndex(1);
        size--;
        return fontElement;
    }

    /**
     * 从队头入队
     */
    public void enQueueFont(E element){
        ensureCapacity(size + 1);
        font = trueIndex(-1);
        elements[font] = element;
        size++;
    }

    /**
     * 从队尾出队
     */
    public E deQueueRear(){
        int rearIndex = trueIndex(size - 1);
        E deElement = elements[rearIndex];
        elements[rearIndex] = null;
        size--;
        return deElement;
    }


    public E font(){
        return elements[font];
    }

    public E Rear(){
        return elements[trueIndex(size - 1)];
    }













    @Override
    public String toString() {
        StringBuilder stringBuilder = new StringBuilder();
        stringBuilder.append("[");
        int length = elements.length;
        for (int i = 0; i < length; i++) {
            stringBuilder.append(elements[i] == null ? "null" : elements[i]);
            if (i < length -1) stringBuilder.append(" , ");
        }
        stringBuilder.append("]");
        stringBuilder.append(" font角标 = ").append(font);
        return stringBuilder.toString();
    }
}
