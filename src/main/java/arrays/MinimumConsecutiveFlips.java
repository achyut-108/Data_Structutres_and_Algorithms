package arrays;

import java.util.Scanner;

/**
 * Array contains 1's and 0's only. Find out total number of minimum flips group
 * of consecutive 1's or 0's so that all the elements of the array becomes
 * either 0 or 1.
 * 
 * @author siddhartha.kumar
 *
 */
public class MinimumConsecutiveFlips {

	public void flip(int[] arr) {
		int count_zero = 0;
		int count_one = 0;

		for (int i = 0; i < arr.length; i++) {
			if (arr[i] == 0) {
				while (i < arr.length && arr[i] == 0) {
					i++;
				}
				count_zero++;
				i--;
			}

			if (arr[i] == 1) {
				while (i < arr.length && arr[i] == 1) {
					i++;
				}
				count_one++;
				i--;
			}
		}

		int minEelement = count_zero < count_one ? 0 : 1;
		if (count_one == 0 || count_zero == 0)
			return;

		for (int i = 0; i < arr.length; i++) {
			if (arr[i] == minEelement) {
				System.out.print("From index " + i + " to index ");
				while (i < arr.length && arr[i] == minEelement) {
					i++;
				}
				System.out.print(--i);
				System.out.println("");
			}
		}
	}

	/**
	 * The property is : The difference between the number of groups of 0 and 1 can
	 * be either 1 or 0. If the array contains all 1s or 0s then the difference is
	 * 0. If the array contains a mix of 1s and 0s,then the difference depends on
	 * the fact that with what digit the array starts and with what digit the array
	 * ends. If the start digit and the end digit is same then the number of groups
	 * of this digit will always be greater else the number of groups would be equal
	 * e.g. : 111 000 101001000111 --> Clearly the number of group of 1s is higher
	 * than that of 0.\ e.g. : 000111010100010011 --> Here the number of groups of
	 * both the 1s and the 0s are same.
	 * 
	 * @param arr
	 */
	public void minimumFlipsUsingProperty(int[] arr) {
		for (int i = 0; i < arr.length; i++) {
			// find out the index from where the the group of digit
			// other than the first digit starts.
			while (i < arr.length && arr[i] == arr[0]) {
				i++;
			}

			// This condition indicates that we have reached
			// end of the array and all the digits are same as the first digit.
			if (i == arr.length)
				return;

			System.out.print("From index : " + i + " ");
			int temp = arr[i];
			while (i < arr.length && arr[i] == temp) {
				i++;
			}
			System.out.print("To index : " + --i);
			System.out.println("");
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

			MinimumConsecutiveFlips minimumConsecutiveFlips = new MinimumConsecutiveFlips();
			minimumConsecutiveFlips.minimumFlipsUsingProperty(arr);
			for (int i : arr) {
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
