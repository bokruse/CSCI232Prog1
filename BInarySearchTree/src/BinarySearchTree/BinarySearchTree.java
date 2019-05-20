package BinarySearchTree;
/**
 *  Bowen Kruse
 *  5/13/2019
 *  Implementation of a Binary Search Tree. Nodes are integers read from "input.txt"
 *  User function provides 6 options, and will continue to offer same options until user
 *  chooses to end Do/While loop
 *
 */
import java.io.File;
import java.io.IOException;
import java.util.Arrays;
import java.util.Scanner;
import java.util.*;

public class BinarySearchTree {
    public static void main (String [] args) throws IOException {
        Scanner FileIn = new Scanner(new File("src/input.txt"));
        Scanner scnr = new Scanner(System.in);
        BST tree = new BST();
        char yeah;

        //Insertion of elements into binary tree
        while (FileIn.hasNext()) {
            String output = FileIn.next();
            String [] Split = output.split(",");
            System.out.println(Arrays.toString(Split));
            for (int i = 0; i < Split.length; i++) {
                tree.insert(Integer.parseInt(Split[i]));
            }
        }

        System.out.println("\nThe integers above have been inserted from input.txt into a binary tree.");

        do {
        //Menu Display
        System.out.println("\nEnter your choice: \n");
        System.out.println("1.\t Delete a node");
        System.out.println("2.\t Insert a node");
        System.out.println("3.\t Search for a given value within the data structure");
        System.out.println("4.\t Print In Order Traversal");
        System.out.println("5.\t Print Pre Order Traversal");
        System.out.println("6.\t Print Post Order Traversal\n");

        int choice = scnr.nextInt();

        switch (choice) {
            case 1:
                System.out.println("\nDelete a node");
                System.out.println("Enter a node to be deleted: ");
                int DelNode = scnr.nextInt();
                tree.delete(DelNode);
                System.out.println("Node deleted");
                tree.printTree();
                break;
            case 2: System.out.println("Insert a node");
                System.out.println("Enter a value to be inserted into the data structure: ");
                int nodeInsert = scnr.nextInt();
                tree.insert(nodeInsert);
                System.out.println("Node inserted");
                tree.printTree();
                break;
            case 3:
                System.out.println("Search for a value within the data structure");
                System.out.println("Enter value: ");
                int SearchNode = scnr.nextInt();
                System.out.println(tree.search(SearchNode));
                break;
            case 4:
                System.out.println("\nPrint of tree In Order Traversal: \n");
                tree.inOrder();
                break;
            case 5:
                System.out.println("\nPrint of tree Pre Order Traversal: \n");
                tree.preOrder();
                break;
            case 6:
                System.out.println("\nPrint of tree Post Order Traversal: \n");
                tree.postOrder();
                break;
        }
        System.out.println("\nContinue?\n(Enter y or n )\n");
        yeah = scnr.next().charAt(0);
        } while (yeah == 'y' || yeah == 'Y');
        System.out.println("<END>");

    }
}
