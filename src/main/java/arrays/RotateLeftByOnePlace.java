package arrays;

import java.util.Scanner;

public class RotateLeftByOnePlace {

	public int[] rotateLeftByOne(int[] arr, int numOfRotations) {

		int[] auxArr = new int[arr.length];

		int j = 0;
		for (int i = numOfRotations; i < arr.length; i++) {
			auxArr[j++] = arr[i];
		}

		for (int i = 0; i < numOfRotations; i++) {
			auxArr[j] = arr[i];
		}

		return auxArr;
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

			RotateLeftByOnePlace rotateLeftByOnePlace = new RotateLeftByOnePlace();
			int[] rotatedArray = rotateLeftByOnePlace.rotateLeftByOne(arr,1);
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
