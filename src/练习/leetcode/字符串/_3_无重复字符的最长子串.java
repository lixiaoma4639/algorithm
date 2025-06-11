package 练习.leetcode.字符串;

import java.util.HashMap;
import java.util.Map;

/**
 * 日期 : 2022/1/30.
 * 创建 : xin.li
 * 描述 : https://leetcode-cn.com/problems/longest-substring-without-repeating-characters/
 *
 *    pi    li      i-1  i
 * a  f  c  a   e   c    f  b
 */
class _3_无重复字符的最长子串 {
    public static void main(String[] args) {
        String s = "abcabcbb";
        s = "afca   e   c    f  b";
        System.out.println(lengthOfLongestSubstring(s.replaceAll(" ", "")));
    }

    public static int lengthOfLongestSubstring(String s) {
        if (s.length() == 0) return 0;
        char[] words = s.toCharArray();
        Map<Character, Integer> piMap = new HashMap<>();
        piMap.put(words[0], 0);
        int li = 0;
        int max = 1;
        for (int i = 1; i < words.length; i++) {
            Integer pi = piMap.getOrDefault(words[i], -1);
            if (li <= pi){
                li = pi + 1;
            }
            max = Math.max(max, i - li + 1);
            piMap.put(words[i], i);
        }
        return max;
    }
}
