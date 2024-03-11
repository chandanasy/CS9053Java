package tree;

import pair.Pair;

public class BinarySearchTreeDemo {

    public static void main(String[] args) {
        // Example using Integer
        BinarySearchTree<Integer> intTree = new BinarySearchTree<>();
        intTree.insert(5);
        intTree.insert(3);
        intTree.insert(8);
        intTree.insert(1);
        intTree.insert(4);

        System.out.println("BinarySearchTree of Integer:");
        intTree.inorder();
        System.out.println();

        // Example using Pair<Integer, String>, sorted by the Integer key
        BinarySearchTree<Pair<Integer, String>> pairTree = new BinarySearchTree<>(
                (pair1, pair2) -> pair1.getKey().compareTo(pair2.getKey()));
        pairTree.insert(new Pair<>(10, "Ten"));
        pairTree.insert(new Pair<>(20, "Twenty"));
        pairTree.insert(new Pair<>(15, "Fifteen"));

        System.out.println("BinarySearchTree of Pair<Integer, String>:");
        pairTree.inorder();
        System.out.println();
    }
}
