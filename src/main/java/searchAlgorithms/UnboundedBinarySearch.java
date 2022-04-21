package searchAlgorithms;

import java.util.Scanner;

/**
 * Given an infinite sized sorted array (length in millions) find the index of
 * the number if present in this array.
 * 
 * We can get the logBase2N time complexity either by dividing by 2 or by
 * multiplying by 2.
 * 
 * @author siddhartha.kumar
 *
 */
public class UnboundedBinarySearch {

	public int searchInInfiniteSizedSortedArray(int[] arr, int numberToSearch) {

		if (arr[0] == numberToSearch)
			return 0;

		int lo = 1, hi = 2 * lo;

		while (lo <= hi) {
			int median = (lo + hi) / 2;
			// This check not required as per the given condition there is no bound in arr
			// length.just put to ensure that the result passes with bounded array as well.
			if (median >= arr.length)
				return -1;
			if (arr[median] > numberToSearch) {
				hi = median - 1;
			} else if (arr[median] < numberToSearch) {
				lo = median + 1;
				hi = 2 * lo;
			} else {
				return median;
			}
		}

		return -1;
	}

	public int searchInInfiniteSizedSortedArrayBetter(int[] arr, int numberToSearch) {

		if (arr[0] == numberToSearch)
			return 0;
		int index = 1;
		while (arr[index] < numberToSearch) {
			index = index * 2;
			// This check not required as per the given condition there is no bound in arr
			// length.just put to ensure that the result passes with bounded array as well.
			if (index >= arr.length)
				return -1;
		}

		if (arr[index] == numberToSearch)
			return index;

		int hi = index - 1;// The value at index is greater than the 'numberToSearch'
		int lo = index / 2;// since this the value at this index was less than the 'numberToSearch'

		// now the 'numberToSearch' if present has to be between 'lo' and 'hi'.
		return binarySearch(arr, numberToSearch, lo, hi);
	}

	private int binarySearch(int[] arr, int numberToSearch, int lo, int hi) {

		while (lo <= hi) {
			int median = (lo + hi) / 2;
			if (arr[median] > numberToSearch) {
				hi = median - 1;
			} else if (arr[median] < numberToSearch) {
				lo = median + 1;
			} else {
				return median;
			}
		}

		return -1;
	}

	public static void main(String[] args) {
		Scanner sc = null;
		try {

			sc = new Scanner(System.in);

			System.out.println("Please enter the size of the infinte array : ");
			int lengthOfArray = sc.nextInt();
			int[] arr = new int[lengthOfArray];
			System.out.println("Please enter the elements of the infinte array : ");
			for (int i = 0; i < lengthOfArray; i++) {
				arr[i] = sc.nextInt();
			}
			System.out.println("Please enter the number to search : ");
			int number = sc.nextInt();
			UnboundedBinarySearch searchInAnInfiniteSizedSortedArray = new UnboundedBinarySearch();
			int result = searchInAnInfiniteSizedSortedArray.searchInInfiniteSizedSortedArray(arr, number);
			System.out.println("Result is : " + result);
			System.out.println("result by first multiplying and finding a range in which the number would lie : "
					+ searchInAnInfiniteSizedSortedArray.searchInInfiniteSizedSortedArrayBetter(arr, number));

		} catch (Exception ex) {
			ex.printStackTrace();
			System.out.println("Excpetion raised in main : " + ex);
		} finally {
			if (sc != null) {
				sc.close();
			}
		}
	}
}