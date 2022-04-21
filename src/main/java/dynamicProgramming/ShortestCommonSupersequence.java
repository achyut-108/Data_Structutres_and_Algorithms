package dynamicProgramming;

import java.sql.Timestamp;
import java.time.LocalDateTime;
import java.util.Scanner;

public class ShortestCommonSupersequence {

	public String shortestSupersequence(String s1, String s2) {
		String lcs = longestCommonSequenceUsing2DArray(s1, s2);
		// lcs = "aabbbaa";

		System.out.println("lcs is : " + lcs);
		int totalLengthOfNewString = lcs.length() + (s1.length() - lcs.length() + s2.length() - lcs.length());
		System.out.println("totalLengthOfNewString: " + totalLengthOfNewString);
		char[] resultCharArr = new char[totalLengthOfNewString];

		int index_s1 = 0;
		int index_s1_lastMatch = -1;
		int count_s1 = 0;
		int result_index = -1;
		int index_s2 = 0;
		int index_s2_lastMatch = -1;
		int count_s2 = 0;
		for (int i = 0; i < lcs.length(); i++) {
			System.out.println(" i : " + i);
			while (s1.charAt(index_s1) != lcs.charAt(i)) {
				index_s1++;
				count_s1++;
			}

			index_s1++;// to ignore the matched character
			System.out.println("coint s1 : " + count_s1);
			while (count_s1 > 0) {
				resultCharArr[++result_index] = s1.charAt(++index_s1_lastMatch);
				System.out.println("s1 : resulkt index : " + result_index + " char : " + resultCharArr[result_index]);
				count_s1--;
			}

			index_s1_lastMatch++;
			System.out.println("index_s1_lastMatch : " + index_s1_lastMatch);
			while (s2.charAt(index_s2) != lcs.charAt(i)) {
				index_s2++;
				count_s2++;
			}

			index_s2++;
			System.out.println("count_s2 : " + count_s2);
			while (count_s2 > 0) {
				resultCharArr[++result_index] = s2.charAt(++index_s2_lastMatch);
				System.out.println("s2 : resulkt index : " + result_index + " char : " + resultCharArr[result_index]);
				count_s2--;
			}

			index_s2_lastMatch++;
			resultCharArr[++result_index] = lcs.charAt(i);
			System.out.println("resulkt index : " + result_index + " char : " + resultCharArr[result_index]);
		}

		if (result_index < resultCharArr.length) {
			System.out.println();
			for (int i = index_s1; i < s1.length(); i++) {
				resultCharArr[++result_index] = s1.charAt(i);
			}

			for (int i = index_s2; i < s2.length(); i++) {
				resultCharArr[++result_index] = s2.charAt(i);
			}
		}

		return String.valueOf(resultCharArr);
	}

	private String longestCommonSequenceUsing2DArray(String s1, String s2) {
		int[][] lcs_table = new int[s1.length() + 1][s2.length() + 1];

		for (int i = 0; i <= s2.length(); i++) {
			lcs_table[0][i] = 0;
		}

		for (int i = 0; i <= s1.length(); i++) {
			lcs_table[i][0] = 0;
		}

		for (int i = 1; i <= s1.length(); i++) {
			for (int j = 1; j <= s2.length(); j++) {
				if (s1.charAt(i - 1) == s2.charAt(j - 1)) {
					lcs_table[i][j] = 1 + lcs_table[i - 1][j - 1];
				} else {
					lcs_table[i][j] = Math.max(lcs_table[i][j - 1], lcs_table[i - 1][j]);
				}
			}
		}

		char[] resultChar = new char[lcs_table[s1.length()][s2.length()]];

		int s1_index = s1.length();
		int s2_index = s2.length();
		int resultIndex = resultChar.length - 1;

		while (resultIndex >= 0) {

			if (s1.charAt(s1_index - 1) == s2.charAt(s2_index - 1)) {
				resultChar[resultIndex] = s1.charAt(s1_index - 1);
				s1_index--;
				s2_index--;
				resultIndex--;
			} else {
				if (lcs_table[s1_index][s2_index - 1] > lcs_table[s1_index - 1][s2_index]) {
					s2_index--;
				} else {
					s1_index--;
				}
			}
		}

		System.out.println("String.valueOf(resultChar)... " + String.valueOf(resultChar));
		return String.valueOf(resultChar);
	}

	private String longestCommonSubsequenceUsing1DArray(String s1, String s2) {
		StringBuilder sb = new StringBuilder();

		int[] lcs_1_table = new int[s2.length() + 1];

		for (int i = 0; i <= s2.length(); i++) {
			lcs_1_table[i] = 0;
		}

		int previousSolution = lcs_1_table[0];

		int lastAddedIndexS1 = -1;
		int lastAddedIndexS2 = -1;
		for (int i = 1; i <= s1.length(); i++) {
			for (int j = 0; j <= s2.length(); j++) {

				if (j == 0) {
					previousSolution = lcs_1_table[j];
					lcs_1_table[j] = j;
					System.out.println("[" + i + " " + j + "] : " + lcs_1_table[j]);
				} else if (s1.charAt(i - 1) == s2.charAt(j - 1)) {
					int temp = lcs_1_table[j];
					lcs_1_table[j] = 1 + previousSolution;
					System.out.println("common char : " + s1.charAt(i - 1) + " : sb.length : " + sb.length()
							+ " : i-1 : " + (i - 1) + " : " + lastAddedIndexS1 + " j-1 : " + (j - 1)
							+ " lastAddedIndexS2 : " + lastAddedIndexS2);
					System.out.println("solution : [" + i + " " + j + "] : " + lcs_1_table[j]);
					System.out.print(" condition : "
							+ (sb.length() < lcs_1_table[j] && i - 1 != lastAddedIndexS1 && j - 1 != lastAddedIndexS2));
					System.out.println();
					if (sb.length() < lcs_1_table[j] && i - 1 != lastAddedIndexS1 && j - 1 != lastAddedIndexS2) {
						System.out.println("char getting added : " + s1.charAt(i - 1));
						sb.append(s1.charAt(i - 1));
						lastAddedIndexS1 = i - 1;
						lastAddedIndexS2 = j - 1;
					}
					previousSolution = temp;
				} else {
					previousSolution = lcs_1_table[j];
					lcs_1_table[j] = Math.max(lcs_1_table[j - 1], lcs_1_table[j]);
					System.out.println("[" + i + " " + j + "] : " + lcs_1_table[j]);
				}
			}
		}

		System.out.println("lcs length : " + lcs_1_table[s2.length()]);
		return sb.toString();
	}

	/**
	 * aabbabaa 
	 * aabbbbbbaa 
	 * Ans : aabbabbbbaa
	 * 
	 * @param args
	 */
	public static void main(String[] args) {
		Scanner sc = null;
		try {
//			sc = new Scanner(System.in);
//			System.out.println("Please enter first String : ");
//			String s1 = sc.nextLine();
//			System.out.println("Please enter second String : ");
//			String s2 = sc.nextLine();

			LocalDateTime startTime = LocalDateTime.now();

			ShortestCommonSupersequence shortestCommonSupersequence = new ShortestCommonSupersequence();
			String result = shortestCommonSupersequence.shortestSupersequence("aabbabaa", "aabbbbbbaa");

			System.out.println("Time Taken : "
					+ (Timestamp.valueOf(LocalDateTime.now()).getTime() - Timestamp.valueOf(startTime).getTime()));
			System.out.println("Shortest Supersequence is : " + result);

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