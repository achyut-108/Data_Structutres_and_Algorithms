package sorting.algorithms;

import java.util.Scanner;

public class NaivePartition {

	public void partition(int[] arr, int pivotIndex) {

		int pivot = arr[pivotIndex];
		
		

		for (int i = pivotIndex; i > 0; i--) {
			arr[i] = arr[i - 1];
		}

		arr[0] = pivot;

		System.out.println("after reshuffling : ");
		for (int i : arr) {
			System.out.println(i);
		}

		pivotIndex = 0;
		for (int i = 1; i < arr.length; i++) {
			if (arr[pivotIndex] > arr[i]) {
				arr[pivotIndex] = arr[i];
				arr[i] = pivot;
				pivotIndex = i;
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

			System.out.println("Plese enter the pivot index  : ");
			int pivotIndex = sc.nextInt();
			NaivePartition naivePartition = new NaivePartition();
			// mergeSort.merge(arr, 0, 0, 1);
			naivePartition.partition(arr, pivotIndex);

			System.out.println("After partition : ");
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
