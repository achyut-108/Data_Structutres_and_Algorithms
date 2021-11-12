package arrays;

import java.util.Scanner;

public class CheckArraySortedInIncreasingOrder {

	public boolean checkSortedInIncreasingOrder(int[] arr) {
		int i = 0;
		while (i < arr.length - 1) {
			if (arr[i] > arr[++i]) {
				return false;
			}
		}

		return true;
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

			CheckArraySortedInIncreasingOrder checkArraySortedInIncreasingOrder = new CheckArraySortedInIncreasingOrder();
			boolean result = checkArraySortedInIncreasingOrder.checkSortedInIncreasingOrder(arr);
			if (result)
				System.out.println("Array is sorted !");
			else
				System.out.println("Array not sorted !");

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
