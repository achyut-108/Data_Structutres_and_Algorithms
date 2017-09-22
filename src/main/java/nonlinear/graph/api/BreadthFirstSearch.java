package nonlinear.graph.api;

import java.util.Queue;
import java.util.concurrent.LinkedBlockingQueue;

public class BreadthFirstSearch {

	private BreadthFirstSearchHelper[] breadthFirstSearchHelperArr;
	private Queue<Integer> queue = new LinkedBlockingQueue<>();

	public BreadthFirstSearch(Graph G, int source) {

		breadthFirstSearchHelperArr = new BreadthFirstSearchHelper[G.noOfVertices()];
		int temp_source = source;
		queue.add(source);
		while (!queue.isEmpty()) {
			int node = queue.poll();
			if (!breadthFirstSearchHelperArr[node].isMarked()) { 
				breadthFirstSearchHelperArr[node].setMarked(true);
				breadthFirstSearchHelperArr[node].setEdgeTo(temp_source);
			}
			temp_source = node;
			G.adjacentVertices(node).forEach(e -> {
				queue.add((Integer) e);
			});
		}
	}

	public static void main(String[] args) {
		System.out.println();
	}
}
