package katas.compressList;

import java.util.List;
import java.util.Map;
import java.util.function.Function;
import java.util.stream.Collectors;

public class CompressList {
	public static <T> Map<T,Long> compress(List<T> list) {
		return list.stream().collect(Collectors.groupingBy(Function.identity(), Collectors.counting()));
	}
}
