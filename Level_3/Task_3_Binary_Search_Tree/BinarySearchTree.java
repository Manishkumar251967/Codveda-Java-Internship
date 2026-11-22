import java.util.Scanner;

public class BinarySearchTree {

    // Node class
    static class Node {
        int data;
        Node left, right;

        Node(int data) {
            this.data = data;
        }
    }

    static Node root;
    static Scanner sc = new Scanner(System.in);

    // Insert node
    static Node insert(Node root, int data) {
        if (root == null) {
            return new Node(data);
        }

        if (data < root.data) {
            root.left = insert(root.left, data);
        } else if (data > root.data) {
            root.right = insert(root.right, data);
        } else {
            System.out.println("Duplicate value not allowed!");
        }

        return root;
    }

    // Search node
    static boolean search(Node root, int key) {
        if (root == null) {
            return false;
        }

        if (root.data == key) {
            return true;
        }

        if (key < root.data) {
            return search(root.left, key);
        } else {
            return search(root.right, key);
        }
    }

    // Find minimum value
    static Node findMin(Node root) {
        while (root.left != null) {
            root = root.left;
        }
        return root;
    }

    // Delete node
    static Node delete(Node root, int key) {
        if (root == null) {
            return null;
        }

        if (key < root.data) {
            root.left = delete(root.left, key);
        } else if (key > root.data) {
            root.right = delete(root.right, key);
        } else {

            // Case 1: No child
            if (root.left == null && root.right == null) {
                return null;
            }

            // Case 2: One child
            if (root.left == null) {
                return root.right;
            }

            if (root.right == null) {
                return root.left;
            }

            // Case 3: Two children
            Node successor = findMin(root.right);
            root.data = successor.data;
            root.right = delete(root.right, successor.data);
        }

        return root;
    }

    // In-order traversal
    static void inorder(Node root) {
        if (root != null) {
            inorder(root.left);
            System.out.print(root.data + " ");
            inorder(root.right);
        }
    }

    // Pre-order traversal
    static void preorder(Node root) {
        if (root != null) {
            System.out.print(root.data + " ");
            preorder(root.left);
            preorder(root.right);
        }
    }

    // Post-order traversal
    static void postorder(Node root) {
        if (root != null) {
            postorder(root.left);
            postorder(root.right);
            System.out.print(root.data + " ");
        }
    }

    // Main method
    public static void main(String[] args) {

        int choice;

        do {
            System.out.println("\n===== BINARY SEARCH TREE =====");
            System.out.println("1. Insert Node");
            System.out.println("2. Search Node");
            System.out.println("3. Delete Node");
            System.out.println("4. In-order Traversal");
            System.out.println("5. Pre-order Traversal");
            System.out.println("6. Post-order Traversal");
            System.out.println("7. Exit");

            System.out.print("Enter your choice: ");
            choice = sc.nextInt();

            switch (choice) {

                case 1:
                    System.out.print("Enter value to insert: ");
                    int value = sc.nextInt();
                    root = insert(root, value);
                    System.out.println("Node inserted successfully!");
                    break;

                case 2:
                    System.out.print("Enter value to search: ");
                    int key = sc.nextInt();

                    if (search(root, key)) {
                        System.out.println("Node found!");
                    } else {
                        System.out.println("Node not found!");
                    }
                    break;

                case 3:
                    System.out.print("Enter value to delete: ");
                    int deleteValue = sc.nextInt();

                    if (search(root, deleteValue)) {
                        root = delete(root, deleteValue);
                        System.out.println("Node deleted successfully!");
                    } else {
                        System.out.println("Node not found!");
                    }
                    break;

                case 4:
                    System.out.print("In-order Traversal: ");
                    inorder(root);
                    System.out.println();
                    break;

                case 5:
                    System.out.print("Pre-order Traversal: ");
                    preorder(root);
                    System.out.println();
                    break;

                case 6:
                    System.out.print("Post-order Traversal: ");
                    postorder(root);
                    System.out.println();
                    break;

                case 7:
                    System.out.println("Exiting BST Application...");
                    break;

                default:
                    System.out.println("Invalid choice!");
            }

        } while (choice != 7);

        sc.close();
    }
}