package 练习.leetcode;

import java.util.LinkedList;
import java.util.Queue;

import javax.management.Query;

/**
 * 日期 : 2021/5/24.
 * 创建 : xin.li
 * 描述 : https://leetcode-cn.com/problems/reverse-integer/
 *
 * 给你一个 32 位的有符号整数 x ，返回将 x 中的数字部分反转后的结果。
 *
 * 如果反转后整数超过 32 位的有符号整数的范围 [−231,  231 − 1] ，就返回 0。
 *
 * 假设环境不允许存储 64 位整数（有符号或无符号）。
 *  
 *
 * 示例 1：
 *
 * 输入：x = 123
 * 输出：321
 * 示例 2：
 *
 * 输入：x = -123
 * 输出：-321
 * 示例 3：
 *
 * 输入：x = 120
 * 输出：21
 * 示例 4：
 *
 * 输入：x = 0
 * 输出：0
 *  
 *
 * 提示：
 *
 * -231 <= x <= 231 - 1
 *
 */
class _7_整数反转 {

    public static void main(String[] args) {
        System.out.println(reverse(1463847412));
        System.out.println(Integer.MAX_VALUE);
        System.out.println(Integer.MIN_VALUE);
    }

    /**
     * 输入：x = 123
     * 输出：321
     *
     * 输入：x = -1234
     * 输出：-4321
     *
     * int最大值 2147483647
     *          -2147483648
     *          -2147483412
     * 这个方法是假设可以输入 比int最大值大的数
     */
    public static int reverse(int x) {
        int result = 0;
        while (x != 0){
            int temp = x % 10;
            if (result > 214748364 || (result == 214748364 && temp > 7)){
                return 0;
            }
            if (result < -214748364 || (result == -214748364 && temp < -8)){
                return 0;
            }
            result = result * 10 + temp;//4321
            x /= 10;
        }
        return result;
    }

    /**
     * 这个方法是不可以输入 比int最大值大的数
     */
    public static int reverse2(int x) {
        int rev = 0;
        while (x != 0) {
            if (rev < Integer.MIN_VALUE / 10 || rev > Integer.MAX_VALUE / 10) {
                return 0;
            }
            int digit = x % 10;
            x /= 10;
            rev = rev * 10 + digit;
        }
        return rev;
    }





}
