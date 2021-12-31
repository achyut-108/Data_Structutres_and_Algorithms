package bitMagic;

import java.util.Scanner;

public class CheckPowerof2 {

	/**
	 * Brian Curnigham Algorithm
	 * 
	 * @param n
	 * @return
	 */
	public boolean checkPowerOf2(int n) {

		int count = 0;

		while (n != 0) {
			n = n & (n - 1);
			count++;
			if (count > 1)
				return false;
		}

		return true;
	}

	/**
	 * The solution is based on the fact that the number which is power of 2 will
	 * have only one set bit.
	 * 
	 * @param n
	 * @return
	 */
	public boolean isPow2Optimised(int n) {
		return n > 0 && ((n & (n - 1)) == 0);
	}

	public static void main(String[] args) {
		Scanner sc = null;
		try {

			sc = new Scanner(System.in);
			System.out.println("Please enter the number to check : ");
			int numberToCheck = sc.nextInt();
			CheckPowerof2 checkPowerof2 = new CheckPowerof2();
			boolean result = checkPowerof2.isPow2Optimised(numberToCheck);
			System.out.println("The number : " + numberToCheck + " is power of 2 : " + result);
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
