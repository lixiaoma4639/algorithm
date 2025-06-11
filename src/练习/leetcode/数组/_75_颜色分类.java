package 练习.leetcode.数组;

import 练习.PrintUtils;

/**
 * 日期 : 2021/12/4.
 * 创建 : xin.li
 * 描述 :
 */
class _75_颜色分类 {
    public static void main(String[] args) {
        int[] nums = {0, 1 , 2, 2, 0 , 1, 2};
        sortColors(nums);
        PrintUtils.printIntArray(nums);
    }

    public static void sortColors(int[] nums) {
        int start = 0;
        int end = nums.length - 1;
        int scan = 0;

        while (scan <= end){
            if (nums[scan] == 0){
                //扫描到0和start进行交换, start和scan都加1
                swap(nums, scan++, start++);
            } else if (nums[scan] == 1){
                //扫描到1, scan跳过
                scan++;
            } else {
                //扫描到2和end进行交换, end减1, scan不动
                swap(nums, scan, end--);
            }
        }

    }
    private static void swap(int[] nums, int a, int b){
        int temp = nums[a];
        nums[a] = nums[b];
        nums[b] = temp;
    }
}
