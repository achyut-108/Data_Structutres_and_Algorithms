package arrays.prefixsum;

import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;

public class PrefixSumSubArrayAnyNumberWithGivenSum {

	public boolean givenSumExists(int[] arr, int givenSum) {

		boolean result = false;
		int currentSum = 0;
		Map<Integer, Integer> preFixSumMap = new HashMap<Integer, Integer>();
		for (int i = 0; i < arr.length; i++) {
			currentSum = currentSum + arr[i];
			if (currentSum == givenSum) {
				System.out.println("The start index is : " + 0);
				System.out.println("THe end index is : " + i);
				return true;
			}

			if (preFixSumMap.containsKey(currentSum - givenSum)) {

				System.out.println("The start index is : " + preFixSumMap.get(currentSum - givenSum) + 1);
				System.out.println("THe end index is : " + i);

				return true;
			}

			preFixSumMap.put(currentSum, i);
		}

		return result;

	}

	/**
	 * e.g. : 4,7,-3,1,2 size : 5
	 * @param args
	 */
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

			System.out.println("Please enter the sum to check : ");
			int givenSum = sc.nextInt();

			PrefixSumSubArrayAnyNumberWithGivenSum prefixSumSubArrayAnyNumberWithGivenSum = new PrefixSumSubArrayAnyNumberWithGivenSum();
			boolean result = prefixSumSubArrayAnyNumberWithGivenSum.givenSumExists(arr, givenSum);
			System.out.println("The given sum : " + givenSum + " exists : " + result);

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