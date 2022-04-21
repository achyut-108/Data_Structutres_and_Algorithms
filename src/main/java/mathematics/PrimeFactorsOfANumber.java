package mathematics;

import java.util.Scanner;

public class PrimeFactorsOfANumber {

	/**
	 * i <= SqrtOfN i^2 <= N
	 * 
	 * @param number
	 */
	public void primeFactors(int number) {

		if (number <= 1)
			return;

		for (int i = 2; i * i <= number; i++) {

			if (isPrimeEfficient(i)) {
				while (number % i == 0) {
					System.out.println(i);
					number = number / i;
				}
			}
		}

		if (number > 1)
			System.out.println(number);
	}

	/**
	 * Worst case Time Complexity : sqrtRootOfN
	 * 
	 * @param number
	 */
	public void primeFactorsEfficient(int number) {
		if (number <= 1)
			return;

		while (number % 2 == 0) {
			System.out.println(2);
			number = number / 2;
		}

		while (number % 3 == 0) {
			System.out.println(3);
			number = number / 3;
		}

		for (int i = 5; i * i <= number; i = i + 6) {
			while (number % i == 0) {
				System.out.println(i);
				number = number / i;
			}

			while (number % (i + 2) == 0) {
				System.out.println(i + 2);
				number = number / (i + 2);
			}
		}

		if (number > 3)
			System.out.println(number);

	}

	public boolean isPrimeEfficient(int number) {
		if (number == 1)
			return false;
		if (number == 2 || number == 3)
			return true;
		if (number % 2 == 0 || number % 3 == 0)
			return false;

		for (int i = 5; i * i < number; i = i + 6) {
			if (number % i == 0 || number % (i + 2) == 0) {
				return false;
			}
		}

		return true;
	}

	public static void main(String[] args) {
		Scanner sc = null;
		try {

			sc = new Scanner(System.in);
			System.out.println("Please enter number to calculate prime factors : ");
			Integer number = sc.nextInt();
			PrimeFactorsOfANumber primeFactorsOfANumber = new PrimeFactorsOfANumber();
			primeFactorsOfANumber.primeFactors(number);
			System.out.println("Prime Factors Efficient !! ");
			primeFactorsOfANumber.primeFactorsEfficient(number);

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