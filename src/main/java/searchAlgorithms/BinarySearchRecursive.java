package searchAlgorithms;

import java.util.Scanner;

public class BinarySearchRecursive {

	public int binarySearch(int[] arr, int numberToSearch) {

		return binarySearch(arr, numberToSearch, 0, arr.length - 1);
	}

	/**
	 * Time Complexity : for successfull search O(logBase2N); for unsuccessful
	 * searches Theta(logBase2N)
	 * 
	 * @param arr
	 * @param numberToSearch
	 * @param lo
	 * @param hi
	 * @return
	 */
	private int binarySearch(int[] arr, int numberToSearch, int lo, int hi) {

		if (lo > hi)
			return -1;

		int median = (lo + hi) / 2;
		if (arr[median] == numberToSearch)
			return median;

		if (numberToSearch > arr[median]) {
			return binarySearch(arr, numberToSearch, median + 1, hi);
		} else {
			return binarySearch(arr, numberToSearch, lo, median - 1);
		}
	}

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
			BinarySearchRecursive binarySearch = new BinarySearchRecursive();
			int binarySearchResult = binarySearch.binarySearch(arr, numberToSearch);
			System.out.println("binarySearch result : " + binarySearchResult);

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