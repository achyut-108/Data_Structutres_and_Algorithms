package mathematics;

import java.util.Scanner;

public class DivisorsOfANumber {

	public void printDivisors(int number) {
		for (int i = 1; i <= number; i++) {
			if (number % i == 0)
				System.out.println(i);
		}
	}

	/**
	 * Following implementation wont give the result in sorted order.
	 * 
	 * @param number
	 */
	public void printDivisorsSqrtN(int number) {
		for (int i = 1; i * i <= number; i++) {
			if (number % i == 0) {
				System.out.println(i);
				// To check for perfect sqaures..e.g: 25 as we want to print unique
				if (i != number / i)
					System.out.println(number / i);
			}

		}
	}

	/**
	 * The following implementation would give the result in sorted order.
	 * 
	 * @param number
	 */
	public void printDivisorsSqrtNSortedOrder(int number) {
		int i = 1;
		// Here checking from 1 to sqrt of N
		for (; i * i < number; i++) {
			if (number % i == 0) {
				System.out.println(i);
			}
		}

		// Here checking from Sqrt of N to 1 and printing the other element of the pair.
		for (; i >= 1; i--) {
			if (number % i == 0)
				System.out.println(number / i);
		}
	}

	/**
	 * Not correct implmentation
	 * 
	 * @param number
	 */
	public void printDivisorsEfficient(int number) {

		System.out.println(1);
		int i = 2;
		while (number % i == 0) {
			System.out.println(i);
			i = i + 2;
		}

		i = 3;
		while (number % i == 0) {
			System.out.println(i);
			i = i + 3;
		}
		for (i = 5; i < number; i = i + 6) {
			if (number % i == 0)
				System.out.println(i);
			if (number % (i + 2) == 0)
				System.out.println(i + 2);
		}

		System.out.println(number);
	}

	public static void main(String[] args) {
		Scanner sc = null;
		try {

			sc = new Scanner(System.in);
			System.out.println("Please enter number to print divisors : ");
			Integer number = sc.nextInt();
			DivisorsOfANumber divisorsOfANumber = new DivisorsOfANumber();
			divisorsOfANumber.printDivisors(number);
			System.out.println("Print divisors Efficient : ");
			divisorsOfANumber.printDivisorsEfficient(number);
			System.out.println("Print divisors SqrtN");
			divisorsOfANumber.printDivisorsSqrtN(number);
			System.out.println("Print divisors SqrtN Sorted");
			divisorsOfANumber.printDivisorsSqrtNSortedOrder(number);

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
