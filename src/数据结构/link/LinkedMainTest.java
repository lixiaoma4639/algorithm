package 数据结构.link;

import 数据结构.List;

/**
 * Created by lixin on 2020/7/19.
 */
class LinkedMainTest {
    public static void main(String[] args) {
        List<Integer> lists = new LinkedList<>();
        lists.add(5);
        lists.add(10);
        lists.add(30);
        lists.add(29);
        lists.add(77);
        System.out.println(lists.toString());
        lists.remove(3);
        System.out.println(lists.indexOf(30));
    }
}
