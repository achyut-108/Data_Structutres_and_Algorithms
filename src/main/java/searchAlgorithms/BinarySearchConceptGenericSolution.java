package searchAlgorithms;

import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.IntStream;

public class BinarySearchConceptGenericSolution<V extends Comparable<V>> {

	private List<V> list = null;
	private V itemToCompare = null;

	public BinarySearchConceptGenericSolution(List<V> list, V itemToCompare) {
		this.list = list;
		this.itemToCompare = itemToCompare;
	}

	public V binarySearch() {
		if (itemToCompare == null)
			return null;
		int index = this.binarySearch(0, list.size() - 1, this.itemToCompare);
		if (index < 0)
			return null;
		else
			return list.get(index);
	}

	private int binarySearch(int lo, int hi, V itemToCompare) {

		int mid = (lo + hi) / 2;
		System.out.println("mid is : " + mid + " mid Value is : " + list.get(mid));

		int compareResult = itemToCompare.compareTo(list.get(mid));

		System.out.println("CompareResult is : " + compareResult + " lo is : " + lo + " hi is : " + hi);
		if (lo == hi && compareResult != 0)
			return -1;

		if (compareResult == 0)
			return mid;
		else if (compareResult > 0)
			return binarySearch(mid + 1, hi, itemToCompare);
		else
			return binarySearch(lo, mid, itemToCompare);

	}

	public static void main(String[] args) {
		List<Integer> list = IntStream.rangeClosed(0, 5).map(e -> {
			return new Integer(e);
		}).boxed().collect(Collectors.toList());

		list.add(null);

		System.out.println("Test : " + Integer.valueOf(3).compareTo(2));

		BinarySearchConceptGenericSolution<Integer> bsc = new BinarySearchConceptGenericSolution<Integer>(list, 1);
		System.out.println(bsc.binarySearch());
	}

}
