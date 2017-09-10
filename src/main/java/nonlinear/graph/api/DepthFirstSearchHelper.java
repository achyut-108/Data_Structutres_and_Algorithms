package nonlinear.graph.api;

public class DepthFirstSearchHelper {

	private boolean marked;
	private int edgeTo;
	
	public boolean isMarked() {
		return marked;
	}
	public void setMarked(boolean marked) {
		this.marked = marked;
	}
	public int getEdgeTo() {
		return edgeTo;
	}
	public void setEdgeTo(int edgeTo) {
		this.edgeTo = edgeTo;
	}
}
