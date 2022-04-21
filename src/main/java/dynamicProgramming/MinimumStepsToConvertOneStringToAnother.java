package dynamicProgramming;

import java.sql.Timestamp;
import java.time.LocalDateTime;
import java.util.Scanner;

/**
 * Find minimum number of insertions and deletions to convert one string to
 * another.
 * 
 * @author siddhartha.kumar
 *
 */
public class MinimumStepsToConvertOneStringToAnother {

	int[][] lcs_table = null;

	public int minimumSteps(String s1, String s2) {

		if (s1 == null || s2 == null || s1.equals(s2))
			return 0;

		int lcs = longestCommonSubsequence(s1, s2);

		return (s1.length() - lcs) + (s2.length() - lcs);

	}

	private int longestCommonSubsequence(String s1, String s2) {

		lcs_table = new int[s1.length() + 1][s2.length() + 1];

		for (int i = 0; i <= s1.length(); i++) {
			lcs_table[i][0] = 0;
		}

		for (int i = 0; i <= s2.length(); i++) {
			lcs_table[0][i] = 0;
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

		return lcs_table[s1.length()][s2.length()];
	}

	public int minimumStepsSpaceOptimised(String s1, String s2) {
		int[] lcs_table_1_d = new int[s2.length() + 1];

		int previousSolution = 0;
		// Filling the solution for first row. First row indicates length of string s1
		// as zero and the length of the second string s2 starting from 0 to the length
		// of the string s2.so total number of steps would be simply equal to length of
		// the string s2 at each index(column).
		for (int i = 0; i <= s2.length(); i++) {
			lcs_table_1_d[i] = i;
		}

		for (int i = 1; i <= s1.length(); i++) {
			for (int j = 0; j <= s2.length(); j++) {
				if (i == 0 || j == 0) {
					previousSolution = lcs_table_1_d[j];
					lcs_table_1_d[j] = i + j;
					//System.out.println("if solution at : " + j + " : " + lcs_table_1_d[j]);
				} else if (s1.charAt(i - 1) == s2.charAt(j - 1)) {
					int temp = lcs_table_1_d[j];
					// System.out.println("temp : " + temp + " : Previous Solution : " +
					// previousSolution);
					lcs_table_1_d[j] = previousSolution;
					//System.out.println("else if Solution at : " + j + " : " + lcs_table_1_d[j]);
					previousSolution = temp;
					// System.out.println("new previous Solution : " + previousSolution);

				} else {
					previousSolution = lcs_table_1_d[j];
					lcs_table_1_d[j] = 1 + Math.min(lcs_table_1_d[j - 1], lcs_table_1_d[j]);
					//System.out.println("else : solution at : " + j + " : " + lcs_table_1_d[j]);
					// System.out.println("else : Previous Solution : " + previousSolution);
				}
			}
		}

		return lcs_table_1_d[s2.length()];
	}

	/**
	 * Test inputs : e.g. : str1 =
	 * 
	 * fcvafurqjylclorwfoladwfqzkbebslwnmpmlkbezkxoncvwhstwzwpqxqtyxozkpgtgtsjobujezgrkvevklmludgtyrmjaxyputqbyxqvupojutsjwlwluzsbmvyxifqtglwvcnkfsfglwjwrmtyxmdgjifyjwrsnenuvsdedsbqdovwzsdghclcdexmtsbexwrszihcpibwpidixmpmxshwzmjgtadmtkxqfkrsdqjcrmxkbkfoncrcvoxuvcdytajgfwrcxivixanuzerebuzklyhezevonqdsrkzetsrgfgxibqpmfuxcrinetyzkvudghgrytsvwzkjulmhanankxqfihenuhmfsfkfepibkjmzybmlkzozmluvybyzsleludsxkpinizoraxonmhwtkfkhudizepyzijafqlepcbihofepmjqtgrsxorunshgpazovuhktatmlcfklafivivefyfubunszyvarcrkpsnglkduzaxqrerkvcnmrurkhkpargvcxefovwtapedaluhclmzynebczodwropwdenqxmrutuhehadyfspcpuxyzodifqdqzgbwhodcjonypyjwbwxepcpujerkrelunstebopkncdazexsbezmhynizsvarafwfmnclerafejgnizcbsrcvcnwrolofyzulcxaxqjqzunedidulspslebifinqrchyvapkzmzwbwjgbyrqhqpolwjijmzyduzerqnadapudmrazmzadstozytonuzarizszubkzkhenaxivytmjqjgvgzwpgxefatetoncjgjsdilmvgtgpgbibexwnexstipkjylalqnupexytkradwxmlmhsnmzuxcdkfkxyfgrmfqtajatgjctenqhkvyrgvapctqtyrufcdobibizihuhsrsterozotytubefutaxcjarknynetipehoduxyjstufwvkvwvwnuletybmrczgtmxctuny
	 * 
	 * str2 =
	 * nohgdazargvalupetizezqpklktojqtqdivcpsfgjopaxwbkvujilqbclehulatshehmjqhyfkpcfwxovajkvankjkvevgdovazmbgtqfwvejczsnmbchkdibstklkxarwjqbqxwvixavkhylqvghqpifijohudenozotejoxavkfkzcdqnoxydynavwdylwhatslyrwlejwdwrmpevmtwpahatwlaxmjmdgrebmfyngdcbmbgjcvqpcbadujkxaxujudmbejcrevuvcdobolcbstifedcvmngnqhudixgzktcdqngxmruhcxqxypwhahobudelivgvynefkjqdyvalmvudcdivmhghqrelurodwdsvuzmjixgdexonwjczghalsjopixsrwjixuzmjgxydqnipelgrivkzkxgjchibgnqbknstspujwdydszohqjsfuzstyjgnwhsrebmlwzkzijgnmnczmrehspihspyfedabotwvwxwpspypctizyhcxypqzctwlspszonsrmnyvmhsvqtkbyhmhwjmvazaviruzqxmbczaxmtqjexmdudypovkjklynktahupanujylylgrajozobsbwpwtohkfsxeverqxylwdwtojoxydepybavwhgdehafurqtcxqhuhkdwxkdojipolctcvcrsvczcxedglgrejerqdgrsvsxgjodajatsnixutihwpivihadqdotsvyrkxehodybapwlsjexixgponcxifijchejoxgxebmbclczqvkfuzgxsbshqvgfcraxytaxeviryhexmvqjybizivyjanwxmpojgxgbyhcruvqpafwjslkbohqlknkdqjixsfsdurgbsvclmrcrcnulinqvcdqhcvwdaxgvafwravunurqvizqtozuxinytafopmhchmxsxgfanetmdcjalmrolejidylkjktunqhkxchyjmpkvsfgnybsjedmzkrkhwryzan
	 * 
	 * For above input using arrays time taken : 38 (long value of timestamp) while
	 * using hashmap : 1776 (long value of timestamp) . So using array for efficient
	 * 
	 * Correct Result : 323
	 * 
	 * 
	 * @param args
	 */
	public static void main(String[] args) {
		Scanner sc = null;
		try {
			sc = new Scanner(System.in);
			System.out.println("Please enter first String : ");
			String s1 = sc.nextLine();
			System.out.println("Please enter second String : ");
			String s2 = sc.nextLine();

			LocalDateTime startTime = LocalDateTime.now();

			MinimumStepsToConvertOneStringToAnother minimumStepsToConvertOneStringToAnother = new MinimumStepsToConvertOneStringToAnother();
			int result = minimumStepsToConvertOneStringToAnother.minimumSteps(s1, s2);

			System.out.println("Time Taken : "
					+ (Timestamp.valueOf(LocalDateTime.now()).getTime() - Timestamp.valueOf(startTime).getTime()));
			System.out.println("Minimum Steps to convert the first String to another String : " + result);
			System.out.println("minimumStepsSpaceOptimised : "
					+ minimumStepsToConvertOneStringToAnother.minimumStepsSpaceOptimised(s1, s2));

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