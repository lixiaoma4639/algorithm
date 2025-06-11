package 算法.排序.冒泡;

import java.util.Arrays;

import 算法.tools.Integers;
import 算法.tools.Times;
import 算法.排序.选择.SelectorSort;

/**
 * 日期 : 2021/8/7.
 * 创建 : xin.li
 * 描述 : 冒泡排序
 */
class BubblingSort {
    public static void main(String[] args) {
//        Integer[] bub = Integers.tailAscOrder(0 , 10000 ,  200);
        Integer[] bub = Integers.random(10000, 0 ,  10000);
        Integer[] bub1 = Arrays.copyOf(bub, bub.length);
        Integer[] bub2 = Arrays.copyOf(bub, bub.length);
        Integer[] bub3 = Arrays.copyOf(bub, bub.length);

        Times.test("普通冒泡排序" , () -> {
            bubSort(bub);
        });
//        Times.test("排好序的冒泡排序" , () -> {
//            bubSort1(bub1);
//        });
//        Times.test("排好序的冒泡排序" , () -> {
//            bubSort2(bub2);
//        });
        Times.test("选择排序" , () -> {
            SelectorSort.selectSort(bub3);
        });


        System.out.println(Integers.isAscOrder(bub2));
    }

    /**
     * 适用于 部分数组末尾已经排好序了的 冒泡排序
     * 找到最后一次交换位置的index, 提前结束本轮冒泡排序,进行下一轮
     */
    private static void bubSort2(Integer[] sorts){
        for (int end = sorts.length - 1; end > 0; end--) {
            //如果数组本来就是有序的, lastChangeIndex = 1则可以提前结束
            int lastChangeIndex = 1;
            for (int i = 1; i <= end; i++) {
                if (sorts[i] < sorts[i - 1]){
                    //交换位置
                    int temp = sorts[i];
                    sorts[i] = sorts[i - 1];
                    sorts[i - 1] = temp;
                    lastChangeIndex = i;
                }
            }
            end = lastChangeIndex;
        }
    }

    /**
     * 适用于 有序的数组的 冒泡排序
     * 如果提前发现数组已经有序了, 则不再循环遍历扫描, 提前结束
     */
    private static void bubSort1(Integer[] sorts){
        for (int end = sorts.length - 1; end > 0; end--) {
            boolean isSorted = true;
            for (int i = 1; i <= end; i++) {
                if (sorts[i] < sorts[i - 1]){
                    //交换位置
                    int temp = sorts[i];
                    sorts[i] = sorts[i - 1];
                    sorts[i - 1] = temp;
                    isSorted = false;
                }
            }
            if (isSorted) break;
        }
    }

    /**
     * 普通冒泡排序
     */
    private static void bubSort(Integer[] sorts){
        for (int end = sorts.length - 1; end > 0; end--) {
            for (int i = 1; i <= end; i++) {
                if (sorts[i] < sorts[i - 1]){
                    //交换位置
                    int temp = sorts[i];
                    sorts[i] = sorts[i - 1];
                    sorts[i - 1] = temp;
                }
            }
        }
    }


}
