package com.cnipr.open.ms.test.pd.learn;

import org.apache.commons.lang3.ArrayUtils;

import java.util.Arrays;
import java.util.LinkedList;
import java.util.List;

/**
 * 求随机给定100个数中相加和为0的3个数
 *
 * @author Bi Yunfei
 * @date 2019/8/7 8:59
 */
public class FindSumIs0 {
	/*
	 1.遇到数，先排序，没错的
	 在遇到问题没有立马出现思路我觉得这是非常正常的事情，但是可以很明确的说，在对于数做操作的时候，有序会比无序好操作的多，毕竟有序的时候我可以采取的方式也就会更多。
	 2.3个数不好想，那转换成2个呢？
	 这其实描述性的来说，就是把复杂问题简单化。就拿这个问题来说吧，我在100个数里面取三个数的和为0可能很难处理，最笨的方法就是三层循环，o(n^3)，在实在想不出来的时候，就说这个吧。
	 但是转念想想，如果我们把这个问题转化为，求两个数的和等于另一个数的相反数呢？这是不是就有了点眉目了呢？
	 3.问题变为了，有序的100个数中，求两数和 为 x的项，是不是开始才思泉涌
	 具体讲下大概的算法，将100个数排序后存到数组 a 中，开始循环数组a，索引为i，然后分别取两头索引left，right对应的值a[left], a[right]的和是否等于该a[i]，在不相等时，
	 在根据 a[left] + a[right] 和与 a[i] 的大小关系，来判断是将left+1 还是讲 right + 1 再进行比对。
	 */
	@Deprecated
	/*待实现*/
	public static void findNums(int[] arr) {
		Arrays.sort(arr);
		int left = 0, right = arr.length - 1;
		for (int i = 0; i < arr.length; i++) {
			if (arr[left] + arr[right] < -arr[i]) {
				left++;
				if (left == i) left++;
			} else if (arr[left] + arr[right] > -arr[i]) {
				right--;
				if (right == i) right--;
			} else {
				System.out.print(left);
				System.out.print(i);
				System.out.print(right);
			}
		}
	}

	/*
	 这个想法是对输入数组进行排序，然后遍历三元组的可能第一个元素的所有索引。
	 对于每个可能的第一个元素，我们进行阵列剩余部分的标准双向2Sum扫描。
	 同样，我们想跳过相等的元素，以避免在答案中重复，而不会像这样设置或混淆
	*/
	public static List<List<Integer>> threeSum(int[] num) {
		Arrays.sort(num);
		List<List<Integer>> list = new LinkedList<>();

		for (int i = 0; i < num.length; i++) {
			if (i == 0 || (i > 0 && num[i] != num[i - 1])) {
				int sum = 0 - num[i];
				int l = i + 1;
				int h = num.length - 1;

				while (l < h) {
					if (num[l] + num[h] == sum) {
						list.add(Arrays.asList(num[i], num[l], num[h]));
						while ((l < h) && (num[l] == num[l + 1])) l++;
						while ((l < h) && (num[l] == num[h - 1])) h--;
						l++;
						h--;
					} else if (num[l] + num[h] < sum) {
						l++;
					} else {
						h--;
					}
				}
			}
		}
		return list;

	}

	public static void main(String[] args) {
		int[] arr = {1, -1, 2, -9, -5, 3, -4, 5, -7, 6, -10, 7, 0, 8, 9};
		int[] S = {-1, 0, 1, 2, -1, -4};
		List<List<Integer>> list = threeSum(arr);
		System.out.println(list.toString());
	}
}
