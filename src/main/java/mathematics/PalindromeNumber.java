package mathematics;

import java.util.Scanner;

public class PalindromeNumber {

	/**
	 * Last digit of a number can be found by '%' operator
	 * @param number
	 * @return
	 */
	public boolean isPalindrome(int number) {

		int origNum = number;
		int reversedNum = 0;

		while (origNum != 0) {
			reversedNum = (origNum % 10) + reversedNum * 10;
			origNum = origNum / 10;
		}

		System.out.println("reversedNum is : " + reversedNum);
		return (number - reversedNum) == 0;
	}

	/**
	 * e.g.: 78987,363,123,367
	 * @param args
	 */
	public static void main(String[] args) {
		Scanner sc = null;
		try {
			sc = new Scanner(System.in);
			System.out.println("Please enter the number to check palindrome : ");
			Integer number = sc.nextInt();
			PalindromeNumber palindromeNumber = new PalindromeNumber();
			boolean result = palindromeNumber.isPalindrome(number);
			System.out.println("is Palindrome : " + result);
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
