package dynamicProgramming;

import java.sql.Timestamp;
import java.time.LocalDateTime;
import java.util.Scanner;

public class LongestPalindromicSubsequenceLength {

	public int longestPalindromicLength(String s1) {
		char[] s2_char_arr = new char[s1.length()];
		int index = s1.length() - 1;
		for (char c : s1.toCharArray()) {
			s2_char_arr[index--] = c;
		}

		String s2 = String.valueOf(s2_char_arr);
		System.out.println("s2  is : " + s2);

		return longestSubsequenceLength(s1, s2);
	}

	private int longestSubsequenceLength(String s1, String s2) {
		int[] lcs_1_d_table = new int[s2.length() + 1];

		for (int i = 0; i <= s2.length(); i++) {
			lcs_1_d_table[i] = 0;
		}

		int previosSolution = lcs_1_d_table[0];

		for (int i = 1; i <= s1.length(); i++) {
			for (int j = 0; j <= s2.length(); j++) {
				if (j == 0) {
					previosSolution = lcs_1_d_table[j];
					lcs_1_d_table[j] = 0;
				} else {
					if (s1.charAt(i - 1) == s2.charAt(j - 1)) {
						int currentSolutionAtIndexJ = lcs_1_d_table[j];
						lcs_1_d_table[j] = 1 + previosSolution;
						previosSolution = currentSolutionAtIndexJ;
					} else {
						int currentSolutionAtIndexJ = lcs_1_d_table[j];
						lcs_1_d_table[j] = Math.max(lcs_1_d_table[j - 1], lcs_1_d_table[j]);
						previosSolution = currentSolutionAtIndexJ;
					}
				}
			}
		}

		return lcs_1_d_table[s2.length()];
	}

	
	/**
	 * aabbabbbbaa
	 * @param args
	 */
	public static void main(String[] args) {
		Scanner sc = null;
		try {
			sc = new Scanner(System.in);
			System.out.println("Please enter first String : ");
			String s1 = sc.nextLine();

			LocalDateTime startTime = LocalDateTime.now();

			LongestPalindromicSubsequenceLength longestPalindromicSubsequenceLength = new LongestPalindromicSubsequenceLength();
			int result = longestPalindromicSubsequenceLength.longestPalindromicLength(s1);

			System.out.println("Time Taken : "
					+ (Timestamp.valueOf(LocalDateTime.now()).getTime() - Timestamp.valueOf(startTime).getTime()));
			System.out.println("Longest Palindromic length is : " + result);

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
