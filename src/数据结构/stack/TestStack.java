package 数据结构.stack;

/**
 * Created by lixin on 2020/8/9.
 */
class TestStack {

    public static void main(String[] args) {
        Stack<Integer> stack = new Stack<>();
        for (int i = 0; i < 5; i++) {
            stack.push(i);
        }


        stack.pop();
        System.out.println(stack);

        System.out.println(stack.top());

        while (!stack.isEmpty()){
            stack.pop();
        }

        System.out.println(stack.top());
        System.out.println(stack);

    }
}
