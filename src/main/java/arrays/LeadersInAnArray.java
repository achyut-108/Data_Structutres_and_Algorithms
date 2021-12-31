package arrays;

import java.util.Scanner;

public class LeadersInAnArray {

	public int[] leaders(int[] arr) {
		System.out.println("Leaders are : ");
		int currentLeader = arr[arr.length - 1];
		System.out.println(currentLeader);
		
		/**
		 * If the current element is greater than the current leader then it is also a
		 * leader.
		 */
		for (int i = arr.length - 2; i >= 0; i--) {
			if (arr[i] > currentLeader) {
				currentLeader = arr[i];
				System.out.println(currentLeader);
			}
		}

		return arr;
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

			LeadersInAnArray leadersInAnArray = new LeadersInAnArray();
			int[] leaders = leadersInAnArray.leaders(arr);
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