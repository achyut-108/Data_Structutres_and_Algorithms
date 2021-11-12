package arrays;

import java.util.Scanner;

public class RemoveDuplicatesFromSortedArray {

	public int removeDuplicates(int[] arr) {

		int currentSize = arr.length;
		for (int i = 1; i < arr.length; i++) {
			if (arr[i] == arr[i - 1]) {
				if (i < arr.length - 1) {
					int j = i + 1;
					while (j < arr.length) {
						if (arr[i] != arr[j])
							break;
						else
							currentSize--;
						j++;
					}
					arr[i] = arr[i + 1];
					shiftByOnePosition(arr, i + 1);
				}
				currentSize--;

			}
		}

		return currentSize;
	}

	public int removeDuplicatesFinal(int[] arr) {

		int resultSize = 1; // as there will be at least one element in array.
		int lastSeenElement = arr[0];
		for (int i = 1; i < arr.length; i++) {
			if (arr[i] != lastSeenElement) {
				resultSize++;
				arr[resultSize - 1] = arr[i];
			}
			lastSeenElement = arr[i];
		}
		return resultSize;
	}

	public int removeDuplicatesFinalMoreEfficient(int[] arr) {

		int resultSize = 1; // as there will be at least one element in array.
		for (int i = 1; i < arr.length; i++) {
			if (arr[i] != arr[resultSize - 1]) {
				arr[resultSize] = arr[i];
				resultSize++;
			}
		}
		return resultSize;
	}

	private void shiftByOnePosition(int arr[], int positionFromWhereToStartShifting) {
		for (int i = positionFromWhereToStartShifting; i < arr.length - 1; i++) {
			arr[i] = arr[i + 1];
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

			RemoveDuplicatesFromSortedArray removeDuplicatesFromSortedArray = new RemoveDuplicatesFromSortedArray();
			int sizeAfterRemovingDuplicates = removeDuplicatesFromSortedArray.removeDuplicatesFinalMoreEfficient(arr);
			System.out.println("The array after removing duplicates : size : " + sizeAfterRemovingDuplicates);
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