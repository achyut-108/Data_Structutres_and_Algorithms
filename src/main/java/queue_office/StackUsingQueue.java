package queue_office;

import java.util.LinkedList;
import java.util.Queue;

public class StackUsingQueue {

	private Queue<Integer> internalQueue = new LinkedList<Integer>();
	private Queue<Integer> auxQueue = new LinkedList<Integer>();

	private int size = 0;

	public void push(Integer item) {
		if (internalQueue.isEmpty()) {
			internalQueue.offer(item);
			size++;
		} else {
			while (!internalQueue.isEmpty()) {
				auxQueue.offer(internalQueue.poll());
			}

			internalQueue.offer(item);
			size++;
			while (!auxQueue.isEmpty()) {
				internalQueue.offer(auxQueue.poll());
			}
		}
	}

	public Integer pop() {
		Integer item = internalQueue.poll();
		size--;
		return item;
	}

	public int size() {
		return size;
	}

	public boolean isEmpty() {
		return size == 0;
	}
	
	public static void main(String[] args) {
		StackUsingQueue stack = new StackUsingQueue();
		stack.push(1);
		stack.push(2);
		stack.push(3);
		stack.push(4);
		stack.push(5);
		stack.push(6);
		System.out.println("size : " + stack.size());
		
		System.out.println("pop : " + stack.pop());
		System.out.println("pop : " + stack.pop());
		System.out.println("pop : " + stack.pop());
		System.out.println("size after 3 pops : " + stack.size());
		System.out.println("pop : " + stack.pop());
		System.out.println("size after 4 pops : " + stack.size());
	}
}