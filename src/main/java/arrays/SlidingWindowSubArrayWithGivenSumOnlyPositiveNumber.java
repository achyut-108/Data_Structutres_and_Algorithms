package arrays;

import java.util.Scanner;

/**
 * Given a sum K and an array arr[] with non-negative numbers. Find whether a
 * contiguous array exists in the given array with sum K.
 * 
 * @author siddhartha.kumar
 *
 */
public class SlidingWindowSubArrayWithGivenSumOnlyPositiveNumber {

	/**
	 * This approach will not work for negative number because neagative numbers
	 * reduce the sum and in this approach we are reducing the sum if the sum
	 * becomes greater. So if the sum which is already reduced by the negative
	 * number present will not yield correct result as the reduced sum might get
	 * lesser than the given sum and since we are reducing the sum anyways so we
	 * might never reach to correct sum. e.g. : 4,7,-3,1,2 and the given sum = 9. In
	 * this array the sum exists : 4+7+(-3)+1 = 9 but in our approach 4+7=11 we will
	 * reduce this sum by 4 as it became greater than the given sum 9.Furhter more 7
	 * when added to -3 would reduce the sum further and thus we never reach to the
	 * value equal to given sum. The problem lies in the fact that in this approach
	 * we are relying on the fact the when adding the sum of the window we would
	 * reach a sum which would be greater than the given sum and then we would start
	 * removing the elements from this window to be able to reach the sum. But if we
	 * have negative numbers that the sum gets reduced once by removing the element
	 * from the window so that taking the negative number into account we would
	 * never reach to the given sum.
	 * 
	 * @param arr
	 * @param givenSum
	 * @return
	 */
	public boolean subArrayExistsWithGivenSum(int[] arr, int givenSum) {

		int sum = 0;
		int indexToRemove = 0;
		int i = 0;

		while (i < arr.length) {
			sum = sum + arr[i++];
			if (sum == givenSum)
				return true;
			while (sum > givenSum) {
				sum = sum - arr[indexToRemove++];
				if (sum == givenSum)
					return true;
			}
		}
		return false;
	}

	// e.g. :arr = { 1,3,4,4 }and givenSum = 9
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

			System.out.println("Please enter the value of given Sum : ");
			int givenSum = sc.nextInt();

			SlidingWindowSubArrayWithGivenSumOnlyPositiveNumber slidingWindowSubArrayWithGivenSum = new SlidingWindowSubArrayWithGivenSumOnlyPositiveNumber();
			boolean result = slidingWindowSubArrayWithGivenSum.subArrayExistsWithGivenSum(arr, givenSum);
			System.out.println("Whether the given sum : " + givenSum + " exists : " + result);
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