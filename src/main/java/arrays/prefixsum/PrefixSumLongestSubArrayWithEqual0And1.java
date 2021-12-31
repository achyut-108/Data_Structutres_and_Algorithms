package arrays.prefixsum;

import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;

public class PrefixSumLongestSubArrayWithEqual0And1 {

	/**
	 * The idea is to generate a prefix sum (after changing the 0 to -1) of the 0
	 * and 1 array and then see if the prefix sum of any index gets repeated. If the
	 * prefix sum comes to be same then it means the sum of the elements after the
	 * first index(first prefix sum) and till the next index of the same prefix sum
	 * the sum is equal to zero and because of this only the prefix sum of the
	 * second index comes to be same.
	 * 
	 * @param arr
	 * @return
	 */
	public int longestSubArrayWithEqualZeroesAndOnes(int[] arr) {

		int prefixSum = 0;
		Map<Integer, Integer> indexMap = new HashMap<Integer, Integer>();
		int result = 0;
		for (int i = 0; i < arr.length; i++) {
			if (arr[i] == 0)
				arr[i] = -1;
			prefixSum = prefixSum + arr[i];
			if (indexMap.containsKey(prefixSum)) {
				int tempResult = i - indexMap.get(prefixSum);
				result = tempResult > result ? tempResult : result;
			} else {
				indexMap.put(prefixSum, i);
			}
		}

		return result;
	}

	/**
	 * e.g. : 0,0,0,1,1,0,0,0,0,1 size:10
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

			PrefixSumLongestSubArrayWithEqual0And1 prefixSumLongestSubArrayWithEqual0And1 = new PrefixSumLongestSubArrayWithEqual0And1();
			int result = prefixSumLongestSubArrayWithEqual0And1.longestSubArrayWithEqualZeroesAndOnes(arr);
			System.out.println("Longest sub-array with 0 and 1 : " + result);

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