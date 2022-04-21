package sorting;

import java.util.Scanner;

public class UnionOfTwoSortedArrays {

	public void union(int[] arr1, int[] arr2) {
		int index_arr1 = 0, index_arr2 = 0;

		while (index_arr1 < arr1.length && index_arr2 < arr2.length) {

			if (arr1[index_arr1] < arr2[index_arr2]) {
				System.out.println(arr1[index_arr1]);
				index_arr1++;
			} else if (arr1[index_arr1] > arr2[index_arr2]) {
				System.out.println(arr2[index_arr2]);
				index_arr2++;
			} else {
				System.out.println(arr1[index_arr1]);
				index_arr1++;
				index_arr2++;
			}

			while (index_arr1 > 0 && index_arr1 < arr1.length && arr1[index_arr1 - 1] == arr1[index_arr1]) {
				index_arr1++;
			}

			while (index_arr2 > 0 && index_arr2 < arr2.length && arr2[index_arr2 - 1] == arr2[index_arr2]) {
				index_arr2++;
			}

		}

		while (index_arr1 < arr1.length) {
			if (index_arr1 > 0 && arr1[index_arr1 - 1] == arr1[index_arr1]) {
				index_arr1++;
				continue;
			} else
				System.out.println(arr1[index_arr1++]);
		}

		System.out.println("index_arr2 : " + index_arr2);
		while (index_arr2 < arr2.length) {
			if (index_arr2 > 0 && arr2[index_arr2 - 1] == arr2[index_arr2]) {
				index_arr2++;
				continue;
			} else
				System.out.println(arr2[index_arr2++]);
		}

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

			UnionOfTwoSortedArrays unionOfTwoSortedArrays = new UnionOfTwoSortedArrays();
			unionOfTwoSortedArrays.union(arr1, arr2);

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