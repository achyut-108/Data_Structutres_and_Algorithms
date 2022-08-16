package arrays;

import java.util.Objects;
import java.util.Queue;

public class SequencePrinter extends Thread {

	int counter = 0;
	Queue<Integer> queue = null;
	int numberOfCounters = 0;
	int maxSequence = 0;

	@Override
	public void run() {

		Integer sequence = 0;
		while (!queue.isEmpty()) {
			if (Objects.nonNull(queue)) {
				sequence = queue.peek();
				if (sequence != null && sequence == counter) {
					System.out.println(Thread.currentThread().getName() + " " + counter);
					queue.poll();
					// queue.offer(sequence + 1);
					counter = counter + numberOfCounters;
				}
			}
		}
	}

	public SequencePrinter(int counter, Queue<Integer> queue, int numberOfCounters, int maxSequence) {
		this.counter = counter;
		this.numberOfCounters = numberOfCounters;
		this.queue = queue;
		this.maxSequence = maxSequence;
	}

}