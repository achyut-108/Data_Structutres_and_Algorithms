package arrays.prefixsum;

import java.util.Scanner;

import sun.security.util.Length;

public class PrefixSumArrayEquilibriumPoint {

	public static int[] prefixSumArr = null;

	public PrefixSumArrayEquilibriumPoint(int[] arr) {
		prefixSumArr = new int[arr.length];
		prefixSumArr[0] = 0;
		for (int i = 1; i < arr.length; i++) {
			prefixSumArr[i] = prefixSumArr[i - 1] + arr[i - 1];
		}
	}

	public boolean hasEquilibriumUsingPrefixSum(int[] arr) {

		for (int i = 0; i < arr.length; i++) {
			int sumAfter = (prefixSumArr[arr.length - 1] + arr[arr.length - 1]) - prefixSumArr[i] - arr[i];
			int sumBefore = prefixSumArr[i];
			if (sumAfter == sumBefore)
				return true;
		}

		return false;
	}

	/**
	 * we initialize two variables as beforeSum and afterSum.The idea is to first
	 * compute the total sum and store this value in after sum. Then For the first
	 * element the before sum is 0 and after sum is 'afterSum' minus the first
	 * element.The before sum of 'i' will be calculated in the 'i-1'th iteration by
	 * adding the 'i-1' th element to the before sum. The after sum of ith element
	 * will be calculated by substracting the ith element from the afterSum as in
	 * each iteration the afterSum is getting updated and is eqaul to the sum of all
	 * the elements starting from 'i' to last index of the array.
	 * 
	 * @param arr
	 * @return
	 */
	public boolean hasEquilibriumWithConstantSpace(int[] arr) {
		int afterSum = 0, beforeSum = 0;

		for (int i = 0; i < arr.length; i++) {
			afterSum = afterSum + arr[i];
		}

		for (int i = 0; i < arr.length; i++) {
			afterSum = afterSum - arr[i];

			if (beforeSum == afterSum)
				return true;

			beforeSum = beforeSum + arr[i];
		}

		return false;
	}

	/**
	 * e.g. :1) 3,4,8,-9,20,6 2) 4,2,-2 3) 2,-2,4
	 * 
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

			PrefixSumArrayEquilibriumPoint prefixSumArrayEquilibriumPoint = new PrefixSumArrayEquilibriumPoint(arr);
			boolean result = prefixSumArrayEquilibriumPoint.hasEquilibriumUsingPrefixSum(arr);
			System.out.println("Prefix Sum Method : The equilibrium exists : " + result);

			System.out.println("Constant space : The equilibrium exists : "
					+ prefixSumArrayEquilibriumPoint.hasEquilibriumWithConstantSpace(arr));
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