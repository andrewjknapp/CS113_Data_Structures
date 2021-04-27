package homework7;

import java.util.Scanner;

public class BinaryTree<E> {

    private E mData;
    private BinaryTree<E> leftSubtree;
    private BinaryTree<E> rightSubtree;

    public BinaryTree(E data, BinaryTree<E> left, BinaryTree<E> right) {
        mData = data;
        leftSubtree = left;
        rightSubtree = right;
    }

    public BinaryTree() {
        this(null, null, null);
    }

    public BinaryTree<E> getLeftSubtree() {
        return leftSubtree;
    }

    public BinaryTree<E> getRightSubtree() {
        return rightSubtree;
    }

    public E getData() {
        return mData;
    }

    public boolean isLeaf() {
        if (mData == null) {
            throw new NullPointerException();
        }
        return rightSubtree == null && leftSubtree == null;
    }

    public void insertNodeIntoTree(String lineForm) {
        char charToStore;
        try {
            charToStore = decodeCharacter(lineForm);
        } catch (IllegalArgumentException e ) {
            System.err.println("Cannot insert: " + lineForm + " | " + e);
            return;
        }



    }

    public char decodeCharacter(String s) throws IllegalArgumentException {
        String cleanedStr = s.replace("\\s", "");
        if (cleanedStr.length() != 1) {
            throw new IllegalArgumentException();
        }
        return 'a';
    }

    public String translateFromMorseCode(String morseCode) {
        return "";
    }

    @Override
    public String toString() {
        String treeStr = mData + "\n";
        return treeStr;
    }

    public static BinaryTree<String> readBinaryTree(Scanner scanner) {
        BinaryTree<String> tree = new BinaryTree<>();

        while (scanner.hasNext()) {
            tree.insertNodeIntoTree(scanner.nextLine());
        }

        return tree;
    }
}
