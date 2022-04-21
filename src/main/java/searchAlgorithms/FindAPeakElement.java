package searchAlgorithms;

import java.util.Scanner;

public class FindAPeakElement {

	public int peakElement(int[] arr) {
		int lo = 0, hi = arr.length - 1;

		if (arr.length == 1)
			return arr[0];
		while (lo <= hi) {
			System.out.println("lo : " + lo + " hi : " + hi);
			int median = (lo + hi) / 2;
//			if (median == 0) {
//				if (arr[median] > arr[median + 1])
//					return arr[median];
//				return -1;
//			}
//
//			if (median == arr.length - 1) {
//				if (arr[median] > arr[arr.length - 2]) {
//					return arr[median];
//				}
//				return -1;
//			}

			if ((median == 0 || arr[median] > arr[median - 1])
					&& (median == arr.length - 1 || arr[median] > arr[median + 1])) {
				return arr[median];
			} else if (median > 0 && arr[median] < arr[median - 1]) {
				hi = median - 1;
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

			FindAPeakElement findAPeakElement = new FindAPeakElement();
			int peakElement = findAPeakElement.peakElement(arr);
			System.out.println("Peak Element is : " + peakElement);

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
