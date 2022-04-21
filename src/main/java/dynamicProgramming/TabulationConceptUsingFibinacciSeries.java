package dynamicProgramming;

import java.util.Arrays;
import java.util.Scanner;

public class TabulationConceptUsingFibinacciSeries {

	int[] dp_arr = null;

	public int fib(int number) {
		dp_arr = new int[number + 1];
		Arrays.fill(dp_arr, -1);
		return fib_inner(number);
	}

	/**
	 * Bottom up approach Time Complexity : O(n) Space Complexity : O(n) This
	 * problem of finding nth Fibonacci number has a better solution using matrix
	 * multiplication method using divide and conquer approach.
	 * 
	 * @param number
	 * @return
	 */
	public int fib_inner(int number) {

		dp_arr[0] = 0;
		dp_arr[1] = 1;

		if (dp_arr[number] != -1)
			return dp_arr[number];

		for (int i = 2; i <= number; i++) {
			dp_arr[i] = dp_arr[i - 1] + dp_arr[i - 2];
		}

		return dp_arr[number];
	}

	public static void main(String[] args) {
		Scanner sc = null;
		try {
			sc = new Scanner(System.in);
			System.out.println("Please enter the number to calculate fibonaccci : ");
			int number = sc.nextInt();

			TabulationConceptUsingFibinacciSeries tabulationConceptUsingFibinacciSeries = new TabulationConceptUsingFibinacciSeries();
			int result = tabulationConceptUsingFibinacciSeries.fib(number);
			System.out.println("The fibonacci number at : " + number + " is : " + result);

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