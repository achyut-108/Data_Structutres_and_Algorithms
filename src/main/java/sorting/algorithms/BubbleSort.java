package sorting.algorithms;

import java.util.Scanner;

import arrays.prefixsum.PrefixSumCheckIfArrayDividedIn3PartsWithEqualSum;

public class BubbleSort {

	/**
	 * The idea is to bubble out the largest element and put it in its correct
	 * position. This can be implemented by comparing the adjacent elements and if
	 * the adjacent(i+1)th element is greater then we swap it and this is done till
	 * we reach end of the array.
	 * 
	 * @param arr
	 */
	public void sort(int[] arr) {

		int j = arr.length - 1;

		while (j > 0) {
			int i = 0;
			while (i < j) {
				if (arr[i] > arr[i + 1]) {
					int temp = arr[i];
					arr[i] = arr[i + 1];
					arr[i + 1] = temp;
				}
				i++;
			}

			j--;
		}
	}

	/**
	 * This optimized implementation takes linear time when the array is already
	 * sorted by using the fact that if no swapping occurs in the first pass then
	 * the array is already sorted.
	 * 
	 * @param arr
	 */
	public void sortOptimised(int[] arr) {

		int j = arr.length - 1;

		while (j > 0) {
			boolean swapped = false;
			int i = 0;
			while (i < j) {
				System.out.println("Swapping starts");
				if (arr[i] > arr[i + 1]) {
					int temp = arr[i];
					arr[i] = arr[i + 1];
					arr[i + 1] = temp;
					swapped = true;
					System.out.println("Swapped");
				}
				i++;
			}

			if (swapped == false) {
				System.out.println("breaking..");
				break;
			}
			j--;
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

			BubbleSort bubbleSort = new BubbleSort();
			bubbleSort.sortOptimised(arr);
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