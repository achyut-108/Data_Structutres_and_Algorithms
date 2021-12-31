package recursion;

import java.util.Scanner;

public class FactorialOfN {

	public int fact(int n) {
		if (n <= 0)
			return 0;
		if (n == 1)
			return 1;

		return n * fact(n - 1);
	}

	public int factTailRecursion(int n, int result) {
		if (n <= 0)
			return 0;
		if (n == 1)
			return 1;

		result = result * n;
		System.out.println("result : " + result);
		return factTailRecursion(n - 1, result);
	}

	public int factTailRecursion(int n) {
		int result = n == 0 ? 0 : 1;
		return factTailRecursion(n, result);
	}

	public static void main(String[] args) {
		Scanner sc = null;
		try {

			sc = new Scanner(System.in);
			System.out.println("Please enter N : ");
			int number = sc.nextInt();
			FactorialOfN factorialOfN = new FactorialOfN();
			int result = factorialOfN.factTailRecursion(number);
			System.out.println("Factorial of n is : " + result);
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