package arrays;

import java.util.Scanner;

/**
 * To find out the length of the maximum alternating even-odd array
 * 
 * @author siddhartha.kumar
 *
 */
public class LongestEvenOddAubArray {

	// Test with : 5,10,20,6,3,8
	// Test with : 10,12,14,7,8
	/**
	 * Kadane's Algorithm
	 * @param arr
	 * @return
	 */
	public int longestArray(int[] arr) {
		int result = 1;
		int currentResult = result;
		boolean even = arr[0] % 2 == 0;
		for (int i = 1; i < arr.length; i++) {
			/**
			 * XNOR operation .. if the previous element is even then the ith element 
			 * should be odd and vice versa.
			 */
			if (even == (arr[i] % 2 != 0)) {
				currentResult++;
				even = arr[i] % 2 == 0;
				result = Math.max(currentResult, result);
			}else {
				currentResult = 1;
			}
		}

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

			LongestEvenOddAubArray longestEvenOddAubArray = new LongestEvenOddAubArray();
			int result = longestEvenOddAubArray.longestArray(arr);
			System.out.println("The length of the longest consecutive even-odd array is : " + result);
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
