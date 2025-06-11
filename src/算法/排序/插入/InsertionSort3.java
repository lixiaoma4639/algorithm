package 算法.排序.插入;

import 算法.排序.Sort;

/**
 * 日期 : 2021/8/14.
 * 创建 : xin.li
 * 描述 : 插入排序3 使用二分查找优化查找位置
 */
public class InsertionSort3 extends Sort<Integer> {

    @Override
    protected void sort() {
        for (int i = 1; i < array.length; i++) {
            //插入的元素
            int insetElement = array[i];
            //找到插入的位置
            int insetIndex = insertSearch(i, insetElement);
            for (int j = i; j > insetIndex; j--) {
                //插入位置后面的元素进行向后挪动
                array[j] = array[j - 1];
            }
            //插入元素
            array[insetIndex] = insetElement;
        }
    }
    /**
     * 二分查找, 查找从0到index中第一个比element大的元素
     */
    public int insertSearch(int index, Integer element){
        int start = 0, end = index;
        while (start < end){
            int middle = (start + end) >> 1;
            if (cmp(element, array[middle]) < 0){
                end = middle;
            } else {
                start = middle + 1;
            }
        }
        return start;
    }
}
