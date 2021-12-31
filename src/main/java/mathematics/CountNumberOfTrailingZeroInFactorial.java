package mathematics;

import java.util.List;
import java.util.Scanner;

public class CountNumberOfTrailingZeroInFactorial {

	/**
	 * The idea is that zero is contributed by the presence of 2 and 5 in the
	 * factorial. The number of 2 will always be greater than the number of 5 as the
	 * number of even numbers would be at least half.
	 * 
	 * If we can just count the number of 5 present then we can say there are as man
	 * zeroes in the factorial of the given number.
	 * 
	 * The 5 is found at every 5th position either itself or in combination with
	 * some factor (such as 2,3,4,etc..) If there is a single 5 either it self or in
	 * combination with some other number,then its count can be easily calculated by
	 * getting the quotient by dividing it with 5. e.g: For 31 we have
	 * 5,10,15,20,25,30 total 6 or 31/5=6. But the number 25 in the factorial
	 * contributes to two 5 so the number shall be similarly divided by 25 and the
	 * quotient should be added to the previous quotient.Similarly if the given
	 * number is less than or equal to 125 then the number will be divided by 125
	 * and the quotient will be added to the previous result.
	 * 
	 * @param number
	 * @return
	 */
	public int countNumOfTrailingZero(int number) {
		int count = 0;

		for (int i = 5; i <= number; i = i * 5) {
			count = count + (number / i);
		}

		return count;
	}

	public static void main(String[] args) {
		Scanner sc = null;
		try {
			sc = new Scanner(System.in);
			System.out.println("Please enter the number to find the trailing number of zeroes in its factorial : ");
			Integer number = sc.nextInt();
			CountNumberOfTrailingZeroInFactorial countNumberOfTrailingZeroInFactorial = new CountNumberOfTrailingZeroInFactorial();
			int result = countNumberOfTrailingZeroInFactorial.countNumOfTrailingZero(number);
			System.out.println("Trailing number of zeroes : " + result);

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
