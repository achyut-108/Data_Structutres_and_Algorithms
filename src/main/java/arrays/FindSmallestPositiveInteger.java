package arrays;

import java.util.Arrays;
import java.util.Collections;
import java.util.List;

public class FindSmallestPositiveInteger {

	// you can write to stdout for debugging purposes, e.g.
	// System.out.println("this is a debug message");

	
	public static void main(String[] args) {
		int[] arr = {-9,-10,-2,-2,-3,-4,-6};
		System.out.println("solution : " + solution(arr));
	}
	public static int solution(int[] A) {
		// write your code in Java SE 8

		if(A == null || A.length == 0) return 1;
		
		Arrays.sort(A);
		int size = A.length;
		if(A[size-1] <= 0) return 1;
		
		int match = 1;
		//1,3,2,4,6,1
		//1,1,2,2,3,4,6
		int previous = 1;
		for (int integer : A) {
			if(integer == match) {
				match++;
			}
		}

		return match;
	}

}
