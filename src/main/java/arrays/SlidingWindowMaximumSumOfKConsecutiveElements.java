package arrays;

import java.util.Scanner;

/**
 * Given an array of integers and a number K. Find the maximum sum of K
 * consecutive elements.
 * 
 * @author siddhartha.kumar
 *
 */
public class SlidingWindowMaximumSumOfKConsecutiveElements {

	public int maxSum(int[] arr, int k) {

		if (k <= 0)
			throw new IllegalArgumentException("K can not be zero or negative !! ");
		int maxSum = 0;
		// find the sum of first k consecutive elements
		for (int i = 0; i < k; i++) {
			maxSum = maxSum + arr[i];
		}

		int lastConsecutiveSum = maxSum;
		for (int i = k; i < arr.length; i++) {
			// The sum of K consecutive elements (with ith element ending ) is calculated by
			// subtracting the first element from the last
			// consecutive sum and then adding the ith element(this will be the last element
			// of the next consecutive sub array with k elements).
			// This is also called "Sliding window technique".

			lastConsecutiveSum = lastConsecutiveSum + arr[i] - arr[i - k];
			maxSum = Math.max(lastConsecutiveSum, maxSum);

		}

		return maxSum;
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

			SlidingWindowMaximumSumOfKConsecutiveElements maximumSumOfKConsecutiveElements = new SlidingWindowMaximumSumOfKConsecutiveElements();
			int result = maximumSumOfKConsecutiveElements.maxSum(arr, k);
			System.out.println("The maximum sum of K consecutive element is : " + result);
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
