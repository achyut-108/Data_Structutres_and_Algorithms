package queue_office;

import java.util.LinkedList;
import java.util.Queue;

/**
 * Given two digits '5' and '6'. Generate first 'n' numbers in Ascending order
 * which consists of only 5 and 6
 * 
 * "" / \ 5 6 / \ / \ 55 56 65 66 / \ 555 556
 * 
 * @author siddhartha.kumar
 *
 */
public class GenerateNumbersWithGivenDigits {

	/**
	 * The idea is to use a auxiliary queue and add 5 and 6 initially to it. Then
	 * pop out from the queue(current). Add 5 to the 'current' and again add the
	 * same to the queue. Add 6 to the 'current' and also add the same to the queue.
	 * 
	 * In this way do till we receive 'n' numbers.
	 * 
	 * This is nothing but the level order Traversal of the tree represented in
	 * above.
	 * 
	 * new item to the queue.
	 * 
	 * @param firstNumber
	 * @param secondNumber
	 * @param size
	 */
	public void generate(int firstNumber, int secondNumber, int size) {
		if (firstNumber > secondNumber) {
			int temp = firstNumber;
			firstNumber = secondNumber;
			secondNumber = temp;
		}

		Queue<String> levelOrderTraversalQueue = new LinkedList<String>();
		levelOrderTraversalQueue.offer("" + firstNumber);
		levelOrderTraversalQueue.offer("" + secondNumber);

		for (int i = 0; i < size; i++) {
			String currentNumber = levelOrderTraversalQueue.poll();
			System.out.println(currentNumber);
			levelOrderTraversalQueue.offer(currentNumber + firstNumber);
			levelOrderTraversalQueue.offer(currentNumber + secondNumber);
		}
	}

	public static void main(String[] args) {
		GenerateNumbersWithGivenDigits generateNumbersWithGivenDigits = new GenerateNumbersWithGivenDigits();
		generateNumbersWithGivenDigits.generate(5, 6, 10);
	}
}
