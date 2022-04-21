package searchAlgorithms;

/**
 * The array has n elements and necessarily it has zero. The array also has all
 * elements from from number 0 to max where max is the maximum element in the
 * array.
 * 
 * Find the repeating element in the array.
 * 
 * @author siddhartha.kumar
 *
 */
public class RepeatingElements {

	public int repeatingElements(int[] arr) {
		int slow = arr[0] + 1;
		int fast = arr[0] + 1;

		do {
			slow = arr[slow] + 1;
			fast = arr[arr[fast] + 1] + 1; // since 'fast' has to move with twice as speed as 'slow'.Initially both
											// 'slow' and 'fast' are at same place,so when slow will move one step
											// ahead(its value will become arr[slow] + 1)
											// the the value of fast shall be equal to the value which the slow would
											// have by moving one more step ahead(now the value of slow would be
											// arr[arr[slow]+1]). So the value of fast is : arr[arr[slow]+1].The extra
											// '1' has been added to avoid the situation when the value of any element
											// of the array is '0' as this would create a self loop. for e.g: [1,0] or
											// [0]
		} while (slow != fast);

		slow = arr[0] + 1;

		while (slow != fast) {
			fast = arr[fast] + 1;
			slow = arr[slow] + 1;
		}

		return slow - 1;
	}
}