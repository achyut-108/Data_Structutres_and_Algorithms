package mathematics;

import java.util.Scanner;

public class GreatestCommonDivisor {

	public int gcd(int a, int b) {
		if (a == 0 || b == 0)
			return 0;
		int result = 1;

		int smaller = a > b ? b : a;
		int greater = a > b ? a : b;

		while (smaller != 0) {
			int remainder = greater % smaller;
			if (remainder == 0) {
				return smaller;
			} else {
				greater = smaller;
				smaller = remainder;
			}
		}

		return result;
	}

	/**
	 * e.g.:1. a=15,b=10 --> (15,10) --> (10,5) --> (5,0) 2. a = 10,b=15 --> (10,15)
	 * --> (15,(10%15)==10)-->(10,5)-->(5,0)
	 * 
	 * @param a
	 * @param b
	 * @return
	 */
	public int gcdUsingRecursion(int a, int b) {
		if (b == 0)
			return a;

		return gcdUsingRecursion(b, a % b);
	}

	public static void main(String[] args) {
		Scanner sc = null;
		try {
			sc = new Scanner(System.in);
			System.out.println("Please enter first number : ");
			Integer a = sc.nextInt();
			System.out.println("Please enter second number : ");
			Integer b = sc.nextInt();
			GreatestCommonDivisor gcd = new GreatestCommonDivisor();
			int result = gcd.gcd(a, b);
			System.out.println("gcd is : " + result);
			System.out.println("gcd using recursion : " + gcd.gcdUsingRecursion(a, b));

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
