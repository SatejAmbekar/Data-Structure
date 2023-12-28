public class Main {
    public static void main(String[] args) {
        BinarySearchTree bst = new BinarySearchTree();

        bst.insert(50);
        bst.insert(20);
        bst.insert(80);
        bst.insert(10);
        bst.insert(40);
        bst.insert(60);
        bst.insert(90);
        bst.insert(15);
        bst.insert(70);
        bst.insert(30);

        bst.preOrder();
        bst.preOrder(bst.getRoot());
        System.out.println();

        bst.inOrder();
        bst.inOrder(bst.getRoot());
        System.out.println();

        bst.postOrder();
        bst.postOrder(bst.getRoot());
        System.out.println();

        System.out.println("60? " + bst.find(bst.getRoot(), 60));
        System.out.println("70? " + bst.find(bst.getRoot(), 70));
        System.out.println("50? " + bst.find(bst.getRoot(), 50));
        System.out.println("160? " + bst.find(bst.getRoot(), 160));

        bst.delete(50);
        bst.preOrder();
        bst.inOrder();
        bst.postOrder();

        System.out.println("Del 49: " + bst.delete(49));

    }
}
