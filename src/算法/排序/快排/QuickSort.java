package 算法.排序.快排;

import 算法.排序.Sort;

/**
 * 日期 : 2021/8/15.
 * 创建 : xin.li
 * 描述 :
 */
public class QuickSort extends Sort<Integer> {

    @Override
    protected void sort() {
        quickSort(0, array.length);
    }

    private void quickSort(int begin, int end){
        if (end - begin < 2) return;
        int middle = findPivot(begin, end);
        quickSort(begin, middle);
        quickSort(middle + 1, end);
    }

    private int findPivot(int begin, int end){
        end--;
        //存储轴点元素的值
        Integer currentElement = array[begin];
        while (begin < end){
            //从右边开始扫描
            while (begin < end){
                if (cmp(currentElement, array[end]) < 0){
                    end--;
                } else {
                    array[begin] = array[end];
                    begin++;
                    //交互完位置,调头从左边开始扫描
                    break;
                }
            }

            //从左边开始扫描
            while (begin < end){
                if (cmp(currentElement, array[begin]) > 0){
                    begin++;
                } else {
                    array[end] = array[begin];
                    end--;
                    //交互完位置,调头从右边开始扫描
                    break;
                }
            }

        }
        //将轴点元素的值放在真正的轴点位置上
        array[begin] = currentElement;
        return begin;
    }
}
