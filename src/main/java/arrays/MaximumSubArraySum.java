package arrays;

import java.util.Scanner;

public class MaximumSubArraySum {

	/**
	 * The idea is to create an auxiliary array with value at each index denoting
	 * the maximum sum by considering the elements in the array ending with that
	 * index. The maximum sum (of sub array with consecutive elements) at any index
	 * i can be calculated by comparing the sum of the maximum sum just before i and
	 * the ith element itself.
	 * 
	 * Below implementation uses O[n] space and time complexity is O[n]
	 * 
	 * @param arr
	 * @return
	 */
	public int maxSubArraySum(int[] arr) {

		int[] auxMaxSumArr = new int[arr.length];
		auxMaxSumArr[0] = arr[0];
		for (int i = 1; i < arr.length; i++) {

			auxMaxSumArr[i] = Math.max(auxMaxSumArr[i - 1] + arr[i], arr[i]);
		}

		int result = auxMaxSumArr[0];
		for (int i = 1; i < auxMaxSumArr.length; i++) {
			if (result < auxMaxSumArr[i]) {
				result = auxMaxSumArr[i];
			}
		}

		return result;
	}

	/**
	 * The idea is to create an auxiliary array with value at each index denoting
	 * the maximum sum by considering the elements in the array ending with that
	 * index. The maximum sum (of sub array with consecutive elements) at any index
	 * i can be calculated by comparing the sum of the maximum sum just before i and
	 * the ith element itself.
	 * 
	 * Below implementation uses O[1] space and time complexity is O[n]
	 * 
	 * ya to previous element se end hone wale sub array me add ho ke max sum hoga
	 * ya fir wo element individually max hoga
	 * 
	 * @param arr
	 * @return
	 */
	// Test Example : 2,3,-8,7,-1,2,3
	public int maxSubArraySumSpaceOptimised(int[] arr) {

		int result = arr[0]; //initialize
		int maxEndingWithIthIndex = arr[0]; //initialize
		for (int i = 1; i < arr.length; i++) {
			maxEndingWithIthIndex = Math.max(maxEndingWithIthIndex + arr[i], arr[i]);
			result = Math.max(maxEndingWithIthIndex, result);
		}

		return result;
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

			MaximumSubArraySum maximumSubArraySum = new MaximumSubArraySum();
			int result = maximumSubArraySum.maxSubArraySum(arr);
			System.out.println("The max Consecutive sub array sum is : " + result);
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
