package queue_office;

import java.util.LinkedList;
import java.util.Queue;

public class ReverseAQueue {

	
	public Queue<Integer> reverse(Queue<Integer> queue){
		
		if(queue.isEmpty()) return queue;
		Integer item = queue.poll();
		reverse(queue);
		queue.offer(item);
		
		return queue;
	}
	
	public static void main(String[] args) {
		Queue<Integer> queue = new LinkedList<Integer>();
		queue.offer(1);
		queue.offer(2);
		queue.offer(3);
		queue.offer(4);
		
		ReverseAQueue reverseAQueue = new ReverseAQueue();
		
		reverseAQueue.reverse(queue);
		
		for(Integer integer : queue) {
			System.out.println(integer);
		}
	}
}
