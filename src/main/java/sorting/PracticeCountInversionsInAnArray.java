package sorting;

import java.util.Scanner;

public class PracticeCountInversionsInAnArray {

	public int countInversions(int[] arr) {
		return countInversions(arr, 0, arr.length - 1);
	}

	private int countInversions(int[] arr, int lo, int hi) {
		int count = 0;
		if (lo < hi) {
			int median = (lo + hi) / 2;
			count = count + countInversions(arr, 0, median);
			count = count + countInversions(arr, median + 1, hi);

			count = count + countAndMerge(arr, lo, hi, median);
		}
		return count;
	}

	private int countAndMerge(int[] arr, int lo, int hi, int median) {
		int count = 0;
		System.out.println("median : " + median);
		int[] leftArr = new int[median - lo + 1];
		int[] rightArr = new int[hi - median];

		for (int i = 0; i < leftArr.length; i++) {
			leftArr[i] = arr[lo + i];
		}

		for (int i = 0; i < rightArr.length; i++) {
			System.out.println("i : " + i);
			rightArr[i] = arr[median + 1 + i];
		}

		int leftIndex = 0, rightIndex = 0;
		//int indexMainArray = 0;

		while (leftIndex < leftArr.length && rightIndex < rightArr.length) {
			if (leftArr[leftIndex] > rightArr[rightIndex]) {
				arr[lo++] = rightArr[rightIndex];
				count = count + leftArr.length - leftIndex;
				rightIndex++;
			} else if (leftArr[leftIndex] <= rightArr[rightIndex]) {
				arr[lo++] = leftArr[leftIndex];
				leftIndex++;
			}
		}

		while (leftIndex < leftArr.length) {
			arr[lo++] = leftArr[leftIndex++];
		}

		while (rightIndex < rightArr.length) {
			arr[lo++] = rightArr[rightIndex++];
		}

		return count;
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

			PracticeCountInversionsInAnArray countInversionsInAnArray = new PracticeCountInversionsInAnArray();
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