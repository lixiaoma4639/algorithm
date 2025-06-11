package 练习.leetcode.队列;

import java.util.Deque;
import java.util.LinkedList;

/**
 * 日期 : 2021/12/25.
 * 创建 : xin.li
 * 描述 :
 *
 * 输入：nums = [1,3,-1,-3,5,3,6,7], k = 3
 * 输出：[3,3,5,5,6,7]
 * 解释：
 * 滑动窗口的位置                最大值
 * ---------------               -----
 * [1  3  -1] -3  5  3  6  7       3
 *  1 [3  -1  -3] 5  3  6  7       3
 *  1  3 [-1  -3  5] 3  6  7       5
 *  1  3  -1 [-3  5  3] 6  7       5
 *  1  3  -1  -3 [5  3  6] 7       6
 *  1  3  -1  -3  5 [3  6  7]      7
 *
 * 来源：力扣（LeetCode）
 * 链接：https://leetcode-cn.com/problems/sliding-window-maximum
 * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 */
class _239_滑动窗口最大值 {

    /**
     * 结题思想
     * 使用双端队列存放当前窗口范围的值, 从头到尾, 值由大到小, 最后取first值就是当前窗口的最大值
     */
    public int[] maxSlidingWindow(int[] nums, int k) {
        if (nums.length == 1) return nums;
        int[] maxWindow = new int[nums.length - (k - 1)];
        Deque<Integer> deque = new LinkedList<>();
        for (int i = 0; i < nums.length; i++) {
            int kIndex = i - (k - 1);
            while (!deque.isEmpty() && nums[i] > nums[deque.getLast()]){
                deque.removeLast();
            }
            deque.addLast(i);

            if (deque.getFirst() < kIndex){
                deque.removeFirst();
            }
            if (kIndex >= 0){
                maxWindow[kIndex] = nums[deque.getFirst()];
            }
        }
        return maxWindow;
    }
}
