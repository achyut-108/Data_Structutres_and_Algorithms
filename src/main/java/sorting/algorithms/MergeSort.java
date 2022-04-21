package sorting.algorithms;

import java.util.Scanner;

public class MergeSort {

	public void sort(int[] arr) {
		sort(arr, 0, arr.length - 1);
	}

	public void sort(int[] arr, int lo, int hi) {
		System.out.println("start : lo : " + lo + " hi : " + hi + " lo < hi : " + (lo < hi));
		if (lo < hi) {
			int mid = (lo + hi) / 2;
			System.out.println("mid : " + mid + " lo : " + lo + " hi : " + hi);
			sort(arr, lo, mid);
			sort(arr, mid + 1, hi);
			merge(arr, lo, mid, hi);
		}

	}

	public void merge(int[] arr, int lo, int mid, int hi) {
		System.out.println("inside merge : ");
		int leftIndex = lo;
		int rightIndex = mid + 1;

		int[] resultArr = new int[hi - lo + 1];

		for (int i = 0; i < resultArr.length; i++) {
			if (arr[leftIndex] >= arr[rightIndex]) {
				resultArr[i] = arr[rightIndex++];
			} else {
				resultArr[i] = arr[leftIndex++];
			}

			if (leftIndex > mid) {
				while (rightIndex <= hi) {
					resultArr[++i] = arr[rightIndex++];
				}
			}

			if (rightIndex > hi) {
				while (leftIndex <= mid) {
					resultArr[++i] = arr[leftIndex++];
				}
			}
		}

		for (int i = 0; i < resultArr.length; i++) {
			arr[lo++] = resultArr[i];
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

			MergeSort mergeSort = new MergeSort();
			// mergeSort.merge(arr, 0, 0, 1);
			mergeSort.sort(arr);
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