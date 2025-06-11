package 练习.leetcode;

/**
 * 日期 : 2021/5/31.
 * 创建 : xin.li
 * 描述 :
 * 给定一个整数数组 nums ，找到一个具有最大和的连续子数组（子数组最少包含一个元素），返回其最大和。
 *
 * 输入：nums = [-2,1,-3,4,-1,2,1,-5,4]
 * 输出：6
 * 解释：连续子数组 [4,-1,2,1] 的和最大，为 6 。
 *
 * 输入：nums = [1]
 * 输出：1
 *
 * 输入：nums = [0]
 * 输出：0
 *
 * 输入：nums = [-1]
 * 输出：-1
 *
 * 输入：nums = [-100000]
 * 输出：-100000
 *
 * 链接：https://leetcode-cn.com/problems/maximum-subarray
 *
 *
 *
 */
class _53_最大子序和 {
    public static void main(String[] args) {
        int sss = maxSubArray(new int[]{-1,-3,-2 , -10});
        System.out.println(sss);
    }

    public static int maxSubArray(int[] nums) {
        int pre = 0, maxNumber = nums[0];
        for (int x : nums) {
            pre = Math.max(pre , pre + x);//0 1 1
            maxNumber = Math.max(pre , x + maxNumber); // 0 1
        }
        return maxNumber;
    }

    /**
     *  输入：nums = [-2,1,-3,4,-1,2,1,-5,4]
     *  输出：6
     *  解释：连续子数组 [4,-1,2,1] 的和最大，为 6 。
     *
     * 输入：nums = [1]
     * 输出：1
     * 输入：nums = [0]
     * 输出：0
     * 输入：nums = [-1]
     * 输出：-1
     *
     * [-1,0,-2]
     */
    public static int maxSubArray2(int[] nums) {
        int length = nums.length;
        int max = nums[0];
        for (int i = 0; i < length; i++) {
            int temp = nums[i];
            for (int j = i + 1; j < length; j++) {
                temp += nums[j];
                max = Math.max(max , temp);
            }
            max = Math.max(max , nums[i]);
        }
        return max;
    }
}
