package 算法.动态规划;

/**
 * 日期 : 2021/11/28.
 * 创建 : xin.li
 * 描述 :
 */
class 最长公共子集 {
    public static void main(String[] args) {
        System.out.println(maxChildStr("BEBCDF", "ABCBCD"));
    }

    public static int maxChildStr(String str1, String str2){
        char[] chars1 = str1.toCharArray();
        char[] chars2 = str2.toCharArray();
        int[][] dp = new int[chars1.length + 1][chars2.length + 1];
        int max = 0;
        for (int i = 1; i <= chars1.length; i++) {
            for (int j = 1; j <= chars2.length; j++) {
                if (chars1[i - 1] == chars2[j - 1]){
                    dp[i][j] = dp[i - 1][j - 1] + 1;
                }
                max = Math.max(max, dp[i][j]);
            }
        }
        return max;
    }
}
