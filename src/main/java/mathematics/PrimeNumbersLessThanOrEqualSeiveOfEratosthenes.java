package mathematics;

import java.util.Arrays;
import java.util.Scanner;

public class PrimeNumbersLessThanOrEqualSeiveOfEratosthenes {

	/**
	 * Time Complexity : O(n*SquareRootOfN)
	 * 
	 * @param number
	 */
	public void printPrimeNumbersNaiveApproach(int number) {

		if (number == 1)
			return;
		for (int i = 2; i <= number; i++) {
			if (isPrime(i)) {
				System.out.println(i);
			}
		}
	}

	public void seiveOfErastosThenesApproach(int number) {

		boolean[] seive = new boolean[number + 1];
		Arrays.fill(seive, true);

		for (int i = 2; i*i <= number; i++) {
			if (seive[i] == true) {
				for (int j = 2*i; j <= number; j = j + i) {
					seive[j] = false;
				}
			}
		}

		for (int i = 2; i <= number; i++) {
			if (seive[i] == true)
				System.out.println(i);
		}
	}

	/**
	 * Time Complexity : O(NLogLogN)
	 * @param number
	 */
	public void seiveOfErastosThenesApproachOptimised(int number) {

		boolean[] seive = new boolean[number + 1];
		Arrays.fill(seive, true);

		for (int i = 2; i <= number; i++) {
			if (seive[i] == true) {
				System.out.println(i);
				for (int j = i*i; j <= number; j = j + i) {
					seive[j] = false;
				}
			}
		}
	}

	
	private boolean isPrime(int number) {
		if (number == 2 || number == 3)
			return true;
		if (number == 1 || number % 2 == 0 || number % 3 == 0)
			return false;

		for (int i = 5; i * i <= number; i = i + 6) {
			if (number % i == 0 || number % (i + 2) == 0)
				return false;
		}

		return true;
	}

	public static void main(String[] args) {
		Scanner sc = null;
		try {
			sc = new Scanner(System.in);
			System.out.println("Please enter number to print the prime numbers upto this point : ");
			Integer number = sc.nextInt();
			PrimeNumbersLessThanOrEqualSeiveOfEratosthenes primeNumbersLessThanOrEqualSeiveOfEratosthenes = new PrimeNumbersLessThanOrEqualSeiveOfEratosthenes();
			primeNumbersLessThanOrEqualSeiveOfEratosthenes.printPrimeNumbersNaiveApproach(number);
			System.out.println("Using seive of Erastothenes approach : ");
			primeNumbersLessThanOrEqualSeiveOfEratosthenes.seiveOfErastosThenesApproach(number);
			System.out.println("Using Seive of Erastothenes approach optimised : ");
			primeNumbersLessThanOrEqualSeiveOfEratosthenes.seiveOfErastosThenesApproachOptimised(number);
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