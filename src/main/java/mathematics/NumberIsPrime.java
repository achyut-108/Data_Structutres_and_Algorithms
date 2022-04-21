package mathematics;

import java.util.Scanner;

public class NumberIsPrime {

	public boolean isPrime(int number) {
		if (number == 1)
			return false;
		int divisor = 2;
		while (divisor < number) {
			if (number % (divisor++) == 0)
				return false;
		}

		return true;
	}

	/**
	 * A prime is definitely of the form 6n+1 and 6n-1 but that does not guarantee
	 * that it is prime. e.g: 25 = 6*4+1 is prime using formule primeNum = 6*n+1 ||
	 * 6*n-1 Wrong approach will fail for 25
	 * 
	 * @param number
	 * @return
	 */
	public boolean isPrimeWrongApproach(int number) {
		if (number == 1)
			return false;
		if (number == 2 || number == 3)
			return true;

		if (((number - 1) % 6) == 0 || ((number + 1) % 6) == 0) {
			return true;
		}

		return false;
	}

	/**
	 * This implementation is based on the fact that a composite number will have at
	 * least two factors such that one factor is below sqrRoot of the composite
	 * number and the other would be greater than it. So if we just check for the
	 * divisibility till the sqrRoot of the number we can ascertain that it is
	 * composite number or not. If such a number does not exist then the number
	 * would be prime,if a factor does not exist below the sqrRoot of the number
	 * then ther will be no factor beyond that as the number would exist as
	 * complement of the number below the sqrRoot of the number in question.
	 * 
	 * Also half of the checks can be minimised by cheking if the number is
	 * divisible by 2. It would minimise chekcing all the even numbers and the even
	 * number make upto half of the number series. Also divisibility check by 3
	 * would reduce the number of checks further. Now we can just ascertain by
	 * checking starting with 5 and adding 6 to it. Also before incerementing by 6
	 * checking by adding 2 to the number starting with 5.
	 * 
	 * 1,2,3,4,5,6,7,8,9,10,11,12,13,14,15,16,17,18,19 2 AND ITS FACOTRS CAN BE
	 * IGNORED AS if a number is divisible by 2 then it also divisible by its
	 * factors..same thing is applied to 3. The number beginning from 5 and adding 6
	 * to it and meanwhile adding 2 to it remains.
	 * 
	 * @param number
	 * @return
	 */
	public boolean isPrimeEfficient(int number) {
		if (number == 1)
			return false;
		if (number == 2 || number == 3)
			return true;
		if (number % 2 == 0 || number % 3 == 0)
			return false;

		for (int i = 5; i * i < number; i = i + 6) {
			if (number % i == 0 || number % (i + 2) == 0) {
				return false;
			}
		}

		return true;
	}

	public static void main(String[] args) {
		Scanner sc = null;
		try {

			sc = new Scanner(System.in);
			System.out.println("Please enter number to check for prime : ");
			Integer number = sc.nextInt();
			NumberIsPrime numberIsPrime = new NumberIsPrime();
			boolean result = numberIsPrime.isPrime(number);
			System.out.println("is prime : " + result);
			System.out.println("is prime Efficient tim complexing sqrRoot Optimised : " + result);

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
