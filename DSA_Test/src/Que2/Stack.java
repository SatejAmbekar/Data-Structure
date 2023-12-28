package Que2;

public class Stack {
	private Student[] arr;
	private int size;
	private int top;

	public Stack(int size) {
		// super();
		this.size = size;
		this.arr = new Student[size];
		this.top = -1;
	}

	public Student[] getArr() {
		return arr;
	}

	public int getSize() {
		return size;
	}

	public int getTop() {
		return top;
	}

	public boolean isEmpty() {
		if (top == -1) {
			return true;
		}
		return false;
	}

	public boolean isFull() {
		if (top == size - 1) {
			return true;
		}
		return false;
	}

	public void push(int studentId, String studentName, int studentMarks) {
		Student newNode = new Student(studentId, studentName, studentMarks);
		if (newNode == null) {
			return;
		}
		if (!isFull()) {
			arr[++top] = newNode;
		}
	}

	public Student pop() {
		if (!isEmpty()) {
			return arr[top--];
		}
		return null;
	}

	public Student peek() {
		if (!isEmpty()) {
			return arr[top];
		}
		return null;
	}

	public void display() {
		if (!isEmpty()) {
			for (int i = 0; i <= top; i++) {
				System.out.println(arr[i]);
			}
		}else {
			System.out.println("Stack is empty");
		}
		
	}
}
