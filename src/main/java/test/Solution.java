package test;

public class Solution {

	public int minumumStepsToReachEnd(int[] arr) {

		if (arr[0] <= 0)
			return -1;
		int result = 0;
		int i = 0;
		while (i < arr.length) {
			int maxReach = i + arr[i];
			if (maxReach >= arr.length - 1) {
				result++;
				break;
			}

			int nextReach = -1;
			int nextIndex = -1;
			for (int j = i + 1; j <= maxReach; j++) {
				int tempStep = j + arr[j];
				if (tempStep >= arr.length - 1) {
					result++;
					return result;
				}

				if (nextReach <= tempStep) {
					nextReach = tempStep;
					nextIndex = j;
				}
			}

			result++;
			i = nextIndex;
		}

		return result;
	}

	public static void main(String[] args) {
		
		int[] arr = {3,2,1,0,4};
				//{1,3,6,1,0,9}; 
		
		Solution solution = new Solution();
		int result = solution.minumumStepsToReachEnd(arr);
		System.out.println("Result : " + result);
		
	} 
}
