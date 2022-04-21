package dynamicProgramming;

import java.sql.Timestamp;
import java.time.LocalDateTime;
import java.util.Scanner;

public class LongestRepeatingSubsequenceInAString {

	public String longestRepeatingSubsequence(String s1) {

		char[] s2_char_arr = new char[s1.length()];

		int index = s1.length() - 1;
		for (char c : s1.toCharArray()) {
			s2_char_arr[index--] = c;
		}

		String s1_reverse = String.valueOf(s2_char_arr);
		System.out.println("s1_reverse : " + s1);
		return longestRepeatingSubsequence(s1, s1);
	}

	private String longestRepeatingSubsequence(String s1, String s1_reverse) {

		int[][] lcs_table = new int[s1.length() + 1][s1_reverse.length() + 1];

		for (int i = 0; i <= s1.length(); i++) {
			lcs_table[i][0] = 0;
		}

		for (int j = 0; j <= s1_reverse.length(); j++) {
			lcs_table[0][j] = 0;
		}

		int previousMatchedIndex = 0;
		for (int i = 1; i <= s1.length(); i++) {
			for (int j = 1; j <= s1_reverse.length(); j++) {
				
				System.out.println(i + " " + j + " " + 
						"[s1.charAt(i - 1) == s1_reverse.charAt(j - 1) && j - 1 != previousMatchedIndex && previousMatchedIndex < j - 1] "
								+ (s1.charAt(i - 1) == s1_reverse.charAt(j - 1) && j - 1 != i-1));
				System.out.println("previousMatchedIndex : " + previousMatchedIndex);
				if (s1.charAt(i - 1) == s1_reverse.charAt(j - 1) && j - 1 != i-1) {
					
					lcs_table[i][j] = 1 + lcs_table[i - 1][j - 1];
					System.out.println("solution : [" + i + "] [" + j + "] : " + lcs_table[i][j]);
					System.out.println("Character matched is : " + s1.charAt(i-1));
					//previousMatchedIndex = j-1;
				} else {
					lcs_table[i][j] = Math.max(lcs_table[i][j - 1], lcs_table[i - 1][j]);
					System.out.println("else solution : [" + i + "] [" + j + "] : " + lcs_table[i][j]);
				}
			}
		}

		char[] resultStringArr = new char[lcs_table[s1.length()][s1_reverse.length()]];

		System.out.println("result length : " + resultStringArr.length);
		int result_index = resultStringArr.length - 1;
		int index_s1 = s1.length();
		int index_s2 = s1_reverse.length();
		previousMatchedIndex = 0;
		while (result_index >= 0) {
			if (s1.charAt(index_s1 - 1) == s1_reverse.charAt(index_s2 - 1) && index_s1-1 != index_s2 - 1) {
				resultStringArr[result_index--] = s1.charAt(index_s1 - 1);
				//previousMatchedIndex = index_s1 - 1;
				index_s1--;
				index_s2--;
			} else {
				if (lcs_table[index_s1][index_s2 - 1] > lcs_table[index_s1 - 1][index_s2]) {
					index_s2--;
				} else {
					index_s1--;
				}
			}
		}

		return String.valueOf(resultStringArr);
	}

	/**
	 * agcsorvauz
	 * 
	 * aa aa aa aa
	 * @param args
	 */
	public static void main(String[] args) {
		Scanner sc = null;
		try {
			sc = new Scanner(System.in);
			System.out.println("Please enter the String : ");
			String s1 = sc.nextLine();

			LocalDateTime startTime = LocalDateTime.now();

			LongestRepeatingSubsequenceInAString longestRepeatingSubsequenceInAString = new LongestRepeatingSubsequenceInAString();
			String result = longestRepeatingSubsequenceInAString.longestRepeatingSubsequence(s1);

			System.out.println("Time Taken : "
					+ (Timestamp.valueOf(LocalDateTime.now()).getTime() - Timestamp.valueOf(startTime).getTime()));
			System.out.println("Longest repeating subsequence is : " + result);

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