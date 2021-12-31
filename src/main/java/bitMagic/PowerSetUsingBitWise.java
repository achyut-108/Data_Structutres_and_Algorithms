package bitMagic;

import java.util.Scanner;

public class PowerSetUsingBitWise {

	public void powerSetUsingBitWise(String str) {

		int numOfSets = (int) Math.pow(2.0, str.length());
		char[] arr = str.toCharArray();
		for (int i = 0; i < numOfSets; i++) {
			int temp = i;
			if (i == 0)
				System.out.print("{}");
			int charIndex = 0;
			while (i != 0) {
				if ((i & 1) == 1) {
					System.out.print(arr[charIndex]);
				}
				i = i >> 1;
				charIndex++;
			}

			i = temp;
			System.out.println(" i is : " + i);
		}

	}

	public static void main(String[] args) {

		Scanner sc = null;
		try {
			sc = new Scanner(System.in);
			System.out.println("Please enter the size of the integer array : ");
			String str = sc.nextLine();
			PowerSetUsingBitWise powerSetUsingBitWise = new PowerSetUsingBitWise();
			powerSetUsingBitWise.powerSetUsingBitWise(str);
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