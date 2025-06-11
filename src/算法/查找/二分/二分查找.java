package 算法.查找.二分;

import 算法.tools.Integers;

import java.util.Arrays;

public class 二分查找 {

    public static void main(String[] args) {
        int[] array = {1, 2, 3, 6, 8, 14, 15, 16, 17, 19};
        System.out.println(Arrays.toString(array));
        System.out.println(search(array, 20));
    }

    /**
     * 这里也使用的是分治算法，分治算法不能包含找到的分治节点，比如二分查找不能包含每次对比完的middle
     * 1
     * 1, 2, 3, 6, 8, ｜14｜, 15, 16, 17, 19
     * 1, 2, ｜3｜, 6, 8,
     * 1, ｜2｜,
     */
    public static int search(int[] array, int element){
        int start = 0;
        int end = array.length;
        while (start < end){
            int middle = (start + end) / 2;
            if (array[middle] > element) {
                end = middle;
            } else if (array[middle] < element) {
                start = middle + 1;
            } else {
                return middle;
            }
        }
        //未找到
        return -1;
    }
}
