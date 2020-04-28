package binaryTreeConcept;

import java.math.BigInteger;

public class BinarySearchTree<E extends Comparable> extends BinaryTree {

	private static final BigInteger sizeIncrementor = new BigInteger("1");

	private TreeNode<E> root;

	private BigInteger size = new BigInteger("0");

	public TreeNode<E> getRoot() {
		return root;
	}

	public BigInteger getSize() {
		return size;
	}

	// @Override
	public void addToTree(E item) {

		if (item == null)
			return;
		TreeNode nodeToAdd = new TreeNode<>();
		nodeToAdd.setItem(item);

		if (this.root == null) {
			this.root = nodeToAdd;
			this.size.add(sizeIncrementor);
			return;
		}

		TreeNode temp = this.root;
		TreeNode previous = null;
		while (temp != null) {
			if (temp.getItem().compareTo(item) > 0) {
				previous = temp;
				temp = temp.getLeft();
				if (temp == null) {
					previous.setLeft(nodeToAdd);
					size.add(sizeIncrementor);
					return;
				}
			} else {
				previous = temp;
				temp = temp.getRight();
				if (temp == null) {
					previous.setRight(nodeToAdd);
					size.add(sizeIncrementor);
					return;
				}
			}

		}

	}

	public boolean search(E item) {

		if (item == null)
			return false;

		int compare = this.root.getItem().compareTo(item);

		if (compare == 0)
			return true;

		TreeNode node = null;

		if (compare > 0)
			node = this.root.getLeft();
		else
			node = this.root.getRight();

		TreeNode previous = this.root;

		return this.searchHelper(node, previous, item) != null ? true : false;

	}

	private TreeNode searchHelper(TreeNode rootNode, TreeNode previous, E itemToSearch) {

		if (rootNode == null)
			return null;

		int compare = rootNode.getItem().compareTo(itemToSearch);

		if (compare == 0)
			return previous;
		if (compare > 0)
			return this.searchHelper(rootNode.getLeft(), rootNode, itemToSearch);
		else
			return this.searchHelper(rootNode.getRight(), rootNode, itemToSearch);
	}

	// private void deleteHelper

	public void delete(E item) {
		if (item == null)
			return;

		int compare = this.root.getItem().compareTo(item);

		TreeNode nodeToDelete = null;
		TreeNode nodeToReplace = null;

		TreeNode temp = null;

		TreeNode previousNode = null;

		
		boolean left = true;
		if (compare == 0) {
			nodeToDelete = this.root;
		} else if (compare > 0) {
			temp = this.root.getLeft();
			previousNode = this.root;
			left = true;
		} else {
			temp = this.root.getRight();
			previousNode = this.root;
			left = false;
		}

		

		if (compare != 0) {
			// this.deleteHelper(temp, left, nodeToDelete, previousNode, item);
			while (temp != null) {
				int tmpCompare = temp.getItem().compareTo(item);
				System.out.println("tmpCompare : " + tmpCompare);
				if (tmpCompare == 0) {
					// nodeToDelete = this.copyValuesToTheOriginalRefrence(nodeToDelete, temp);
					nodeToDelete = temp;

					break;
				} else if (tmpCompare > 0) {
					// previousNode = this.copyValuesToTheOriginalRefrence(previousNode, temp);
					previousNode = temp;
					temp = temp.getLeft();
					left = true;
					
				} else {
					// previousNode = this.copyValuesToTheOriginalRefrence(previousNode, temp);
					previousNode = temp;
					temp = temp.getRight();
					left = false;
				}
			}
		}

		System.out.println("Node to delete is : " + nodeToDelete.getItem());

		if (nodeToDelete == null)
			return;

		if (nodeToDelete.getLeft() == null && nodeToDelete.getRight() == null) {

			if (previousNode == null) {
				this.root = null;
				return;
			}

			if (left)
				previousNode.setLeft(null);
			else
				previousNode.setRight(null);
			return;
		}

		if (nodeToDelete.getLeft() == null)
			nodeToReplace = nodeToDelete.getRight();
		else if (nodeToDelete.getRight() == null)
			nodeToReplace = nodeToDelete.getLeft();

		System.out.println("Node To Replace when one child is null... : " + nodeToReplace.getItem());

		if (nodeToReplace != null) {

			if (previousNode == null) {

				this.root = nodeToReplace;
				return;

			} else {

				System.out.println("previous node is : " + previousNode.getItem() + " left is : " + left);
				
				if (left) {
					System.out.println("left.....");
					previousNode.setLeft(nodeToReplace);
				} else
					previousNode.setRight(nodeToReplace);
				return;
			}
		}

		temp = nodeToDelete.getRight();// Needed to find the nodeToReplace in case both the child are non null..
		TreeNode nodeToReplacePrevious = nodeToDelete;

		while (temp != null) {
			nodeToReplace = temp;
			temp = temp.getLeft();
			if (temp != null) {
				nodeToReplacePrevious = nodeToReplace;
				nodeToReplace = temp;
			}
		}

		System.out.println("Node to replace is : " + nodeToReplace.getItem() + " NodeToReplaceprevious is : "
				+ nodeToReplacePrevious.getItem());

		E nodeToDeleteItem = (E) nodeToDelete.getItem();
		E nodeToReplacePreviousItem = (E)nodeToReplacePrevious.getItem();

		nodeToDelete.setItem(nodeToReplace.getItem());// Replacing the value of the node to be deleted with the value of
														// node to be replaced

		if (nodeToReplacePreviousItem.compareTo(nodeToDeleteItem) == 0) {
			nodeToReplacePrevious.setRight(nodeToReplace.getRight());
		} else {
			System.out.println("here...");
			nodeToReplacePrevious.setLeft(nodeToReplace.getRight());
		}

	}

	// If Node to delete is root...
	// if (previousNode == null) {
	// if (nodeToReplace.getItem().compareTo(nodeToDelete.getLeft().getItem()) != 0)
	// nodeToReplace.setLeft(nodeToDelete.getLeft());
	// nodeToReplace.setRight(nodeToDelete.getRight());
	// nodeToDelete.setLeft(null);
	// nodeToDelete.setRight(null);
	// nodeToDelete = null;
	// this.root = nodeToReplace;
	// nodeToReplacePrevious.setLeft(null);
	// } else {
	//
	// System.out.println(" Pevious Node is : " + previousNode.getItem() + "
	// NodeToReplaceprevious is : "
	// + nodeToReplacePrevious.getItem());
	//
	// if (left) {
	// previousNode.setLeft(nodeToReplace);
	// if (nodeToReplace.getItem().compareTo(nodeToDelete.getLeft().getItem()) != 0)
	// nodeToReplace.setLeft(nodeToDelete.getLeft());
	// nodeToReplace.setRight(nodeToDelete.getRight());
	// nodeToDelete.setLeft(null);
	// nodeToDelete.setRight(null);
	// nodeToDelete = null;
	// nodeToReplacePrevious.setLeft(null);
	// } else {
	// previousNode.setRight(nodeToReplace);
	// nodeToReplace.setLeft(nodeToDelete.getLeft());
	// nodeToReplace.setRight(nodeToDelete.getRight());
	// nodeToDelete.setLeft(null);
	// nodeToDelete.setRight(null);
	// nodeToDelete = null;
	// nodeToReplacePrevious.setLeft(null);
	// }
	// }

	private void deleteHelper(TreeNode temp, Boolean left, TreeNode nodeToDelete, TreeNode previousNode, E item) {
		while (temp != null) {
			int tmpCompare = temp.getItem().compareTo(item);
			if (tmpCompare == 0) {
				nodeToDelete = this.copyValuesToTheOriginalRefrence(nodeToDelete, temp);
				// nodeToDelete = temp;

				break;
			} else if (tmpCompare > 0) {
				previousNode = this.copyValuesToTheOriginalRefrence(previousNode, temp);
				// previousNode = temp;
				temp = temp.getLeft();
				left = true;
			} else {
				previousNode = this.copyValuesToTheOriginalRefrence(previousNode, temp);
				// previousNode = temp;
				temp = temp.getRight();
				left = false;
			}
		}

		System.out.println("In delete helper nodeToDelete is : " + nodeToDelete.getItem());

	}

	private TreeNode copyValuesToTheOriginalRefrence(TreeNode reference, TreeNode value) {

		// if(reference == null) reference = new TreeNode();

		reference.setItem(value.getItem());
		reference.setLeft(value.getLeft());
		reference.setRight(value.getRight());

		return reference;
	}

	public static void main(String[] args) {
		BinarySearchTree<Integer> bst = new BinarySearchTree<>();
		// bst.addToTree(1);
		// bst.addToTree(9);
		// bst.addToTree(5);
		// bst.addToTree(-1);
		// bst.addToTree(6);
		// bst.addToTree(13);
		// bst.addToTree(8);
		// bst.addToTree(4);

		int[] arr = { 42, 51, 94, 1, 35, 65, 25, 15, 88, 57, 44, 92, 28, 66, 60, 37, 33, 52, 38, 29, 76, 8, 75, 22, 59,
				96, 30, 36 };

		for (int i = 0; i < arr.length; i++) {
			bst.addToTree(arr[i]);
		}

		BinaryTreeTraversals treeTraversals = new BinaryTreeTraversals(bst);

		// System.out.println("Before Addition!!");
		treeTraversals.inOrderTraversal();
		// System.out.println("After additon!!!");

		BinarySearchTreeUtils<Integer> bstUtils = new BinarySearchTreeUtils();

		// bstUtils.replaceANodeBySumOfItsInorderPredAndSucc(bst, 14);

		bst.delete(1);

		System.out.println("After deletion!!!");
		treeTraversals.inOrderTraversal();

	}
}
