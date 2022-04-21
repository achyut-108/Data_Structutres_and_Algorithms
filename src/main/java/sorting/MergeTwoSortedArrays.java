package sorting;

import java.util.Scanner;

public class MergeTwoSortedArrays {

	public int[] mergeSortedArrays(int[] arr1, int[] arr2) {
		int[] resultArr = new int[arr1.length + arr2.length];

		int index_arr1 = 0, index_arr2 = 0;

		for (int i = 0; i < resultArr.length; i++) {
			if (arr1[index_arr1] < arr2[index_arr2]) {
				resultArr[i] = arr1[index_arr1++];
			} else if (arr1[index_arr1] > arr2[index_arr2]) {
				resultArr[i] = arr2[index_arr2++];
			} else {
				resultArr[i++] = arr1[index_arr1++];
				resultArr[i] = arr2[index_arr2++];
			}

			if (index_arr1 == arr1.length) {
				while (i < resultArr.length && index_arr2 < arr2.length) {
					resultArr[++i] = arr2[index_arr2++];
				}
			}

			if (index_arr2 == arr2.length) {
				while (i < resultArr.length && index_arr1 < arr1.length) {
					resultArr[++i] = arr2[index_arr1++];
				}
			}
		}

		return resultArr;
	}

	public static void main(String[] args) {
		Scanner sc = null;
		try {
			sc = new Scanner(System.in);
			System.out.println("Please enter the size of the first array : ");
			int lengthOfFirstArray = sc.nextInt();
			int[] arr1 = new int[lengthOfFirstArray];
			System.out.println("Please enter the elements of the first array : ");

			for (int i = 0; i < lengthOfFirstArray; i++) {
				arr1[i] = sc.nextInt();
			}

			System.out.println("Please enter the size of the second array : ");
			int lengthOfSecondArray = sc.nextInt();
			int[] arr2 = new int[lengthOfSecondArray];
			System.out.println("Please enter the elements of the second array : ");

			for (int i = 0; i < lengthOfSecondArray; i++) {
				arr2[i] = sc.nextInt();
			}

			MergeTwoSortedArrays mergeTwoSortedArrays = new MergeTwoSortedArrays();
			int[] resultArr = mergeTwoSortedArrays.mergeSortedArrays(arr1, arr2);
			System.out.println("After Sorting : ");
			for (int i : resultArr) {
				System.out.println(i);
			}
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