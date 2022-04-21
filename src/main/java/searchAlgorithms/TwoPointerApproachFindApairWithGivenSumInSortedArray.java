package searchAlgorithms;

import java.util.Scanner;

public class TwoPointerApproachFindApairWithGivenSumInSortedArray {

	public boolean pairExists(int[] arr, int sum) {
		int lo = 0, hi = arr.length - 1;

		while (lo < hi) {

			if (arr[lo] + arr[hi] == sum) {
				System.out.println("Pair Exists at : " + lo + " hi .. " + hi);
				return true;
			} else if (arr[lo] + arr[hi] > sum) {
				hi = hi - 1;
			} else {
				lo = lo + 1;
			}
		}

		return false;
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

			System.out.println("Enter the sum for which the pair needs to be found : ");
			int sum = sc.nextInt();

			TwoPointerApproachFindApairWithGivenSumInSortedArray twoPointerApproachFindApairWithGivenSumInSortedArray = new TwoPointerApproachFindApairWithGivenSumInSortedArray();
			boolean result = twoPointerApproachFindApairWithGivenSumInSortedArray.pairExists(arr, sum);
			System.out.println("Pair Exists : " + result);

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