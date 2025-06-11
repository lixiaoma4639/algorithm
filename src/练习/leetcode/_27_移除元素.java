package 练习.leetcode;

/**
 * 日期 : 2021/5/27.
 * 创建 : xin.li
 * 描述 : https://leetcode-cn.com/problems/remove-element/
 */
class _27_移除元素 {
    public static void main(String[] args) {
        int[] ints = {0, 1, 2, 2, 3, 0, 4, 2};
        int length = removeElement(ints, 2);
        System.out.println(length);
        for (int j = 0; j < length; j++) {
            System.out.print(ints[j] + " -> ");
        }
    }

    /**
     * 输入：nums = [0,1,2,2,3,0,4,2], val = 2
     * 输出：5, nums = [0,1,4,0,3]
     * 解释：函数应该返回新的长度 5, 并且 nums 中的前五个元素为 0, 1, 3, 0, 4。注意这五个元素可为任意顺序。你不需要考虑数组中超出新长度后面的元素。
     */
    public static int removeElement2(int[] nums, int val) {
        if (nums == null || nums.length == 0) return 0;
        int index = 0;
        for (int i = 0; i < nums.length; i++) {
            int num = nums[i];
            if (num != val){
                nums[index] = num;
                index++;
            }
        }
        return index;
    }

    /**
     * 输入：nums = [0,1,2,2,3,0,4,2], val = 2
     * 输出：5, nums = [0,1,4,0,3]
     * 解释：函数应该返回新的长度 5, 并且 nums 中的前五个元素为 0, 1, 3, 0, 4。注意这五个元素可为任意顺序。你不需要考虑数组中超出新长度后面的元素。
     */
    public static int removeElement(int[] nums, int val) {
        if (nums == null || nums.length == 0) return 0;
        int fast = 0;
        int slow = 0;
        while (fast < nums.length){
            if (nums[fast] != val){
                nums[slow] = nums[fast];
                slow++;
            }
            fast++;
        }
        return slow;
    }
}
