package searchAlgorithms;

import java.util.Scanner;

public class LinearSearch {

	/**
	 * does linear search and returns the index of the number present else returns
	 * -1.
	 * 
	 * @param arr
	 * @param numberToSearch
	 * @return
	 */
	public int linearSearch(int[] arr, int numberToSearch) {
		for (int i = 0; i < arr.length; i++) {
			if (arr[i] == numberToSearch) {
				return i;
			}
		}

		return -1;
	}

	/**
	 * uses the fact the array is sorted in ascending order and stops the search once it encounters a
	 * element greater than it.
	 * 
	 * @param arr
	 * @param numberToSearch
	 * @return
	 */
	public int linearSearchOptimised(int[] arr, int numberToSearch) {
		for (int i = 0; i < arr.length; i++) {
			if (arr[i] > numberToSearch) {
				break;
			} else if (arr[i] == numberToSearch) {
				return i;
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
			LinearSearch binarySearch = new LinearSearch();
			int linearSearchResult = binarySearch.linearSearch(arr, numberToSearch);
			System.out.println("linearSearchResult  : " + linearSearchResult);
			System.out.println(
					"linearOptimisedSearchResult : " + binarySearch.linearSearchOptimised(arr, numberToSearch));

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
