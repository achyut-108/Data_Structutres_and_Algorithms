package recursion;

import java.util.Scanner;

public class FibonacciNumber {

	public int printFib(int n) {
		if (n == 0)
			return 0;
		if (n == 1)
			return 1;

		return printFib(n - 1) + printFib(n - 2);
	}

	public static void main(String[] args) {
		Scanner sc = null;
		try {

			sc = new Scanner(System.in);
			System.out.println("Please enter N : ");
			int number = sc.nextInt();
			FibonacciNumber fibonacciNumber = new FibonacciNumber();
			int result = fibonacciNumber.printFib(number);
			System.out.println("Fibonacci of number n is : " + result);
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
