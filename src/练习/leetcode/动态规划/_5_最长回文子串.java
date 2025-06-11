package 练习.leetcode.动态规划;

/**
 * 日期 : 2022/1/8.
 * 创建 : xin.li
 * 描述 :https://leetcode-cn.com/problems/longest-palindromic-substring/
 *
 * 输入：s = "babad"
 * 输出："bab"
 * 解释："aba" 同样是符合题意的答案。
 *
 * 输入：s = "cbbd"
 * 输出："bb"
 *
 *
 */
class _5_最长回文子串 {
    public static void main(String[] args) {
        System.out.println(longestPalindrome2("babad"));
        System.out.println(longestPalindrome("babad"));
    }

    public static String longestPalindrome(String s) {
        char[] chars = s.toCharArray();
        boolean[] dp = new boolean[chars.length];
        int maxLength = 1;
        int begin = 0;
        boolean oldDp = false;
        for (int i = chars.length - 1; i >= 0; i--) {
            for (int j = i; j < chars.length; j++) {
                boolean temp = dp[j];
                int currentLength = j - i + 1;
                if (currentLength <= 2){
                    dp[j] = chars[i] == chars[j];
                } else {
                    dp[j] = chars[i] == chars[j] && oldDp;
                }
                oldDp = temp;
                if (dp[j] && currentLength > maxLength){
                    maxLength = currentLength;
                    begin = i;
                }
            }
        }
        return s.substring(begin, begin + maxLength);
    }

    public static String longestPalindrome2(String s) {
        char[] chars = s.toCharArray();
        boolean[][] dp = new boolean[chars.length][chars.length];
        int maxLength = 1;
        int begin = 0;
        for (int i = chars.length - 1; i >= 0; i--) {
            for (int j = i; j < chars.length; j++) {
                int currentLength = j - i + 1;
                if (currentLength <= 2){
                    dp[i][j] = chars[i] == chars[j];
                } else {
                    dp[i][j] = chars[i] == chars[j] && dp[i + 1][j - 1];
                }
                if (dp[i][j] && currentLength > maxLength){
                    maxLength = currentLength;
                    begin = i;
                }
            }
        }
        return s.substring(begin, begin + maxLength);
    }
}
