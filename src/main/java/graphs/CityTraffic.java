package graphs;

import java.util.ArrayList;
import java.util.List;

public class CityTraffic {

	public static boolean isNumeric(String string) {
		int intValue;

		System.out.println(String.format("Parsing string: \"%s\"", string));

		if (string == null || string.equals("")) {
			System.out.println("String cannot be parsed, it is null or empty.");
			return false;
		}

		try {
			intValue = Integer.parseInt(string);
			return true;
		} catch (NumberFormatException e) {
			System.out.println("Input String cannot be parsed to Integer.");
		}
		return false;
	}

	public int[][] readInput(String[] input) {

		List<Integer[]> resultList = new ArrayList<Integer[]>();
		// String[] splitArr = input.split(",");
		for (String string : input) {

			String[] split1 = string.split(":");
			Integer node = Integer.valueOf(split1[0]);
			String[] split2 = split1[1].split("\\[");
			String[] split3 = split2[1].split("\\]");
			String[] adjacentNodes = split3[0].split(",");
			for (String s4 : adjacentNodes) {
				// System.out.println(s4);
				// System.out.println(Integer.valueOf(s4));
			}
			int i = 0;
			while (i < adjacentNodes.length) {
				Integer[] arr = new Integer[2];
				arr[0] = node;
				arr[1] = Integer.valueOf(adjacentNodes[i]);
				resultList.add(arr);
				i++;
			}
		}

		int[][] result = new int[resultList.size()][2];
		int i = 0;

		for (Integer[] arr : resultList) {
			for (Integer integer : arr) {
				System.out.println(integer);
			}
			System.out.println("$$$$$$$$$$$$$$$");
		}

		for (int j = 0; j < resultList.size(); j++) {
			Integer[] arr = resultList.get(j);
			for (int k = 0; k < 2; k++) {
				result[j][k] = arr[k];
			}
		}

		return result;
	}

//	int[] arr = new int[2];arr[0]=Integer.valueOf(splitArr[0]);arr[1]=Integer.valueOf(splitArr[1]);

	public static void main(String[] args) {

		CityTraffic cityTraffic = new CityTraffic();

		String[] input = new String[] { "1:[5]", "4:[5]", "3:[5]", "5:[1,4,3,2]", "2:[5,15,7]", "7:[2,8]", "8:[7,38]",
				"15:[2]", "38:[8]" };
		int[][] result = cityTraffic.readInput(input);
		for (int j = 0; j < result.length; j++) {
			for (int k = 0; k < 2; k++) {
				System.out.println(result[j][k]);
			}
			System.out.println("################");
		}

	}

//	String s = "5:[1,4,3,2]";
//	String[] split1 = s.split(":");
//	for (String s1 : split1) {
//		System.out.println(s1);
//	}
//	System.out.println("--------------");
//	String[] split2 = split1[1].split("\\[");
//	for (String s2 : split2) {
//		System.out.println(s2);
//	}
//
//	System.out.println("--------------");
//	String[] split3 = split2[1].split("\\]");
//	for (String s3 : split3) {
//		System.out.println(s3);
//	}
//
//	System.out.println("--------------");
//	String[] split4 = split3[0].split(",");
//	System.out.println("split4 length : " + split4.length);
//	for (String s4 : split4) {
//		System.out.println(s4);
//		System.out.println(Integer.valueOf(s4));
//	}
}
