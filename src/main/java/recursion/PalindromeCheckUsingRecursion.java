package recursion;

import java.util.Scanner;

/**
 * check if a String is palindrome. A String is palindrome when read from
 * beginning to end is same as when read from end to beginning.
 * 
 * e.g. : aabbcbbaa is palindrome. abcdd is not palindrome
 * 
 * @author siddhartha.kumar
 *
 */
public class PalindromeCheckUsingRecursion {

	/**
	 * Time complexity : O(n) Recurrence relation : T(n) = T(n-2) + O(1) Auxiliary
	 * Space : O(n) as total function calls is n/2 (e.g. : str length 10,then first
	 * call is with length 10,then with length 8,then 6 and so on.)
	 * 
	 * @param str
	 * @param lo
	 * @param hi
	 * @return
	 */
	public boolean isPalindrome(String str, int lo, int hi) {
		if (lo >= hi)
			return true;

		return (str.toCharArray()[lo] == str.toCharArray()[hi]) && isPalindrome(str, lo + 1, hi - 1);
	}

	public static void main(String[] args) {
		Scanner sc = null;
		try {
			sc = new Scanner(System.in);
			System.out.println("Please enter the String to check : ");
			String str = sc.nextLine();
			PalindromeCheckUsingRecursion palindromeCheckUsingRecursion = new PalindromeCheckUsingRecursion();
			boolean result = palindromeCheckUsingRecursion.isPalindrome(str, 0, str.length() - 1);
			System.out.println("is " + str + " palindrome : " + result);
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