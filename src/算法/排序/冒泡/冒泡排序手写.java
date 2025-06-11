package 算法.排序.冒泡;

import java.util.Arrays;

public class 冒泡排序手写 {
    public static void main(String[] args) {
        int[] array = {0, 10, 8, 4 , 7, 3, 5, 6, 9, 2,1};
//        bubSort(array);
        bubSort3(array);
        System.out.println(Arrays.toString(array));
    }

    /**
     * 冒泡排序的关键是最大值放在数组最右侧
     * 10, 17, 13, 4, 9, 15, 11, 12, 18, 3
     */
    private static void bubSort3(int[] sorts){
        for (int i = sorts.length - 1; i > 0 ; i--) {
            for (int j = 1; j <= i; j++) {
                int prev = sorts[j - 1];
                if (prev > sorts[j]) {
                    sorts[j - 1] = sorts[j];
                    sorts[j] = prev;
                }
            }
        }
    }

    /**
     * 冒泡排序的关键是最大值放在数组最右侧
     * 10, 17, 13, 4, 9, 15, 11, 12, 18, 3
     * 10  13 17，
     */
    private static void bubSort2(int[] sorts){
        for (int i = sorts.length - 1; i > 0; i--) {
//            int lastIndex = 1;
            for (int j = 1; j <= i; j++) {
                int pre = sorts[j - 1];
                int current = sorts[j];
                if (pre > current) {
                    sorts[j - 1] = current;
                    sorts[j] = pre;
//                    lastIndex = j;
                }
            }
//            i = lastIndex;
        }
    }

    /**
     * 选择排序
     * 优点：最多只做n次替换， 比冒泡排序替换次数少了很多
     */
    public static void selectSort(int[] sorts){
        for (int end = sorts.length - 1; end > 0 ; end--) {
            int maxIndex  = 0;
            for (int j = 1; j <= end; j++) {
                //在数组里找到最大值的index
                if (sorts[maxIndex] < sorts[j]) {
                    maxIndex = j;
                }
            }
            //将最大值直接放在数组的末尾，然后进行下一轮排序
            int temp = sorts[end];
            sorts[end] = sorts[maxIndex];
            sorts[maxIndex] = temp;
        }
    }


    /**
     * 10, 17, 13, 4, 9, 15, 11, 12, 18, 3
     * 10  13 17，
     */
    private static void bubSort(int[] sorts){
        //倒叙遍历，将数组中最大的值逐步放在数组最后一位, 0位不需要遍历，当遍历1位时就已经排好位了
        for (int i = sorts.length - 1; i > 0 ; i--) {
            //2
            int lastReplaceIndex = 1;
            for (int j = lastReplaceIndex; j <= i; j++) {
                int temp = sorts[j];
                int pre = sorts[j - 1];
                //从头开始，每前后两个进行比较，把大的值放在数组最后
                if (pre > temp) {
                    sorts[j] = pre;
                    sorts[j - 1] = temp;
                    lastReplaceIndex = j;
                }
            }
            i = lastReplaceIndex;
        }
    }
}
