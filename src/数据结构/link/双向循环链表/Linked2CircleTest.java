package 数据结构.link.双向循环链表;

import 数据结构.List;

/**
 * Created by lixin on 2020/8/9.
 */
class Linked2CircleTest {

    public static void main(String[] args) {
        List<String> stringLists = new LinkedList2Circle<>();
        stringLists.add("0");
        stringLists.add("1");
        stringLists.add("2");
        stringLists.add("3");
        stringLists.add("4");
        stringLists.add("5");

//        stringLists.add(stringLists.size() , "6");

//        stringLists.remove(stringLists.size() - 1);

        System.out.println(stringLists.indexOf("4"));
        System.out.println(stringLists.indexOf("88"));
        System.out.println(stringLists.contains("3"));
        System.out.println(stringLists.get(3));
        System.out.println(stringLists.get(4));

        System.out.println(stringLists);
    }
}
