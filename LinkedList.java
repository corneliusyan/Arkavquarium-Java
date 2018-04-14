public class LinkedList<T> {
	private Node<T> head;

	public LinkedList() {
		head = null;
	}

	public void add(T data) {
		Node<T> newNode = new Node<T>(data);
		if (head == null) {
			head = newNode;
		} else {
			Node<T> cur = head;
			while (cur.getNext() != null) {
				cur = cur.getNext();
			}
			cur.setNext(newNode);
		}
	}

	public void remove(T data) {
		int idx = find(data);
		do {
			if (idx == 0) {
				Node<T> temp = head;
				head = head.getNext();
			} else {
				Node<T> cur = head;
				while (cur.getNext().getData() != data) {
					cur = cur.getNext();
				}
				Node<T> temp = cur.getNext();
				cur.setNext(cur.getNext().getNext());
			}
			idx = find(data);
		} while (idx != -1);
	}

	public int find(T data) {
		int ans = 0;
		Node<T> cur = head;
		while (cur != null && cur.getData() != data) {
			cur = cur.getNext();
			ans++;
		}
		return (cur == null ? -1 : ans);
	}

	public Node<T> getHead() {
		return head;
	}

	public T get(int idx) {
		Node<T> cur = head;
		while (idx > 0) {
			cur = cur.getNext();
			idx--;
		}
		return cur.getData();
	}

	public boolean isEmpty() {
		return (head == null);
	}

	public int getSize() {
		int size = 0;
		Node<T> cur = head;
		while (cur != null) {
			size++;
			cur = cur.getNext();
		}
		return size;
	}
}