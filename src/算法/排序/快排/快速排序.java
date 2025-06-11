package 算法.排序.快排;

import 算法.tools.Integers;

import java.util.Arrays;

public class 快速排序 {

    static Integer[] array;

    public static void main(String[] args) {
        array = Integers.random(10, 0 , 20);
        System.out.println(Arrays.toString(array));
        new 快速排序().quickSort(0, array.length);
        System.out.println(Arrays.toString(array));
    }

    /**
     * 13, 17, 13, 4, 9, 15, 11, 12, 18, 3
     * 13, -, 13, 4, 9, -, -, -, 18, 3
     * 3  12 13 4, 9, 11, |13|,15  18  17
     * |3| 12 13 4 9 11       |15 | 17| 18
     * 11 9 4  |12|  13
     * 4 9 |11|
     * 4|9|
     * |3|4|9||11||12|13|13||15 | 17| 18
     */
    private void quickSort(int start, int end) {
        if (end - start <= 1) return;
        int pivotIndex = findPivotIndex(start, end);
        //这里不能包含pivotIndex
        quickSort(start, pivotIndex);
        quickSort(pivotIndex + 1, end);
    }

    private int findPivotIndex(int start, int end) {
        int pivot = array[start];
        end--;
        while (start < end){
            while (start < end){
                if (array[end] >= pivot) {
                    end--;
                } else {
                    //进行移动
                    array[start++] = array[end];
                    break;
                }
            }
            while (start < end){
                if (array[start] <= pivot) {
                    start++;
                } else {
                    array[end--] = array[start];
                    break;
                }
            }
        }
        array[start] = pivot;
        return start;
    }

}
