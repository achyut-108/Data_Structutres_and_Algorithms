package arrays;

import java.util.Scanner;

public class FrequenciesInSortedArray {

	public void printFrequencies(int[] arr) {
		int i = 0;
		while (i < arr.length) {
			int temp = arr[i];
			int frequency = 0;
			while (i < arr.length) {
				if (arr[i] == temp) {
					frequency++;
					i++;
				} else
					break;
			}
			System.out.println("The frquency of " + temp + " is : " + frequency);
		}
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

			FrequenciesInSortedArray frequnciesInSortedArray = new FrequenciesInSortedArray();
			frequnciesInSortedArray.printFrequencies(arr);
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