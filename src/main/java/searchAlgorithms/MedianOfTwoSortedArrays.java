package searchAlgorithms;

import java.util.Scanner;

public class MedianOfTwoSortedArrays {

	/**
	 * Following approach uses the method of merging two sorted arrays.
	 * 
	 * @param arr1
	 * @param arr2
	 * @return
	 */
	public double medianOfTwoSortedArrays(int[] arr1, int[] arr2) {
		int result = 0;
		int index_arr1 = 0, index_arr2 = 0;
		int resultIndex = -1;

		int medianIndex = (arr1.length + arr2.length) / 2;
		System.out.println("medianIndex : " + medianIndex);
		boolean isEven = (arr1.length + arr2.length) % 2 == 0;

		while (index_arr1 < arr1.length || index_arr2 < arr2.length) {

			if (index_arr1 < arr1.length && (index_arr2 > arr2.length - 1 || arr1[index_arr1] <= arr2[index_arr2])) {
				resultIndex++;
				System.out.println("###resultIndex : " + resultIndex + " index_arr1 : " + index_arr1);
				if (isEven && (resultIndex == medianIndex - 1)) {
					System.out.println("###resultIndex even : : " + resultIndex + " value : " + arr1[index_arr1]);
					result = result + arr1[index_arr1];
				} else if (resultIndex == medianIndex) {
					System.out.println("###resultIndex even/odd : : " + resultIndex + " value : " + arr1[index_arr1]);
					result = result + arr1[index_arr1];
					break;
				}
				index_arr1++;

			} else if (index_arr2 < arr2.length) {
				resultIndex++;
				System.out.println("@@@resultIndex : " + resultIndex + " index_arr2 : " + index_arr2 + " "
						+ (isEven && (resultIndex == medianIndex - 1)));
				if (isEven && (resultIndex == medianIndex - 1)) {
					System.out.println("@@@resultIndex even : : " + resultIndex + " value : " + arr2[index_arr2]);
					result = result + arr2[index_arr2];
				} else if (resultIndex == medianIndex) {
					System.out.println("@@@resultIndex even/odd : : " + resultIndex + " value : " + arr2[index_arr2]);
					result = result + arr2[index_arr2];
					break;
				}
				index_arr2++;
			}
		}

		if (isEven)
			return (double) result / 2;
		else
			return result;
	}

	public static void main(String[] args) {
		Scanner sc = null;
		try {

			sc = new Scanner(System.in);
			System.out.println("Please enter the size of the first integer array : ");
			int lengthOfArray1 = sc.nextInt();

			int[] arr1 = new int[lengthOfArray1];

			System.out.println("Please enter the elements of the first array : ");

			for (int i = 0; i < lengthOfArray1; i++) {
				arr1[i] = sc.nextInt();
			}

			System.out.println("Please enter the size of the second integer array : ");
			int lengthOfArray2 = sc.nextInt();

			int[] arr2 = new int[lengthOfArray2];

			System.out.println("Please enter the elements of the second array : ");

			for (int i = 0; i < lengthOfArray2; i++) {
				arr2[i] = sc.nextInt();
			}

			// int[] arr3 = new int[] { 10, 20, 30, 40, 50 };

			// int arr4[] = new int[] { 5, 15, 25, 35, 45 };

			MedianOfTwoSortedArrays medianOfTwoSortedArrays = new MedianOfTwoSortedArrays();
			double result = medianOfTwoSortedArrays.medianOfTwoSortedArrays(arr1, arr2);
			System.out.println("Median : " + result);
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