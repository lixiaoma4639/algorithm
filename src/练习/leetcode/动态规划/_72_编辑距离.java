package 练习.leetcode.动态规划;

/**
 * 日期 : 2022/1/31.
 * 创建 : xin.li
 * 描述 :
 *
 * 来源：力扣（LeetCode）
 * 链接：https://leetcode-cn.com/problems/edit-distance
 * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 *
 * 输入：word1 = "intention", word2 = "execution"
 * 输出：5
 * 解释：
 * intention -> inention (删除 't')
 * inention -> enention (将 'i' 替换为 'e')
 * enention -> exention (将 'n' 替换为 'x')
 * exention -> exection (将 'n' 替换为 'c')
 * exection -> execution (插入 'u')
 *
 * 0 <= word1.length, word2.length <= 500
 * word1 和 word2 由小写英文字母组成
 */
class _72_编辑距离 {

    public int minDistance(String word1, String word2) {
        char[] chars1 = word1.toCharArray();
        char[] chars2 = word2.toCharArray();
        int row = chars1.length + 1;
        int col = chars2.length + 1;
        int[][] dp = new int[row][col];
        dp[0][0] = 0;

        for (int i = 1; i < row; i++) {
            dp[i][0] = i;
        }
        for (int i = 1; i < col; i++) {
            dp[0][i] = i;
        }
        for (int i = 1; i < row; i++) {
            for (int j = 1; j < col; j++) {
                int top = dp[i][j - 1] + 1;
                int left = dp[i - 1][j] + 1;
                int replace = dp[i - 1][j - 1];
                if (chars1[i - 1] != chars2[j - 1]){
                    replace = dp[i - 1][j - 1] + 1;
                }
                dp[i][j] = Math.min(Math.min(top, left), replace);
            }
        }
        return dp[row-1][col-1];
    }
}






















