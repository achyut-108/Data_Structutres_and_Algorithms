package arrays;

import java.util.Scanner;

/**
 * 
 * @author siddhartha.kumar
 *
 */
public class SecondLargestElement {

	public int secondLargestIndex(int[] arr) {
		int _1stLargest = 0;
		int _2ndLargest = -1;

		for (int i = 1; i < arr.length; i++) {
			if (arr[i] > arr[_1stLargest]) {
				_2ndLargest = _1stLargest;
				_1stLargest = i;
			} else if (arr[i] < arr[_1stLargest]) {
				if (_2ndLargest == -1) {
					_2ndLargest = i;
				} else if (arr[i] > arr[_2ndLargest])
					_2ndLargest = i;
			}
		}

		System.out.println("1stLargest is : " + arr[_1stLargest] + " presnt at : " + _1stLargest);
		if (_2ndLargest >= 0)
			System.out.println("2ndLargest is : " + arr[_2ndLargest] + " present at : " + _2ndLargest);
		else {
			System.out.println("There is no second largest !!" + _2ndLargest);
		}
		return _2ndLargest;
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

			SecondLargestElement secondLargestElement = new SecondLargestElement();
			int result = secondLargestElement.secondLargestIndex(arr);
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
