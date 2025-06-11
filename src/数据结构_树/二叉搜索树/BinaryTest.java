package 数据结构_树.二叉搜索树;

import java.util.Comparator;

import 数据结构_树.二叉搜索树.printer.BinaryTrees;

/**
 * 日期 : 2020/8/24.
 * 创建 : xin.li
 * 描述 :
 */
class BinaryTest {


    public static void main(String[] args) {
        SearchBinaryTree<Person> searchBinaryTree2 = new SearchBinaryTree<>((o1, o2) -> o2.getAge() - o1.getAge());
        Integer[] integers = new Integer[]{
                1,7,4,3,9,2,8,10,5,6,11
        };
        for (Integer integer : integers) {
            searchBinaryTree2.add(new Person(integer , "李鑫" + integer));
        }
        BinaryTrees.print(searchBinaryTree2);
        System.out.println();

        searchBinaryTree2.lastOrder(new SearchBinaryTree.Visitor<Person>() {
            @Override
            public boolean visit(Person element) {
                System.out.print(element.getAge() + " ");
                return false;
            }
        });
        System.out.println();
        searchBinaryTree2.lastOrderCircle(new SearchBinaryTree.Visitor<Person>() {
            @Override
            public boolean visit(Person element) {
                System.out.print(element.getAge() + " ");
                return false;
            }
        });

//        searchBinaryTree2.inOrder(new SearchBinaryTree.Visitor<Person>() {
//            @Override
//            public boolean visit(Person element) {
//                System.out.print(element.getAge() + " ");
//                return false;
//            }
//        });
//        System.out.println();
//        searchBinaryTree2.inOrderCircle(new SearchBinaryTree.Visitor<Person>() {
//            @Override
//            public boolean visit(Person element) {
//                System.out.print(element.getAge() + " ");
//                return false;
//            }
//        });

//        searchBinaryTree2.preOrder(new SearchBinaryTree.Visitor<Person>() {
//            @Override
//            public boolean visit(Person element) {
//                System.out.print(element.getAge() + " ");
//                return false;
//            }
//        });
//        System.out.println();
//        searchBinaryTree2.preOrderCircle(new SearchBinaryTree.Visitor<Person>() {
//            @Override
//            public boolean visit(Person element) {
//                System.out.print(element.getAge() + " ");
//                return false;
//            }
//        });


//        searchBinaryTree2.remove(new Person(7));
//
//        System.out.println("\n");
//        BinaryTrees.print(searchBinaryTree2);
//
//        System.out.println("\n");
//        System.out.println(searchBinaryTree2.contain(new Person(7)));

    }

    private void test6(){
        SearchBinaryTree<Person> searchBinaryTree2 = new SearchBinaryTree<>((o1, o2) -> o2.getAge() - o1.getAge());
        Integer[] integers = new Integer[]{
                7,4,3,9,2,8,10,5,6
        };
        for (Integer integer : integers) {
            searchBinaryTree2.add(new Person(integer , "李鑫" + integer));
        }
        BinaryTrees.print(searchBinaryTree2);

        searchBinaryTree2.inOrderTraversal();
    }


    private void test5(){
        SearchBinaryTree<Person> searchBinaryTree2 = new SearchBinaryTree<>((o1, o2) -> o2.getAge() - o1.getAge());
        Integer[] integers = new Integer[]{
                7,4,3,9,2,8,10,5
        };
        for (Integer integer : integers) {
            searchBinaryTree2.add(new Person(integer , "李鑫" + integer));
        }
        BinaryTrees.print(searchBinaryTree2);
        System.out.println("\n");
        System.out.println(searchBinaryTree2.isComplete());
    }

    private void test4(){
        SearchBinaryTree<Person> searchBinaryTree2 = new SearchBinaryTree<>((o1, o2) -> o2.getAge() - o1.getAge());
        Integer[] integers = new Integer[]{
                7,4,2,1,3,5,9,8,11,10,12
        };
        for (Integer integer : integers) {
            searchBinaryTree2.add(new Person((int)(Math.random() * 100) , "李鑫" + integer));
        }
        BinaryTrees.print(searchBinaryTree2);
        System.out.println("\n");

//        searchBinaryTree2.preOrderTraversal();
//        searchBinaryTree2.inOrderTraversal();
//        searchBinaryTree2.lastOrderTraversal();
//        searchBinaryTree2.levelOrderTraversal();

        searchBinaryTree2.levelOrder(new SearchBinaryTree.Visitor<Person>() {
            @Override
            public boolean visit(Person element) {
                System.out.print(" " + element + ", ");
                return false;
            }
        });
        System.out.println("\n");
        searchBinaryTree2.inOrder(new SearchBinaryTree.Visitor<Person>() {
            @Override
            public boolean visit(Person element) {
                System.out.print(" " + element + ", ");
                return element.getAge() == 5;
            }
        });
        System.out.println("\n");
        searchBinaryTree2.lastOrder(new SearchBinaryTree.Visitor<Person>() {
            @Override
            public boolean visit(Person element) {
                System.out.print(" " + element + ", ");
                return element.getAge() == 5;
            }
        });

        System.out.println("\n" + searchBinaryTree2.height());
    }

    private void test3(){
        SearchBinaryTree<Person> searchBinaryTree2 = new SearchBinaryTree<>((o1, o2) -> o2.getAge() - o1.getAge());
        Integer[] integers = new Integer[]{
                7,4,2,1,3,5,9,8,11,10,12
        };
        for (Integer integer : integers) {
            searchBinaryTree2.add(new Person(integer));
        }
        BinaryTrees.print(searchBinaryTree2);
    }

    private void test2(){
        SearchBinaryTree<Person> searchBinaryTree1 = new SearchBinaryTree<>();
        Integer[] integers = new Integer[]{
                7,4,2,1,3,5,9,8,11,10,12
        };
        for (Integer integer : integers) {
            searchBinaryTree1.add(new Person(integer));
        }
        BinaryTrees.print(searchBinaryTree1);
    }


    private void test1(){
        SearchBinaryTree<Integer> searchBinaryTree = new SearchBinaryTree<>();
        Integer[] integers = new Integer[]{
                7,4,2,1,3,5,9,8,11,10,12
        };
        for (Integer integer : integers) {
            searchBinaryTree.add(integer);
        }
        BinaryTrees.print(searchBinaryTree);
    }


    static class MyComparator1 implements Comparator<Person> {

        @Override
        public int compare(Person e1, Person e2) {
            return e1.getAge() - e2.getAge();
        }
    }

    static class MyComparator2 implements Comparator<Person>{

        @Override
        public int compare(Person e1, Person e2) {
            return e1.getAge() - e2.getAge();
        }
    }
}
