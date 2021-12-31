package arrays;

import java.util.Scanner;

/**
 * Find the index(can be any) element in the array which occurs more than N/2
 * times where N is the length of the array.
 * 
 * @author siddhartha.kumar
 *
 */
public class MajorityELement {

	public int majorityElement(int[] arr) {
		int count = 0;
		int majorityTrend = majorityElementTrend(arr);
		for (int i = 0; i < arr.length; i++) {
			if (arr[i] == majorityTrend)
				count++;
		}

		if (count > arr.length / 2)
			return majorityTrend;

		return -1;
	}

	/**
	 * Moore's Algorithm. In My words Trend(Rujhan) Algorithm. If at all a majority
	 * element exists,the following algo will return the majority element. The idea
	 * is to consider the first element as the majority.Then give it a vote as 1. If
	 * the next element is equal to it then then increase the vote else decrease the
	 * vote. if the vote becomes zero then assign the next element as the majority
	 * element.In this way the votes of the element of the array would cancle each
	 * other paving the way for one majority(if exists) element. If the return
	 * element is majority can be found by counting the number of this element in
	 * the array.
	 * 
	 * @param arr
	 * @return
	 */
	public int majorityElementTrend(int[] arr) {
		int majority = arr[0];
		int vote = 1;
		for (int i = 1; i < arr.length; i++) {
			if (arr[i] != arr[i - 1]) {
				vote--;
			} else {
				vote++;
			}
			if (vote == 0) {
				majority = arr[i];
				vote++;
			}
		}

		return majority;
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

			MajorityELement majorityELement = new MajorityELement();
			int majorityElement = majorityELement.majorityElement(arr);
			System.out.println("The majority element is : " + majorityElement);

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