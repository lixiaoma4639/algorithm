package 数据结构_树.二叉搜索树重构;

import 数据结构_树.二叉搜索树.printer.BinaryTrees;

/**
 * 日期 : 2020/9/5.
 * 创建 : xin.li
 * 描述 :
 */
class BSTTest {

    public static void main(String[] args) {
        BST<Integer> searchBinaryTree2 = new BST<Integer>();
        Integer[] integers = new Integer[]{
                7,4,3,9,2,8,10,5,6
        };
        for (Integer integer : integers) {
            searchBinaryTree2.add(integer);
        }
        BinaryTrees.print(searchBinaryTree2);

        searchBinaryTree2.remove(7);

        System.out.println("\n");
        BinaryTrees.print(searchBinaryTree2);

        System.out.println("\n");
        System.out.println(searchBinaryTree2.contain(8));
    }
}
