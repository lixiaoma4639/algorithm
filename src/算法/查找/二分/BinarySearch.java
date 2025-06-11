package 算法.查找.二分;

/**
 * 日期 : 2021/8/14.
 * 创建 : xin.li
 * 描述 :
 */
public class BinarySearch {
    public static void main(String[] args) {
        int[] array = {1, 2, 5 , 6, 34, 36, 44, 100, 110 , 120, 130, 150};
//        int[] array = {0, 1, 2, 3 , 4, 5, 6, 7, 8,9};
//        System.out.println(search(array, 8));
        System.out.println(insertSearch(array, 121));
    }

    public static int search(int[] array, int element){
        if (array == null) return -1;
        int start = 0, end = array.length;
        //使用小于，不包含end对应的index，防止越界
        while (start < end){
            int middle = (start + end) / 2;
            if (array[middle] < element) {
                start = middle + 1;
            } else if (array[middle] > element){
                end = middle;
            } else {
                return middle;
            }
        }
        //未找到
        return -1;
    }

    /**
     * 二分查找, 查找element该元素对应角标
     */
    public static int search2(int[] array, int element){
        if (array == null) return -1;
        int start = 0, end = array.length;
        while (start < end){
            int middle = (start + end) / 2;
            if (array[middle] > element){
                end = middle;
            } else if(array[middle] < element) {
                start = middle + 1;
            } else {
                return middle;
            }
        }
        //未找到
        return -1;
    }

    /**
     * 二分查找, 查找第一个比element大的元素
     */
    public static int insertSearch(int[] array, int element){
        if (array == null) return -1;
        int start = 0, end = array.length;
        while (start < end){
            int middle = (start + end) >> 1;
            if (element < array[middle]){
                end = middle;
            } else {
                start = middle + 1;
            }
        }
        return start;
    }
}
