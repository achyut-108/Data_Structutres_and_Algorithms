package arrays.prefixsum;

import java.util.Scanner;

public class PrefixSumSumOfAnyRangeInArray {

	public static int[] prefixSumArr = null;

	public PrefixSumSumOfAnyRangeInArray(int[] arr) {

		prefixSumArr = new int[arr.length];
		prefixSumArr[0] = 0;
		for (int i = 1; i < arr.length; i++) {
			prefixSumArr[i] = prefixSumArr[i - 1] + arr[i - 1];
		}

	}

	public int getSum(int arr[], int start, int end) {

		return (prefixSumArr[end] + arr[end]) - prefixSumArr[start];

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
			System.out.println("Please enter the start index : ");
			int startIndex = sc.nextInt();

			System.out.println("Please enter the end index : ");
			int endIndex = sc.nextInt();

			PrefixSumSumOfAnyRangeInArray prefixSumSumOfAnyRangeInArray = new PrefixSumSumOfAnyRangeInArray(arr);
			int result = prefixSumSumOfAnyRangeInArray.getSum(arr, startIndex, endIndex);
			System.out.println("The result is : " + result);
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