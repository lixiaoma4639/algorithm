package 算法.动态规划;

/**
 * 日期 : 2021/11/21.
 * 创建 : xin.li
 * 描述 :
 */
class CoinChange {
    public static void main(String[] args) {
        System.out.println(coins4(41));
    }


    /**
     * 暴力获取最优解
     */
//    private static int coins1(int n) {//n = 41
//        if (n < 1) return Integer.MAX_VALUE;
//        if (n == 1 || n == 5 || n==20 || n ==25) return 1;
//        int min1 = Math.min(coins1(n - 1), coins1(n - 5));
//        int min2 = Math.min(coins1(n - 20), coins1(n - 25));
//        return Math.min(min1, min2) + 1;
//    }

    /**
     * 暴力解优化
     * 记忆化搜索
     */
    private static int coins2(int n) {//n = 41
        if (n < 1) return -1;
        int[] dp = new int[n + 1];
        int[] faces = {1, 5 , 20 ,25};
        for (int face: faces) {
            if (n < face) break;
            dp[face] = 1;
        }
        return coins2(n , dp);
    }
    private static int coins2(int n, int[] dp) {
        if (n < 1) return Integer.MAX_VALUE;
        if (dp[n] == 0){
            int min2 = Math.min(coins2(n - 20, dp), coins2(n - 25, dp));
            int min1 = Math.min(coins2(n - 1, dp), coins2(n - 5, dp));
            return Math.min(min1, min2) + 1;
        }
        return dp[n];
    }

    /**
     * 由底部向上递推
     */
    private static int coins3(int n) {
        if (n < 1) return -1;
        int[] dp = new int[n + 1];
        for (int i = 1; i <= n; i++) {
            int min = Integer.MAX_VALUE;
            if (i >= 1) min = Math.min(dp[i - 1], min);
            if (i >= 5) min = Math.min(dp[i - 5], min);
            if (i >= 20) min = Math.min(dp[i - 20], min);
            if (i >= 25) min = Math.min(dp[i - 25], min);
            dp[i] = min + 1;
        }
        return dp[n];
    }

    /**
     * 由底部向上递推
     */
    private static int coins4(int n) {
        if (n < 1) return -1;
        int[] dp = new int[n + 1];
        int[] faces = new int[dp.length];
        for (int i = 1; i <= n; i++) {
            int min = Integer.MAX_VALUE;
            if (i >= 1 && dp[i - 1] < min) {
                min = dp[i - 1];
                faces[i] = 1;
            }
            if (i >= 5 && dp[i - 5] < min) {
                min = dp[i - 5];
                faces[i] = 5;
            }
            if (i >= 20 && dp[i - 20] < min) {
                min = dp[i - 20];
                faces[i] = 20;
            }
            if (i >= 25 && dp[i - 25] < min) {
                min = dp[i - 25];
                faces[i] = 25;
            }
            dp[i] = min + 1;
        }
        printFaces(n, faces);
        return dp[n];
    }
    private static void printFaces(int n , int[] faces){
        while (n >= 1){
            System.out.println(faces[n]);
            n -= faces[n];
        }
    }
}
