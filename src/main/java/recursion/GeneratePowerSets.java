package recursion;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Iterator;
import java.util.List;
import java.util.Scanner;

/**
 * Generate Sub sequences or power sets or sub sets
 * 
 * @author siddhartha.kumar
 *
 */
public class GeneratePowerSets {

	public List<String> generateSubSets(String str, List<String> result) {

		// iterating on the same list and adding to it will result in concurrent
		// modification exception.
		for (String string : new ArrayList<String>(result)) {
			if (string.equalsIgnoreCase("")) {
				result.add(str);
			} else {
				result.add(string + str);
			}
		}

//		result.forEach(string -> {
//			if (string.equalsIgnoreCase("")) {
//				result.add(str);
//			} else {
//				result.add(string + str);
//			}
//		});
//
//		for (String string : result) {
//			if (string.equalsIgnoreCase("")) {
//				 //result.add(str);
//			} else {
//				// result.add(string + str);
//			}
//		}

		return result;
	}

	public List<String> generateSubsets(String str) {
		List<String> result = new ArrayList<String>(Arrays.asList(""));
		for (char c : str.toCharArray()) {
			System.out.println("c is : " + String.valueOf(c));
			generateSubSets(String.valueOf(c), result);
		}
		return result;
	}

	/**
	 *          0        ""
	 *             /             \
	 *        1   ""              A
	 *         /     \         /    \
	 *      2 ""       B+""   A      AB 
 	 *       /  \    /   \    /\     /  \
	 *    3 "" ""+C  B   BC   A AC  AB  ABC
	 *     /        /    /    /  /   /
	 *        
	 *     
	 * @param currentString
	 * @param str
	 * @param currentPostion
	 */
	public void generateSubsetsUsingRecursion(String currentString, String str, int currentPostion) {
		if (currentPostion == str.length()) {
			System.out.println(currentString);
			return;
		}

		generateSubsetsUsingRecursion(currentString, str, currentPostion + 1);
		generateSubsetsUsingRecursion(currentString + String.valueOf(str.charAt(currentPostion)), str, currentPostion + 1);
	}

	public void generateSubsetsUsingRecursion(String str) {
		System.out.println(" ");
		generateSubsetsUsingRecursion("", str, 0);
	}

	public static void main(String[] args) {
		Scanner sc = null;
		try {
			sc = new Scanner(System.in);
			System.out.println("Please enter the String : ");
			String string = sc.nextLine();
			GeneratePowerSets generatePowerSets = new GeneratePowerSets();
			List<String> result = generatePowerSets.generateSubsets(string);
			System.out.println("result using iteration :");
			for (String str : result) {
				System.out.println(str);
			}

			System.out.println("result with recursion : ");
			generatePowerSets.generateSubsetsUsingRecursion(string);
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