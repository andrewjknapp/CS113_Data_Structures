package homework7;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.Scanner;

/**
 * MorseCodeTree : A BinaryTree, with Nodes of type Character to represent each letter of the English alphabet,
 * and a means of traversal to be used to decipher Morse code.
 *
 * @version 1.0
 */
public class MorseCodeTree extends BinaryTree<Character> {

    private final String MORSE_CODE_FILE_NAME = "./src/homework7/morseCodeTreeData.txt";

    public MorseCodeTree() {
        super(new Node());

       readMorseCodeTree();
    }

    // TODO:
    // Build this class, which includes the parent BinaryTree implementation in addition to
    // the `translateFromMorseCode` and `readMorseCodeTree` methods. Documentation has been suggested for the former,
    // where said exceptional cases are to be handled according to the corresponding unit tests.
    public void readMorseCodeTree() {
        try {
            Scanner scan = new Scanner(new File(MORSE_CODE_FILE_NAME));


            String line;
            String[] data;
            Node currentNode;

            while (scan.hasNext()) {
                currentNode = root;
                line = scan.nextLine();
                data = line.split(" ");

                for (int i = 0; i < data[1].length(); i++) {
                    if (data[1].charAt(i) == '*') {
                        if (currentNode.left == null) {
                            currentNode.left = new Node();
                        }
                        currentNode = currentNode.left;
                    } else {
                        if (currentNode.right == null) {
                            currentNode.right = new Node();
                        }
                        currentNode = currentNode.right;
                    }
                }

                currentNode.data = data[0];
            }
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        }
    }

    /**
     * Non-recursive method for translating a String comprised of morse code values through traversals
     * in the MorseCodeTree.
     *
     * The given input is expected to contain morse code values, with '*' for dots and '-' for dashes, representing
     * only letters in the English alphabet.
     *
     * This method will also handle exceptional cases, namely if a given token's length exceeds that of the tree's
     * number of possible traversals, or if the given token contains a character that is neither '*' nor '-'.
     *
     * @param morseCode The given input representing letters in Morse code
     * @return a String representing the decoded values from morseCode
     */
    public String translateFromMorseCode(String morseCode) throws Exception {
        String[] words = morseCode.split(" ");
        StringBuilder sb = new StringBuilder();
        Node currentNode;
        for (String word : words) {

            currentNode = root;

            for (int i = 0; i < word.length(); i++) {
                if (word.charAt(i) == '*') {
                    currentNode = currentNode.left;
                } else if (word.charAt(i) == '-') {
                    currentNode = currentNode.right;
                } else {
                    throw new Exception("Illegal Character, only '*', '-', or ' ' expected");
                }
            }

            sb.append(currentNode.data);
        }

        return sb.toString();
    }

} // End of class MorseCodeTree