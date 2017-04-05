/**
 * Title: Project 5
 *
 * Description: Doubly Linked List
 *
 * @ Author: Tejal Deshpande, Grady Jenkins, Joe Gudzak
 * 
 * @ Version: 1.0
 *
 */

public class DoublyLinkedList<T> {
	
//private static inner node class

	public static class Node<T> {
		private T data;
		private Node next;
		private Node prev;

		public Node(T data) {
			this.data = data;
		}

		@Override
		public String toString() {
			return data.toString();
		}

		T getData() {
			return data;
		}

		Node getNext() {
			return this.next;
		}
	}

	public Node first = null;
	public Node last = null;

//Inserts a new node at the beginning of list
	public void addFirst(T data) {
		Node newNode = new Node(data);

		if (isEmpty()) {
			newNode.next = null;
			newNode.prev = null;
			first = newNode;
			last = newNode;

		} else {
			first.prev = newNode;
			newNode.next = first;
			newNode.prev = null;
			first = newNode;
		}
	}

// Returns true if list is empty
	public boolean isEmpty() {
		return (first == null);
	}

	// returns first element in list
	public Node getFirst() {
		return first;
	}

	//returns last element in list
	public Node getLast() {
		return last;
	}


}
