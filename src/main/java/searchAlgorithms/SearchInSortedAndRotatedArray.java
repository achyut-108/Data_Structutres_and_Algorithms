package searchAlgorithms;

import java.util.Scanner;

public class SearchInSortedAndRotatedArray {

	public int searchInSortedAndRotatedArray(int[] arr, int numberToSearch) {

		int lo = 0, hi = arr.length - 1;

		while (lo <= hi) {
			int median = (lo + hi) / 2;
			if (arr[median] == numberToSearch)
				return median;

			if (arr[median] > arr[lo]) {// left half sorted
				if (numberToSearch < arr[median] && numberToSearch >= arr[lo]) {
					hi = median + 1;
				} else {
					lo = median + 1;
				}
			} else { // right half sorted

				if (numberToSearch > arr[median] && numberToSearch <= arr[hi]) {
					lo = median + 1;
				} else {
					hi = median - 1;
				}
			}
		}

		return -1;
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
			System.out.println("Please enter the size of the integer array : ");
			int lengthOfArray = sc.nextInt();

			int[] arr = new int[lengthOfArray];

			System.out.println("Please enter the elements of the array : ");

			for (int i = 0; i < lengthOfArray; i++) {
				arr[i] = sc.nextInt();
			}

			System.out.println("Please enter the number to search for : ");
			int numberToSearch = sc.nextInt();
			SearchInSortedAndRotatedArray searchInSortedAndRotatedArray = new SearchInSortedAndRotatedArray();
			int binarySearchResult = searchInSortedAndRotatedArray.searchInSortedAndRotatedArray(arr, numberToSearch);
			System.out.println("Search result : " + binarySearchResult);
			
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