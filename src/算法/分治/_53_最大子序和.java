package 算法.分治;

/**
 * 日期 : 2021/11/21.
 * 创建 : xin.li
 * 描述 :
 */
class _53_最大子序和 {
    public static void main(String[] args) {
        int[] aaa = {-2,1,-3,4,-1,2,1,-5,4};
        System.out.println(maxSubArray(aaa, 0, aaa.length));
        System.out.println(maxSubArray(aaa));
    }

    /**
     * 动态规划求解
     */
    public static int maxSubArray1(int[] nums) {
        if (nums == null || nums.length < 1) return -1;
        int dp = nums[0];
        int max = dp;
        for (int i = 1; i < nums.length; i++) {
            if (dp <= 0){
                dp = nums[i];
            } else {
                dp += nums[i];
            }
            max = Math.max(max, dp);
        }
        return max;
    }

    /**
     * 分治求最大子序列
     */
    public static int maxSubArray(int[] nums, int begin, int end) {
        if (end - begin < 2) return nums[begin];
        int middle = (end + begin) >> 1;
        int leftSum = nums[middle-1];
        int leftMax = leftSum;
        //扫描左半边
        for (int i = middle - 2; i >= begin; i--) {
            leftSum += nums[i];
            leftMax = Math.max(leftMax, leftSum);
        }

        int endSum = nums[middle];
        int endMax = endSum;
        //扫描右半边
        for (int i = middle + 1; i < end; i++) {
            endSum += nums[i];
            endMax = Math.max(endMax, endSum);
        }

        return Math.max(leftMax + endMax, Math.max(
                maxSubArray(nums, begin, middle),
                maxSubArray(nums, middle, end)
        ));
    }

    /**
     * 暴力求最大值
     */
    public static int maxSubArray(int[] nums) {
        int maxSub = Integer.MIN_VALUE;
        for (int i = 0; i < nums.length; i++) {
            int temp = nums[i];
            for (int j = i+1; j < nums.length; j++) {
                temp += nums[j];
                maxSub = Math.max(maxSub , temp);
            }
        }
        return maxSub;
    }
}
