package java基础;

/**
 * Created by lixin on 2020/8/15.
 */
class NumberLearn {
    public static void main(String[] args) {

        int a = 0b00000000000000000000000000000111;
        /**
         *
         * -7原码 = 0b10000000000000000000000000000111;
         * -7反码 = 0b11111111111111111111111111111000;
         * -7的补码 = 0b11111111111111111111111111111001;
         * 计算机操作的是补码
         */
        int b = 0b11111111111111111111111111111001;
        System.out.println("a = " + a);
        System.out.println("b = " + b);

        System.out.println("------------------------------------");

        //java中没有2进制表示方法,可以使用其他进制转换为2进制
        int i1 = 0b110;
        //16进制以0x/0X表示
        int i2 = 0x2f;
        //8进制以0开头表示
        int i3 = 0177;
//        System.out.println("i1 = " + i1);
//        System.out.println("i2 = " + Integer.toBinaryString(i2));
//        System.out.println("i3 = " + Integer.toBinaryString(i3));


//        int i4 = ~5;
//        System.out.println("i4 = " + i4);
//        System.out.println("------------------------------------");

        //i = 10 ,  j = 20 交换两个元素变量
        int i = 10;
        int j = 20;
        //第二种解法 使用异或 , 一个元素异或两次还是这个元素本身
        i = i ^ j; // 10 ^ 20
        j = i ^ j; // 10 ^ 20 ^ 20 = 10
        i = i ^ j; // 10 ^ 20 ^ 10 = 20
        System.out.println("i = " + i);
        System.out.println("j = " + j);

        //第一中常规方式
//        int c = i;
//        i = j;
//        j = c;
//        System.out.println("i = " + i);
//        System.out.println("j = " + j);

    }
}
