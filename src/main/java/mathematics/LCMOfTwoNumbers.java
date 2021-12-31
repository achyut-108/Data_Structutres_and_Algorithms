package mathematics;

import java.io.Serializable;
import java.util.Scanner;

public class LCMOfTwoNumbers implements Serializable{

	/**
	 * 
	 */
	private static final long serialVersionUID = 3336904604128341670L;

	/**
	 * time complexity : O(max(a,b)) Reason : In the worst case the LCM would be the
	 * product of two numbers. So since we are multiplying the number the min(a,b)
	 * starting from '1',so it can go at max till the max(a,b).
	 * 
	 * @param a
	 * @param b
	 * @return
	 */
	public int lcm(int a, int b) {
		if (a == 0 || b == 0)
			return a;
		int min = Math.min(a, b);
		int max = Math.max(a, b);
		int multiplier = 1;
		int result = min;
		while (result % max != 0) {
			result = min * (++multiplier);
		}

		return result;
	}

	/**
	 * a*b = gcd(a,b) * lcm(a,b) lcm(a,b) = (a*b)/gcd(a,b)
	 * 
	 * @param a
	 * @param b
	 * @return
	 */
	public int lcmUsingGcd(int a, int b) {
		int gcd_a_b = gcd(a, b);
		return (a * b) / gcd_a_b;
	}

	private int gcd(int a, int b) {
		if (b == 0)
			return a;
		return gcd(b, a % b);
	}

	public static void main(String[] args) {
		Scanner sc = null;
		try {
			sc = new Scanner(System.in);
			System.out.println("Please enter first number : ");
			Integer a = sc.nextInt();
			System.out.println("Please enter second number : ");
			Integer b = sc.nextInt();
			LCMOfTwoNumbers lcm = new LCMOfTwoNumbers();
			int result = lcm.lcm(a, b);
			System.out.println("lcm is : " + result);
			System.out.println("lcm using gcd : " + lcm.lcmUsingGcd(a, b));

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
