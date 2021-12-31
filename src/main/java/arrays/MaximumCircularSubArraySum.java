package arrays;

import java.util.Scanner;

public class MaximumCircularSubArraySum {

	/**
	 * Time Complexity is O(n).
	 * @param arr
	 * @return
	 */
	public int maxSubArraySum(int[] arr) {
		int maxLinear = maxLinearSum(arr);
		//if the max is negative it means all the elements in the array is negative.
		//if this condition is removed then it would result in giving the final result as 0;
		if(maxLinear < 0 ) return maxLinear;
		
		return Math.max(maxLinear, maxExclusiveCircularSum(arr));
	}

	public int maxLinearSum(int[] arr) {
		int maxSumEndingWithIMinusOne = arr[0];
		int result = maxSumEndingWithIMinusOne;
		for (int i = 1; i < arr.length; i++) {
			maxSumEndingWithIMinusOne = Math.max(maxSumEndingWithIMinusOne + arr[i], arr[i]);
			result = Math.max(maxSumEndingWithIMinusOne, result);
		}

		return result;
	}

	/**
	 * Inverting the array so that the same method(maxLinearSum) can be used. After
	 * inverting the max would become min and vice versa and thus by the result (of
	 * passing to maxLinearSum) would give the min sum(inverted).So the actual sum
	 * would be obtained by adding this value to the array sum. e.g: 8,-4,3,-5,4 -->
	 * The Minimum consecutive sum can be obtained by adding -4,3,-5 i.e. -6,. But
	 * now if the array us inverted--> -8,4,-3,5,-4--> The same set of values would
	 * give max sum but in inverted manner i.e. 6. So the actual sum would have been
	 * arr_sum - (-6) or in other words arr_sum + 6(max sum obtained after inverting
	 * the array.
	 * 
	 * @param arr
	 * @return
	 */
	public int maxExclusiveCircularSum(int[] arr) {

		int arr_sum = 0;
		for (int i = 0; i < arr.length; i++) {
			arr_sum = arr_sum + arr[i];
			arr[i] = -arr[i];
		}
		int minConsecutiveSubArraySum = maxLinearSum(arr);
		return arr_sum + minConsecutiveSubArraySum;
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

			MaximumCircularSubArraySum maximumCircularSubArraySum = new MaximumCircularSubArraySum();
			int maxCircularSum = maximumCircularSubArraySum.maxSubArraySum(arr);
			System.out.println("The maxSum is : " + maxCircularSum);
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