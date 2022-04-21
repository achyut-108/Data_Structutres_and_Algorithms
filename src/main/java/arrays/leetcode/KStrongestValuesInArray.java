package arrays.leetcode;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;
import java.util.Map;
import java.util.Map.Entry;
import java.util.Scanner;
import java.util.TreeMap;

public class KStrongestValuesInArray {

	public int[] kStrongestValues(int[] arr, int k) {
		int[] resultArr = new int[k];

		Arrays.sort(arr);
		int median = arr[(arr.length - 1) / 2];
		Map<Integer, List<Integer>> map = new TreeMap<Integer, List<Integer>>(Collections.reverseOrder());

		for (int i = 0; i < arr.length; i++) {
			int key = arr[i] - median;
			if (key < 0)
				key = key * (-1);
			if (map.containsKey(key)) {
				map.get(key).add(arr[i]);
			} else {
				List<Integer> list = new ArrayList<Integer>();
				list.add(arr[i]);
				map.put(key, list);
			}
		}

		for (Entry<Integer, List<Integer>> entry : map.entrySet()) {
			System.out.println("Key is : " + entry.getKey());
			List<Integer> list = entry.getValue();
			Collections.sort(list, Collections.reverseOrder());
			for (Integer integer : list) {
				System.out.println("integer : " + integer + " k before : " + k);
				resultArr[--k] = integer;
				if (k == 0)
					break;
			}

			if (k == 0)
				break;
		}

		return resultArr;
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

			System.out.println("Please enter the number of Strongest elements required !!");
			int k = sc.nextInt();
			KStrongestValuesInArray kStrongestValuesInArray = new KStrongestValuesInArray();
			int[] resultArr = kStrongestValuesInArray.kStrongestValues(arr, k);
			System.out.println("The Stringest elements are : ");
			for (Integer integer : resultArr) {
				System.out.println(integer);
			}
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