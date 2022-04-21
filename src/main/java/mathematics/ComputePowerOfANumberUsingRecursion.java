package mathematics;

import java.util.Scanner;

import arrays.RemoveDuplicatesFromSortedArray;

public class ComputePowerOfANumberUsingRecursion {

	/**
	 * x^n = x^n/2 * x^n/2 (if n is even) if n is odd : x^n = x^n/2 * x^n/2 * x
	 * 
	 * @param number
	 * @param power
	 * @return
	 */
	public int computePower(int number, int power) {
		int result = 1;
		if (power == 0)
			return 1;
		int temp = computePower(number, power / 2);
		result = temp * temp;
		if (power % 2 == 0) {
			return result;
		} else {
			return result * number;
		}
	}

	public static void main(String[] args) {
		Scanner sc = null;
		try {

			sc = new Scanner(System.in);
			System.out.println("Please enter the number to compute power : ");
			int number = sc.nextInt();
			System.out.println("Please enter the power : ");
			int power = sc.nextInt();
			ComputePowerOfANumberUsingRecursion computePowerOfANumber = new ComputePowerOfANumberUsingRecursion();
			int result = computePowerOfANumber.computePower(number, power);
			System.out.println("The power is  : " + result);

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