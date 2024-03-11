package tree;

import java.util.Comparator;

public class BinarySearchTree<T> {
    private TreeNode<T> root;
    private Comparator<T> comparator;

    public BinarySearchTree() {
        this(null);
    }

    public BinarySearchTree(Comparator<T> comparator) {
        this.comparator = comparator;
    }

    // Insert value into the BST
    public void insert(T value) {
        root = insertRec(root, value);
    }

    private TreeNode<T> insertRec(TreeNode<T> node, T value) {
        if (node == null) {
            return new TreeNode<>(value);
        }

        int cmp = compare(value, node.getValue());
        if (cmp < 0) {
            node.setLeft(insertRec(node.getLeft(), value));
        } else if (cmp > 0) {
            node.setRight(insertRec(node.getRight(), value));
        }

        return node;
    }

    private int compare(T o1, T o2) {
        if (comparator != null) {
            return comparator.compare(o1, o2);
        } else {
            return ((Comparable<T>) o1).compareTo(o2);
        }
    }

    // Method to call inorder traversal of the BST
    public void inorder() {
        inorderRec(root);
    }

    private void inorderRec(TreeNode<T> node) {
        if (node != null) {
            inorderRec(node.getLeft());
            System.out.print(node.getValue() + " ");
            inorderRec(node.getRight());
        }
    }
}

