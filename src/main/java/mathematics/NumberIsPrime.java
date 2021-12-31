package mathematics;

import java.util.Scanner;

public class NumberIsPrime {

	public boolean isPrime(int number) {
		if (number == 1)
			return false;
		int divisor = 2;
		while (divisor < number) {
			if (number % (divisor++) == 0)
				return false;
		}

		return true;
	}

	public boolean isPrimeEfficient(int number) {
		if (number == 1)
			return false;
		if (number == 2 || number == 3)
			return true;

		if (((number - 1) % 6) == 0 || ((number + 1) % 6) == 0) {
			return true;
		}

		return false;
	}

	public static void main(String[] args) {
		Scanner sc = null;
		try {

			sc = new Scanner(System.in);
			System.out.println("Please enter number to check for prime : ");
			Integer number = sc.nextInt();
			NumberIsPrime numberIsPrime = new NumberIsPrime();
			boolean result = numberIsPrime.isPrime(number);
			System.out.println("is prime : " + result);
			System.out.println("is prime using formule primeNum = 6*n+1 || 6*n-1 : " + result);

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
