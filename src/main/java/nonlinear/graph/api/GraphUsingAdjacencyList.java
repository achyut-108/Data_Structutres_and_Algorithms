package nonlinear.graph.api;

import java.util.ArrayList;
import java.util.List;

public class GraphUsingAdjacencyList implements Graph{

	private final Integer V;
	private List<Object>[] vertices;
	
	
	/***
	 * 
	 * @param V
	 * Will create a Graph with V Vertices using adjacency list representation
	 */
	public GraphUsingAdjacencyList(int V) {
		this.V = V;
		vertices = (List<Object>[])new List[this.V];
		for(int i = 0;i<V;i++) {
			vertices[i] = new ArrayList<Object>();
		}
	}
	
	@Override
	public void addEdge(int v, int w) {
		this.vertices[v].add(w);
		this.vertices[w].add(v);
	}

	@Override
	public int noOfVertices() {
		// TODO Auto-generated method stub
		return V;
	}

	@Override
	public int noOfEdges() {
		// TODO Auto-generated method stub
		return 0;
	}

	@Override
	public List<Object> adjacentVertices(int v) {
		// TODO Auto-generated method stub
		return this.vertices[v];
	}

	public static void main(String[] args) {
		GraphUsingAdjacencyList G = new GraphUsingAdjacencyList(5);
		G.addEdge(0, 1);
		G.addEdge(0, 2);
	}
	
}

