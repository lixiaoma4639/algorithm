package 练习.leetcode;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;
import java.util.PriorityQueue;
import java.util.stream.Collectors;

/**
 * 日期 : 2021/5/31.
 * 创建 : xin.li
 * 描述 :
 *
 * 给定一个排序数组和一个目标值，在数组中找到目标值，并返回其索引。
 * 如果目标值不存在于数组中，返回它将会被按顺序插入的位置。
 * 你可以假设数组中无重复元素。
 *
 * 输入: [1,3,5,6], 5
 * 输出: 2
 *
 * 输入: [1,3,5,6], 2
 * 输出: 1
 *
 * 输入: [1,3,5,6], 7
 * 输出: 4
 *
 * 输入: [1,3,5,6], 0
 * 输出: 0
 *
 * 链接：https://leetcode-cn.com/problems/search-insert-position
 */
class _35_搜索插入位置 {
    public int searchInsert(int[] nums, int target) {
        int length = nums.length;
        for (int i = 0; i < nums.length; i++) {
            int nowNum = nums[i];
            if (target == nowNum){
                return i;
            } else if (target < nowNum){
                return i;
            }
        }
        return length;
    }













}
