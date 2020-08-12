package interviewbit.interview.questions.microsift;

import java.util.Arrays;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Map.Entry;
import java.util.Objects;

public class MajorityElement {

	public static Integer compute(List<Integer> list) {

		if (Objects.isNull(list))
			return null;

		Map<Integer, Integer> countMap = new HashMap<Integer, Integer>();

		list.parallelStream().forEach(integer -> {
			Integer count = countMap.get(integer);
			if (count != null)
				countMap.put(integer, ++count);
			else
				countMap.put(integer, 1);

		});

		Integer majorityElement = null;
		Integer countOfMajorityElement = 0;

		for (Entry<Integer, Integer> entrySet : countMap.entrySet()) {
			if (countOfMajorityElement < entrySet.getValue()) {
				majorityElement = entrySet.getKey();
				countOfMajorityElement = entrySet.getValue();
			}
		}
		return majorityElement;
	}

	public static void main(String[] args) {
		Integer[] arr = { 12 };
		System.out.println("result : " + compute(Arrays.asList(arr)));
	}

}
