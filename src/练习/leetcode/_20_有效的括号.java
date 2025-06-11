package 练习.leetcode;

import java.util.Deque;
import java.util.HashMap;
import java.util.LinkedList;
import java.util.Map;
import java.util.Queue;
import java.util.Stack;

/**
 * 日期 : 2021/5/25.
 * 创建 : xin.li
 * 描述 :
 *
 * 有效字符串需满足：
 *
 * 左括号必须用相同类型的右括号闭合。
 * 左括号必须以正确的顺序闭合。
 *  
 *
 * 示例 1：
 * 输入：s = "()"
 * 输出：true
 *
 * 示例 2：
 * 输入：s = "()[]{}"
 * 输出：true
 *
 * 示例 3：
 * 输入：s = "(]"
 * 输出：false
 *
 * 示例 4：
 * 输入：s = "([)]"
 * 输出：false
 *
 * 示例 5：
 * 输入：s = "{()([])[]}"
 * 输出：true
 *
 * 链接：https://leetcode-cn.com/problems/valid-parentheses
 */
class _20_有效的括号 {

    public static void main(String[] args) {
        System.out.println(isValid("([)]"));
    }

    /**
     * {}()([])[]}
     * {()([()])[]}
     *
     *
     */
    public static boolean isValid(String s) {
        int length = s.length();
        if (length % 2 == 1) return false;
        Map<Character , Character> map = new HashMap<>();
        map.put(']' , '[');
        map.put(')' , '(');
        map.put('}' , '{');
        Deque<Character> stack = new LinkedList<>();
        for (int i = 0; i < length; i++) {
            char c = s.charAt(i);
            if (map.containsKey(c) && map.get(c) == stack.peekFirst()){
                stack.poll();
            } else {
                stack.offerFirst(c);
            }
        }
        return stack.isEmpty();
    }












}
