package searchAlgorithms;

import java.util.Arrays;
import java.util.Scanner;

public class PythagoreanTriplet {

	public boolean pythagoreanTripletExists(int[] arr) {

		Arrays.sort(arr);

		for (int j : arr) {
			System.out.println(j);
		}
		System.out.println("sorted...");
		for (int i = 0; i < arr.length; i++) {
			int sum = arr[i] * arr[i];

			int lo = 0, hi = arr.length - 1;
//4 49 1 59 19 81 97 99 82 90 99 10 58 73 23
			while (lo < hi) {
				int squareSum = (arr[lo] * arr[lo]) + (arr[hi] * arr[hi]);
				if (squareSum == sum) {
					System.out.println("triplet : " + i + " " + lo + " " + hi);
					return true;
				} else if (squareSum > sum) {
					hi = hi - 1;
				} else {
					lo = lo + 1;
				}

				if (lo == i)
					lo = lo + 1;
				else if (hi == i)
					hi = hi - 1;
			}

		}

		return false;
	}

	public boolean pythagoreanTripletEasyToUnderstand(int[] arr) {

		Arrays.sort(arr);
		for (int i = 0; i < arr.length; i++) {
			int sum = arr[i] * arr[i];
			int lo = 0;
			int hi = arr.length - 1;

			while (lo < hi) {
				if (lo == i)
					lo = lo + 1;
				else if (hi == i)
					hi = hi - 1;
				int squareSum = arr[lo] * arr[lo] + arr[hi] * arr[hi];
				if (squareSum == sum) {
					return true;
				} else if (squareSum > sum) {
					hi--;
				} else {
					lo++;
				}
			}
		}

		return false;
	}

	public static void main(String[] args) {
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

			PythagoreanTriplet pythagoreanTriplet = new PythagoreanTriplet();
			boolean result = pythagoreanTriplet.pythagoreanTripletExists(arr);
			System.out.println("Pythagorean Triplet Exists : " + result);
			System.out.println(
					"pythagoreanTripletEasyToUnderstand " + pythagoreanTriplet.pythagoreanTripletEasyToUnderstand(arr));
		} catch (Exception ex) {
			System.out.println("Excpetion raised in main : " + ex);
		} finally {
			if (sc != null) {
				sc.close();
			}
		}
	}
}