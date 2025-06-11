package 算法.排序;


import java.util.Arrays;

import 算法.tools.Asserts;
import 算法.tools.Integers;
import 算法.排序.堆排序.HeapSort;
import 算法.排序.归并.MergeSort;
import 算法.排序.快排.QuickSort;
import 算法.排序.插入.InsertionSort;
import 算法.排序.插入.InsertionSort2;
import 算法.排序.插入.InsertionSort3;

@SuppressWarnings({"rawtypes", "unchecked", "unused"})
public class Main {

	public static void main(String[] args) {
		Integer[] array = Integers.random(100000, 0 , 100000);
		testSorts(array,
//				new InsertionSort(),
//				new InsertionSort2(),
//				new InsertionSort3(),
				new MergeSort(),
				new QuickSort()
		);
	}

	static void testSorts(Integer[] array, Sort... sorts) {
		for (Sort sort : sorts) {
			Integer[] newArray = Integers.copy(array);
			sort.sort(newArray);
			Asserts.test(Integers.isAscOrder(newArray));
		}
		Arrays.sort(sorts);

		for (Sort sort : sorts) {
			System.out.println(sort);
		}
	}


//	static void selectionSort(Integer[] array) {
//		for (int end = array.length - 1; end > 0; end--) {
//			int maxIndex = 0;
//			for (int begin = 1; begin <= end; begin++) {
//				if (array[maxIndex] <= array[begin]) {
//					maxIndex = begin;
//				}
//			}
//			int tmp = array[maxIndex];
//			array[maxIndex] = array[end];
//			array[end] = tmp;
//		}
//		
//		// 8 10 9 10 
//	}
//	
//	static void bubbleSort1(Integer[] array) {
//		for (int end = array.length - 1; end > 0; end--) {
//			for (int begin = 1; begin <= end; begin++) {
//				if (array[begin] < array[begin - 1]) {
//					int tmp = array[begin];
//					array[begin] = array[begin - 1];
//					array[begin - 1] = tmp;
//				}
//			}
//		}
//	}
//	
//	static void bubbleSort2(Integer[] array) {
//		for (int end = array.length - 1; end > 0; end--) {
//			boolean sorted = true;
//			for (int begin = 1; begin <= end; begin++) {
//				if (array[begin] < array[begin - 1]) {
//					int tmp = array[begin];
//					array[begin] = array[begin - 1];
//					array[begin - 1] = tmp;
//					sorted = false;
//				}
//			}
//			if (sorted) break;
//		}
//	}
//
//	static void bubbleSort3(Integer[] array) {
//		for (int end = array.length - 1; end > 0; end--) {
//			// sortedIndex的初始值在数组完全有序的时候有用
//			int sortedIndex = 1;
//			for (int begin = 1; begin <= end; begin++) {
//				if (array[begin] < array[begin - 1]) {
//					int tmp = array[begin];
//					array[begin] = array[begin - 1];
//					array[begin - 1] = tmp;
//					sortedIndex = begin;
//				}
//			}
//			end = sortedIndex;
//		}
//	}
}
