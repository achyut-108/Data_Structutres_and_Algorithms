package arrays;

import java.util.Scanner;

public class MaximumConsesutiveOnes {

	public int maxConsecutiveOnes(int[] arr) {
		int result = 0;

		for (int i = 0; i < arr.length; i++) {
			int tempResult = 0;
			while (i < arr.length && arr[i] == 1) {
				tempResult = tempResult + 1;
				i++;
			}
			if (result < tempResult)
				result = tempResult;
		}

		return result;
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

			MaximumConsesutiveOnes maximumConsesutiveOnes = new MaximumConsesutiveOnes();
			int result = maximumConsesutiveOnes.maxConsecutiveOnes(arr);
			System.out.println("The max Consecutive 1's is : " + result);
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
