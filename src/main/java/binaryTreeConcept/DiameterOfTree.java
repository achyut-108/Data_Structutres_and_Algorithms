package binaryTreeConcept;

public class DiameterOfTree {

	private BinaryTree tree;

	public DiameterOfTree(BinaryTree tree) {
		this.tree = tree;
	}

	public Integer diameter() {
		if (this.tree == null || this.tree.getRoot() == null)
			return null;

		return this.diameter(this.tree.getRoot());
	}

	private Integer height(TreeNode treeNode) {

		if (treeNode == null)
			return 0;
		int hLeft = this.height(treeNode.getLeft());
		int hright = this.height(treeNode.getRight());

		return Math.max(hLeft, hright) + 1;
	}

	// approach1 (o(n^2)) Complexity
	private Integer diameter(TreeNode node) {

		if (node == null)
			return 0;

		int ld = this.diameter(node.getLeft());
		int rd = this.diameter(node.getRight());

		int d3 = this.height(node.getLeft()) + this.height(node.getRight()) + 1;

		return Math.max(Math.max(ld, rd), d3);
	}

	class Height {
		int h;
	}

	// approach2 (O(n)) Complexity
	private Integer diameterOptimised(TreeNode node, Height height) {

		Height lh = new Height();
		Height rh = new Height();

		if (node == null) {
			height.h = 0;
			return 0;
		}

		int ld = this.diameterOptimised(node.getLeft(), lh);
		int rd = this.diameterOptimised(node.getRight(), rh);

		height.h = Math.max(lh.h, rh.h) + 1;
		
		int d3 = lh.h + rh.h + 1;

		return Math.max(Math.max(ld, rd), d3);
	}

}
