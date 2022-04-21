package sorting.algorithms;

import java.util.Scanner;

/**
 * 
 * @author siddhartha.kumar
 *
 */
public class SelectionSort {

	/**
	 * The idea is to find out the minimum element and put in the first position and
	 * similarly find out the next greater element and put it in the next position.
	 * 
	 * This algorithm is unstable. For e.g. : int[] arr = [90,27,85,90,25] the first
	 * 90 will be replaced by the last 25 and hence it would appear after the next
	 * 90.So in sorted array the next 90 will appear before the first 90.
	 * 
	 * @param arr
	 */
	public void sort(int[] arr) {
		for (int i = 0; i < arr.length; i++) {
			int smaller = arr[i];
			int swapIndex = i;
			for (int j = i + 1; j < arr.length; j++) {
				if (smaller > arr[j]) {
					smaller = arr[j];
					swapIndex = j;
				}
			}

			if (smaller != arr[i]) {
				int temp = arr[i];
				arr[i] = smaller;
				arr[swapIndex] = temp;
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

			SelectionSort selectionSort = new SelectionSort();
			selectionSort.sort(arr);
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