package 数据结构_树.二叉树;

/**
 * 日期 : 2020/8/23.
 * 创建 : xin.li
 * 描述 :
 */
class CompleteBinaryTest {
    public static void main(String[] args) {
        int n = 768;
        int power = 0;
        while (n >= 2){
            n = n >> 1;
            power++;
        }
        System.out.println(power);
    }
}
