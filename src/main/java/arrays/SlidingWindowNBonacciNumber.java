package arrays;

import java.util.Scanner;

/**
 * ith N-Bonacci Number is sum of previous 'i-1' numbers.
 * 
 * @author siddhartha.kumar
 *
 */
public class SlidingWindowNBonacciNumber {

	public int[] nBonacciNumber(int N, int numOfBonacciNumber) {
		int[] arr = new int[numOfBonacciNumber];
		for (int i = 0; i < arr.length; i++) {
			if (i < N - 1) {
				arr[i] = 0;
			} else if (i == N - 1 || i == N) {
				arr[i] = 1;
			} else {
				arr[i] = 2 * arr[i - 1] - arr[i - 1 - N];
			}
		}

		return arr;
	}

	public static void main(String[] args) {
		Scanner sc = null;
		try {
			sc = new Scanner(System.in);
			System.out.println("Please enter the value of N : ");
			int N = sc.nextInt();
			System.out.println("Please enter num of N-Bonacci number required : ");
			int numOfNBonacciNumbers = sc.nextInt();

			SlidingWindowNBonacciNumber slidingWindowNBonacciNumber = new SlidingWindowNBonacciNumber();
			int[] resultArr = slidingWindowNBonacciNumber.nBonacciNumber(N, numOfNBonacciNumbers);

			System.out.println("Below are the N-Bonacci Numbers : ");
			for (int i : resultArr) {
				System.out.println(i);
			}
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