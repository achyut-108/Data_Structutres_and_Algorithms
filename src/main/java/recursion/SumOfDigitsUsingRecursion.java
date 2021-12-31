package recursion;

import java.util.Scanner;

/**
 * given a integer in the form of String,find the sum of digits in the integer.
 * 
 * @author siddhartha.kumar
 *
 */
public class SumOfDigitsUsingRecursion {

	public int sumOfDigits(String str, int startIndex) {

		if (startIndex == str.length() - 1)
			return Integer.parseInt(String.valueOf(str.toCharArray()[str.length() - 1]));
		return Integer.parseInt(String.valueOf(str.toCharArray()[startIndex])) + sumOfDigits(str, startIndex + 1);
	}

	public int sumOfDigits(String str, int lo, int hi) {
		if (lo == hi)
			return Integer.parseInt(String.valueOf(str.toCharArray()[lo]));
		if (lo > hi)
			return 0;
		return Integer.parseInt(String.valueOf(str.toCharArray()[lo]))
				+ Integer.parseInt(String.valueOf(str.toCharArray()[hi])) + sumOfDigits(str, lo + 1, hi - 1);
	}

	public int sumOfDigitsWithIntegerInput(Integer number) {
		if (number == 0)
			return 0;
		return (number % 10) + sumOfDigitsWithIntegerInput(number / 10);
	}

	public int sumOfDigitsUsingIteration(int number) {
		int result = 0;
		while (number > 0) {
			result = result + number % 10;
			number = number / 10;
		}
		return result;
	}

	public static void main(String[] args) {
		Scanner sc = null;
		String str = null;
		try {
			sc = new Scanner(System.in);
			System.out.println("Please enter the Integer to check : ");
			str = sc.nextLine();
			Integer integer = Integer.parseInt(str);
			SumOfDigitsUsingRecursion sumOfDigitsUsingRecursion = new SumOfDigitsUsingRecursion();
			int result = sumOfDigitsUsingRecursion.sumOfDigits(str, 0);
			int result_hi_lo = sumOfDigitsUsingRecursion.sumOfDigits(str, 0, str.length() - 1);
			int resultIntegerInput = sumOfDigitsUsingRecursion.sumOfDigitsWithIntegerInput(integer);
			int resultUsingIteration = sumOfDigitsUsingRecursion.sumOfDigitsUsingIteration(integer);

			// System.out.println("Sum of digits : " + result + " result_hi_lo : " +
			// result_hi_lo);
			System.out.println("resultIntegerInput : " + resultIntegerInput);
			System.out.println("resultUsingIteration : " + resultUsingIteration);
		} catch (NumberFormatException nfe) {
			System.out.println("Please enter a valid integer ! " + str);
			nfe.printStackTrace();
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
