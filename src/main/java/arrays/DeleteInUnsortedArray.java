package arrays;

import java.util.Scanner;

public class DeleteInUnsortedArray {

	public int delete(int[] arr, int itemToDelete) {

		//Matching the last element
		if (arr[arr.length-1] == itemToDelete) {
			arr[arr.length-1] = 0;
			return arr.length-1;
		}
		
		
		for (int i = 0; i < arr.length; i++) {
			if (arr[i] == itemToDelete) {
				for (int j = i; j < arr.length - 1; j++) {
					arr[j] = arr[j + 1];
				}
				arr[arr.length-1] = 0;
				return i;
			}
		}

		return -1;
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

			System.out.println("Please enter the integer to delete in the array : ");

			int itemToDelete = sc.nextInt();

			DeleteInUnsortedArray deleteInUnsortedArray = new DeleteInUnsortedArray();
			int result = deleteInUnsortedArray.delete(arr, itemToDelete);

			if (result >= 0) {
				System.out.println("The integer deleted from index : " + result);
				System.out.println("Array after deletion : ");
				for(int i : arr) {
					System.out.println("arr : " + i);
				}
				
				return;
			}

			System.out.println("The integer is not present !!");
		} catch (Exception ex) {
			System.out.println("Exception raise in main : " + ex);
		} finally {
			if (sc != null) {
				sc.close();
			}
		}
	}

}