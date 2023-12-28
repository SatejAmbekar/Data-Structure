package Que1;

import java.util.ArrayList;
import java.util.List;

public class LinkedList {
	private Book head;
	private int count;

	public LinkedList() {
		this.head = null;
		count = 0;
	}

	public Book getHead() {
		return head;
	}

	public void setHead(Book head) {
		this.head = head;
	}

	public int getCount() {
		return count;
	}

	public void setCount(int count) {
		this.count = count;
	}

	public boolean addAtEnd(int bookId, String bookTitle, String bookAuthor, double price) {
		Book newNode = new Book(bookId, bookTitle, bookAuthor, price);
		if (newNode == null) {
			return false;
		}
		if (head == null) {
			head = newNode;
			count++;
			return true;

		}

		Book temp = head;
		while (temp.getNext() != null) {
			temp = temp.getNext();
		}
		temp.setNext(newNode);
		count++;
		return true;
	}

	public boolean deleteAtEnd() {
		if (head == null) {
			return false;

		}
		if (head.getNext() == null) {
			head = null;
			count--;
			return true;

		}
		Book prev = head;
		while (prev.getNext().getNext() != null) {
			prev = prev.getNext();
		}
		prev.setNext(null);
		count--;
		return true;

	}

	public boolean insertAtFront(int bookId, String bookTitle, String bookAuthor, double price) {
		Book newNode = new Book(bookId, bookTitle, bookAuthor, price);
		if (newNode == null) {
			return false;
		}
		if (head == null) {
			head = newNode;
			count++;
			return true;
		}
		newNode.setNext(head);
		head = newNode;
		count++;
		return true;
	}

	public boolean deleteAtStart() {
		if (head == null) {
			return false;

		}
		if (head.getNext() == null) {
			head = null;
			count--;
			return true;

		}
		head = head.getNext();
		count--;
		return true;

	}

	public boolean insertAtPosition(int bookId, String bookTitle, String bookAuthor, double price, int pos) {
		Book newNode = new Book(bookId, bookTitle, bookAuthor, price);
		if (newNode == null) {
			return false;
		}

		if (pos == 1) {
			if (head == null) {
				head = newNode;
			} else {
				newNode.setNext(head);
				head = newNode;
			}
			count++;
			return true;
		}
		if (pos > count + 1) {
			return false;
		}

		if (pos <= count + 1) {
			int temp = 2;
			Book prev = head;
			while (temp < pos) {
				prev = prev.getNext();
				temp++;
			}
			newNode.setNext(prev.getNext());
			prev.setNext(newNode);
			count++;
			return true;
		}
		return false;
	}

	public boolean deleteAtPosition(int pos) {

		if (pos == 1) {
			if (head == null) {
				return false;
			}
			head = head.getNext();
			count--;
			return true;
		}
		if (pos > count) {
			return false;
		}
		int temp = 2;
		Book prev = head;
		while (temp < pos && pos <= count) {
			prev = prev.getNext();
			temp++;
		}
		prev.setNext(prev.getNext().getNext());
		count--;
		return true;

	}

	public void searchByBookName(String name) {
		Book temp = head;
		while (temp != null) {
			if (temp.getBookTitle().equals(name)) {
				System.out.println(temp);
			}
			temp = temp.getNext();
		}
	}

	public void sort() {
		List<Book> book = new ArrayList<>();
		Book temp = head;
		while (temp != null) {
			book.add(temp);
			temp = temp.getNext();
		}
		book.stream().sorted((s1, s2) -> {
			if (s2.getPrice() < s1.getPrice()) {
				return -1;
			} else if (s2.getPrice() == s1.getPrice()) {
				return 0;
			} else
				return 1;
		}).forEach(s -> System.out.println(s));

	}

	public void display() {
		Book temp = head;
		while (temp != null) {
			System.out.println(temp);
			temp = temp.getNext();
		}
	}

}
