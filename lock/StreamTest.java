package com.cnipr.open.ms.test.pd.bug;

import java.util.Arrays;
import java.util.IntSummaryStatistics;
import java.util.List;
import java.util.Random;
import java.util.stream.Collectors;

/**
 * stream使用
 *
 * @author Bi Yunfei
 * @date 2019/7/26 15:21
 */
public class StreamTest {
	public static void main(String[] args) {
		List<String> list = Arrays.asList("abc", "", "bc", "efg", "abcd", "", "jkl");
		List<String> stringList = list.stream().filter(x -> !x.isEmpty()).collect(Collectors.toList());
		System.out.println(stringList);
		System.out.println("*********************map*************************");
		List<Integer> numbers = Arrays.asList(3, 2, 2, 3, 7, 3, 5);
		// 获取对应的平方数
		List<Integer> squaresList = numbers.stream().map(i -> i * i).distinct().collect(Collectors.toList());
		System.err.println(squaresList);
		System.out.println("*********forEach************limit**********sorted***************");
		Random random = new Random();
		random.ints().limit(5).forEach(System.out::println);
		random.ints().limit(6).sorted().forEach(System.out::println);
		System.out.println("********************Collectors**************************");
		List<String>strings = Arrays.asList("abc", "", "bc", "efg", "abcd","", "jkl");
		List<String> filtered = strings.stream().filter(string -> !string.isEmpty()).collect(Collectors.toList());

		System.out.println("筛选列表: " + filtered);
		String mergedString = strings.stream().filter(string -> !string.isEmpty()).collect(Collectors.joining(", "));
		System.out.println("合并字符串: " + mergedString);
		System.out.println("*********************统计*************************");

		IntSummaryStatistics stats = numbers.stream().mapToInt((x) -> x).summaryStatistics();
		System.out.println("列表中最大的数 : " + stats.getMax());
		System.out.println("列表中最小的数 : " + stats.getMin());
		System.out.println("所有数之和 : " + stats.getSum());
		System.out.println("平均数 : " + stats.getAverage());

		System.out.println("*********************并行（parallel）程序*************************");
		// 获取空字符串的数量
		long count = strings.parallelStream().filter(string -> string.isEmpty()).count();
		System.err.println(count);
	}
}
