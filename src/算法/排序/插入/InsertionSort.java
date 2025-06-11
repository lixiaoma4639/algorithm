package 算法.排序.插入;

import 算法.排序.Sort;

/**
 * 日期 : 2021/8/14.
 * 创建 : xin.li
 * 描述 : 插入排序
 */
public class InsertionSort extends Sort<Integer> {

    @Override
    protected void sort() {
        for (int i = 1; i < array.length; i++) {
            int current = i;
            while (current > 0 && cmp(current, current - 1) < 0){
                swap(current, current - 1);
                current--;
            }
        }
    }
}
