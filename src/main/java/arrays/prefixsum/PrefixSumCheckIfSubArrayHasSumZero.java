package arrays.prefixsum;

import java.util.HashSet;
import java.util.Map;
import java.util.Scanner;
import java.util.Set;

public class PrefixSumCheckIfSubArrayHasSumZero {

	/**
	 * The sub array exists if any element is zero(as single element of the array is
	 * also a sub-array) or the sum till that point(prefix sum) is zero or the
	 * prefix sum is repeated.
	 * 
	 * If the prefix sum of i and the prefix sum of j (such that j > i) are equal it
	 * means to prefixSum(i) only 'zero' was added to it till jth element to get the
	 * prefixSum(j) as prefixSum(j) = prefixSum(i) + sumOfAllElements(i+1...j)
	 * 
	 * if prefixSum(j) = prefixSum(i),then sumOfAllElements(i+1...j) = 0 which means
	 * there is sub-array from 'i+1' to 'j' whose sum is equal to zero.
	 * 
	 * @param arr
	 * @return
	 */
	public boolean subArrayWithZeroExists(int[] arr) {

		int prefixSum = 0;
		Set<Integer> distinctPrefixSumSet = new HashSet<Integer>();
		for (int i = 0; i < arr.length; i++) {
			prefixSum = prefixSum + arr[i];
			if (arr[i] == 0 || prefixSum == 0 || distinctPrefixSumSet.contains(prefixSum)) {
				return true;
			}
			distinctPrefixSumSet.add(prefixSum);
		}

		return false;
	}

	/**
	 * e.g. : 1,4,-2,-2,5,-4,3 noOfElements : 7 e.g.: 4,2,0,1,6 noOfElements : 5
	 * e.g. : 4,2,-3,1,6 noOfElements : 5
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

			PrefixSumCheckIfSubArrayHasSumZero prefixSumCheckIfSubArrayHasSumZero = new PrefixSumCheckIfSubArrayHasSumZero();
			boolean result1 = prefixSumCheckIfSubArrayHasSumZero.subArrayWithZeroExists(arr);
			System.out.println("Prefix Sum Method using extra space : Sum Can be divided into 3 parts : " + result1);

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
