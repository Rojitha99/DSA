
package dsa;

/**
 *
 * @author Rojitha
 */
public class BST {

class Node {
        int key;
        Node left, right;

        Node(int item) {
            key = item;
            left = right = null;
        }
    }

    Node root;

    // INSERT
    Node insert(Node root, int key) {
        if (root == null)
            return new Node(key);

        if (key < root.key)
            root.left = insert(root.left, key);
        else if (key > root.key)
            root.right = insert(root.right, key);

        return root;
    }

    // SEARCH
    boolean search(Node root, int key) {
        if (root == null)
            return false;
        if (root.key == key)
            return true;

        return key < root.key
                ? search(root.left, key)
                : search(root.right, key);
    }

    // DELETE
    Node delete(Node root, int key) {
        if (root == null)
            return root;

        if (key < root.key)
            root.left = delete(root.left, key);
        else if (key > root.key)
            root.right = delete(root.right, key);
        else {
            // node with one child or no child
            if (root.left == null)
                return root.right;
            else if (root.right == null)
                return root.left;

            // node with two children
            root.key = minValue(root.right);
            root.right = delete(root.right, root.key);
        }
        return root;
    }

    int minValue(Node root) {
        int min = root.key;
        while (root.left != null) {
            min = root.left.key;
            root = root.left;
        }
        return min;
    }

    // INORDER TRAVERSAL
    void inorder(Node root) {
        if (root != null) {
            inorder(root.left);
            System.out.print(root.key + " ");
            inorder(root.right);
        }
    }

    public static void main(String[] args) {
        // TODO code application logic here
        BST tree = new BST();

        tree.root = tree.insert(tree.root, 50);
        tree.insert(tree.root, 30);
        tree.insert(tree.root, 70);
        tree.insert(tree.root, 20);
        tree.insert(tree.root, 40);

        System.out.print("BST Inorder: ");
        tree.inorder(tree.root);

        System.out.println("\nSearch 40: " + tree.search(tree.root, 40));

        tree.root = tree.delete(tree.root, 30);

        System.out.print("After Deletion: ");
        tree.inorder(tree.root);
    }
    
}
