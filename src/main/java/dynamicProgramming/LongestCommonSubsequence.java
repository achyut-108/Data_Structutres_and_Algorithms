package dynamicProgramming;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Scanner;

public class LongestCommonSubsequence {

	public int printLongestCommonSubSequence(String s1, String s2) {

		Map<String, List<Integer>> map = new HashMap<String, List<Integer>>();
		int i = 0;
		for (char c : s2.toCharArray()) {
			if (map.containsKey(String.valueOf(c))) {
				map.get(String.valueOf(c)).add(i);
			} else {
				List<Integer> list = new ArrayList<Integer>();
				list.add(i);
				map.put(String.valueOf(c), list);
			}
			i++;
		}

		int startIndexOfFirstString = -1;
		int endIndexOfSecondString = -1;
		int count = 0;
		int minSum = -1;
		for (i = 0; i < s1.length(); i++) {
			if (map.containsKey(String.valueOf(s1.charAt(i)))) {
				for (Integer integer : map.get(String.valueOf(s1.charAt(i)))) {
					//System.out.println("Integer is : " + integer);
					int tempSum = i + integer;
					//System.out.println("temp sum : " + tempSum + " minSum : " + minSum );
					if (minSum < 0) {
						minSum = tempSum;
						startIndexOfFirstString = i;
						endIndexOfSecondString = integer;
						break;
					}

					if (tempSum < minSum) {
						minSum = tempSum;
						startIndexOfFirstString = i;
						endIndexOfSecondString = integer;
					}
				}
			}
		}

		//System.out.println("startIndexOfFirstString : " + startIndexOfFirstString);
		if (startIndexOfFirstString >= 0) {
			System.out.println("" + String.valueOf(s1.charAt(startIndexOfFirstString)));
			i = startIndexOfFirstString + 1;
			++count;
			System.out.println("count : " + count);
			while (endIndexOfSecondString < s2.length() && i < s1.length()) {
				if (map.containsKey(String.valueOf(s1.charAt(i)))) {
					for (Integer integer : map.get(String.valueOf(s1.charAt(i)))) {
						if (integer > endIndexOfSecondString) {
							System.out.println(String.valueOf(s1.charAt(i)));
							count = count + 1;
							startIndexOfFirstString = i;
							endIndexOfSecondString = integer;
							System.out.println("count inside : " + count);
							break;
						}
					}
				}

				i++;
			}
		}

		return count;
	}

	public static void main(String[] args) {
		Scanner sc = null;
		try {
			sc = new Scanner(System.in);
			System.out.println("Please enter the first string : ");
			String s1 = sc.nextLine();
			System.out.println("Please enter the second String : ");
			String s2 = sc.nextLine();
			LongestCommonSubsequence longestCommonSubsequence = new LongestCommonSubsequence();

			int result = longestCommonSubsequence.printLongestCommonSubSequence(s1, s2);
			System.out.println("The length of longest Common subsquence is   : " + result);
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