public class ThreadedBinarySearchTree {
    private Node root;

    public ThreadedBinarySearchTree() {
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
                //to left
                if(temp.getlFlag() == 'T') {
                    newNode.setRight(temp); //step 1
                    newNode.setLeft(temp.getLeft()); //step 2
                    temp.setLeft(newNode); //step 3
                    temp.setlFlag('L'); //step 3
                    return true;
                }
                temp = temp.getLeft();
            }
            else {
                //to right
                if(temp.getrFlag() == 'T') {
                    newNode.setLeft(temp); //step 1
                    newNode.setRight(temp.getRight()); //step 2
                    temp.setRight(newNode);//step 3
                    temp.setrFlag('L');
                    return true;
                }
                temp = temp.getRight();
            }
        }
    }

    public void inOrder() {
        Node temp = root;
        char flag = 'L';

        System.out.print("InOrder: ");
        while(temp != null) {
            while(temp.getlFlag() == 'L' && flag == 'L') {
                temp = temp.getLeft();
            }

            System.out.print(temp.getData() + " ");
            flag = temp.getrFlag();
            temp = temp.getRight();
        }
        System.out.println();
    }

    public void preOrder() {
        Node temp = root;
        char flag = 'L';

        System.out.print("PreOrder: ");
        while(temp != null) {
            while(temp.getlFlag() == 'L' && flag == 'L') {
                System.out.print(temp.getData() + " ");
                temp = temp.getLeft();
            }

            if(flag == 'L') {
                System.out.print(temp.getData() + " ");
            }

            flag = temp.getrFlag();
            temp = temp.getRight();
        }
        System.out.println();
    }

    public void postOrder() {
        Node temp = root;
        char flag = 'L';

        System.out.print("PostOrder: ");
        while(temp != null) {

            while(temp.getlFlag() == 'L' && flag == 'L') {
                temp = temp.getLeft();
            }

            flag = temp.getrFlag();
            if(flag == 'L') {
                temp = temp.getRight();
            }
            else {
                while(true) {
                    System.out.print(temp.getData() + " ");
                    if(isRightChild(temp)) {
                        while(temp.getlFlag() == 'L') {
                            temp = temp.getLeft();
                        }
                        temp = temp.getLeft();
                    }
                    else {
                        while(temp.getrFlag() == 'L') {
                            temp = temp.getRight();
                        }
                        temp = temp.getRight();
                        break;
                    }
                }
            }

        }
        System.out.println();
    }

    private boolean isRightChild(Node node) {

        if(node == root) {
            return false;
        }

        Node temp = root;
        while(true) {
            if(node.getData() < temp.getData()) {
                temp = temp.getLeft();
                if(temp == node) {
                    return false;
                }
            }
            else {
                temp = temp.getRight();
                if(temp == node) {
                    return true;
                }
            }
        }
    }

    public boolean delete(int data) {
        if(root == null) {
            return false;
        }

        //locate the del node
        Node del = root, parent = root;
        while(del.getData() != data) {
            if(data < del.getData()) {

                if(del.getlFlag() == 'T') {
                    return false;
                }

                parent = del;
                del = del.getLeft();
            }
            else {

                if(del.getrFlag() == 'T') {
                    return false;
                }

                parent = del;
                del = del.getRight();
            }
        }

        while(true) {
            //check if the node is terminal
            if (del.getlFlag() == 'T' && del.getrFlag() == 'T') {
                //if node is terminal, then delete and return true
                if (del == root) {
                    root = null;
                    return true;
                }


                if (parent.getLeft() == del) {
                    //del's inorder predecessor will become inorder predecessor of parent
                    parent.setLeft(del.getLeft());
                    parent.setlFlag('T');
                } else {
                    //del's inorder successor will become inorder successor of parent
                    parent.setRight(del.getRight());
                    parent.setrFlag('T');
                }

                return true;

            }

            //if the node is non-terminal node then shift it down the tree and check again if it is a terminal node now
            if(del.getlFlag() == 'L') {
                //find max from left
                Node max = del.getLeft();
                parent = del;

                while(max.getrFlag() == 'L') {
                    parent = max;
                    max = max.getRight();
                }

                //swap del and max
                int temp = max.getData();
                max.setData(del.getData());
                del.setData(temp);

                del = max;
            }
            else {
                //find min from right
                Node min = del.getRight();
                parent = del;

                while(min.getlFlag() == 'L') {
                    parent = min;
                    min = min.getLeft();
                }

                //swap
                int temp = min.getData();
                min.setData(del.getData());
                del.setData(temp);

                del = min;
            }
        }
    }
}









