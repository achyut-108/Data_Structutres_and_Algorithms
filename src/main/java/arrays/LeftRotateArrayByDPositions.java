package arrays;

import java.util.Scanner;

public class LeftRotateArrayByDPositions {

	public int[] leftRotate(int[] arr, int numOfRotations) {

		if (numOfRotations == arr.length)
			return arr;

		if (numOfRotations > arr.length) {
			numOfRotations = numOfRotations % arr.length;
		}

		System.out.println("num of rotations : " + numOfRotations);

		int high = numOfRotations - 1;
		int lo = 0;
		// reverse first 'numOfRotations'th elements
		reverse(arr, lo, high);

		lo = numOfRotations;
		high = arr.length - 1;
		// reverse the remaining part of the array
		reverse(arr, lo, high);

		lo = 0;
		high = arr.length - 1;

		// reverse the entire array
		reverse(arr, lo, high);

		return arr;
	}

	private void reverse(int[] arr, int lo, int high) {
		while (lo < high) {
			int temp = arr[lo];
			arr[lo++] = arr[high];
			arr[high--] = temp;
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

			System.out.println("Please enter num of Left Rotations : ");
			int numOfLeftRotations = sc.nextInt();

			LeftRotateArrayByDPositions rotateLeftByDPlace = new LeftRotateArrayByDPositions();
			int[] rotatedArray = rotateLeftByDPlace.leftRotate(arr, numOfLeftRotations);
			System.out.println("The array after rotating : ");
			for (int i : rotatedArray) {
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
