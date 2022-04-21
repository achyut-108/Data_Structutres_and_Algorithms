package searchAlgorithms;

import java.util.Scanner;

import sun.security.util.Length;

public class BinarySearch {

	/**
	 * arr is sorted in ascending order
	 * 
	 * @param arr
	 * @param numberToSearch
	 * @return
	 */
	public int binarySearch(int[] arr, int numberToSearch) {

		int hi = arr.length - 1;
		int lo = 0;

		while (lo <= hi) {
			int median = (lo + hi) / 2;

			if (numberToSearch == arr[median]) {
				return median;
			} else if (numberToSearch > arr[median]) {
				lo = median + 1;
			} else {
				hi = median - 1;
			}
		}

		return -1;
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
			BinarySearch binarySearch = new BinarySearch();
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