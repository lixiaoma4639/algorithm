package 数据结构.queue.双向循环队列;

/**
 * 日期 : 2020/8/16.
 * 创建 : xin.li
 * 描述 :
 */
class TestCircleDeque {
    public static void main(String[] args) {
        CircleDeque<Integer> circleDeque = new CircleDeque<>();
        //5 4 3 2 1 100 101 102 103 104
        for (int i = 0; i < 10; i++) {
            circleDeque.enQueueFont(i + 1);
            circleDeque.enQueueRear(i + 100);
        }
        System.out.println(circleDeque);
        //[null , 7 , 6 , 5 , 4 , 3 , 2 , 1 , 100 , 101 , 102 , 103 , 104 , 105 , 106 , null , null , null , null , null , null , null]
        for (int i = 0; i < 3; i++) {
            circleDeque.deQueueFont();
            circleDeque.deQueueRear();
        }
        System.out.println(circleDeque);

        circleDeque.enQueueRear(1000);
        circleDeque.enQueueFont(0);

        System.out.println(circleDeque);

        circleDeque.clear();
        System.out.println(circleDeque);


//        while (!circleDeque.isEmpty()){
//            System.out.println(circleDeque.deQueueFont());
//        }
    }
}
