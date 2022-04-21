package searchAlgorithms;

import java.util.Arrays;
import java.util.Scanner;

/**
 * hash map approach is much better if allowed to have extra space
 * 
 * @author siddhartha.kumar
 *
 */
public class CountPairsWithGivenSumInASortedArray {

	public int countPairs(int[] arr, int givenSum) {
		Arrays.sort(arr);
		int result = 0;
		int lo = 0, hi = arr.length - 1;

		while (lo < hi) {
			System.out.println("lo : " + lo + " hi : " + hi);
			if (arr[lo] + arr[hi] == givenSum) {
				result++;
				int lo_previous = lo;
				lo = lo + 1;
				while (lo < hi && arr[lo_previous] == arr[lo]) {
					lo++;
					result++;
				}
				lo = lo_previous;
				hi--;
			} else if (arr[lo] + arr[hi] < givenSum) {
				lo++;
			} else {
				hi--;
			}
		}

		return result;
	}

	/**
	 * -1,1,5,7 sum = 6 ans-> 2 1,1,1,1 sum =2 ans-> 6 -1,1,5,5,7 sum=6 ans->3
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

			System.out.println("Please enter the sum for which to find the pair : ");

			for (int i = 0; i < lengthOfArray; i++) {
				arr[i] = sc.nextInt();
			}

			System.out.println("Please enter the sum to check : ");
			int givenSum = sc.nextInt();
			CountPairsWithGivenSumInASortedArray countPairsWithGivenSumInASortedArray = new CountPairsWithGivenSumInASortedArray();
			int result = countPairsWithGivenSumInASortedArray.countPairs(arr, givenSum);
			System.out.println("No of pairs : " + result);

		} catch (Exception ex) {
			ex.printStackTrace();
			System.out.println("Excpetion raised in main : " + ex);
		} finally {
			if (sc != null) {
				sc.close();
			}
		}
	}
}