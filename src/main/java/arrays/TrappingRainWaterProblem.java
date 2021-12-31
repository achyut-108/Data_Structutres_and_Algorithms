package arrays;

import java.util.Scanner;

/**
 * The array 'arr' contains height(+ve) of the pillar. Find out the max water
 * that can be stored between these pillars.
 * @author siddhartha.kumar
 *
 */
public class TrappingRainWaterProblem {

	/**
	 * The idea is to find out the left-Max array and the right-Max array.
	 * The water stored at any pillar is clearly : min(left-max_i,right-max_i)-arr[i]
	 * @param arr
	 * @return
	 */
	public int volumeOfWater(int[] arr) {
		int result = 0;

		int[] leftMaxArr = new int[arr.length];
		int leftMax = arr[0];
		leftMaxArr[0] = leftMax;
		for (int i = 1; i < arr.length; i++) {
			if (arr[i] > leftMax) {
				leftMax = arr[i];
			}
			leftMaxArr[i] = leftMax;
		}

		System.out.println("LeftMax arr : ");
		for (int i = 0; i < leftMaxArr.length; i++) {
			System.out.println(leftMaxArr[i]);
		}

		int rightMax = arr[arr.length - 1];
		int[] rightMaxArr = new int[arr.length];
		rightMaxArr[arr.length - 1] = rightMax;
		for (int i = arr.length - 2; i >= 0; i--) {
			if (arr[i] > rightMax) {
				rightMax = arr[i];
			}
			rightMaxArr[i] = rightMax;
		}

		System.out.println("Right Max Array : ");

		for (int i = 0; i < rightMaxArr.length; i++) {
			System.out.println(rightMaxArr[i]);
		}
		for (int i = 0; i < arr.length; i++) {
			result = result + (Math.min(leftMaxArr[i], rightMaxArr[i]) - arr[i]);
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

			TrappingRainWaterProblem rainWaterProblem = new TrappingRainWaterProblem();
			int volumeOfWater = rainWaterProblem.volumeOfWater(arr);
			System.out.println("The water stored is : " + volumeOfWater);
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
