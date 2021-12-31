package arrays;

import java.util.Scanner;

public class SlidingWindowSubArrayOfSizeKWithGivenSum {

	public boolean subArrayWithGivenSumOfSizeK(int[] arr, int k, int givenSum) {

		int consecutiveSum = 0;
		for (int i = 0; i < k; i++) {
			consecutiveSum += arr[i];
		}

		if (consecutiveSum == givenSum)
			return true;

		for (int i = k; i < arr.length; i++) {
			consecutiveSum = consecutiveSum + arr[i] - arr[i - k];
			if (consecutiveSum == givenSum)
				return true;
		}

		return false;
	}

	// e.g. :arr = { 1,8,30,-5,20,7 }and K = 3
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

			System.out.println("Please enter the value of K : ");
			int k = sc.nextInt();

			System.out.println("Please enter the sum to check : ");
			int givenSum = sc.nextInt();

			SlidingWindowSubArrayOfSizeKWithGivenSum sliArrayOfSizeKWithGivenSum = new SlidingWindowSubArrayOfSizeKWithGivenSum();
			boolean result = sliArrayOfSizeKWithGivenSum.subArrayWithGivenSumOfSizeK(arr, k, givenSum);
			System.out.println("Whether the given sum : " + givenSum + " with " + k + " consecutive elements "
					+ " exists : " + result);
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
