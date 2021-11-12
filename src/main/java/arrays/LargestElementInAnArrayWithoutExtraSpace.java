package arrays;

import java.util.Scanner;

public class LargestElementInAnArrayWithoutExtraSpace {

	public int getLargestElement(int[] arr) throws Exception {
		if (arr.length <= 0)
			throw new Exception("Pleae provide array with elements");

		int result = 0;
		for (int i = 1; i < arr.length; i++) {
			if (arr[i] > arr[result]) {
				result = i;
			}
		}

		System.out.println("The largest element is : " + arr[result] + " present at : " + result);
		return result;
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

			LargestElementInAnArrayWithoutExtraSpace largestElementInAnArray = new LargestElementInAnArrayWithoutExtraSpace();
			int result = largestElementInAnArray.getLargestElement(arr);
		} catch (Exception ex) {
			System.out.println("Exception raise in main : " + ex);
		} finally {
			if (sc != null) {
				sc.close();
			}
		}
	}

}
