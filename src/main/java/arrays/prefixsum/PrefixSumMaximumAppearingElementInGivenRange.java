package arrays.prefixsum;

import java.util.Scanner;

public class PrefixSumMaximumAppearingElementInGivenRange {

	public int maxAppearingELement(int[] loRange, int[] hiRange) {
		int[] preFixSumArr = new int[1000];
		for (int i = 0; i < loRange.length; i++) {
			preFixSumArr[loRange[i]] = 1;
			preFixSumArr[hiRange[i] + 1] = -1;
		}

		int maXOccuringElement = preFixSumArr[0];
		for (int i = 1; i < preFixSumArr.length; i++) {
			preFixSumArr[i] = preFixSumArr[i - 1] + preFixSumArr[i];
			if (maXOccuringElement < preFixSumArr[i])
				maXOccuringElement = preFixSumArr[i];
		}

		return maXOccuringElement;
	}

	public static void main(String[] args) {
		Scanner sc = null;
		try {
			sc = new Scanner(System.in);
			System.out.println("Please enter the size of the loRange and hiRange array : ");
			int lengthOfArray = sc.nextInt();
			int[] loRangeArr = new int[lengthOfArray];
			int[] hiRangeArr = new int[lengthOfArray];
			System.out.println("Please enter the elements of the loRange array : ");

			for (int i = 0; i < lengthOfArray; i++) {
				loRangeArr[i] = sc.nextInt();
			}

			System.out.println("Please enter the elements of hiRange array : ");

			for (int i = 0; i < lengthOfArray; i++) {
				hiRangeArr[i] = sc.nextInt();
			}

			PrefixSumMaximumAppearingElementInGivenRange prefixSumMaximumAppearingElementInGivenRange = new PrefixSumMaximumAppearingElementInGivenRange();
			int result = prefixSumMaximumAppearingElementInGivenRange.maxAppearingELement(loRangeArr, hiRangeArr);
			System.out.println("The max ocurring element is : " + result);

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