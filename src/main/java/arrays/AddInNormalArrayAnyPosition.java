package arrays;

import java.util.Scanner;

/**
 * 
 * @author siddhartha.kumar
 *
 */
public class AddInNormalArrayAnyPosition {

	public int add(int arr[], int position, int currentSize, int capacity, int itemToInsert) {

		if (position > capacity) {
			return -1;
		}
		
		if (currentSize == capacity) {
			return currentSize;
		}

		int index = position - 1;

		// shift the array by one position to the right
		// i=index as this place should also be shifted
		// as this is the place where the new item will
		// be inserted
		for (int i = currentSize - 1; i >= index; i--) {
			arr[i + 1] = arr[i];
		}

		arr[index] = itemToInsert;

		return currentSize + 1;
	}

	public static void main(String[] args) {
		Scanner sc = null;
		try {

			sc = new Scanner(System.in);
			System.out.println("Please enter the capacity of the integer array : ");
			int capacity = sc.nextInt();

			int[] arr = new int[capacity];

			System.out.println("Please enter the current size of the array : ");

			int currentSize = sc.nextInt();

			System.out.println("Please enter the elements of the array : ");

			for (int i = 0; i < currentSize; i++) {
				arr[i] = sc.nextInt();
			}

			System.out.println("Please enter the integer to insert in the array : ");

			int itemToInsert = sc.nextInt();

			System.out.println("Please enter the position at which to insert the new item in the array :");

			int position = sc.nextInt();

			AddInNormalArrayAnyPosition addInNormalArrayAnyPosition = new AddInNormalArrayAnyPosition();
		
			int result = addInNormalArrayAnyPosition.add(arr, position, currentSize, capacity, itemToInsert);

			
			if (result > currentSize) {
				System.out.println("The item added at index : " + (position - 1));
				System.out.println("The modified array is : ");
				for (int i = 0; i < arr.length; i++) {
					System.out.println(arr[i]);
				}

				return;
			}

			if(result < 0 ) {
				System.out.println("The position to insert can not be greater than capacity !! ");
				return;
			}
			
			System.out.println("The item could not be added !! The Array has reached its capacity !!");
		} catch (Exception ex) {
			System.out.println("Exception raise in main : " + ex);
			ex.printStackTrace();
		} finally {
			if (sc != null) {
				sc.close();
			}
		}
	}

}
