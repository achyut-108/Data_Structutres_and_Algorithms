package nonlinear.graph.api;

public class DepthFirstSearch {

	private DepthFirstSearchHelper[] depthFirstSearchHelperArr;

	private Graph G;

	/**
	 * 
	 * @param G
	 * @param source
	 *            : the point at which the search has to be started
	 */
	public DepthFirstSearch(Graph G, int source) {
		this.G = G;
		this.depthFirstSearchHelperArr = new DepthFirstSearchHelper[G.noOfVertices()];
		this.dfs(source);
	}

	private void dfs(int source) {
		this.depthFirstSearchHelperArr[source].setMarked(true);
		G.adjacentVertices(source).forEach(vertex -> {
			if (!this.depthFirstSearchHelperArr[(int) vertex].isMarked()) {
				this.depthFirstSearchHelperArr[(int) vertex].setEdgeTo(source);
				this.dfs((int)vertex);
			}
		});
	}

}
