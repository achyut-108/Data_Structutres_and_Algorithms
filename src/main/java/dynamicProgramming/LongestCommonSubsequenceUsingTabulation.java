package dynamicProgramming;

import java.sql.Timestamp;
import java.time.LocalDateTime;
import java.util.Scanner;

/**
 * Find LCS using bottom up approach
 * 
 * @author siddhartha.kumar
 *
 */
public class LongestCommonSubsequenceUsingTabulation {

	int[][] lcs_table = null;

	public LongestCommonSubsequenceUsingTabulation() {
	}

	public int longestCommonSubsequence(String s1, String s2) {
		lcs_table = new int[s1.length()+1][s2.length()+1];
		return longestCommonSubsequence(s1, s2, s1.length(), s2.length());
	}

	private int longestCommonSubsequence(String s1, String s2, int len_s1, int len_s2) {

		/**
		 * 1st row of the table zero as it denotes the length of the first first string
		 * to be zero
		 */
		for (int i = 0; i <= len_s2; i++) {
			lcs_table[0][i] = 0;
		}

		/**
		 * 1st column of the table as zero because it denotes the length of the second
		 * string to be zero.
		 */
		for (int i = 0; i <= len_s1; i++) {
			lcs_table[i][0] = 0;
		}

		for (int row = 1; row <= len_s1; row++) {
			for (int column = 1; column <= len_s2; column++) {
				if (s1.charAt(row-1) == s2.charAt(column-1)) {
					lcs_table[row][column] = 1 + lcs_table[row - 1][column - 1];
				} else {
					lcs_table[row][column] = Math.max(lcs_table[row][column - 1], lcs_table[row - 1][column]);
				}
			}
		}

		return lcs_table[len_s1][len_s2];
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
	 * using hashmap : 1776 (long value of timestamp) . So using array for efficient result : 323
	 * 
	 * Using tabulation method time taken is : 20 (long value of timestamp) result is : 
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

			LongestCommonSubsequenceUsingTabulation longestCommonSubsequenceUsingTabulation = new LongestCommonSubsequenceUsingTabulation();
			int result = longestCommonSubsequenceUsingTabulation.longestCommonSubsequence(s1, s2);
			System.out.println("Time Taken : "
					+ (Timestamp.valueOf(LocalDateTime.now()).getTime() - Timestamp.valueOf(startTime).getTime()));
			System.out.println("Longest common subsequence is : " + result);

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
