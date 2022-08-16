package deque;

public class DoubleEndedNode<E> {

	private DoubleEndedNode next;
	private DoubleEndedNode previous;
	private E item;

	public DoubleEndedNode<E> getNext() {
		return next;
	}

	public void setNext(DoubleEndedNode<E> next) {
		this.next = next;
	}

	public DoubleEndedNode<E> getPrevious() {
		return previous;
	}

	public void setPrevious(DoubleEndedNode<E> previous) {
		this.previous = previous;
	}

	public E getItem() {
		return item;
	}

	public void setItem(E item) {
		this.item = item;
	}
}
