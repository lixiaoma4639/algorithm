package 算法.排序.归并;

import 算法.排序.Sort;

/**
 * 日期 : 2021/8/15.
 * 创建 : xin.li
 * 描述 :
 */
public class MergeSort extends Sort<Integer> {
    private Integer[] leftArray;

    @Override
    protected void sort() {
        leftArray = new Integer[array.length >> 1];
        splitSort(0, array.length);
    }

    private void splitSort(int begin, int end){
        if (end - begin < 2) return;
        int middle = (end + begin) >> 1;
        //拆分左边
        splitSort(begin, middle);
        //拆分右边
        splitSort(middle, end);
        //拆分完毕,进行归并
        mergeSort(begin, middle, end);
    }

    private void mergeSort(int begin, int middle, int end) {
        int leftIndex = 0, leftEnd = middle - begin;
        int rightIndex = middle, rightEnd = end;
        int arrayIndex = begin;
        //备份左边
        for (int i = 0; i < leftEnd; i++) {
            leftArray[i] = array[i + begin];
        }
        //开始合并, leftIndex >= leftEnd, 则表明左边合并完了, 左边一旦合并完了则排序就完成了
        while (leftIndex < leftEnd){
            //rightIndex < rightEnd判断右边是否合并结束
            if (rightIndex < rightEnd && cmp(array[rightIndex] , leftArray[leftIndex]) < 0){
                array[arrayIndex] = array[rightIndex];
                arrayIndex++;
                rightIndex++;
            } else {
                array[arrayIndex] = leftArray[leftIndex];
                arrayIndex++;
                leftIndex++;
            }
        }
    }
}
