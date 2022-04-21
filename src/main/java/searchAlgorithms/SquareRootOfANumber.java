package searchAlgorithms;

import java.util.Scanner;

public class SquareRootOfANumber {

	public int sqrt(int number) {

		if (number == 0)
			return 0;
		if(number < 0) number = number * -1;

		int lo = 1;
		int hi = number;
		int result = -1;
		while (lo <= hi) {
			int median = (lo + hi) / 2;
			int toSearch = median * median;
			if (toSearch > number) {
				hi = median - 1;
			} else if (toSearch < number) {
				lo = median + 1;
				result = median;
			}else {
				result = median;
				break;
			}
		}

		return result;
	}

	public static void main(String[] args) {
		Scanner sc = null;
		try {

			sc = new Scanner(System.in);
			System.out.println("Please enter the nuber to find the square root : ");

			int number = sc.nextInt();
			SquareRootOfANumber squareRootOfANumber = new SquareRootOfANumber();
			int ocurrences = squareRootOfANumber.sqrt(number);

			System.out.println("Square root  : " + ocurrences);

		} catch (Exception ex) {
			System.out.println("Excpetion raised in main : " + ex);
		} finally {
			if (sc != null) {
				sc.close();
			}
		}
	}
}