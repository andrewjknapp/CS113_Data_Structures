package homework7;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;

public class MorseCodeDriver {

    public static void main(String[] args) {
        MorseCodeTree mct = new MorseCodeTree();

        Scanner keyboard = new Scanner(System.in);
        String promptStr = "> ";

        String input;

        System.out.println("~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~");
        System.out.println("Welcome to the Morse Code Translator");
        System.out.println("Type help for how to use");
        System.out.println("~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~");

        mainLoop: while (true) {
            System.out.print(promptStr);
            input = keyboard.nextLine();

            switch (input.toLowerCase()) {
                case "h":
                case "help":
                    printHelpMessage();
                    break;
                case "line":
                    translateMorseCodeLine(keyboard, mct);
                    break;
                case "file":
                    readMorseCodeFile(keyboard, mct);
                    break;
                case "view":
                    displayAllMorseCode(mct);
                    break;
                default:
                    System.out.println("Exiting program. \nThanks for using the Morse Code translator!");
                    break mainLoop;
            }
        }

        keyboard.close();

    }

    /**
     * printHelpMessage
     * Display command options for the Morse Code Driver
     */
    private static void printHelpMessage() {
        System.out.println("Morse Code Translating CLI");
        System.out.println("Commands");
        System.out.println("line  - Live Morse Code Translator, type in Morse Code (using * for dot and - for dash) and view translated result");
        System.out.println("file  - Display translation of file containing Morse Code");
        System.out.println("view  - Display a table containing each Morse Code word and its English counterpart");
        System.out.println("help  - Display available commands");
        System.out.println("exit  - Exit the Program");
    }

    /**
     * translateMorseCodeLine
     * Take in user input as a string containing '*', '-', ' ' characters. This function
     * uses the Morse Code Tree to translate the user input
     *
     * @param kb  - Scanner for Keyboard input
     * @param mct - Morse Code Tree containing all symbols to translate Morse Code to English
     */
    private static void translateMorseCodeLine(Scanner kb, MorseCodeTree mct) {
        System.out.print("Morse Code > ");
        String morseCodeLine = kb.nextLine();
        try {
            System.out.println(mct.translateFromMorseCode(morseCodeLine));
        } catch (Exception e) {
            System.err.println(e.getMessage());
        }
    }

    /**
     * readMorseCodeFile
     * Takes in user input for the path to a file. Then translates the Morse Code from the file
     * and displays it as English
     *
     * @param kb  - Scanner for Keyboard input
     * @param mct - Morse Code Tree containing all symbols to translate Morse Code to English
     */
    private static void readMorseCodeFile(Scanner kb, MorseCodeTree mct) {
        System.out.println("Please enter name of file to translate");
        System.out.print("File Name > ");
        String fileName = kb.nextLine();
        try {
            Scanner fileScanner = new Scanner(new File(fileName));

            while (fileScanner.hasNext()) {
                System.out.println(mct.translateFromMorseCode(fileScanner.nextLine()));
            }

            fileScanner.close();

        } catch (FileNotFoundException e) {
            System.err.println("Whoops, could not find file with path " + fileName);
        } catch (Exception e) {
            System.err.println("Invalid character found in " + fileName + " : " + e.getMessage());
        }
    }

    /**
     * displayAllMorseCode
     * Displays the English - Morse Code Symbol pair for each letter in the alaphabet
     * in table form
     *
     * @param mct - Morse Code Tree containing all symbols to translate Morse Code to English
     */
    private static void displayAllMorseCode(MorseCodeTree mct) {
        HashMap<Character, String> allMorseMappings = mct.getAllMorseCodeMappings();

        int currentRow = 0;
        int colCount = 5;

        // Loop through each value in the allMorseMappings HashMap and display
        // each in the form of
        // | a : *-   |
        for (Map.Entry<Character, String> code : allMorseMappings.entrySet()) {
            String value = code.getValue();
            value += " ".repeat(6 - value.length());
            System.out.print("| " + code.getKey() + " : " + value + "|");

            if (currentRow == colCount - 1) {
                System.out.println();
            }
            currentRow++;
            currentRow = currentRow % colCount;
        }

        System.out.println();
    }
}
