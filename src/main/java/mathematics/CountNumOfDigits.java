package mathematics;

import java.util.Scanner;

public class CountNumOfDigits {

	public int countNumOfDigits(int number) {
		int count = 0;

		while (number != 0) {
			number = number / 10;// removes the last digit
			count++;
		}

		return count;
	}

//	public static void main(String[] args) {
//		System.out.println(" / result : " + 20 / 10);
//		System.out.println("% result : " + 20 % 10);
//	}

	public static void main(String[] args) {
		Scanner sc = null;
		try {
			sc = new Scanner(System.in);
			System.out.println("Please enter the number to count its digit : ");
			Integer number = sc.nextInt();
			CountNumOfDigits countNumOfDigits = new CountNumOfDigits();
			int result = countNumOfDigits.countNumOfDigits(number);
			System.out.println("Numf of digits : " + result);
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
