package arrays;

import java.util.Scanner;

/**
 * 
 * @author siddhartha.kumar
 *
 */
public class SearchInUnSortedArray {

	/**
	 * if the itemitemToSearch found returns an integer >=0 else returns -1.
	 * 
	 * @param arr
	 * @param itemToSearch
	 * @return
	 */
	public int search(int[] arr, int itemToSearch) {

		for (int i = 0; i < arr.length; i++) {
			if (arr[i] == itemToSearch) {
				return i;
			}
		}

		return -1;
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

			System.out.println("Please enter the integer to search in the array : ");

			int itemToSearch = sc.nextInt();

			SearchInUnSortedArray searchInUnSortedArray = new SearchInUnSortedArray();
			int result = searchInUnSortedArray.search(arr, itemToSearch);

			if (result >= 0) {
				System.out.println("The integer is present at index : " + result);
				return;
			}

			System.out.println("The integer is not present !!");
		} catch (Exception ex) {
			System.out.println("Excpetion raise in main : " + ex);
		} finally {
			if (sc != null) {
				sc.close();
			}
		}
	}
}
