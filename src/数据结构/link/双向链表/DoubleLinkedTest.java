package 数据结构.link.双向链表;

import 数据结构.List;

/**
 * Created by lixin on 2020/8/8.
 */
class DoubleLinkedTest {

    private static List<String> mStringLists = new LinkedList2<>();

    public static void main(String[] args) {
        mStringLists.add("0");
        mStringLists.add("1");
        mStringLists.add("2");
        mStringLists.add("3");
        mStringLists.add("4");
        mStringLists.add("5");
        mStringLists.add("6");
        test(mStringLists);
        
    }

    private static void test(List<String> lists){

//        lists.add(lists.size() , "6");

//        lists.remove(2);
//        lists.remove(2);
//        lists.remove(lists.size() - 1);
        lists.clear();
        System.out.println(lists);
    }
}
