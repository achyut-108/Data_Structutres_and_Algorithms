package arrays;

import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;

/**
 * Given an array of size N. Find number of distinct elements in every window of
 * size K.
 * 
 * @author siddhartha.kumar
 *
 */
public class SlidingWindowDistinctElementsinEveryWindow {

	/**
	 * The idea is to maintain the distinct elements of the window with given window
	 * size in a hash map along with their counts. The no of elements of the first
	 * window can be obtained just by getting the size of the hash map.
	 * 
	 * From the next window the first element of the first window will be removed
	 * and the first element of the next window will be added to the hashmap.If the
	 * element already exists in the hashmap then simply its count will be increased
	 * by one.
	 * 
	 * In this way in the hash map only the distinct element of the current window
	 * will be present and the count will be obtained just by getting the size of
	 * the hash map before moving to the next window.
	 * 
	 * 
	 * 
	 * 
	 * @param arr
	 * @param windowSize
	 */
	public void printNumOfDistinctElementsInEveryWindow(int[] arr, int windowSize) {

		Map<Integer, Integer> distinctMap = new HashMap<Integer, Integer>();

		for (int i = 0; i < windowSize; i++) {
			if (distinctMap.containsKey(arr[i])) {
				distinctMap.put(arr[i], distinctMap.get(arr[i]) + 1);
			} else {
				distinctMap.put(arr[i], 1);
			}
		}

		System.out.print(distinctMap.size() + " ");

		for (int i = windowSize; i < arr.length; i++) {
			if (distinctMap.containsKey(arr[i - windowSize])) {
				distinctMap.put(arr[i - windowSize], distinctMap.get(arr[i - windowSize]) - 1);
				if (distinctMap.get(arr[i - windowSize]) == 0) {
					distinctMap.remove(arr[i - windowSize]);
				}
			}
			if (distinctMap.containsKey(arr[i])) {
				distinctMap.put(arr[i], distinctMap.get(arr[i]) + 1);
			} else {
				distinctMap.put(arr[i], 1);
			}

			System.out.print(distinctMap.size() + " ");
		}
	}

	/**
	 * e.g: 1,2,1,3,4,3,3 windowSize : 4
	 * 
	 * @param args
	 */
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
			System.out.println("Please enter the window size : ");
			int windowSize = sc.nextInt();

			SlidingWindowDistinctElementsinEveryWindow slidingWindowDistinctElementsinEveryWindow = new SlidingWindowDistinctElementsinEveryWindow();
			slidingWindowDistinctElementsinEveryWindow.printNumOfDistinctElementsInEveryWindow(arr, windowSize);

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