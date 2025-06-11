package 练习.leetcode.数组;

import 练习.PrintUtils;

/**
 * 日期 : 2021/12/4.
 * 创建 : xin.li
 * 描述 : https://leetcode-cn.com/problems/sub-sort-lcci/
 *
 */
class _16_16_部分排序 {

    public static void main(String[] args) {
        int[] nums = {1,2,4,7,10,11,7,12,6,7,16,18,19};
        subSort(nums);
        PrintUtils.printIntArray(nums);
    }

    public static int[] subSort(int[] array) {
        if (array.length == 0) return new int[]{-1, -1};
        int maxNum = array[0];
        int endIndex = -1;
        for (int i = 1; i < array.length; i++) {
            if (array[i] >= maxNum){
                //顺序正常
                maxNum = array[i];
            } else {
                //存在逆序
                endIndex = i;
            }
        }

        if (endIndex == -1) return new int[]{-1, -1};

        maxNum = array[array.length - 1];
        int startIndex = -1;
        for (int i = array.length - 2; i >= 0; i--) {
            if (array[i] <= maxNum){
                //顺序正常
                maxNum = array[i];
            } else {
                //存在逆序
                startIndex = i;
            }
        }
        return new int[]{startIndex, endIndex};
    }












}
