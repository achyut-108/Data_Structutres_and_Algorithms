package deque;

import java.util.Objects;

/**
 * 
 * @author siddhartha.kumar
 *
 * @param <E>
 */
public class DequeUsingLinkedList<E> {

	private DoubleEndedNode<E> first;
	private DoubleEndedNode<E> last;
	private int size;

	public void offerFirst(E item) {
		if (Objects.nonNull(item)) {
			if (first == null) {
				first = new DoubleEndedNode<E>();
				first.setItem(item);
				last = first;
				size++;
			} else {
				DoubleEndedNode<E> newNode = new DoubleEndedNode<E>();
				newNode.setItem(item);
				newNode.setNext(this.first);
				first.setPrevious(newNode);
				first = newNode;
				size++;
			}
		}
	}

	public void offerLast(E item) {
		if (Objects.nonNull(item)) {
			if (Objects.isNull(first)) {
				first = new DoubleEndedNode<E>();
				first.setItem(item);
				first = last;
				size++;
			} else {
				DoubleEndedNode<E> newNode = new DoubleEndedNode<E>();
				newNode.setItem(item);
				last.setNext(newNode);
				newNode.setPrevious(last);
				last = newNode;
				size++;
			}
		}
	}

	public boolean isEmpty() {
		return size == 0;
	}

	public E pollFirst() {
		E item = null;
		if (!isEmpty()) {
			item = first.getItem();
			DoubleEndedNode<E> newFirst = first.getNext();
			if (newFirst != null)
				newFirst.setPrevious(null);
			first.setNext(null);
			first = newFirst;
			size--;
		}

		return item;
	}

	public E pollLast() {
		E item = null;
		if (!isEmpty()) {
			DoubleEndedNode<E> newLast = last.getPrevious();
			newLast.setNext(null);
			last.setPrevious(null);
			last = newLast;
			size--;
		}

		return item;
	}

	public E peekFirst() {
		return !isEmpty() ? first.getItem() : null;
	}

	public E peekLast() {
		return !isEmpty() ? last.getItem() : null;
	}

	public int size() {
		return size;
	}

	public static void main(String[] args) {
		DequeUsingLinkedList<Integer> dequeUsingLinkedList = new DequeUsingLinkedList<Integer>();
		dequeUsingLinkedList.offerFirst(1);
		System.out.println("peek : " + dequeUsingLinkedList.peekFirst());
		dequeUsingLinkedList.offerFirst(2);
		System.out.println("peek : " + dequeUsingLinkedList.peekFirst());
		dequeUsingLinkedList.offerLast(3);
		System.out.println("peek : " + dequeUsingLinkedList.peekFirst());

		for (int i = 0; i < 3; i++) {
			System.out.println("----- " + i);
			System.out.println(dequeUsingLinkedList.pollFirst());
		}

	}
}