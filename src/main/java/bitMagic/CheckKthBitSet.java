package bitMagic;

import java.util.Scanner;

/**
 * The integers in java are represented in 2's complement. Given a number N and
 * a number K (K < the OS bit representation). Find out if the Kth bit is set
 * i.e. is '1'
 * 
 * @author siddhartha.kumar
 *
 */
public class CheckKthBitSet {

	/**
	 * The following approach uses the fact that the representation of 1 is all 0s
	 * and at the end 1. If this binary representation is left shifted k-1 times
	 * then naturally the Kth position of the 1(in binary representation) would be
	 * 1. Now here we have all zeroes and only one at the Kth position. If we do
	 * 'and' of 'N' with the left shifted 1 then if the Kth bit of N is 1 then we
	 * will have a non-zero number else zero.
	 * 
	 * @param n
	 * @param k
	 * @return
	 */
	public boolean isBitSet(int n, int k) {

		return ((((1 << (k - 1)) & n) != 0));

	}

	/**
	 * The following approach uses the fact that the number n when right shifted k-1
	 * times then the kth bit would come at the end and when we do 'and' operation
	 * with 1,then if the bit is set we will get 1 as in 1 there are all 0s and only
	 * one '1' at the end.
	 * 
	 * @param n
	 * @param k
	 * @return
	 */
	public boolean isBitSetByRightShift(int n, int k) {
		return (((n >> k - 1) & 1) == 1);
	}

	public static void main(String[] args) {
		Scanner sc = null;
		try {

			sc = new Scanner(System.in);
			System.out.println("Please enter the number to check : ");
			int numberToCheck = sc.nextInt();
			System.out.println("Please enter the value of K : ");
			int K = sc.nextInt();

			CheckKthBitSet checkKthBitSet = new CheckKthBitSet();
			boolean result = checkKthBitSet.isBitSetByRightShift(numberToCheck, K);
			System.out.println("If the " + K + "th bit is set : " + result);
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