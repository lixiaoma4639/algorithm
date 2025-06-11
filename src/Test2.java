import 数据结构_树.二叉搜索树.SearchBinaryTree;

import java.net.URI;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.Queue;
import java.util.Stack;

public class Test2 {

    static class ParentA{
        protected void hello(){
            System.out.println("hello");
        }
    }

    static class ParentB extends ParentA{
        @Override
        protected void hello() {
            System.out.println("word");
        }
    }

    private static final int MODE_SHIFT = 30;
    private static final int MODE_MASK  = 0x3 << MODE_SHIFT;
    public static final int UNSPECIFIED = 0 << MODE_SHIFT;
    public static final int EXACTLY     = 1 << MODE_SHIFT;
    public static final int AT_MOST     = 2 << MODE_SHIFT;
    public static void main2(String[] args) {
        System.out.println(MODE_MASK);
        System.out.println(UNSPECIFIED);
        System.out.println(EXACTLY);
        System.out.println(AT_MOST);

        System.out.println(3/ 2);
    }

    public static void main(String[] args) {
//        Queue<Integer> queue = new LinkedList<>();
//        queue.add(1);
//        queue.add(2);
//        queue.add(3);
//        System.out.println(queue);
//        System.out.println(queue.peek());
//        System.out.println(0x41);
//        System.out.println(0x90);
//        System.out.println(0x91);
//        System.out.println(0x26);
//        System.out.println(0x01);

//        Stack<Integer> stack = new Stack<Integer>();
//        stack.add(10);
//        stack.add(20);
//        stack.add(30);
//        stack.add(40);
//        stack.add(50);
//
//        System.out.println("Stack: " + stack);
//        //遍历元素
//        Iterator<Integer> value = stack.iterator();
//        while (value.hasNext()) {
//            System.out.println(value.next());
//        }

        String url = "http://www.baidu.com?source=app&hotel=slg&source=app&source=app&orderId=111&source=app";
        url = "http://www.baidu.com?orderId=111&source=app&&&source=app&source=app&source=app&source=app";
//        String url = "http://www.baidu.com?source=app";
//        url = url.replaceAll("(source=app&)+|(source=app)+$", "");
//        url = url.replaceAll("source=app", "");
        url= url.replaceAll("(source=app&)+", "");
        url = url.replaceAll("(&source=app)+", "");
        url = url.replaceAll("source=app", "");
        System.out.println(url);
    }

}
