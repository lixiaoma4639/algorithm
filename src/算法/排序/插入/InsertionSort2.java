package 算法.排序.插入;

import 算法.tools.Integers;
import 算法.排序.Sort;

/**
 * 日期 : 2021/8/14.
 * 创建 : xin.li
 * 描述 : 插入排序2优化
 */
public class InsertionSort2 extends Sort<Integer> {

    @Override
    protected void sort() {
        for (int i = 1; i < array.length; i++) {
            int current = i;
            Integer curElement = array[current];
            while (current > 0 && cmp(curElement, array[current - 1]) < 0){
                array[current] = array[current - 1];
                current--;
            }
            array[current] = curElement;
        }
    }
}
