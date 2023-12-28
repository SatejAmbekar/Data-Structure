public class CircularLinkedList {
    Node head;

    public CircularLinkedList() {
        head = null;
    }

    public boolean insert(int data) {

        Node newNode = new Node(data);
        if(newNode == null) {
            return false;
        }

        if(head == null) {
            head = newNode;
            newNode.setNext(head);
            return true;
        }

        Node last = head;
        while(last.getNext() != head) {
            last = last.getNext();
        }

        last.setNext(newNode);
        newNode.setNext(head);

        return true;
    }

    public boolean insert(int data, int position) {
        if(position <= 0) {
            return false;
        }

        Node newNode = new Node(data);
        if(newNode == null) {
            return false;
        }

        if(position == 1) {

            if(head == null) {
                head = newNode;
                newNode.setNext(newNode);
                return true;
            }

            newNode.setNext(head);
            Node last = head;
            while(last.getNext() != head) {
                last = last.getNext();
            }
            last.setNext(newNode);
            head = newNode;

            return true;
        }

        Node prev = head;
        for(int i= 1; i < position - 1; i++) {
            prev = prev.getNext();
            if(prev == head) {
                return false;
            }
        }

        newNode.setNext(prev.getNext());
        prev.setNext(newNode);

        return true;

    }

    public void display() {
        if(head == null) {
            return;
        }

        Node temp = head;
        do {
            System.out.print(temp.getData() + " ");
            temp = temp.getNext();
        }while(temp != head);

        System.out.println();
    }

    public boolean deleteByVal(int data) {
        if(head == null) {
            return false;
        }

        if(head.getData() == data) {

            if(head.getNext() == head) {
                head = null;
                return true;
            }

            Node last = head;
            while(last.getNext() != head) {
                last = last.getNext();
            }
            last.setNext(head.getNext());
            head = head.getNext();

            return true;
        }

        Node prev = head, del = head;
        while(del.getData() != data) {
            prev = del;
            del = del.getNext();
            if(del == head) {
                return false;
            }
        }

        prev.setNext(del.getNext());
        return true;
    }

    public boolean deleteByPosition(int position) {
        if(head == null || position < 1) {
            return false;
        }

        if(position == 1) {
            if(head.getNext() == head) {
                head = null;
                return true;
            }

            Node last = head;
            while(last.getNext() != head) {
                last = last.getNext();
            }
            last.setNext(head.getNext());
            head = head.getNext();

            return true;
        }

        Node prev = head;
        for(int i = 1; i < position - 1; i++) {
            prev = prev.getNext();
            if(prev.getNext() == head) {
                return false;
            }
        }
        //Node del = prev.getNext();
        //prev.setNext(del.getNext());

        prev.setNext(prev.getNext().getNext());

        return true;
    }

}
