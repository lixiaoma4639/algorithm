package 练习.leetcode;

import java.util.Arrays;

/**
 * 日期 : 2021/7/9.
 * 创建 : xin.li
 * 描述 :
 *
 * 给定一个由 整数 组成的 非空 数组所表示的非负整数，在该数的基础上加一。
 *
 * 最高位数字存放在数组的首位， 数组中每个元素只存储单个数字。
 *
 * 你可以假设除了整数 0 之外，这个整数不会以零开头。
 *
 *  
 *
 * 示例 1：
 *
 * 输入：digits = [1,2,3]
 * 输出：[1,2,4]
 * 解释：输入数组表示数字 123。
 *
 *
 * 输入：digits = [9,9,9]
 * 输出：[1,0,0,0]
 * 解释：输入数组表示数字 999。
 *
 * 示例 2：
 * 输入：digits = [4,3,2,1]
 * 输出：[4,3,2,2]
 * 解释：输入数组表示数字 4321。
 *
 * 示例 3：
 * 输入：digits = [0]
 * 输出：[1]
 *
 * 提示：
 * 1 <= digits.length <= 100
 * 0 <= digits[i] <= 9
 *
 * 链接：https://leetcode-cn.com/problems/plus-one
 */
class _66_加一 {
    public static void main(String[] args) {
        int[] s = new int[]{9, 9, 9};
        s = new int[]{9, 9};
        System.out.print(Arrays.toString(plusOne(s)));
    }

    /**
     * 输入：digits = [9,9,9]
     * 输出：[1,0,0,0]
     * 解释：输入数组表示数字 999。
     */
    public static int[] plusOne(int[] digits) {
        int length = digits.length;
        for (int i = length - 1; i >= 0; i--) {
            int single = digits[i] + 1;
            if (single == 10){
                digits[i] = 0;
                //进一位
                if (i == 0){
                    int[] newDigits = new int[length + 1];
                    newDigits[0] = 1;
                    System.arraycopy(digits, 0, newDigits, 1, length);
                    return newDigits;
                }
            } else {
                digits[i] = single;
                break;
            }
        }
        return digits;
    }












}
