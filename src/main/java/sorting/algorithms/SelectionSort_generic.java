package sorting.algorithms;

import java.util.List;
import java.util.concurrent.CopyOnWriteArrayList;
import java.util.stream.Collectors;
import java.util.stream.IntStream;

public class SelectionSort_generic<E extends Comparable<E>> {

	private List<E> list;

	public SelectionSort_generic(List<E> list) {
		this.list = list;
	}

	public void sort() {
		
		if(this.list == null) return;
		
		for (int i = 0; i < this.list.size(); i++) {
			int index = this.selectMinimum(i);
			this.swap(i, index);
		}
	}

	private int selectMinimum(int index) {

		E min = list.get(index);

		for (int i = index + 1; i < list.size(); i++) {
			if (min.compareTo(list.get(i)) > 0) {
				min = list.get(i);
				index = i;
			}
		}

		return index;
	}

	private void swap(int index1, int index2) {
		E temp = this.list.get(index1);
		this.list.set(index1, this.list.get(index2));
		this.list.set(index2, temp);
	}

	public static void main(String[] args) {
		List<Integer> list = IntStream.range(0, 10).boxed().map(e->{
			 return e;
		 }).collect(Collectors.toList());
		
//		ConcurrentHashMap<Integer, String> chp = new ConcurrentHashMap<Integer, String>();
//		
//		chp.remove(0,"");

		CopyOnWriteArrayList<Integer> cowal = new CopyOnWriteArrayList<>();
		cowal.add(1);
		
		list.add(-1);
		list.add(-19);
		 System.out.println("Before Sorting");
		 list.forEach(System.out::println);
		SelectionSort_generic<Integer> selectionSort = new SelectionSort_generic<>(list);

		selectionSort.sort();

		System.out.println("------After Sorting-------");
		list.forEach(System.out::println);

	}

}
