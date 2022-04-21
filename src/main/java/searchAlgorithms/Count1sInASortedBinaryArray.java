package searchAlgorithms;

import java.util.Scanner;

public class Count1sInASortedBinaryArray {

	public int numberOf1s(int[] arr) {

		int lo = 0, hi = arr.length - 1;
		int firstOcurrence = -1;
		while (lo <= hi) {
			int median = (lo + hi) / 2;
			if (arr[median] < 1) {
				lo = median + 1;
			} else {// since it is a binary array so the numbers would be either 1 or less than 1
					// that is 0;
				if (median == 0 || arr[median - 1] != 1) {
					firstOcurrence = median;
					break;
				} else {
					hi = median - 1;
				}
			}
		}

		if (firstOcurrence != -1) {
			return arr.length - firstOcurrence;
		}

		return 0;
	}

	public static void main(String[] args) {
		Scanner sc = null;
		try {

			sc = new Scanner(System.in);
			System.out.println("Please enter the size of the binary array : ");
			int lengthOfArray = sc.nextInt();

			int[] arr = new int[lengthOfArray];

			System.out.println("Please enter the elements of the binary array : ");

			for (int i = 0; i < lengthOfArray; i++) {
				arr[i] = sc.nextInt();
			}

			Count1sInASortedBinaryArray count1sInASortedBinaryArray = new Count1sInASortedBinaryArray();
			int ocurrences = count1sInASortedBinaryArray.numberOf1s(arr);

			System.out.println("Number of 1s in the array : " + ocurrences);

		} catch (Exception ex) {
			System.out.println("Excpetion raised in main : " + ex);
		} finally {
			if (sc != null) {
				sc.close();
			}
		}
	}
}