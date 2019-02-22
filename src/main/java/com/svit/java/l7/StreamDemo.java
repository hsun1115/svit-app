package com.svit.java.l7;

import java.util.*;
import java.util.stream.*;

public class StreamDemo {

	public static void main(String[] args) {
		// map
		List<Integer> number = Arrays.asList(1, 2, 3, 4, 5);
		List<Integer> square = number.stream().map(x -> x * x).collect(Collectors.toList());
		System.out.println(square);

		// filter
		List<String> names = Arrays.asList("Reflection", "Collection", "Stream");
		List<String> result = names.stream().filter(s -> s.startsWith("S")).collect(Collectors.toList());
		System.out.println(result);

		// sorted
		List<String> sortedStr = names.stream().sorted().collect(Collectors.toList());
		System.out.println(sortedStr);

		// collect method and return a set
		Set<Integer> squareSet = number.stream().map(x -> x * x).collect(Collectors.toSet());
		System.out.println(squareSet);

		// forEach
		number.stream().map(x -> x * x).forEach(y -> System.out.println(y + 100));

		// reduce
		int even = number.stream().filter(x -> x % 2 == 0).reduce(0, (ans, i) -> ans + i);

		System.out.println(even);

	}

}


