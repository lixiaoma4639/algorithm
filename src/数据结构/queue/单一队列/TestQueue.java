package 数据结构.queue.单一队列;

/**
 * 时间 : 2020/8/13
 * 创建 : xin.li
 * 描述 :
 */
public class TestQueue {

    public static void main(String[] args) {

        Queue<Integer> queue = new Queue<>();
        queue.enQueue(1);
        queue.enQueue(2);
        queue.enQueue(3);
        queue.enQueue(4);
        queue.enQueue(5);

        System.out.println(queue.front());
        System.out.println(queue.deQueue());
        queue.enQueue(6);

        while (!queue.isEmpty()){
            System.out.print(queue.deQueue());
        }

    }
}
