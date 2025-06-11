package 数据结构.queue.单一循环队列;

/**
 * 日期 : 2020/8/15.
 * 创建 : xin.li
 * 描述 :
 */
class CircleQueueTest {
    public static void main(String[] args) {
        CircleQueue<Integer> circleQueue = new CircleQueue<>();
        for (int i = 0; i < 10; i++) {
            circleQueue.enQueue(i);
        }
        System.out.println("circleQueue = " + circleQueue);

        for (int i = 0; i < 5; i++) {
            System.out.print(circleQueue.deQueue());
        }

        System.out.println("\ncircleQueue = " + circleQueue);

        for (int i = 15; i < 23; i++) {
            circleQueue.enQueue(i);
        }

        System.out.println("circleQueue = " + circleQueue);

        circleQueue.clear();
        System.out.println("circleQueue = " + circleQueue);

//        while (!circleQueue.isEmpty()){
//            System.out.print(circleQueue.deQueue() + " ");
//        }
    }
}
