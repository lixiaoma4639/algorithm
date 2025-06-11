package 算法.动态规划;

/**
 * 日期 : 2021/11/28.
 * 创建 : xin.li
 * 描述 :
 */
class _300_最长递增子序列 {

    public static void main(String[] args) {
        int[] aaa = {10,9,2,5,3,7,7,101,18, 19};
        int[] bbb = {0,1,0,3,2,3};
        System.out.println(lengthOfLIS(bbb));
    }

    public static int lengthOfLIS(int[] nums) {
        int[] dp = new int[nums.length];
        int max = dp[0] = 1;
        for (int i = 1; i < nums.length; i++) {
            dp[i] = 1;
            for (int j = 0; j < i; j++) {
                if (nums[j] >= nums[i]) continue;
                //可以连续拼接
                dp[i] = Math.max(dp[j] + 1, dp[i]);
            }
            max = Math.max(max, dp[i]);
        }
        return max;
    }
}
