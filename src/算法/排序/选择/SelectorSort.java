package 算法.排序.选择;

import java.util.Arrays;

import 算法.tools.Integers;
import 算法.tools.Times;

/**
 * 日期 : 2021/8/7.
 * 创建 : xin.li
 * 描述 :
 */
public class SelectorSort {
    public static void main1(String[] args) {
        Integer[] select = Integers.random(10, 0 ,  100);

        Times.test("选择排序" , () -> {
            selectSort(select);
        });

        System.out.println(Integers.isAscOrder(select));
        for (int i = 0; i < select.length; i++) {
            System.out.print(select[i] + " ");
        }
    }

    public static void main(String[] args) {
        Integer[] select = new Integer[]{51,15,15,43,8,51,9,99,30,85};
        selectSort(select);
        for (int i = 0; i < select.length; i++) {
            System.out.print(select[i] + ", ");
        }
    }

    /**
     * 选择排序, 将数组中最大的依次放在末尾
     */
    public static void selectSort(Integer[] sorts){
        for (int end = sorts.length - 1; end > 0; end--) {
            int maxIndex = 0;
            for (int i = 1; i <= end; i++) {
                if (sorts[maxIndex] <= sorts[i]){
                    maxIndex = i;
                }
            }
            int temp = sorts[maxIndex];
            sorts[maxIndex] = sorts[end];
            sorts[end] = temp;
        }
    }


}
