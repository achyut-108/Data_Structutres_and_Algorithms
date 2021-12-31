package recursion;

import java.util.Scanner;

/**
 * Find the sum of first n natural number.
 * 
 * @author siddhartha.kumar
 *
 */
public class SumOfFirstNNaturalNumber {

	/**
	 * There exists a direct formula for sum of first n number : (n*(n+1))/2 But
	 * here we will use recursion to find the sum.
	 * 
	 * Time Complexity : O(n) , Space Complexity : O(n)
	 * 
	 * @param n
	 * @return
	 */
	public int sum(int n) {

		if (n == 0)
			return 0;

		return sum(n - 1) + n;

	}

	public static void main(String[] args) {
		Scanner sc = null;
		try {
			sc = new Scanner(System.in);
			System.out.println("Please enter N : ");
			int number = sc.nextInt();
			SumOfFirstNNaturalNumber sunFirstNNaturalNumber = new SumOfFirstNNaturalNumber();
			int result = sunFirstNNaturalNumber.sum(number);
			System.out.println("Sum of " + number + " consecutive number is : " + result);
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