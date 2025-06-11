package 算法.动态规划;

/**
 * 日期 : 2021/12/4.
 * 创建 : xin.li
 * 描述 :
 */
class 背包问题 {
    public static void main(String[] args) {
        int[] values = {6, 3, 5, 4, 6 };
        int[] weights = {2, 2, 6, 5, 4 };
        int mayWights = 10;
        System.out.println(getMaxValue(weights, values, mayWights));
        System.out.println(getMaxValue2(weights, values, mayWights));
        System.out.println(getMaxValue3(weights, values, mayWights));
    }

    /**
     * index 0
     * wight 6
     * value 2
     */
    private static int getMaxValue(int[] weights, int[] values, int mayWights) {
        //dp[i][j] i代表第几个元素, j代表最多还可以放的重量
        int[][] dp = new int[values.length + 1][mayWights + 1];
        for (int i = 1; i <= values.length; i++) {
            int weight = weights[i - 1];
            for (int j = 1; j <= mayWights; j++) {
                if (j < weight){
                    dp[i][j] = dp[i - 1][j];
                } else {
                    dp[i][j] = Math.max(dp[i - 1][j- weight] + values[i -1], dp[i - 1][j]);
                }
            }
        }
        return dp[weights.length][mayWights];
    }

    /**
     * 优化
     */
    private static int getMaxValue2(int[] weights, int[] values, int capacity) {
        //dp[i][j] = 最大价值
        int[] dp = new int[capacity + 1];
        for (int i = 1; i <= values.length; i++) {
            int weight = weights[i - 1];
            for (int j = capacity; j >= 1; j--) {
                if (j < weight) continue;
                dp[j] = Math.max(dp[j- weight] + values[i -1], dp[j]);
            }
        }
        return dp[capacity];
    }

    /**
     * 优化
     */
    private static int getMaxValue3(int[] weights, int[] values, int capacity) {
        //dp[i][j] = 最大价值
        int[] dp = new int[capacity + 1];
        for (int i = 1; i <= values.length; i++) {
            int weight = weights[i - 1];
            for (int j = capacity; j >= weight; j--) {
                dp[j] = Math.max(dp[j- weight] + values[i -1], dp[j]);
            }
        }
        return dp[capacity];
    }
}
