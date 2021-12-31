package recursion;

import java.util.Scanner;

public class RopeCuttingProblem {

	public int maxNumOfCuts(int lengthOfRope, int a, int b, int c) {

		if (lengthOfRope < 0)
			return -1;
		if (lengthOfRope == 0)
			return 0;

		int max = Math.max(maxNumOfCuts(lengthOfRope - a, a, b, c), maxNumOfCuts(lengthOfRope - b, a, b, c));
		max = Math.max(max, maxNumOfCuts(lengthOfRope - c, a, b, c));

		if (max == -1)
			return -1;// To handle when all the leaves of the recursion tree return -1

		return max + 1;
	}

	/**
	 * Corner case : ropeLength : 9 a=2,b=2,c=2
	 * 
	 * @param args
	 */
	public static void main(String[] args) {
		Scanner sc = null;
		try {
			sc = new Scanner(System.in);
			System.out.println("Please enter the length of the rope : ");
			Integer lengthOfRope = sc.nextInt();
			System.out.println("Please enter first length : ");
			int a = sc.nextInt();
			System.out.println("Please enter second length : ");
			int b = sc.nextInt();
			System.out.println("Please enter third length : ");
			int c = sc.nextInt();
			RopeCuttingProblem ropeCuttingProblem = new RopeCuttingProblem();
			int result = ropeCuttingProblem.maxNumOfCuts(lengthOfRope, a, b, c);
			System.out.println("max num of cuts : " + result);

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
