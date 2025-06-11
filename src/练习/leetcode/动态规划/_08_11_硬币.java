package 练习.leetcode.动态规划;

/**
 * 日期 : 2022/2/2.
 * 创建 : xin.li
 * 描述 :
 * 来源：力扣（LeetCode）
 * 链接：https://leetcode-cn.com/problems/coin-lcci
 * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 *
 * 硬币。给定数量不限的硬币，币值为25分、10分、5分和1分，编写代码计算n分有几种表示法。
 *  输入: n = 10
 *  输出：4
 *  解释: 有四种方式可以凑成总金额:
 * 10=10
 * 10=5+5
 * 10=5+1+1+1+1+1
 * 10=1+1+1+1+1+1+1+1+1+1
 *
 */
class _08_11_硬币 {


    public static void main(String[] args) {
        _08_11_硬币 a = new _08_11_硬币();
        //System.out.println(Integer.MAX_VALUE);
        System.out.println(a.waysToChange(10));;
        System.out.println(a.minNum(11));;
    }

    static final int MOD = 1000000007;
    int[] coins = {25, 10, 5, 1};
    public int waysToChange(int n) {
        int MOD = 1000000007;
        int[] dp = new int[n + 1];
        dp[0] = 1;
        for (int i = 25; i <= n; i++) {
            dp[i] = (dp[i] + dp[i - 25]) % MOD;
        }
        for (int i = 10; i <= n; i++) {
            dp[i] =  (dp[i] + dp[i - 10]) % MOD;
        }
        for (int i = 5; i <= n; i++) {
            dp[i] =  (dp[i] + dp[i - 5]) % MOD;
        }
        for (int i = 1; i <= n; i++) {
            dp[i] =  (dp[i] + dp[i - 1]) % MOD;
        }
        return dp[n];
    }

    private int maxWay(int n){
        if (n < 0) return Integer.MIN_VALUE;
        if (n == 25) return 1;
        if (n == 10) return 4;
        if (n == 5) return 2;
        if (n == 1) return 1;
        int max1 = Math.max(maxWay(n - 25), maxWay(n-10));
        int max2 = Math.max(maxWay(n - 5), maxWay(n-1));
        return Math.max(max1, max2);
    }

    private int minNum(int n){
        int[] dp = new int[n + 1];
        for (int i = 1; i <= n; i++) {
            int min = dp[i - 1] + 1;
            if (i >= 5) min = Math.min(dp[i - 5] + 1, min);
            if (i >= 10) min = Math.min(dp[i - 10] + 1, min);
            if (i >= 25) min = Math.min(dp[i - 25] + 1, min);
            dp[i] = min;
        }
        return dp[n];
    }
}














