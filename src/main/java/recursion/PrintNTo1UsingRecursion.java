package recursion;

import java.util.Scanner;

/**
 * For a positive number 'n' print number from n to 1
 * 
 * @author siddhartha.kumar
 *
 */
public class PrintNTo1UsingRecursion {

	/**
	 * Time Complexity : T(n) = T(n-1) + 1; Space Complexity : O(n) as we have n+1
	 * function call stacks. The last function call being print(0).
	 * 
	 * @param n
	 */
	public void print(int n) {
		if (n <= 0)
			return;
		System.out.println(n);
		print(n - 1);
	}

	public static void main(String[] args) {
		Scanner sc = null;
		try {

			sc = new Scanner(System.in);
			System.out.println("Please enter N : ");
			int number = sc.nextInt();
			PrintNTo1UsingRecursion printNTo1UsingRecursion = new PrintNTo1UsingRecursion();
			printNTo1UsingRecursion.print(number);
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