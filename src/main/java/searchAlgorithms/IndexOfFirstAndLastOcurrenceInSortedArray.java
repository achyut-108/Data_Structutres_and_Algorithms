package searchAlgorithms;

import java.util.Arrays;
import java.util.Scanner;

public class IndexOfFirstAndLastOcurrenceInSortedArray {

	public int[] indexOfFirstAndLastOcurrence(int[] arr, int numberToSearch) {

		int[] resultArr = new int[2];
		Arrays.fill(resultArr, -1);

		int lo = 0, hi = arr.length - 1;

		while (lo <= hi) {
			int median = (lo + hi) / 2;
			if (numberToSearch > arr[median]) {
				lo = median + 1;
			} else if (numberToSearch < arr[median]) {
				hi = median - 1;
			} else if (numberToSearch == arr[median]) {
				resultArr[0] = firstOcurrence(arr, numberToSearch, lo, hi, median);
				resultArr[1] = lastOcurrence(arr, numberToSearch, lo, hi, median);
				break;
			}
		}

		return resultArr;

	}

	private int firstOcurrence(int[] arr, int numberToSearch, int lo, int hi, int median) {
		System.out.println("lo : " + lo + " : hi : " + hi);
		hi = median;
		while (lo <= hi) {
			median = (lo + hi) / 2;
			if (lo == hi && arr[median] == numberToSearch)
				return median;
			if (numberToSearch <= arr[median]) {
				hi = median;
			} else {
				lo = median + 1;
			}
		}
		return -1;
	}

	private int lastOcurrence(int[] arr, int numberToSearch, int lo, int hi, int median) {
		lo = median;

		while (lo <= hi) {
			median = (lo + hi) / 2;
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

	public int[] firstAndLstPositionBetter(int[] arr, int numberToSearch) {
		int lo = 0, hi = arr.length - 1;
		int[] resultArr = new int[2];
		Arrays.fill(resultArr, -1);
		while (lo <= hi) {
			int median = (lo + hi) / 2;
			if (arr[median] > numberToSearch) {
				hi = median - 1;
			} else if (arr[median] < numberToSearch) {
				lo = median + 1;
			} else {
				resultArr[0] = firstOcurrenceBetter(arr, numberToSearch, lo, median);
				System.out.println("firstOCurrence Better in code : " + resultArr[0]);
				resultArr[1] = lastOcurrenceBetter(arr, numberToSearch, median, hi);
				return resultArr;
			}
		}

		return resultArr;
	}

	private int firstOcurrenceBetter(int[] arr, int numberToSearch, int lo, int hi) {

		while (lo <= hi) {
			int median = (lo + hi) / 2;
			if (arr[median] > numberToSearch) {
				hi = median - 1;
			} else if (arr[median] < numberToSearch) {
				lo = median + 1;
			} else if (median == 0 || arr[median - 1] != numberToSearch) {
				return median;
			} else {
				hi = median - 1;
			}
		}

		return -1;
	}

	private int lastOcurrenceBetter(int[] arr, int numberToSearch, int lo, int hi) {
		System.out.println("hi .. " + hi);
		while (lo <= hi) {
			int median = (lo + hi) / 2;
			if (arr[median] > numberToSearch) {
				hi = median - 1;
			} else if (arr[median] < numberToSearch) {
				lo = median + 1;
			} else if (median == arr.length - 1 || arr[median + 1] != numberToSearch) {
				return median;
			} else {
				lo = median + 1;
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
			IndexOfFirstAndLastOcurrenceInSortedArray indexOfFirstAndLastOcurrenceInSortedArray = new IndexOfFirstAndLastOcurrenceInSortedArray();
			int[] indexOfFirstAndLastOcurrence = indexOfFirstAndLastOcurrenceInSortedArray
					.indexOfFirstAndLastOcurrence(arr, numberToSearch);

			System.out.println("First Ocurrence : " + indexOfFirstAndLastOcurrence[0]);
			System.out.println("Last Ocurrence : " + indexOfFirstAndLastOcurrence[1]);

			int[] firstAndLastOcurrenceBetter = indexOfFirstAndLastOcurrenceInSortedArray.firstAndLstPositionBetter(arr,
					numberToSearch);
			System.out.println("First Ocurrence better : " + firstAndLastOcurrenceBetter[0]);
			System.out.println("Last Ocurrence better : " + firstAndLastOcurrenceBetter[1]);
		} catch (Exception ex) {
			System.out.println("Excpetion raised in main : " + ex);
		} finally {
			if (sc != null) {
				sc.close();
			}
		}
	}
}