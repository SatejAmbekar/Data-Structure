public class Queue {
    private int [] arr;
    int front, rear;
    private int size;

    public Queue(int size) {
        this.size = size;
        front = rear = -1;
        arr = new int[size];
    }

    public boolean isEmpty() {
        return (front == -1 && rear == -1) || (front > rear);
    }

    public boolean isFull() {
        return rear == size - 1;
    }

    public boolean insert(int data) {
        if(isFull()) {
            return false;
        }

        arr[++rear] = data;
        return true;
    }

    public int delete() {
        if(isEmpty()) {
            return -999;
        }

        return arr[front++];
    }
}
