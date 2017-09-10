package nonlinear.graph.api;

public class DepthFirstSearch {
	
	private DepthFirstSearchHelper[] depthFirstSearchHelperArr;
	
	public DepthFirstSearch(Graph G) {
		this.depthFirstSearchHelperArr = new DepthFirstSearchHelper[G.noOfVertices()];
		this.dfs();
	}
	
	private void dfs() {
		
	}
	
}
