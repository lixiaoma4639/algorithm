package 练习.leetcode.数组;

/**
 * 日期 : 2021/12/4.
 * 创建 : xin.li
 * 描述 :
 * https://leetcode-cn.com/problems/merge-sorted-array/
 */
class _88_合并两个有序数组 {
    public static void main(String[] args) {
        int[] num1 = {1,2,3,0,0,0};
        int[] num2 = {2,5,6};
        merge(num1, 3, num2 , 3);
        for (int aaa: num1 ) {
            System.out.print(aaa + " ");
        }
    }

    public static void merge(int[] nums1, int m, int[] nums2, int n) {
        if (nums2 == null || nums2.length == 0) return;
        int index1 = m - 1;
        int index2 = n - 1;
        int current = nums1.length - 1;
        while (index2 >= 0){
            if (index1 >= 0 && nums1[index1] >= nums2[index2]){
                nums1[current--] = nums1[index1--];
            } else {
                nums1[current--] = nums2[index2--];
            }
        }
    }

}
