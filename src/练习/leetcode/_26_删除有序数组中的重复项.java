package 练习.leetcode;

/**
 * 日期 : 2021/5/26.
 * 创建 : xin.li
 * 描述 :
 * 给你一个有序数组 nums ，请你 原地 删除重复出现的元素，使每个元素 只出现一次 ，返回删除后数组的新长度。
 *
 * 不要使用额外的数组空间，你必须在 原地 修改输入数组 并在使用 O(1) 额外空间的条件下完成。
 *
 *  
 *
 * 说明:
 *
 * 为什么返回数值是整数，但输出的答案是数组呢?
 *
 * 请注意，输入数组是以「引用」方式传递的，这意味着在函数里修改输入数组对于调用者是可见的。
 *
 * 链接：https://leetcode-cn.com/problems/remove-duplicates-from-sorted-array
 */
class _26_删除有序数组中的重复项 {

    public static void main(String[] args) {
        int[] nums = {0,0,1,1,1,2,2,3,3,4};
        int i = removeDuplicates(nums);
        System.out.println(i);
        for (int j = 0; j < i; j++) {
            System.out.print(nums[j] + " -> ");
        }
    }

    /**
     *
     * 输入：nums = [1,1,2]
     * 输出：2, nums = [1,2]
     * 解释：函数应该返回新的长度 2 ，并且原数组 nums 的前两个元素被修改为 1, 2 。不需要考虑数组中超出新长度后面的元素。
     *
     * 输入：nums = [0,0,1,1,1,2,2,3,3,4]
     * 输出：5, nums = [0,1,2,3,4]
     * 解释：函数应该返回新的长度 5 ， 并且原数组 nums 的前五个元素被修改为 0, 1, 2, 3, 4 。不需要考虑数组中超出新长度后面的元素。
     */
    public static int removeDuplicates2(int[] nums) {
        if (nums == null || nums.length == 0) return 0;
        int length = nums.length;
        int temp = nums[0];
        int index = 1;
        for (int i = 1; i < length; i++) {
            int currency = nums[i];
            if (temp != currency){
                temp = (nums[index] = currency);
                index++;
            }
        }
        return index;
    }


    public static int removeDuplicates(int[] nums) {
        //[0,0,1,1,1,2,2,3,3,4]
        if (nums == null || nums.length == 0) return 0;
        int length = nums.length;
        int index = 0;
        for (int i = 1; i < length; i++) {
            int currency = nums[i];
            if (nums[index] != currency){
                nums[++index] = currency;
            }
        }
        return index + 1;
    }







}
