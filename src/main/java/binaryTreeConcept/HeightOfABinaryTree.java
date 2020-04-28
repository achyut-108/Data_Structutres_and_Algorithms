package binaryTreeConcept;

public class HeightOfABinaryTree<E extends Comparable> {

	private TreeNode<E> node;

	public HeightOfABinaryTree(TreeNode node) {
		this.node = node;
	}

	public int getHeight() {

		return this.getHeight(this.node);
	}

	private int getHeight(TreeNode node) {
		if (node == null)
			return 0;

		return Math.max(getHeight(node.getLeft()), getHeight(node.getRight())) + 1;
	}
}
