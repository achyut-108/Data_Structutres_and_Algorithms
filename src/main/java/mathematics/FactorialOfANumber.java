package mathematics;

import java.util.Scanner;

/**
 * Given a number greater or equal to zero find the factorial of it.
 * 
 * @author siddhartha.kumar
 *
 */
public class FactorialOfANumber {

	public int fact(int n) {
		if (n == 0)
			return 1;
		return n * fact(n - 1);
	}

	public int factIterative(int n) {
		int result = 1;
		while (n != 1) {
			result = result * (n);
			n = n - 1;
		}

		return result;
	}

	public static void main(String[] args) {
		Scanner sc = null;
		try {
			sc = new Scanner(System.in);
			System.out.println("Please enter the number to calculate Factorial : ");
			Integer number = sc.nextInt();
			FactorialOfANumber factorialOfANumber = new FactorialOfANumber();
			int result = factorialOfANumber.fact(number);
			System.out.println("Factorial is : " + result);
			System.out.println("Factorial using iterative approach : " + factorialOfANumber.factIterative(number));
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
