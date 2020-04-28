package binaryTreeConcept;

public class HeightOfBinaryTree {

	private BinaryTree tree;

	public HeightOfBinaryTree(BinaryTree tree) {
		this.tree = tree;
	}

	public Integer height() {
		if (this.tree == null || this.tree.getRoot() == null)
			return null;

		return this.height(this.tree.getRoot());

	}

	private Integer height(TreeNode treeNode) {

		if (treeNode == null)
			return 0; 
		int hLeft = this.height(treeNode.getLeft());
		int hright = this.height(treeNode.getRight());

		return Math.max(hLeft, hright) + 1;
	}

}
