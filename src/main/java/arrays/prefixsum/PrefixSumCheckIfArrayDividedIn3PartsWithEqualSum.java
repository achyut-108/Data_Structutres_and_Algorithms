package arrays.prefixsum;

import java.util.Scanner;

public class PrefixSumCheckIfArrayDividedIn3PartsWithEqualSum {

	/**
	 * The idea is to first find the prefix sum array as pre-processing. Then the
	 * total sum is the prefix sum of the last element of the given array.
	 * 
	 * If the total sum is not completely divisible by 3 then the result is false.
	 * 
	 * Now iterating over the prefix sum array we try to find first element whose
	 * value is equal to totalSum/3 and increment the groupCount by 1. Lets say this
	 * index was i.
	 * 
	 * Now iterating the array from i+1 to last element we try to find next group of
	 * elements whose sum is equal to totalSum/3 in a while loop. If such sum exists
	 * we increment the groupCount by 1 and exit from the while loop. We update the
	 * i to the current index. We repeat this step until we reach the end of the
	 * array.
	 * 
	 * If the group count is equal to 3 we return true else false.
	 * 
	 * 
	 * @param arr
	 * @return
	 */
	public boolean checkWithExtraSpace(int[] arr) {

		int[] prefixSumArr = new int[arr.length];
		prefixSumArr[0] = arr[0];
		for (int i = 1; i < arr.length; i++) {
			prefixSumArr[i] = prefixSumArr[i - 1] + arr[i];
		}

		if (prefixSumArr[arr.length - 1] % 3 != 0)
			return false;

		int sum_arr_divide_by_3 = prefixSumArr[arr.length - 1] / 3;

		int group_count = 0;
		int i = 0;
		while (i < arr.length) {
			if (prefixSumArr[i++] == sum_arr_divide_by_3) {
				group_count++;
				break;
			}
		}

		for (i = i; i < prefixSumArr.length; i++) {
			int sum = 0;
			while (i < prefixSumArr.length) {
				sum = sum + arr[i++];
				if (sum == sum_arr_divide_by_3) {
					group_count++;
					break;
				}
			}

			i--;
		}

		return group_count == 3;
	}

	/**
	 * sum(arr[0]...arr[i]) = sum(arr[i+1]...arr[j]) = sum(arr[j+1]..arr[n-1]) =
	 * totalSum/3 prefixSum(i) = sum(arr[0]...arr[i]) = totalSum/3
	 * sum(arr[i+1]...arr[j]) = prefixSum(j) - prefixSum(i) = totalSum/3
	 * =>prefixSum(j) - prefixSum(i) = prefixSum(i) = totalSum/3 =>prefixSum(j) =
	 * 2*prefixSum(i) => prefixSum(j) = (2*totalSum)/3
	 * 
	 * So if we first find an index i whose prefix sum is equal to totalSum/3 and
	 * then if we find an index 'j' such that prefixSum(j) = (2*totalSum)/3 , then
	 * the there surely exists 3 groups whose sum is equal to totalSum/3 each.
	 * 
	 * We just need to find i and j as the first group ends with i,the second group
	 * starts with i+1 and ends with j and the last and third group starts with j+1.
	 * 
	 * prefixSum(i) = totalSum/3 and the sum(i+1...j) = totalSum/3 then j must be
	 * less than n(size of the array) which necessitates the presence of the third
	 * group.
	 * 
	 * 
	 * @param arr
	 * @return
	 */
	public boolean checkWithConstantSpace(int[] arr) {
		int totalSum = arr[0];
		for (int i = 1; i < arr.length; i++) {
			totalSum = totalSum + arr[i];
		}

		int firstIndex = -1, secondIndex = -1;

		if (totalSum % 3 != 0)
			return false;

		int totalSumBy3 = totalSum / 3;
		int preFixSum = arr[0];
		for (int i = 1; i < arr.length; i++) {
			// The check of firstIndex will make sure that the first the firstIndex is found
			// then only the second index.
			if (preFixSum == totalSumBy3 && firstIndex == -1) {
				firstIndex = i;
			}

			preFixSum = preFixSum + arr[i];

			// The check of firstIndex will make sure that the first the firstIndex is found
			// then only the second index.
			if (preFixSum == 2 * totalSumBy3 && firstIndex != -1) {
				secondIndex = i;
			}
		}

		return firstIndex >= 0 && secondIndex >= 0;
	}

	/**
	 * e.g. : 5,2,1,6,1,1,5 noOFElements=7 e.g. : 1,3,4,0,4 noOFElements=5
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

			PrefixSumCheckIfArrayDividedIn3PartsWithEqualSum prefixSumCheckIfArrayDividedIn3PartsWithEqualSum = new PrefixSumCheckIfArrayDividedIn3PartsWithEqualSum();
			boolean result1 = prefixSumCheckIfArrayDividedIn3PartsWithEqualSum.checkWithExtraSpace(arr);
			boolean result2 = prefixSumCheckIfArrayDividedIn3PartsWithEqualSum.checkWithConstantSpace(arr);
			System.out.println("Prefix Sum Method using extra space : Sum Can be divided into 3 parts : " + result1);
			System.out.println("Prefix Sum Method using constant space : Sum Can be divided into 3 parts : " + result2);
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