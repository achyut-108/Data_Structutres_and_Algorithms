package bitMagic;

import java.util.Scanner;

import arrays.ShiftZeroesToEnd;

public class _2OddOcurringArray {

	public void _2OddOccurring(int[] arr) {

		int xor_arr = arr[0];
		for (int i = 1; i < arr.length; i++) {
			xor_arr = xor_arr ^ arr[i];
		}

		System.out.println("xor_arr : " + xor_arr);

		int _1stOdd = 0, _2ndOdd = 0;
		for (int i = 0; i < arr.length; i++) {
			if ((arr[i] & 1) == 0) {
				_1stOdd = arr[i] ^ _1stOdd;
			} else {
				_2ndOdd = arr[i] ^ _2ndOdd;
			}
		}
		System.out.println("The two odd occurring elements are : " + _1stOdd + " " + _2ndOdd);
	}

	public static void main(String[] args) {

//		System.out.println(5 ^ 6 ^ 5 ^ 6 ^ 7 ^ 8);
//		System.out.println(8 ^ 7);
//		System.out.println(15 ^ 16);
//		System.out.println(31 ^ 20 ^ 15 ^ 20 ^ 16);
//		System.out.println("20 and 11 : " + (15 & 31 & 16));
		Scanner sc = null;
		try {

			sc = new Scanner(System.in);
			System.out.println("Please enter the size of the integer array : ");
			int lengthOfArray = sc.nextInt();

			int[] arr = new int[lengthOfArray];

			System.out.println("Please enter the elements of the array : ");

			for (int i = 0; i < lengthOfArray; i++) {
				arr[i] = sc.nextInt();
			}

			_2OddOcurringArray _2OddOcurringArray = new _2OddOcurringArray();
			_2OddOcurringArray._2OddOccurring(arr);
			for (int i : arr) {
				System.out.println(i);
			}
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