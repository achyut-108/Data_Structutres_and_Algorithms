package searchAlgorithms;

import java.util.Scanner;

public class IndexOfLastOcurrenceInSortedArray {

	public int indexOfLastOcurrence(int[] arr, int numberToSearch) {

		int lo = 0, hi = arr.length - 1;

		while (lo <= hi) {
			System.out.println("lo hi : " + lo + " " + hi);
			int median = (lo + hi) / 2;
			if ((hi - lo) == 1 || hi == lo) {
				if (arr[hi] == numberToSearch) {
					return hi;
				} else if (arr[lo] == numberToSearch)
					return lo;
				else
					return -1;
			} else if (numberToSearch >= arr[median]) {
				lo = median;
			} else {
				hi = median - 1;
			}
		}

		return -1;
	}

	public int indexOfLastOcurrenceCleanerCode(int[] arr, int numberToSearch) {
		int lo = 0;
		int hi = arr.length - 1;

		while (lo <= hi) {
			int median = (lo + hi) / 2;

			if (numberToSearch > arr[median]) {
				lo = median + 1;
			} else if (numberToSearch < arr[median]) {
				hi = median - 1;
			} else {
				if (median == arr.length - 1 || arr[median + 1] != numberToSearch) {
					return median;
				} else {
					lo = median + 1;
				}
			}
		}

		return -1;
	}

	private int lastOcurrence(int[] arr, int numberToSearch, int lo, int hi, int median) {
		lo = median;

		while (lo <= hi) {
			median = (lo + hi) / 2;

			if (lo == hi && arr[median] == numberToSearch)
				return median;

			if (numberToSearch >= arr[median]) {
				lo = median;
			} else {
				hi = median - 1;
			}
		}

		return -1;
	}

	/**
	 * e.g. : a) 1,10,10,20,25,25 b) 1,10,15,25,25,25
	 * 
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
			IndexOfLastOcurrenceInSortedArray indexOfLastOcurrenceInSortedArray = new IndexOfLastOcurrenceInSortedArray();
			int indexOfLastOcurrence = indexOfLastOcurrenceInSortedArray.indexOfLastOcurrence(arr, numberToSearch);
			System.out.println("Last ocurrence : " + indexOfLastOcurrence);
			System.out.println("indexOfLastOcurrenceCleanerCode : result : "
					+ indexOfLastOcurrenceInSortedArray.indexOfLastOcurrenceCleanerCode(arr, numberToSearch));

			//System.out.println("lastOcurrence last : " + (indexOfLastOcurrenceInSortedArray.lastOcurrence(arr, numberToSearch, 0, arr.length-1, (arr.length-1)/2)));
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