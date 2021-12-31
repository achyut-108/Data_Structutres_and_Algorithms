package recursion;

import java.util.Scanner;

/**
 * There are n number of persons in a circle and the person at '0'th position
 * has the gun and that person will kill the K'th person. In the next round the
 * k+1 th person will kill ((k+1)+k)th person and in this way only one person
 * would remain alive.What is the index of that person when everyone was alive.
 * 
 * @author siddhartha.kumar
 *
 */
public class JosephusProblem {

	public int jos(int length, int k) {

		if (length == 1)
			return 0;

		return ((jos(length - 1, k) + k) % length);

	}

	public static void main(String[] args) {
		Scanner sc = null;
		try {
			sc = new Scanner(System.in);
			System.out.println("Please enter the no of persons : ");
			int noOfPersons = sc.nextInt();
			System.out.println("Please enter value of K : ");
			int k = sc.nextInt();
			JosephusProblem josephusProblem = new JosephusProblem();
			int result = josephusProblem.jos(noOfPersons, k);
			System.out.println("result : " + result);

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