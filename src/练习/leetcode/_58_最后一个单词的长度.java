package 练习.leetcode;

/**
 * 日期 : 2021/7/9.
 * 创建 : xin.li
 * 描述 :
 *
 * 给你一个字符串 s，由若干单词组成，单词之间用空格隔开。返回字符串中最后一个单词的长度。如果不存在最后一个单词，请返回 0 。
 *
 * 单词 是指仅由字母组成、不包含任何空格字符的最大子字符串。
 *
 *  
 *
 * 示例 1：
 * 输入：s = "Hello World"
 * 输出：5
 *
 * 示例 2：
 * 输入：s = " "
 * 输出：0
 *  
 *
 * 提示：
 *
 * 1 <= s.length <= 104
 * s 仅有英文字母和空格 ' ' 组成
 *
 * 链接：https://leetcode-cn.com/problems/length-of-last-word
 */
class _58_最后一个单词的长度 {

    public static void main(String[] args) {

    }

    public static int lengthOfLastWord(String s) {
        if (s == null) return 0;
        String[] words = s.split(" ");
        if (words.length == 0) return 0;


        return 1;
    }

    public int lengthOfLastWord2(String s) {
        int end = s.length() - 1;
        while(end >= 0 && s.charAt(end) == ' ') end--;
        if(end < 0) return 0;
        int start = end;
        while(start >= 0 && s.charAt(start) != ' ') start--;
        return end - start;
    }

}









