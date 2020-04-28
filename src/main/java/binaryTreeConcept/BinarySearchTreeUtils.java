package binaryTreeConcept;

public class BinarySearchTreeUtils<E extends Comparable> {

	private BinarySearchTree<Comparable<E>> binarySearchTree;

	// public BinarySearchTreeUtils(BinarySearchTree<Comparable<E>>
	// binarySearchTree) {
	// this.binarySearchTree = binarySearchTree;
	// }

	public void replaceANodeBySumOfItsInorderPredAndSucc(BinarySearchTree<Integer> bst, Integer item) {

		if (bst == null || item == null)
			return;

		this.replaceHelper(bst.getRoot(), item);

		if (current != null && sucessor == null && previous != null) {
			current.setItem(previous.getItem());
		}
		// no condtion for previous== null required as For a BST with only node
		// no addition is required as there are no previous and successor nodes...
	}

	TreeNode<Integer> previous = null;
	TreeNode<Integer> current = null;
	TreeNode<Integer> sucessor = null;

	private void replaceHelper(TreeNode<Integer> node, Integer item) {

		if (node == null)
			return;

		this.replaceHelper(node.getLeft(), item);

		System.out.println("Node being inspected is : " + node.getItem());

		// check for successor == null required
		// so that the succesor doesnot get updated in the subsequent
		// recrusive calls
		if (current != null && sucessor == null) {
			sucessor = node;
			System.out.println("successor is : " + sucessor.getItem());
		}

		if (item.compareTo(node.getItem()) == 0) {
			current = node;
		} else if (current == null) {
			previous = node;
			System.out.println("previous is : " + previous.getItem());
		}

		if (sucessor != null) {
			System.out.println("inside successir not null : " + previous.getItem());
			if (previous != null)
				current.setItem(previous.getItem() + sucessor.getItem());
			else
				current.setItem(sucessor.getItem());
			return;
		} else
			this.replaceHelper(node.getRight(), item);

	}

}
