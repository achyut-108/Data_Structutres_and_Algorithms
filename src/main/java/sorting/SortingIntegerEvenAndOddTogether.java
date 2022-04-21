package sorting;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;
import java.util.Scanner;

import searchAlgorithms.TwoPointerApproachFindApairWithGivenSumInSortedArray;

public class SortingIntegerEvenAndOddTogether {

	public void sort(List<Integer> arr) {

		Comparator<Integer> evenOddComparator = new Comparator<Integer>() {
			public int compare(Integer integer1, Integer integer2) {

				if (integer1 % 2 == 0 && integer2 % 2 == 0) {
					return (integer1 - integer2);
				} else if (integer1 % 2 == 0) {
					return 1;
				} else if (integer2 % 2 == 0) {
					return -1;
				} else {
					return integer1 - integer2;
				}

			}
		};

		Collections.sort(arr, evenOddComparator);
	}

	public static void main(String[] args) {
		Scanner sc = null;
		try {

			sc = new Scanner(System.in);
			System.out.println("Please enter the size of the integer List : ");
			int lengthOfArray = sc.nextInt();

			List<Integer> list = new ArrayList<Integer>();

			System.out.println("Please enter the elements of the List : ");

			for (int i = 0; i < lengthOfArray; i++) {
				list.add(sc.nextInt());
			}

			SortingIntegerEvenAndOddTogether sortingIntegerEvenAndOddTogether = new SortingIntegerEvenAndOddTogether();
			sortingIntegerEvenAndOddTogether.sort(list);

			System.out.println("After Sorting : ");
			for (Integer integer : list) {
				System.out.println(integer);
			}

		} catch (Exception ex) {
			ex.printStackTrace();
			System.out.println("Exception raise in main : " + ex);
		} finally {
			if (sc != null) {
				sc.close();
			}
		}
	}
}