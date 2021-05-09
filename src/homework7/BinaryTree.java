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

//    public void insertNodeIntoTree(String lineForm) {
//        String charToStore;
//        try {
//            charToStore = decodeCharacter(lineForm);
//            // If
//            if (mData == null) {
//                mData = charToStore;
//            }
//            System.out.println(charToStore);
//        } catch (IllegalArgumentException e ) {
//            System.err.println("Cannot insert: " + lineForm + " | " + e);
//            return;
//        }
//
//
//
//    }

    public String decodeCharacter(String s) throws IllegalArgumentException {
        String cleanedStr = s.replaceAll("\\s", "");
        if (cleanedStr.length() != 1 && !cleanedStr.equals("null")) {
            throw new IllegalArgumentException();
        }
        return cleanedStr;
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
            //tree.insertNodeIntoTree(scanner.nextLine());
        }

        return tree;
    }

    class Node<E> {
        private E mData;
        private Node mRight;
        private Node mLeft;

        public Node(E data) {
            mData = data;
            mRight = null;
            mLeft = null;
        }

        public Node() {
            this(null);
        }

        public Node<E> getLeft() {
            return mLeft;
        }

        public Node<E> getRight() {
            return mRight;
        }

        public E getData() {
            return mData;
        }

        public void setData(E data) {
            mData = data;
        }

        public void setRight(Node right) {
            mRight = right;
        }

        public void setLeft(Node left) {
            mLeft = left;
        }

        public String toString() {
            return mData + " \n";
        }

    }
}
