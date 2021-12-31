package bitMagic;

import java.util.Scanner;

/**
 * Find out how many bits are 1 or set in the given number.
 * 
 * @author siddhartha.kumar
 *
 */
public class CountSetBits {

	/**
	 * The idea is to first initialise the count by taking 'and' of the number with
	 * '1'. if the last bit is 1 then this operation would result in a value 1 as in
	 * 1 we have all zeroes and the 'and' of zero with 1 is zero. So whatever be the
	 * bit value at position other then the last postion the result would be zero.If
	 * the number 'n' last bit is '0' then the result would be zero and hence count
	 * zero,but if the last bit is 1 then the result would be '1' and hence count
	 * would be initialized as 1.
	 * 
	 * Since the int in java is represented as 32 bit then we will right shift each
	 * bit starting from the second bit by 1. In doing so the ith bit(the bit being
	 * shifted) would come at the end. By doing 'and' operation with '1' would
	 * result in count as 1 or 0 depending whether the ith bit is 1 or 0.
	 *
	 * 
	 * @param n
	 * @return
	 */
	public int countUsingRightShift(int n) {
		System.out.println("start n is : " + n);
		int count = n & 1;

		for (int i = 1; i < 32; i++) {
			count = count + ((n >> i) & 1);
		}

		System.out.println("end n is : " + n);
		return count;

	}

	/**
	 * On doing 'and' operation with 1 the last bit if it is '1' would produce the
	 * result as 1 else 0 and accordingly the count would be updated. After this the
	 * number 'n' would be updated by doing a Unsigned right shift by one position which
	 * would move the the 'last-1'th bit to last position. In other words one set
	 * bit if any would be removed. This would be done for all the bits in 'n'. In
	 * this way one by one all the set bits would become zero. The loop will thus
	 * stop when n becomes zero.
	 * 
	 * The below method does not need to know how many bits are present in 'n'.
	 * 
	 * @param n
	 * @return
	 */
	public int countUsingUnsignedRightShiftOptimised(int n) {
		System.out.println("start n is : " + n);
		int count = 0;

		while (n != 0) {
			count = count + (n & 1);
			n = n >>> 1;
		}

		System.out.println("end n is : " + n);
		return count;

	}

	/**
	 * Brian Curnigham Algorithm : If we substract 1 from a number then in the
	 * result the first set bit from the end position becomes 0 and rest all bits
	 * till this bit(from end) becomes 1.
	 * 
	 * If we do (n & (n-1)) then in the result till the first set bit would become
	 * zero.
	 * 
	 * e.g. : n = 5 0000....101 n-1 = 4 0000....100 (n & (n-1)) = 0000....100
	 * 
	 * If we repeat the above operation by also updating the n as (n & (n-1)) and
	 * keep increaing the count till n becomes zero,we will get the number of set
	 * bits.
	 * 
	 * The above method will only run for set bits only as in every step one set bit
	 * is getting zero.
	 * 
	 * @param n
	 * @return
	 */
	public int countUsingBrianCurnigham(int n) {
		System.out.println("start n is : " + n);
		int count = 0;

		while (n != 0) {
			n = (n & (n - 1));
			count++;
		}

		System.out.println("end n is : " + n);
		return count;

	}

	public static void main(String[] args) {
		Scanner sc = null;
		try {

			sc = new Scanner(System.in);
			System.out.println("Please enter the number to check : ");
			int numberToCheck = sc.nextInt();
			CountSetBits countSetBits = new CountSetBits();
			int result = countSetBits.countUsingUnsignedRightShiftOptimised(numberToCheck);
			System.out.println("Total number of set bit is : " + result);
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
