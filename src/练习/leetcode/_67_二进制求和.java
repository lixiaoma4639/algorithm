package 练习.leetcode;

import java.util.Arrays;

/**
 * 日期 : 2021/7/9.
 * 创建 : xin.li
 * 描述 :
 * 链接：https://leetcode-cn.com/problems/add-binary
 * 给你两个二进制字符串，返回它们的和（用二进制表示）。
 *
 * 输入为 非空 字符串且只包含数字 1 和 0。
 *
 *  
 *
 * 示例 1:
 *
 * 输入: a = "11", b = "1"
 * 输出: "100"
 * 示例 2:
 *
 * 输入: a = "1010", b = "1011"
 * 输出: "10101"
 *  
 *
 * 提示：
 *
 * 每个字符串仅由字符 '0' 或 '1' 组成。
 * 1 <= a.length, b.length <= 10^4
 * 字符串如果不是 "0" ，就都不含前导零。
 *
 */
class _67_二进制求和 {

    /**
     * 输入: a = "11", b = "1"
     * 输出: "100"
     *
     * "1010"
     * "1011"
     *
     *
     */
    public static String addBinary2(String a, String b) {
        char[] aChars = a.toCharArray();
        char[] bChars = b.toCharArray();
        char[] bigChars;
        char[] smallChars;
        if (aChars.length >= bChars.length){
            bigChars = aChars;
            smallChars = bChars;
        } else {
            bigChars = bChars;
            smallChars = aChars;
        }

        int smallIndex = smallChars.length - 1;
        int bigLength = bigChars.length;
        boolean isAdd = false;
        for (int i = bigLength - 1; i >= 0; i--) {
            int sum = toInt(bigChars[i]) + (
                    smallIndex < 0 ? 0 : toInt(smallChars[smallIndex--])
            ) + (isAdd ? 1 : 0);
            if (sum == 0){
                isAdd = false;
                bigChars[i] = '0';
            } else if (sum == 1){
                isAdd = false;
                bigChars[i] = '1';
            } else if (sum == 2){
                isAdd = true;
                bigChars[i] = '0';
                //进1
                if (i == 0){
                    char[] newChars = new char[bigLength + 1];
                    newChars[0] = '1';
                    System.arraycopy(bigChars, 0, newChars, 1, bigLength);
                    return String.valueOf(newChars);
                }
            } else {
                isAdd = true;
                bigChars[i] = '1';
                //进1
                if (i == 0){
                    char[] newChars = new char[bigLength + 1];
                    newChars[0] = '1';
                    System.arraycopy(bigChars, 0, newChars, 1, bigLength);
                    return String.valueOf(newChars);
                }
            }
        }
        return String.valueOf(bigChars);
    }

    private static int toInt(char c){
        return c - '0';
    }

    public static void main(String[] args) {
        System.out.println(addBinary("11" , "1"));
//        System.out.println(addBinary("110" , "1"));
        System.out.println(addBinary("1011" , "1011"));
        System.out.print(1 + '0');
        System.out.println();

        new StringBuilder().reverse();

        int[] sss = new int[]{1, 2, 3};
        for (int i = 0; i < sss.length; i++) {
            System.out.print(sss[i] + " ");
        }
    }

    public static String addBinary(String a, String b) {
        StringBuilder sb = new StringBuilder();

        int aLength = a.length();
        int bLength = b.length();
        int maxLength = Math.max(aLength , bLength);
        int next = 0;
        for (int i = 0; i < maxLength; i++) {
            next += i < aLength ? (a.charAt(aLength - 1 - i) - '0'): 0;
            next += i < bLength ? (b.charAt(bLength - 1 - i) - '0'): 0;
            sb.append((char) (next % 2 + '0'));
            next = next/2;
        }

        if (next > 0) sb.append('1');
        sb.reverse();

        return sb.toString();
    }















}
