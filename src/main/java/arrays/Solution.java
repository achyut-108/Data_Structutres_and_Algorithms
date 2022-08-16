package arrays;

import java.util.Queue;
import java.util.concurrent.LinkedBlockingQueue;

public class Solution {

	Queue<Integer> internalQueue = new LinkedBlockingQueue<Integer>();//need to make sure about the name 'LinkedBlockingQueue'
	int numberOfThreads = 3;
	public void printSequence(int maxSequence){
		
		for(int i = 1;i<=maxSequence;i++) {
			internalQueue.offer(i);
			//System.out.println("i .." + i);
		}
		
		//internalQueue.offer(1);
		
		Thread t1 = new SequencePrinter(1,internalQueue,numberOfThreads,maxSequence);
		t1.setName("T1");//not sure about the exact method name
		Thread t2 = new SequencePrinter(2,internalQueue,numberOfThreads,maxSequence);
		t2.setName("T2");
		Thread t3 = new SequencePrinter(3,internalQueue,numberOfThreads,maxSequence);
		t3.setName("T3");
		t1.start();
		t2.start();
		t3.start();
	}
	
	public static void main(String[] args) {
		Solution solution = new Solution();
		solution.printSequence(10);
	}
	
}
