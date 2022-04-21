package searchAlgorithms;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Scanner;

public class CountTripletsWithGivenSum {

	/**
	 * This takes duplicate triplet as well if the numbers in the array repeat
	 * themselves.
	 * 
	 * @param arr
	 * @param givenSum
	 * @return
	 */
	public int countTriplet(int[] arr, int givenSum) {
		int result = 0;
		Arrays.sort(arr);
		for (int i = 0; i < arr.length; i++) {
			int sum = givenSum - arr[i];
			int lo = i + 1, hi = arr.length - 1;
			while (lo < hi) {
				if (arr[lo] + arr[hi] == sum) {
					result++;
					int lo_previous = lo;
					lo = lo + 1;
					while (lo < hi && arr[lo_previous] == arr[lo]) {
						result++;
						lo++;
					}

					lo = lo_previous;
					hi--;
				} else if (arr[lo] + arr[hi] > sum) {
					hi--;
				} else {
					lo++;
				}
			}

		}

		return result;

	}

	/**
	 * Below implementation count distinct triplets.
	 * 
	 * @param arr
	 * @return
	 */
	public List<List<Integer>> countTripletsWithSumZero(int[] arr) {
		int result = 0;
		Arrays.sort(arr);
		int givenSum = 0;
		List<List<Integer>> resultList = new ArrayList<List<Integer>>();
		for (int i = 0; i < arr.length; i++) {
			if (i != 0 && arr[i] == arr[i - 1])
				continue;
			int sum = givenSum - arr[i];
			int lo = i + 1;
			int hi = arr.length - 1;

			while (lo < hi) {
				// At this point we are encountering the element at lo for the first time
				if (arr[lo] + arr[hi] == sum) {
					List<Integer> interMediateList = new ArrayList<Integer>();
					interMediateList.add(arr[i]);
					interMediateList.add(arr[lo]);
					interMediateList.add(arr[hi]);
					resultList.add(interMediateList);
					result++;
					lo++;
					hi--;
					// after incrementing the 'lo' by 1 we need to make sure that the element at
					// 'lo-1'(previous lo) is not same as this. If it is same then we have already
					// considered this triplet.
					while (lo < hi && arr[lo] == arr[lo - 1]) {
						lo++;
					}
				} else if (arr[lo] + arr[hi] > sum) {
					hi--;
				} else {
					lo++;
				}
			}

		}

		return resultList;
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

			System.out.println("Please enter the sum to check : ");
			int givenSum = sc.nextInt();
			CountTripletsWithGivenSum countTripletsWithGivenSum = new CountTripletsWithGivenSum();
			int result = countTripletsWithGivenSum.countTriplet(arr, givenSum);
			System.out.println("Total number of Triplets : " + result);

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