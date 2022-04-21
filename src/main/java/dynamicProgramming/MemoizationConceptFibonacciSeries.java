package dynamicProgramming;

import java.util.Arrays;
import java.util.Scanner;

public class MemoizationConceptFibonacciSeries {

	int[] memo = null;
	int number = -1;

	public MemoizationConceptFibonacciSeries(int number) {
		memo = new int[number + 1];
		Arrays.fill(memo, -1);
		this.number = number;
	}

	public int fib() {
		return fib(this.number);
	}

	private int fib(int number) {
		if (number == 0 || number == 1)
			return number;

		if (memo[number] == -1) {
			int result = fib(number - 1) + fib(number - 2);
			memo[number] = result;
		}

		return memo[number];

	}

	public static void main(String[] args) {
		Scanner sc = null;
		try {
			sc = new Scanner(System.in);
			System.out.println("Please enter which fibonacci number you require : ");
			int number = sc.nextInt();

			MemoizationConceptFibonacciSeries memoizationConceptFibonacciSeries = new MemoizationConceptFibonacciSeries(
					number);
			int result = memoizationConceptFibonacciSeries.fib();
			System.out.println("The required fibnacci number is  : " + result);
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