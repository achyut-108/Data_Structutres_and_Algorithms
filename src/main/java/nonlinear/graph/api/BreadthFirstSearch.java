package nonlinear.graph.api;

import java.util.Queue;
import java.util.concurrent.LinkedBlockingQueue;

public class BreadthFirstSearch {

	private BreadthFirstSearchHelper[] breadthFirstSearchHelperArr;
	private Queue<Integer> queue = new LinkedBlockingQueue<>();
	
	public BreadthFirstSearch(Graph G,int source) {
		queue.add(source);
		while(!queue.isEmpty()) {
			int node = queue.poll();
			
		}
	}
	
}
