package sorting.algorithms;

import java.util.Scanner;

public class InsertionSort {

	/**
	 * The insertion sort algorithm : Left most element is considered as sorted. The
	 * next element(s) find their respective position and insert themselves in the
	 * left sorted array.
	 * 
	 * Time Complexity : For sorted array : O(n) For array sorted in reverse order :
	 * O(n^2)
	 * 
	 * @param arr
	 */
	public void sort(int[] arr) {

		for (int i = 1; i < arr.length; i++) {
			int smaller_index = i;
			int j = i - 1;
			while (j >= 0) {
				if (arr[j] > arr[smaller_index]) {
					int temp = arr[j];
					arr[j] = arr[smaller_index];
					arr[smaller_index] = temp;
					smaller_index = j;
				} else if (arr[j] <= arr[i]) {
					break;
				}

				j--;
			}
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

			InsertionSort insertionSort = new InsertionSort();
			insertionSort.sort(arr);
			System.out.println("After Sorting : ");
			for (int i : arr) {
				System.out.println(i);
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
