package arrays;

import java.util.Scanner;

public class MaximumDifferenceInArray {

	/**
	 * In any Integer array Find the Max(a[j]-a[i]) such that j > i; The array can be 
	 * sorted or unsorted.
	 */

	public int maxDiff(int[] arr) {
		if (arr.length == 1)
			return arr[0];

		int smallestLeft = arr[0];
		int maxDiff = arr[1] - arr[0];

		for (int i = 1; i < arr.length; i++) {

			int tempDiff = arr[i] - smallestLeft;
			if (tempDiff > maxDiff)
				maxDiff = tempDiff;

			if (arr[i] < smallestLeft)
				smallestLeft = arr[i];

		}
		return maxDiff;
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

			MaximumDifferenceInArray maximumDifferenceInArray = new MaximumDifferenceInArray();
			int maxDiff = maximumDifferenceInArray.maxDiff(arr);
			System.out.println("The array after removing duplicates : maxDiff : " + maxDiff);
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
