package 斐波那契数列;

/**
 * Created by lixin on 2020/6/6.
 */
class MainTest {

    public static void main(String[] args) {
//        System.out.print(fib2(0) + " ");
//        System.out.print(fib2(1)+ " ");
//        System.out.print(fib2(2)+ " ");
//        System.out.print(fib2(3)+ " ");
//        System.out.print(fib2(4)+ " ");
//        System.out.print(fib2(5)+ " ");
//        System.out.print(fib2(6)+ " ");
//        System.out.print(fib2(7)+ " ");
//        System.out.print(fib2(8)+ " ");
//        System.out.print(fib2(9)+ " ");
//        System.out.print(fib2(10)+ " ");

        System.out.println(fib2(100000000));
    }

    /**
     * 斐波那契数列
     * 0 1 1 2 3 5 8 13 21 34 55 ...
     */
    private static int fib1(int index) {
        if (index <= 1) return index;
        //index 前一位 加上 前两位等于当前index的值
        return fib1(index - 1) + fib1(index - 2);
    }

    /**
     * 斐波那契数列
     * index 0 1 2 3 4 5 6 7
     * value 0 1 1 2 3 5 8 13 21 ...
     */
    private static int fib2(int index) {
        if (index <= 1) return index;
        int first = 0;
        int second = 1;
        int sum ;
        for (int i = 0; i < index - 1; i++) {
            sum = first + second;
            first = second;
            second = sum;
        }
        return second;
    }
}
