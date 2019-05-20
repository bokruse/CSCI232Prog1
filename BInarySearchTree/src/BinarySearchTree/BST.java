package BinarySearchTree;

import java.util.LinkedList;
import java.util.Queue;

class Node {
    Node left, right;
    int data;

    public Node(int n) {
        left = null;
        right = null;
        data = n;
    }
    public void setLeft(Node n) { left = n; }
    public void setRight(Node n) { right = n; }
    public Node getLeft() { return left; }
    public Node getRight() { return right; }
    public void setData(int d) { data = d; }
    public int getData() { return  data; }

}

class BST {
    private Node root;
    public BST() { root = null; }
    public boolean isEmpty() { return root == null; }

    //insertion data
    public void insert(int data) { root = insert(root, data);}
    private Node insert(Node node, int data) {
        if (node == null) node = new Node(data);
        else {
            if (data <= node.getData())
                node.left = insert(node.left, data);
            else
                node.right = insert(node.right, data);
        }
        return node;
    }

    //Deletion of nodes
    public void delete(int k) {
        if (isEmpty())
            System.out.println("Tree is empty");
        else if (search(k) == false)
            System.out.println(k + " is not present in data structure");
        else {
            root = delete (root, k);
            System.out.println(k + " Deleted from data structure");
        }
    }
    private Node delete (Node root, int k) {
        Node p, p2, n;
        if (root.getData() == k) {
            Node Left, Right;
            Left = root.getLeft();
            Right = root.getRight();
            if (Left == null && Right == null)
                return null;
            else if (Left == null) {
                p = Right;
                return p;
            }
            else if (Right == null) {
                p = Left;
                return p;
            }
            else {
                p2 = Right;
                p = Right;
                while (p.getLeft() != null)
                    p = p.getLeft();
                p.setLeft(Left);
                return p2;
            }
        }
        if (k < root.getData()) {
            n = delete(root.getLeft(), k);
            root.setLeft(n);
        }
        else {
            n = delete(root.getRight(), k);
            root.setRight(n);
        }
        return root;
    }

    //Search for element
    public boolean search (int val) { return search(root, val); }
    private boolean search (Node r, int val) {
        boolean found = false;
        while ((r != null) && !found) {
            int rval = r.getData();
            if (val < rval)
                r = r.getLeft();
            else if (val > rval)
                r = r.getRight();
            else {
                found = true;
                break;
            }
            found = search (r, val);
        }
        return found;
    }

    //InOrder
    public void inOrder() { inOrder(root);}
    private void inOrder(Node r) {
        if (r != null) {
            inOrder(r.getLeft());
            System.out.print(r.getData() + " ");
            inOrder(r.getRight());
        }
    }

    //preOrder
    public void preOrder() { preOrder(root);}
    private void preOrder(Node r) {
        if (r != null) {
            System.out.print(r.getData() + " ");
            preOrder(r.getLeft());
            preOrder(r.getRight());
        }
    }

    //postOrder
    public void postOrder() { postOrder(root);}
    private void postOrder(Node r) {
        if (r != null) {
            postOrder(r.getLeft());
            postOrder(r.getRight());
            System.out.print(r.getData() + " ");
        }
    }

    public void printTree() { printTree(root);}
    private void printTree(Node root) {
        System.out.println("\nCurrent Tree Data Structure: ");
        if (root == null) return;

        Queue<Node> q = new LinkedList<Node>();

        //puts root into queue
        q.add(root);

        while (true) {
            int nodeCount = q.size();
            if (nodeCount == 0)
                break;

            while (nodeCount > 0) {
                Node node = q.peek();
                System.out.print("\t" + String.format("%-20s", node.data) + " \t");
                q.remove();
                if (node.left != null)
                    q.add(node.left);
                if (node.right != null)
                    q.add(node.right);
                nodeCount--;
            }
            System.out.println();
            System.out.println(" ");
        }

    }

    public int height() { return height(root);}
    private int height(Node root) {
        if (root == null)
            return 0;
        else {
            /* compute  height of each subtree */
            int lheight = height(root.left);
            int rheight = height(root.right);

            /* use the larger one */
            if (lheight > rheight)
                return(lheight+1);
            else return(rheight+1);
        }
    }

}

