package nonlinear.graph.api;

public class DepthFirstSearch {

	private DepthFirstSearchHelper[] depthFirstSearchHelperArr;

	private Graph G;
	/***
	 * The source vertex
	 */
	private int source;

	/**
	 * 
	 * @param G
	 * @param source
	 *            : the point at which the search has to be started
	 */
	public DepthFirstSearch(Graph G, int source) {
		this.G = G;
		this.source = source;
		this.depthFirstSearchHelperArr = new DepthFirstSearchHelper[G.noOfVertices()];
		for(int i=0;i<G.noOfVertices();i++) {
			this.depthFirstSearchHelperArr[i] = new DepthFirstSearchHelper();
		}
		this.dfs(source);
	}

	private void dfs(int source) {
		System.out.println("[dfs] : depthFirstSearchHelperArr is : " + this.depthFirstSearchHelperArr);
		this.depthFirstSearchHelperArr[source].setMarked(true);
		G.adjacentVertices(source).forEach(vertex -> {
			if (!this.depthFirstSearchHelperArr[(int) vertex].isMarked()) {
				this.depthFirstSearchHelperArr[(int) vertex].setEdgeTo(source);
				this.dfs((int) vertex);
			}
		});
	}

	public DepthFirstSearchHelper[] getDepthFirstSearchHelperArr() {
		return depthFirstSearchHelperArr;
	}

	public Graph getG() {
		return G;
	}

	public int getSource() {
		return source;
	}

}
