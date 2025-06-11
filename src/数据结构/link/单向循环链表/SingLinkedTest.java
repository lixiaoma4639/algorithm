package 数据结构.link.单向循环链表;

import 数据结构.List;

/**
 * Created by lixin on 2020/8/9.
 */
class SingLinkedTest {
    public static void main(String[] args) {
        List<String> mStringLists = new LinkedList4<>();
        mStringLists.add("0");
        mStringLists.add("1");
        mStringLists.add("2");
        mStringLists.add("3");
        mStringLists.add("4");
        mStringLists.add("5");
        mStringLists.add("6");

//        mStringLists.add(0 , "-1");

//        mStringLists.add(3, "2.5");

        mStringLists.add(mStringLists.size() , "7");

//        mStringLists.remove(mStringLists.size() - 1);


        System.out.println(mStringLists.indexOf("88"));
        System.out.println(mStringLists.contains("3"));
        System.out.println(mStringLists.get(3));
        System.out.println(mStringLists.get(4));


        System.out.println(mStringLists);
    }
}
