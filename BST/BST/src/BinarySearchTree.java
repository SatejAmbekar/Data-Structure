import java.util.Stack;

public class BinarySearchTree {
    private Node root;

    public BinarySearchTree() {
        root = null;
    }

    public boolean insert(int data) {
        Node newNode = new Node(data);
        if(newNode == null) {
            return false;
        }

        if(root == null) {
            root = newNode;
            return true;
        }

        Node temp = root;
        while(true) {
            if(data == temp.getData()) {
                return false;
            }

            if(data < temp.getData()) {
                if(temp.getLeft() == null) {
                    temp.setLeft(newNode);
                    return true;
                }
                temp = temp.getLeft();
            }
            else {
                if(temp.getRight() == null) {
                    temp.setRight(newNode);
                    return true;
                }
                temp = temp.getRight();
            }
        }
    }

    public void preOrder() {
        Node temp = root;
        Stack<Node> stack = new Stack<>();

        System.out.print("Pre: ");
        while(temp != null || !stack.empty()) {

            while(temp != null) {
                System.out.print(temp.getData() + " ");
                stack.push(temp);
                temp = temp.getLeft();
            }

            //temp = stack.pop().getRight();
            temp = stack.pop();
            temp = temp.getRight();

        }
        System.out.println();
    }

    public void inOrder() {
        Node temp = root;
        Stack<Node> stack = new Stack<>();

        System.out.print("In:  ");
        while(temp != null || !stack.empty()) {
            while(temp != null) {
                stack.push(temp);
                temp = temp.getLeft();
            }

            temp = stack.pop();
            System.out.print(temp.getData() + " ");
            temp = temp.getRight();
        }
        System.out.println();
    }

    public void postOrder() {
        class Pair {
            Node node;
            char flag;

            public Pair(Node node, char flag) {
                this.node = node;
                this.flag = flag;
            }
        }

        Node temp = root;
        Stack<Pair> stack = new Stack<>();

        System.out.print("Post: ");
        while(temp != null || !stack.empty()) {

            while(temp != null) {
                stack.push(new Pair(temp, 'L'));
                temp = temp.getLeft();
            }

            Pair pair = stack.pop();

            if(pair.flag == 'L') {
                temp = pair.node.getRight();
                pair.flag = 'R';
                stack.push(pair);
            }
            else {
                System.out.print(pair.node.getData() + " ");
            }
        }
        System.out.println();
    }

    public void preOrder(Node root) {
        if(root == null) {
            return;
        }
        System.out.print(root.getData() + " ");
        preOrder(root.getLeft());
        preOrder(root.getRight());
    }

    public void inOrder(Node root) {
        if(root == null) {
            return;
        }
        inOrder(root.getLeft());
        System.out.print(root.getData() + " ");
        inOrder(root.getRight());
    }

    public void postOrder(Node root) {
        if(root == null) {
            return;
        }
        postOrder(root.getLeft());
        postOrder(root.getRight());
        System.out.print(root.getData() + " ");
    }

    public int getCount(Node root) {
        if(root == null) {
            return 0;
        }
        return 1 + getCount(root.getLeft()) + getCount(root.getRight());
    }

    public boolean find(Node root, int data) {
        if(root == null) {
            return false;
        }

        if(root.getData() == data) {
            return true;
        }

        if(data < root.getData()) {
            return find(root.getLeft(), data);
        }

        return find(root.getRight(), data);
    }

    public Node getRoot() {
        return root;
    }

    public boolean delete(int data) {
        if(root == null) {
            return false;
        }

        //locate del and parent
        Node parent = root, del = root;
        while (del.getData() != data) {
            if(data < del.getData()) {
                parent = del;
                del = del.getLeft();
            }
            else {
                parent = del;
                del = del.getRight();
            }
            //if the data is not existing
            if(del == null) {
                return false;
            }
        }

        while(true) {
            //check if the node is terminal
            if (del.getLeft() == null && del.getRight() == null) {

                //if the del is terminal and root node
                if (del == root) {
                    root = null;
                    return true;
                }

                if (parent.getLeft() == del) {
                    parent.setLeft(null);
                } else {
                    parent.setRight(null);
                }
                return true;
            }
            else {
                //shift the del down the tree
                if(del.getLeft() != null) {
                    //max from left
                    parent = del;
                    Node max = del.getLeft();

                    while(max.getRight() != null) {
                        parent = max;
                        max = max.getRight();
                    }

                    int temp = max.getData();
                    max.setData(del.getData());
                    del.setData(temp);

                    del = max;
                }
                else {
                    //min from right
                    parent = del;
                    Node min = del.getRight();

                    while(min.getLeft() != null) {
                        parent = min;
                        min = min.getLeft();
                    }

                    int temp = min.getData();
                    min.setData(del.getData());
                    del.setData(temp);

                    del = min;
                }
            }
        }
    }
}
