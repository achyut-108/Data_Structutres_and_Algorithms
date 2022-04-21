package sorting;

import java.util.Scanner;

/**
 * A pair (arr[i] and arr[j] forms an inversion when i < j and arr[i] > arr[j]
 * e.g: 2,4,1,3,5 -> Total inversions : 3 (2,1),(4,1),(4,3)
 * @author siddhartha.kumar
 *
 */
public class CountInversionsInAnArray {

	public int countInversions(int[] arr) {
		// int result = 0;
		return countInversions(arr, 0, arr.length - 1);
	}

	private int countInversions(int[] arr, int lo, int hi) {
		int result = 0;
		if (lo < hi) {
			int mid = (lo + hi) / 2;
			result = result + countInversions(arr, lo, mid);
			result = result + countInversions(arr, mid + 1, hi);
			result = result + countAndMerge(arr, lo, mid, hi);
		}
		return result;
	}

	private int countAndMerge(int[] arr, int lo, int mid, int hi) {

		int count = 0;
		int[] arr1 = new int[mid - lo + 1];
		int[] arr2 = new int[hi - mid];

		for (int i = 0; i < arr1.length; i++) {
			arr1[i] = arr[lo + i];
		}

		for (int i = 0; i < arr2.length; i++) {
			arr2[i] = arr[mid + 1 + i];
		}

		int index_arr1 = 0, index_arr2 = 0;
		while (index_arr1 < arr1.length && index_arr2 < arr2.length) {
			if (arr1[index_arr1] > arr2[index_arr2]) {
				count = count + arr1.length - index_arr1;
				System.out.println("lo is : " + lo);
				arr[lo++] = arr2[index_arr2];
				index_arr2++;
			} else if (arr1[index_arr1] <= arr2[index_arr2]) {
				System.out.println("lo is : " + lo);
				arr[lo++] = arr1[index_arr1];
				index_arr1++;
			}
		}

		while (index_arr1 < arr1.length) {
			arr[lo++] = arr1[index_arr1++];
		}

		while (index_arr2 < arr2.length) {
			arr[lo++] = arr2[index_arr2++];
		}

		return count;
	}

	private int binarySearch(int[] arr, int element) {
		int result = -1;
		int lo = 0, hi = arr.length - 1;
		while (lo <= hi) {
			int mid = (lo + hi) / 2;
			if (arr[mid] > element) {
				hi = mid - 1;
			} else if (arr[mid] < element) {
				lo = mid + 1;
			} else {
				return mid;
			}
		}

		return result;
	}

	/**
	 * e.g. : 2,4,1,3,5
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

			CountInversionsInAnArray countInversionsInAnArray = new CountInversionsInAnArray();
			// mergeSort.merge(arr, 0, 0, 1);
			int result = countInversionsInAnArray.countInversions(arr);
			System.out.println("Total number of Inversions : " + result);

			for (int i : arr) {
				System.out.println(" i.. " + i);
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