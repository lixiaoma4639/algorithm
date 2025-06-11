package 练习.leetcode;

/**
 * 日期 : 2021/5/29.
 * 创建 : xin.li
 * 描述 :
 * 链接：https://leetcode-cn.com/problems/implement-strstr
 *
 *
 * 输入：haystack = "hello", needle = "llo"
 * 输出：2
 *
 * 输入：haystack = "aaaaa", needle = "abb"
 * 输出：-1
 *
 * 输入：haystack = "", needle = ""
 * 输出：0
 */
class _28_实现strStr {
    /**
     * "mississippi"
     * "issip"
     */
    public static void main(String[] args) {
        int i = strStr("mississippi", "issip");
        System.out.println(i);

    }


    public static int strStr(String haystack, String needle) {
        if (needle == null || haystack == null) return -1;
        int needleLength = needle.length();
        if (needleLength == 0) return 0;
        int stackLength = haystack.length();
        if (haystack.length() == 0) return -1;

        for (int i = 0; i + needleLength <= stackLength; i++) {
            boolean has = true;
            for (int j = 0; j < needleLength; j++) {
                if (haystack.charAt(i+j) != needle.charAt(j)){
                    has = false;
                    break;
                }
            }
            if (has){
                return i;
            }
        }
        return -1;
    }

    public static int strStr3(String haystack, String needle) {
        if (needle == null || haystack == null) return -1;
        int needleLength = needle.length();
        if (needleLength == 0) return 0;
        int stackLength = haystack.length();
        if (haystack.length() == 0) return -1;

        int index = 0;
        while (index + needleLength <= stackLength) {
            if (haystack.substring(index , index + needleLength).equals(needle))
                return index;
            index++;
        }
        return -1;

    }

    public static int strStr2(String haystack, String needle) {
        if (needle == null || haystack == null) return -1;

        int needleLength = needle.length();
        if (needleLength == 0) return 0;
        int stackLength = haystack.length();
        if (haystack.length() == 0) return -1;

        int index = 0;
        for (int i = 0; i < stackLength; i++) {
            char c = haystack.charAt(i);
            if (c == needle.charAt(index)){
                index++;
                if (index == needleLength){
                    return i - (needleLength - 1);
                }
            } else {
                index = 0;
                if (c == needle.charAt(index)){
                    index++;
                }
            }
        }
        return -1;

    }

    /**
     * "mississippi"
     * "issip"
     */
    static class Solution {
        public int strStr(String haystack, String needle) {
            int n = haystack.length(), m = needle.length();
            for (int i = 0; i + m <= n; i++) {
                boolean flag = true;
                for (int j = 0; j < m; j++) {
                    if (haystack.charAt(i + j) != needle.charAt(j)) {
                        flag = false;
                        break;
                    }
                }
                if (flag) {
                    return i;
                }
            }
            return -1;
        }
    }
}
