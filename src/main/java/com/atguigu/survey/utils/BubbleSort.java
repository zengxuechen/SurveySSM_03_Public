package com.atguigu.survey.utils;

import java.util.Arrays;

public class BubbleSort {

	/**
	 * 冒泡排序并且返回
	 * 
	 * @param arr
	 * @return
	 */
	public static int[] bubbleSort(int[] arr) {
		int temp;// 定义一个临时变量
		for (int i = 0; i < arr.length - 1; i++) {// 冒泡趟数，n-1趟
			for (int j = 0; j < arr.length - i - 1; j++) {
				if (arr[j + 1] < arr[j]) {
					temp = arr[j];
					arr[j] = arr[j + 1];
					arr[j + 1] = temp;
				}
			}
		}
		return arr;
	}
	
	   public static void main(String[] args) {
	        int arr[] = new int[]{1,6,2,2,5};
	        int[] bubbleSort = BubbleSort.bubbleSort(arr);
	        System.out.println(Arrays.toString(bubbleSort));
	    }
}
