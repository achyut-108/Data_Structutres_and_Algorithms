package binaryTreeConcept;

public class BinaryTreeTest {

	
	public static void main(String[] args) {
		BinaryTree<Integer> bt = new BinaryTree();
		
		bt.add(1);
		bt.add(2);
		bt.add(3);
		bt.add(4);
		bt.add(4);
		bt.add(4);
		bt.add(7);
		bt.add(9);
		bt.doneAdding();
		
		System.out.println(bt.getRoot().getLeft().getLeft().getItem());
		System.out.println(bt.getRoot().getRight().getItem());
		
		System.out.println("size : " + bt.getSize());
		
		HeightOfABinaryTree<Integer> heightOfABinaryTree = new HeightOfABinaryTree<>(bt.getRoot());
		
		System.out.println("height : " + heightOfABinaryTree.getHeight());
		
	}
}
