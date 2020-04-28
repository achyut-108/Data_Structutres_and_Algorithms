package binaryTreeConcept;

import java.util.LinkedList;
import java.util.Queue;

public class BinaryTreeTraversals {

	private BinaryTree tree;

	public BinaryTreeTraversals(BinaryTree tree) {
		this.tree = tree;
	}

	private boolean isTreeNull() {
		if (tree == null || tree.getRoot() == null)
			return true;
		return false;
	}

	public void inOrderTraversal() {
		System.out.println("inOrderTraversal Start !!");
		if (!isTreeNull())
			this.inOrderTraversal(tree.getRoot());

		System.out.println("InOrderTraversal ends!!");
	}

	private void inOrderTraversal(TreeNode treeNode) {
		if (treeNode == null)
			return;
		this.inOrderTraversal(treeNode.getLeft());
		System.out.println("Node is..... : " + treeNode.getItem());
		this.inOrderTraversal(treeNode.getRight());
	}

	public void preOrderTraversal() {
		if (!isTreeNull())
			this.preOrderTraversal(this.tree.getRoot());
	}

	private void preOrderTraversal(TreeNode node) {
		if (node == null)
			return;
		System.out.println("Node is : " + node);
		this.preOrderTraversal(node.getLeft());
		this.preOrderTraversal(node.getRight());
	}

	public void postOrderTraversal() {
		if (!isTreeNull())
			this.postOrderTraversal(this.tree.getRoot());
	}

	private void postOrderTraversal(TreeNode node) {
		if (node == null)
			return;
		this.postOrderTraversal(node.getLeft());
		this.postOrderTraversal(node.getRight());
		System.out.println("Node is : " + node);

	}

	public void levelOrderTraversal() {

		Queue<TreeNode> queue = new LinkedList<TreeNode>();
		queue.add(this.tree.getRoot());

		while (!queue.isEmpty()) {
			TreeNode node = queue.poll();
			System.out.println("Node is : " + node);
			if (node.getLeft() != null)
				queue.add(node.getLeft());
			if (node.getRight() != null)
				queue.add(node.getRight());
		}
	}

}
