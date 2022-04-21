package dynamicProgramming;

import java.sql.Timestamp;
import java.time.LocalDateTime;
import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;

public class LongestCommonSubsequenceWithMemoization {

	public class LcaSolutionKey {
		private int len_s1;
		private int len_s2;

		public LcaSolutionKey() {
		}

		public LcaSolutionKey(int len_s1, int len_s2) {
			this.len_s1 = len_s1;
			this.len_s2 = len_s2;
		}

		public int getLen_s1() {
			return len_s1;
		}

		public void setLen_s1(int len_s1) {
			this.len_s1 = len_s1;
		}

		public int getLen_s2() {
			return len_s2;
		}

		public void setLen_s2(int len_s2) {
			this.len_s2 = len_s2;
		}

		@Override
		public int hashCode() {
			final int prime = 31;
			int result = 1;
			result = prime * result + getEnclosingInstance().hashCode();
			result = prime * result + len_s1;
			result = prime * result + len_s2;
			return result;
		}

		@Override
		public boolean equals(Object obj) {
			if (this == obj)
				return true;
			if (obj == null)
				return false;
			if (getClass() != obj.getClass())
				return false;
			LcaSolutionKey other = (LcaSolutionKey) obj;
			if (!getEnclosingInstance().equals(other.getEnclosingInstance()))
				return false;
			if (len_s1 != other.len_s1)
				return false;
			if (len_s2 != other.len_s2)
				return false;
			return true;
		}

		private LongestCommonSubsequenceWithMemoization getEnclosingInstance() {
			return LongestCommonSubsequenceWithMemoization.this;
		}

	}

	int[][] twoDArray = null;
	StringBuilder sb = new StringBuilder();

	Map<LcaSolutionKey, Integer> solutionMap = new HashMap<LongestCommonSubsequenceWithMemoization.LcaSolutionKey, Integer>();

	public LongestCommonSubsequenceWithMemoization(String s1, String s2) {
		twoDArray = new int[s1.length() + 1][s2.length() + 1];
		for (int[] row : twoDArray)
			Arrays.fill(row, -1);
	}

	public int longestCommonSubsequence(String s1, String s2, int len_s1, int len_s2) {

		if (twoDArray[len_s1][len_s2] != -1)
			return twoDArray[len_s1][len_s2];
		if (len_s1 == 0 || len_s2 == 0) {
			twoDArray[len_s1][len_s2] = 0;
		} else {

			if (s1.charAt(len_s1 - 1) == s2.charAt(len_s2 - 1)) {
				twoDArray[len_s1][len_s2] = 1 + longestCommonSubsequence(s1, s2, len_s1 - 1, len_s2 - 1);
				//System.out.println(s1.charAt(len_s1 - 1));
				sb.append(s1.charAt(len_s1 - 1));
			} else {
				twoDArray[len_s1][len_s2] = Math.max(longestCommonSubsequence(s1, s2, len_s1, len_s2 - 1),
						longestCommonSubsequence(s1, s2, len_s1 - 1, len_s2));
			}
		}

		// System.out.println("twoDArray : (" + len_s1 + "),( " + len_s2 + " ) : " +
		// twoDArray[len_s1][len_s2]);
		return twoDArray[len_s1][len_s2];
	}

	public int longestCommonSubsequenceUsingHashMap(String s1, String s2, int len_s1, int len_s2) {

		LcaSolutionKey lcaSolutionKey = new LcaSolutionKey(len_s1, len_s2);
		if (solutionMap.containsKey(lcaSolutionKey)) {
			return solutionMap.get(lcaSolutionKey);
		}

		if (len_s1 == 0 || len_s2 == 0) {
			solutionMap.put(lcaSolutionKey, 0);
		} else {
			if (s1.charAt(len_s1 - 1) == s2.charAt(len_s2 - 1)) {
				solutionMap.put(lcaSolutionKey,
						1 + longestCommonSubsequenceUsingHashMap(s1, s2, len_s1 - 1, len_s2 - 1));
			} else {
				solutionMap.put(lcaSolutionKey,
						Math.max(longestCommonSubsequenceUsingHashMap(s1, s2, len_s1, len_s2 - 1),
								longestCommonSubsequenceUsingHashMap(s1, s2, len_s1 - 1, len_s2)));
			}
		}

		return solutionMap.get(lcaSolutionKey);
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

			LongestCommonSubsequenceWithMemoization longestCommonSubsequenceWithMemoization = new LongestCommonSubsequenceWithMemoization(
					s1, s2);
			int result = longestCommonSubsequenceWithMemoization.longestCommonSubsequence(s1, s2, s1.length(),
					s2.length());
			// System.out.println("Longset subsequence is : " +
			// longestCommonSubsequenceWithMemoization.sb.toString());

//			int result = longestCommonSubsequenceWithMemoization.longestCommonSubsequenceUsingHashMap(s1, s2,
//					s1.length(), s2.length());
			System.out.println("Time Taken : "
					+ (Timestamp.valueOf(LocalDateTime.now()).getTime() - Timestamp.valueOf(startTime).getTime()));
			System.out.println("Longest common subsequence is : " + result);
			// System.out.println("The length of the longest sub sequence : " + result);
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
