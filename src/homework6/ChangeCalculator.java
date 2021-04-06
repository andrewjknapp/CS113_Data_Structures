package homework6;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.PrintWriter;
import java.util.Comparator;
import java.util.HashSet;
import java.util.Iterator;
import java.util.TreeSet;

/**
 * ChangeCalculator : Class containing the recursive method calculateChange, which determines and prints all
 * possible coin combinations representing a given monetary value in cents.
 *
 * Problem derived from Koffman & Wolfgang's Data Structures: Abstraction and Design Using Java (2nd ed.):
 * Ch. 5, Programming Project #7, pg. 291.
 *
 * NOTE: An additional method, printCombinationsToFile(int), has been added for the equivalent tester file to
 * verify that all given coin combinations are unique.
 */
public class ChangeCalculator {

    private static final int[] cValues = { 25, 10, 5, 1 };
    private static final String FILE_NAME = "src/homework6/test/CoinCombinations.txt";
    private static TreeSet<String> combinations = new TreeSet<>(new ChangeValueComparator());

    /**
     * Wrapper method for determining all possible unique combinations of quarters, dimes, nickels, and pennies that
     * equal the given monetary value in cents.
     *
     * In addition to returning the number of unique combinations, this method will print out each combination to the
     * console. The format of naming each combination is up to the user, as long as they adhere to the expectation
     * that the coins are listed in descending order of their value (quarters, dimes, nickels, then pennies). Examples
     * include "1Q 2D 3N 4P", and "[1, 2, 3, 4]".
     *
     * @param cents a monetary value in cents
     * @return the total number of unique combinations of coins of which the given value is comprised
     */
    public static int calculateChange(int cents) {
        // Implement a recursive solution following the given documentation.
        combinations.clear();
        makeChange(cents, 0, 0, 0, cents);

        return combinations.size();
    }

    private static void makeChange(int total, int nQuarter, int nDime, int nNickel, int nPenny) {

        final int QUARTER = cValues[0], DIME = cValues[1], NICKEL = cValues[2], PENNY = cValues[3];

        // Check that only a valid amount was entered
        if (QUARTER * nQuarter +
            DIME * nDime +
            NICKEL * nNickel +
            PENNY * nPenny != total) {
            System.err.println("Number of coins must add up to total");
            return;
        }

        String combination = "[" + nQuarter + ", " + nDime + ", " + nNickel + ", " + nPenny + "]";

        if (!combinations.contains(combination)) {
            combinations.add(combination);
        }

        if (nPenny >= 5) {
            makeChange(total, nQuarter, nDime, nNickel + 1, nPenny - 5);
        }
        if (nPenny >= 10) {
            makeChange(total, nQuarter, nDime + 1, nNickel, nPenny - 10);
        }
        if (nPenny >= 25) {
            makeChange(total, nQuarter + 1, nDime, nNickel, nPenny - 25);
        }
    }

    /**
     * Calls upon calculateChange(int) to calculate and print all possible unique combinations of quarters, dimes,
     * nickels, and pennies that equal the given value in cents.
     *
     * Similar to calculateChange's function in printing each combination to the console, this method will also
     * produce a text file named "CoinCombinations.txt", writing each combination to separate lines.
     *
     * @param cents a monetary value in cents
     */
    public static void printCombinationsToFile(int cents) {
        // This when calculateChange is complete. Note that the text file must be created within this directory.
        calculateChange(cents);

        try {
            PrintWriter pw = new PrintWriter(new File(FILE_NAME));

            Iterator<String> it = combinations.descendingIterator();

            while (it.hasNext()) {
                pw.append(it.next());
                pw.append('\n');
            }

            pw.flush();
            pw.close();
        } catch (FileNotFoundException e) {
            System.err.println("Error opening file: " + e);
        }
    }

} // End of class ChangeCalculator

// ChangeValueComparator is used to specify the
// comparator method in the TreeSet used above
// in ChangeCalculator
class ChangeValueComparator implements Comparator<String> {
    public int compare(String str1, String str2) {
        // Extract number of change for quarters, dimes
        // nickels, and pennies
        int[] change1 = parseInput(str1);
        int[] change2 = parseInput(str2);

        int changeComp;

        for (int i = 0; i < change1.length; i++) {
            changeComp = change1[i] - change2[i];

            if (changeComp != 0) {
                return changeComp;
            }
        }

        return 0;
    }

    // Extracts integers from the String representation
    // of an array;
    // Ex input: String "[2, 4, 0, 1]"
    // Ex output: int[]  [2, 4, 0, 1]
    private int[] parseInput(String str) {
        str = str.substring(1, str.length() - 1);

        String[] strArr = str.split(", ");
        int[] intArr = new int[strArr.length];

        for (int i = 0; i < strArr.length; i++) {
            intArr[i] = Integer.parseInt(strArr[i]);
        }
        return intArr;
    }
}