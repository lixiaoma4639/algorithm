package 算法.动态规划;

/**
 * 日期 : 2021/11/28.
 * 创建 : xin.li
 * 描述 :
 *
 * 输入：text1 = "abcde", text2 = "ace"
 * 输出：3
 * 解释：最长公共子序列是 "ace" ，它的长度为 3 。
 */
class _1143_最长公共子序列 {

    public static void main(String[] args) {
        System.out.println(longestCommonSubsequence("abcde", "ace"));
    }

    public static int longestCommonSubsequence(String text1, String text2) {
        char[] chars1 = text1.toCharArray();
        char[] chars2 = text2.toCharArray();
        int[] dp = new int[chars2.length + 1];
        for (int i = 1; i <= chars1.length; i++) {
            int current = 0;
            for (int j = 1; j <= chars2.length; j++) {
                int leftTop = current;
                current = dp[j];
                if (chars1[i - 1] == chars2[j - 1]){
                    dp[j] = leftTop + 1;
                } else {
                    dp[j] = Math.max(dp[j], dp[j - 1]);
                }
            }
        }
        return dp[chars2.length];
    }

    public static int longestCommonSubsequence2(String text1, String text2) {
        char[] chars1 = text1.toCharArray();
        char[] chars2 = text2.toCharArray();

        int[][] dp = new int[chars1.length + 1][chars2.length + 1];
        for (int i = 1; i <= chars1.length; i++) {
            for (int j = 1; j <= chars2.length; j++) {
                if (chars1[i - 1] == chars2[j - 1]){
                    dp[i][j] = dp[i- 1][j - 1] + 1;
                } else {
                    dp[i][j] = Math.max(dp[i - 1][j], dp[i][j - 1]);
                }
            }
        }
        return dp[chars1.length][chars2.length];
    }
}
