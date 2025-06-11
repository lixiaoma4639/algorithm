package 练习.leetcode.动态规划;

/**
 * 日期 : 2022/2/2.
 * 创建 : xin.li
 * 描述 :
 * 输入：nums = [1,3,5,4,7]
 * 输出：3
 * 解释：最长连续递增序列是 [1,3,5], 长度为3。
 * 尽管 [1,3,5,7] 也是升序的子序列, 但它不是连续的，因为 5 和 7 在原数组里被 4 隔开。
 *
 * 来源：力扣（LeetCode）
 * 链接：https://leetcode-cn.com/problems/longest-continuous-increasing-subsequence
 * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 */
class _674_最长连续递增序列 {
    public int findLengthOfLCIS(int[] nums) {
        int length = nums.length;
        //int[] dp = new int[length];
        //dp[0] = 1;
        int dp = 1;
        int max = 1;
        int pre = nums[0];
        for (int i = 1; i < length; i++) {
            if (nums[i] > pre){
                dp = dp + 1;
            } else {
                dp = 1;
            }
            max = Math.max(max, dp);
            pre = nums[i];
        }
        return max;
    }
}
