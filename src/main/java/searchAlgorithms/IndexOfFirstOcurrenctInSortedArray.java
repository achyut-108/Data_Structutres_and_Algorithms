package searchAlgorithms;

import java.util.Scanner;

/**
 * Find the index of first occurrence of the given element in the given array.
 * 
 * @author siddhartha.kumar
 *
 */
public class IndexOfFirstOcurrenctInSortedArray {

	public int firstOcurrence(int[] arr, int numberToSearch) {
		int lo = 0;
		int hi = arr.length - 1;

		while (lo <= hi) {
			int median = (lo + hi) / 2;
			if (lo == hi && arr[median] == numberToSearch) {
				return median;
			}

			if (numberToSearch <= arr[median]) {
				hi = median;
			} else {
				lo = median + 1;
			}
		}

		return -1;
	}

	/**
	 * e.g. : 1,10,10,20,25,25
	 * 1,10,15,25,25,25
	 * @param args
	 */
	public static void main(String[] args) {
		Scanner sc = null;
		try {

			sc = new Scanner(System.in);
			System.out.println("Please enter the size of the integer array : ");
			int lengthOfArray = sc.nextInt();

			int[] arr = new int[lengthOfArray];

			System.out.println("Please enter the elements of the array : ");

			for (int i = 0; i < lengthOfArray; i++) {
				arr[i] = sc.nextInt();
			}

			System.out.println("Please enter the number to search for : ");
			int numberToSearch = sc.nextInt();
			IndexOfFirstOcurrenctInSortedArray indexOfFirstOcurrenctInSortedArray = new IndexOfFirstOcurrenctInSortedArray();
			int indexOfFirstOcurrence = indexOfFirstOcurrenctInSortedArray.firstOcurrence(arr, numberToSearch);
			System.out.println("First ocurrence : " + indexOfFirstOcurrence);

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
