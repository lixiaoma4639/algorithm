package 练习.leetcode;

import java.util.Deque;
import java.util.HashMap;
import java.util.HashSet;
import java.util.LinkedList;
import java.util.Map;
import java.util.Queue;
import java.util.Set;

/**
 * 日期 : 2021/5/24.
 * 创建 : xin.li
 * 描述 :
 *
 * 给你一个整数 x ，如果 x 是一个回文整数，返回 true ；否则，返回 false 。
 * 回文数是指正序（从左向右）和倒序（从右向左）读都是一样的整数。例如，121 是回文，而 123 不是。
 *
 *  
 *
 * 示例 1：
 * 输入：x = 121
 * 输出：true
 *
 * 示例 2：
 * 输入：x = -121
 * 输出：false
 * 解释：从左向右读, 为 -121 。 从右向左读, 为 121- 。因此它不是一个回文数。
 *
 * 示例 3：
 * 输入：x = 10
 * 输出：false
 * 解释：从右向左读, 为 01 。因此它不是一个回文数。
 *
 * 示例 4：
 * 输入：x = -101
 * 输出：false
 *  
 *
 * 提示：
 *
 *
 * 链接：https://leetcode-cn.com/problems/palindrome-number
 */
class _9_回文数 {
    public static void main(String[] args) {
        System.out.println(isPalindrome(14741));
    }

    /**
     * 123321
     */
    public static boolean isPalindrome(int x) {
        // 特殊情况：
        if (x == 0) return true;
        if (x < 0 ||  x % 10 == 0) return false;

        int revertHalf = 0;
        // re = 123  123
        // x = 12   123
        while (x > revertHalf){
            revertHalf = revertHalf * 10 +  x % 10;
            x /= 10;
        }
        return revertHalf == x || revertHalf / 10 == x;
    }

    /**
     * 454
     * 123123
     */
    public static boolean isPalindrome2(int x) {
        if (x < 0) return false;
        Map<Integer , Integer> map = new HashMap<>();
        int flag = 0;
        while (x != 0){
            int i = x % 10;
            Integer exist = map.get(i);
            map.put(i , exist == null ? 1 :  exist + 1);
            x /= 10;
        }
        return false;
    }

    public static boolean isPalindrome4(int x) {
        // 特殊情况：
        // 如上所述，当 x < 0 时，x 不是回文数。
        // 同样地，如果数字的最后一位是 0，为了使该数字为回文，
        // 则其第一位数字也应该是 0
        // 只有 0 满足这一属性
        if (x < 0 || (x % 10 == 0 && x != 0)) {
            return false;
        }

        int revertedNumber = 0;
        while (x > revertedNumber) {
            revertedNumber = revertedNumber * 10 + x % 10;
            x /= 10;
        }

        // 当数字长度为奇数时，我们可以通过 revertedNumber/10 去除处于中位的数字。
        // 例如，当输入为 12321 时，在 while 循环的末尾我们可以得到 x = 12，revertedNumber = 123，
        // 由于处于中位的数字不影响回文（它总是与自己相等），所以我们可以简单地将其去除。
        return x == revertedNumber || x == revertedNumber / 10;
    }

    /**
     * 123
     */
    public static boolean isPalindrome3(int x) {
        if (x < 0) return false;
        if (x < 10) return true;
        Deque<Integer> deque = new LinkedList<>();
        while (x != 0){
            int i = x % 10;
            deque.offer(i);
            x /= 10;
        }
        while (!deque.isEmpty()){
            Integer first = deque.peekFirst();
            Integer last = deque.peekLast();
            if (!first.equals(last)){
                return false;
            }
            deque.pollFirst();
            deque.pollLast();
        }
        return true;
    }
}
