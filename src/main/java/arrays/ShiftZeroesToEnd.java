package arrays;

import java.util.Scanner;

public class ShiftZeroesToEnd {

	public int shift(int[] arr) {
		int numOfZeroes = 0;

		while (arr[numOfZeroes] == 0) {
			numOfZeroes++;
			if (numOfZeroes == arr.length) {
				break;
			}
		}

		if (numOfZeroes == arr.length)
			return numOfZeroes;

		if (numOfZeroes > 0) {
			arr[0] = arr[numOfZeroes];
		}

		int sizeWithoutZeroes = 1;
		for (int i = numOfZeroes + 1; i < arr.length; i++) {
			if (arr[i] != 0) {
				arr[sizeWithoutZeroes] = arr[i];
				sizeWithoutZeroes++;
			} else {
				numOfZeroes++;
			}
		}

		appendZeroesToEnd(arr, numOfZeroes);

		return numOfZeroes;
	}

	private void appendZeroesToEnd(int[] arr, int numOfZeroes) {
		int i = arr.length - 1;
		while (numOfZeroes > 0) {
			arr[i--] = 0;
			numOfZeroes--;
		}
	}

	public int shiftEfficient(int[] arr) {
		int count = 0;
		for (int i = 0; i < arr.length; i++) {
			if (arr[i] != 0) {
				int temp = arr[count];
				arr[count] = arr[i];
				arr[i] = temp;
				count++;
			}
		}

		return arr.length-count;
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

			ShiftZeroesToEnd shiftZeroesToEnd = new ShiftZeroesToEnd();
			int numOfZeroes = shiftZeroesToEnd.shiftEfficient(arr);
			System.out.println("The array after shifting zeoresto end : numOfZeroes : " + numOfZeroes);
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
