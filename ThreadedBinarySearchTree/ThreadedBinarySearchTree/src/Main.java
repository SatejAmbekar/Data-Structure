public class Main {
    public static void main(String[] args) {

        ThreadedBinarySearchTree t = new ThreadedBinarySearchTree();

        t.insert(50);
        t.insert(20);
        t.insert(10);
        t.insert(40);
        t.insert(30);
        t.insert(25);
        t.insert(90);
        t.insert(100);
        t.insert(80);
        t.insert(85);
        t.insert(60);

        t.inOrder();
        t.preOrder();
        t.postOrder();

        System.out.println();

        t.delete(50);
        t.inOrder();
        t.preOrder();
        t.postOrder();

    }
}
