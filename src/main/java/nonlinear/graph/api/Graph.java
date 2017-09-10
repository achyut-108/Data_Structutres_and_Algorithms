package nonlinear.graph.api;

public interface Graph {
	/***
	 * 
	 * @param v
	 * @param w
	 * add an edge v-w
	 */
	public void addEdge(int v, int w);
	/***
	 * returns number of vertices
	 * @return
	 */
	public int noOfVertices();
	/***
	 * returns number of edges
	 * @return
	 */
	public int noOfEdges();
	
	public Iterable<Integer> adjacentVertices(int v);
	
}
