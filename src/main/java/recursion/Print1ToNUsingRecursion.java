package recursion;

import java.util.Scanner;

/**
 * Given a positive integer N,print 1 to N.
 * 
 * @author siddhartha.kumar
 *
 */
public class Print1ToNUsingRecursion {

	public void print(int n) {
		if (n <= 0)
			return;
		print(n - 1);
		System.out.println(n);
	}

	public static void main(String[] args) {
		Scanner sc = null;
		try {

			sc = new Scanner(System.in);
			System.out.println("Please enter N : ");
			int number = sc.nextInt();
			Print1ToNUsingRecursion print1ToNUsingRecursion = new Print1ToNUsingRecursion();
			print1ToNUsingRecursion.print(number);
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