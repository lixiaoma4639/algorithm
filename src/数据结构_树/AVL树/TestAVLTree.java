package 数据结构_树.AVL树;

import 数据结构_树.二叉搜索树.printer.BinaryTrees;

/**
 * 日期 : 2020/9/6.
 * 创建 : xin.li
 * 描述 :
 */
class TestAVLTree {
    public static void main(String[] args) {
        AVLTree<Integer> avlTree = new AVLTree<>();
        Integer[] integers = new Integer[]{
                80, 19, 15, 48, 99, 94, 45, 86, 10, 37, 3, 12, 35, 42, 65
        };
        for (Integer integer : integers) {
            avlTree.add(integer);
        }
        BinaryTrees.print(avlTree);
        System.out.println();
        avlTree.preOrder(new BinaryTree.Visitor<Integer>() {
            @Override
            public boolean visit(Integer element) {
                System.out.print(element + " ");
                return false;
            }
        });

        System.out.println("\n");
//        avlTree.remove(3);
//        BinaryTrees.print(avlTree);
//
//        System.out.println("\n");
//        avlTree.remove(65);
//        BinaryTrees.print(avlTree);
//
//        System.out.println("\n");
//        avlTree.remove(48);
//        BinaryTrees.print(avlTree);
//
//        System.out.println("\n");
//        avlTree.add(1);
//        BinaryTrees.print(avlTree);
//
//        System.out.println("\n");
//        avlTree.remove(86);
//        BinaryTrees.print(avlTree);
    }
}
