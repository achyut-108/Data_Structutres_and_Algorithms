package searchAlgorithms;

import java.util.Scanner;

public class CountOcurrencesInSortedArray {

	public int countOcurrences(int[] arr, int numberToSearch) {

		int lo = 0;
		int hi = arr.length - 1;
		while (lo <= hi) {
			int median = (lo + hi) / 2;
			if (numberToSearch > arr[median]) {
				lo = median + 1;
			} else if (numberToSearch < arr[median]) {
				hi = median - 1;
			} else {
				int lastOcurrence = lastOcurrence(arr, numberToSearch, lo, hi, median);
				System.out.println("lastOcurrence : " + lastOcurrence);
				int firstOcurrence = firstOcurrence(arr, numberToSearch, lo, hi, median);
				System.out.println("firstOcurrence : " + firstOcurrence);
				return lastOcurrence - firstOcurrence + 1;
			}
		}

		return -1;
	}

	public int firstOcurrence(int[] arr, int numberToSearch, int lo, int hi, int median) {

		hi = median;

		while (lo <= hi) {
			median = (lo + hi) / 2;
			if (lo == hi && numberToSearch == arr[median]) {
				return median;
			}
			if (numberToSearch <= arr[median]) {
				hi = median;
			} else {
				lo = median + 1;
			}
		}

		return -1;
	}

	public int lastOcurrence(int[] arr, int numberToSearch, int lo, int hi, int median) {

		lo = median;
		while (lo <= hi) {
			median = (lo + hi) / 2;
			if (numberToSearch < arr[median]) {
				hi = median - 1;
			} else if (numberToSearch > arr[median]) {
				lo = median + 1;
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

			System.out.println("Please enter the number to count ocurrences : ");
			int numberToSearch = sc.nextInt();
			CountOcurrencesInSortedArray countOcurrencesInSortedArray = new CountOcurrencesInSortedArray();
			int ocurrences = countOcurrencesInSortedArray.countOcurrences(arr, numberToSearch);

			System.out.println("Ocurrences : " + ocurrences);

		} catch (Exception ex) {
			System.out.println("Excpetion raised in main : " + ex);
		} finally {
			if (sc != null) {
				sc.close();
			}
		}
	}
}