package bitMagic;

import java.util.Scanner;

public class FirstSetBit {

	public int firstSetBitPosition(int number) {
		int result = 0;
		int count = 0;
//		if (number % 2 != 0)
//			return 0;

		while (result <= 0) {
			result = (number & 1);
			number = number >>> 1;//the number becomes half.
			//System.out.println("count : " + count);
			count++;
		}

		
		return count;
	}
	
	public static void main(String[] args) {
		Scanner sc = null;
		try {

			sc = new Scanner(System.in);
			System.out.println("Please enter the number to check : ");
			int numberToCheck = sc.nextInt();
			FirstSetBit firstSetBit = new FirstSetBit();
			int result = firstSetBit.firstSetBitPosition(numberToCheck);
			System.out.println("Total first set bit is : " + result);
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