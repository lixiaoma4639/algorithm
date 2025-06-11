package 数据结构_树.红黑树;

import java.util.HashMap;
import java.util.Map;
import java.util.TreeMap;

import 数据结构_树.二叉搜索树.printer.BinaryTrees;

/**
 * 日期 : 2021/3/6.
 * 创建 : xin.li
 * 描述 :
 */
class RBTest {
    public static void main(String[] args) {
        Integer[] integers = new Integer[]{
                55,87,56,74,96,22,62,20,70,68,90,50
        };
        RBTree<Integer> rbTree = new RBTree<>();
        for (Integer integer : integers) {
            rbTree.add(integer);
        }

        BinaryTrees.print(rbTree);

        for (Integer integer : integers) {
            rbTree.remove(integer);
            System.out.println();
            System.out.println("--------------------");
            System.out.println("[" + integer + "]");
            BinaryTrees.print(rbTree);
        }

    }

}
