package arrays;

import java.util.Scanner;

public class ReverseTheArray {

	public void reverse(int[] arr) {
		int low = 0;
		int high = arr.length - 1;

		/**
		 * This loop will run almost N/2 times. So Time complexity : O(N) and space Complexity : O(1)
		 * as storing in 'temp' variable.
		 */
		while (low < high) {
			System.out.println("Before Swapping low is : " + low + " high is : " + high);
			int temp = arr[low];
			arr[low++] = arr[high];
			arr[high--] = temp;
			System.out.println("After Swapping low is : " + low + " high is : " + high);
		}
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

			ReverseTheArray reverseTheArray = new ReverseTheArray();
			reverseTheArray.reverse(arr);
			System.out.println("The array after reversal :");
			for(int i : arr) {
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
