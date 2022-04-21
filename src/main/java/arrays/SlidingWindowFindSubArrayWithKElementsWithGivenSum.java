package arrays;

import java.util.Scanner;

/**
 * Find if a sub array of length K exists whose sum is S
 * 
 * @author siddhartha.kumar
 *
 */
public class SlidingWindowFindSubArrayWithKElementsWithGivenSum {

	public boolean checkSubArrayWithGivenSum(int[] arr, int sum, int lengthOfSubArray) {

		int lastConsecutiveSum = 0;
		for (int i = 0; i < lengthOfSubArray; i++) {
			lastConsecutiveSum = lastConsecutiveSum + arr[i];
		}

		for (int i = lengthOfSubArray; i < arr.length; i++) {
			if (lastConsecutiveSum == sum)
				return true;
			lastConsecutiveSum = lastConsecutiveSum - arr[i - lengthOfSubArray] + arr[i] ;
		}

		return false;
	}

	// e.g. :arr = { 1,8,30,-5,20,7 }and K = 3 and sum = 45
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
			int lengthOfSubArray = sc.nextInt();

			System.out.println("Please enter the sum : ");
			int sum = sc.nextInt();
			SlidingWindowFindSubArrayWithKElementsWithGivenSum findSubArrayWithKElementsWithGivenSum = new SlidingWindowFindSubArrayWithKElementsWithGivenSum();
			boolean result = findSubArrayWithKElementsWithGivenSum.checkSubArrayWithGivenSum(arr, sum,
					lengthOfSubArray);
			System.out.println(
					"Does the sub array exist with sum  : " + sum + " and length : " + lengthOfArray + " : " + result);
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
