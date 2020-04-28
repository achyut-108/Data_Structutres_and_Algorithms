package binaryTreeConcept;

import java.math.BigInteger;
import java.util.LinkedList;
import java.util.Queue;

public class BinaryTree<E extends Comparable> {

	private TreeNode<E> root;
	private Queue<TreeNode> queue;
	private BigInteger size = new BigInteger("0");
	private static final BigInteger incrementor = new BigInteger("1");

	public BinaryTree() {
		this.queue = new LinkedList<>();
	}

	public TreeNode<E> getRoot() {
		return root;
	}

	public BigInteger getSize() {
		return size;
	}

	private boolean isFullNode(TreeNode node) {
		return node != null && node.getRight() != null && node.getLeft() != null;
	}

	public void add(E item) {
		if (this.root == null) {
			TreeNode node = new TreeNode(item);
			this.root = node;
			this.queue.add(node);
			this.size.add(incrementor);

			return;
		}

		TreeNode nodeToAdd = new TreeNode(item);
		TreeNode nodeToWhichToAdd = this.queue.peek();

		if (!this.isFullNode(nodeToWhichToAdd)) {
			if (nodeToWhichToAdd.getLeft() == null) {
				nodeToWhichToAdd.setLeft(nodeToAdd);
			} else {
				nodeToWhichToAdd.setRight(nodeToAdd);
				queue.remove();
			}

			this.queue.add(nodeToAdd);
			this.size.add(incrementor);
		}

	}

	public boolean doneAdding() {
		this.queue = null;
		return true;
	}

}
