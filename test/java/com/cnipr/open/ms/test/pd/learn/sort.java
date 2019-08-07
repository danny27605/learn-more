package com.cnipr.open.ms.test.pd.learn;

import org.apache.commons.lang3.ArrayUtils;

import java.util.Arrays;

/**
 * 排序
 * https://www.jianshu.com/p/47170b1ced23
 *
 * @author Bi Yunfei
 * @date 2019/8/6 8:43
 */
public class sort {

	private sort() {
	}

	//冒泡
	public static int[] BubbleSort(int[] arr) {
		if (arr.length == 0) {
			return null;
		}
		for (int i = 0; i < arr.length; i++) {
			boolean flag = false;
			for (int j = 0; j < arr.length - i - 1; j++) {
				if (arr[j + 1] < arr[j]) {
					int temp = arr[j];
					arr[j] = arr[j + 1];
					arr[j + 1] = temp;
					flag = true;
				}
			}
			if (!flag) {
				break;
			}
		}
		return arr;
	}

	//冒泡优化
	//在每一轮中, 可以同时找到当前未处理元素的最大值和最小值
	public static int[] cocktailSort(int[] arr) {
		int left = 0;
		int right = arr.length - 1;
		while (left < right) {
			for (int i = left; i < right; i++) {
				if (arr[i] > arr[i + 1]) {
					swap(arr, i, i + 1);
				}
			}
			right--;
			for (int i = right; i > left; i--) {
				if (arr[i] < arr[i - 1]) {
					swap(arr, i, i - 1);
				}
			}
			left++;
		}
		return arr;
	}

	//选择
	public static int[] selectSort(int[] arr) {
		if (ArrayUtils.isEmpty(arr)) {
			return null;
		}
		for (int i = 0; i < arr.length; i++) {
			int minIndex = i;
			for (int j = i; j < arr.length; j++) {
				if (arr[j] < arr[minIndex]) {
					minIndex = j;
				}
			}
			swap(arr, i, minIndex);
		}
		return arr;
	}

	//选择优化
	//在每一轮中, 可以同时找到当前未处理元素的最大值和最小值
	public static int[] selectSort1(int[] arr) {
		if (ArrayUtils.isEmpty(arr)) {
			return null;
		}
		int left = 0, right = arr.length - 1;
		while (left < right) {
			int minIndex = left;
			int maxIndex = right;
			if (arr[minIndex] > arr[maxIndex]) {
				swap(arr, minIndex, maxIndex);
			}
			for (int i = left + 1; i < right; i++) {
				if (arr[i] < arr[minIndex])
					minIndex = i;
				if (arr[i] > arr[maxIndex])
					maxIndex = i;
			}
			swap(arr, left, minIndex);
			swap(arr, right, maxIndex);
			left++;
			right--;
		}
		return arr;
	}

	//插入
	public static int[] insertSort(int[] arr) {
		if (ArrayUtils.isEmpty(arr)) return null;
		/*
		for (int i = 1; i < arr.length; i++) {
			int temp = arr[i];
			int preIndex = i - 1;
			while (preIndex >= 0 && temp < arr[preIndex]) {
				arr[preIndex + 1] = arr[preIndex];
				preIndex--;
			}
			arr[preIndex + 1] = temp;
		}
	    */
		for (int i = 0; i < arr.length; i++) {
			for (int j = i; j > 0 && arr[j] < arr[j - 1]; j--) {
				swap(arr, j, j - 1);
			}
		}
		return arr;
	}

	//插入优化
	//在直接插入排序中，待插入的元素总是在有序区线性查找合适的插入位置，没有利用有序的优势，考虑使用二分查找搜索插入位置进行优化，即二分插入排序。
	public static int[] insertSort1(int[] arr) {
		if (ArrayUtils.isEmpty(arr)) return null;
		for (int i = 1; i < arr.length; i++) {
			int left = 0;//左边界
			int right = i - 1;//右边界
			int temp = arr[i];
			while (left <= right) {
				//搜索有序区第一个大于temp，即插入位置
				int mid = left + ((right - left) >> 1);//中间值
				if (arr[mid] > temp) {
					right = mid - 1;
				} else {
					left = mid + 1;
				}
			}
			for (int j = i - 1; j > left; j--) {
				arr[j + 1] = arr[j];
			}
			arr[left] = temp;
		}
		return arr;
	}

	//希尔排序
	/*
	先将整个待排元素序列分割成 gap 个增量为 gap 的子序列（每个子序列由位置相差为 gap 的元素组成，整个序列正好分割成 gap 个子序列，每个序列中有 n / gap 个元素）
	分别进行直接插入排序，然后缩减增量为之前的一半再进行排序，待 gap == 1时，希尔排序就变成了直接插入排序。因为此时序列已经基本有序，
	直接插入排序在元素基本有序的情况下（接近最好情况），效率是很高的。gap初始值一般取 len / 2
	 */
	public static int[] shellSort(int[] arr) {
		int len = arr.length;
		if (len == 0) return arr;
		int gap = len / 2;
		int temp;
		while (gap > 0) {
			for (int i = gap; i < len; i++) {
				temp = arr[i];
				int preIndex = i - gap;
				while (preIndex >= 0 && arr[preIndex] > temp) {
					arr[preIndex + gap] = arr[preIndex];
					preIndex -= gap;
				}
				arr[gap + preIndex] = temp;
			}
			gap /= 2;
		}
		return arr;
	}

	//归并
	/*
	1）把长度为 n 的输入序列分成两个长度为 n / 2 的子序列；
	2）对这两个子序列分别采用归并排序；
	3）将两个排序好的子序列合并成一个最终的排序序列。
	 */
	public static int[] MergeSort(int[] arr) {
		if (arr.length < 2) return arr;
		int mid = arr.length / 2;
		int[] left = Arrays.copyOfRange(arr, 0, mid);
		int[] right = Arrays.copyOfRange(arr, mid, arr.length);
		return merge(MergeSort(left), MergeSort(right));
	}

	/**
	 * 将连
	 *
	 * @param left
	 * @param right
	 * @return
	 */
	public static int[] merge(int[] left, int[] right) {
		int[] result = new int[left.length + right.length];
		int i = 0, j = 0, k = 0;
		while (i < left.length && j < right.length) {
			if (left[i] <= right[j]) {
				result[k++] = left[i++];
			} else {
				result[k++] = right[j++];
			}
		}
		while (i < left.length) {
			result[k++] = left[i++];
		}
		while (j < right.length) {
			result[k++] = right[j++];
		}
		return result;
	}

	/**
	 * 交换
	 *
	 * @param arr
	 * @param i
	 * @param j
	 * @return
	 */
	public static int[] swap(int[] arr, int i, int j) {
		int temp = arr[i];
		arr[i] = arr[j];
		arr[j] = temp;
		return arr;
	}

	public static void main(String[] args) {
		int arr[] = {9, 6, 3, 2, 5, 8, 7, 4, 1, 0};
		arr = shellSort(arr);
		for (int i = 0; i < arr.length; i++) {
			System.out.println(arr[i]);
		}
	}
}
