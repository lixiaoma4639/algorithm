package 练习.leetcode.树;

import 练习.leetcode.TreeNode;

/**
 * 日期 : 2021/12/26.
 * 创建 : xin.li
 * 描述 : https://leetcode-cn.com/problems/maximum-binary-tree/
 *
 * 输入：nums = [3,2,1,6,0,5]
 * 输出：[6,3,5,null,2,0,null,null,1]
 */
class _654_最大二叉树 {

    public TreeNode constructMaximumBinaryTree(int[] nums) {
        return maxBinaryRecursion(nums, 0 , nums.length);
    }

    public TreeNode maxBinaryRecursion(int[] nums, int start, int end) {
        if (start == end) return null;
        int maxIndex = start;
        for (int i = start; i < end; i++) {
            if (nums[i] > nums[maxIndex]) maxIndex = i;
        }
        TreeNode treeNode = new TreeNode(nums[maxIndex]);
        treeNode.left = maxBinaryRecursion(nums, start, maxIndex);
        treeNode.right = maxBinaryRecursion(nums, maxIndex + 1, end);
        return treeNode;
    }
}
