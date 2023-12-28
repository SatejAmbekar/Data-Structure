import java.util.Arrays;

public class Main {
    public static void main(String[] args) {

        CircularQueueNew q = new CircularQueueNew(5);

        System.out.println("Ins: " + q.insert(10));
        System.out.println("Ins: " + q.insert(20));
        System.out.println("Ins: " + q.insert(30));
        System.out.println("Ins: " + q.insert(40));
        System.out.println("Ins: " + q.insert(50));

        System.out.println("isFull: " + q.isFull());

        System.out.println("Delete: " + q.delete());
        System.out.println("isFull: " + q.isFull());
        System.out.println("Delete: " + q.delete());
        System.out.println("isFull: " + q.isFull());


        /*CircularQueue q = new CircularQueue(5);
        System.out.println("Ins: " + q.insert(10));
        System.out.println("Ins: " + q.insert(20));
        System.out.println("Ins: " + q.insert(30));
        System.out.println("Ins: " + q.insert(40));
        System.out.println("Ins: " + q.insert(50));

        System.out.println("isFull: " + q.isFull());

        System.out.println("Delete: " + q.delete());
        System.out.println("isFull: " + q.isFull());
        System.out.println("Delete: " + q.delete());
        System.out.println("isFull: " + q.isFull());
        */

    }
}
