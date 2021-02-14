package homework3;

import java.util.Scanner;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class Driver {
    public static void main(String[] args) {

        Scanner keyboard = new Scanner(System.in);
        String promptStr = "> ";

        System.out.println("~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~");
        System.out.println("Welcome to the Polynomial Adder");
        System.out.println("Type help for how to use");
        System.out.println("~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~");
        System.out.print(promptStr);
        boolean promptAgain = true;
        String input, confirmClear, termInput, polyInput;
        String[] polyTerms;

        Pattern termCheck = Pattern.compile("[-|+]?\\d*x?(\\^-?\\d*)?");

        Polynomial poly1 = new Polynomial();
        Polynomial poly2 = new Polynomial();
        Polynomial sum = new Polynomial();

        Polynomial[] polynomials = {poly1, poly2};
        String[] polyNames = {"Polynomial 1", "Polynomial 2"};
        int selectedPoly = 0;


        while(promptAgain) {
            input = keyboard.nextLine();

            /* EXIT ********************************************/
            if (input.equals("exit")) {
                promptAgain = false;
            }
            /* SWITCH ******************************************/
            else if (input.equals("switch")) {
                if (selectedPoly == 0) {
                    selectedPoly = 1;
                } else {
                    selectedPoly = 0;
                }
                System.out.println(polyNames[selectedPoly]);
            }
            /* LIST ********************************************/
            else if (input.equals("list")) {
                System.out.println(polyNames[selectedPoly]);
                System.out.println(polynomials[selectedPoly]);
            }
            /* CLEAR *******************************************/
            else if (input.equals("clear")) {
                System.out.println("Are you sure you want to delete " + polyNames[selectedPoly] + " y/n");
                System.out.println(polynomials[selectedPoly]);

                System.out.print(promptStr);
                confirmClear = keyboard.nextLine();

                if (confirmClear.equals("y")) {
                    polynomials[selectedPoly] = new Polynomial();
                    System.out.println("Cleared contents of " + polyNames[selectedPoly]);
                } else {
                    System.out.println("Clear aborted");
                }
            }
            /* ADD-TERM *****************************************/
            else if (input.equals("add-term")) {
                System.out.println("Please enter a term in the form...");
                System.out.println("+3x^2 ~or~ -5x^-4 ~or~ 4");

                System.out.print(promptStr);
                termInput = keyboard.nextLine();
                Matcher m = termCheck.matcher(termInput);
                boolean validInput = m.matches();

                if (validInput) {
                    polynomials[selectedPoly].addTerm(new Term(termInput));
                    System.out.println("Added Term " + termInput);
                } else {
                    System.out.println("Input does not follow patten, please try again");
                }
            }
            /* ADD-POLY *****************************************/
            else if (input.equals("add-poly")) {
                System.out.println("Please enter a polynomial in the form...");
                System.out.println("+3x^2 -5x^1 +2");
                System.out.println("This will replace " + polyNames[selectedPoly]);
                System.out.print(promptStr);

                polyInput = keyboard.nextLine();

                polyTerms = polyInput.split(" ");
                boolean validInput = true;
                for (String term : polyTerms) {
                    Matcher m = termCheck.matcher(term);
                    validInput = m.matches();
                    if (!validInput) break;
                }

                if (validInput) {
                    System.out.println("Good Input");
                    polynomials[selectedPoly] = new Polynomial();
                    for (String term : polyTerms) {
                        polynomials[selectedPoly].addTerm(new Term(term));
                    }

                    System.out.println("Created Polynomial");
                    System.out.println(polynomials[selectedPoly].toString());
                } else {
                    System.out.println("Input does not match pattern, try again");
                }
            }
            /* COMPUTE ******************************************/
            else if (input.equals("compute")) {
                sum = new Polynomial();
                sum.add(polynomials[0]);
                sum.add(polynomials[1]);
                System.out.println("Sum of Polynomial 1 and Polynomial 2");
                System.out.println("  " + polynomials[0]);
                System.out.println("+ " + polynomials[1]);
                System.out.println(sum);
            }
            /* HELP *********************************************/
            else {
                System.out.println("Polynomial Adder aims to make adding polynomials easier");
                System.out.println("Commands");
                System.out.println("list        - Prints current Polynomial");
                System.out.println("switch      - Switches current selected polynomial");
                System.out.println("compute     - Display sum of polynomials");
                System.out.println("add-term    - Adds term to current polynomial");
                System.out.println("add-poly    - Replace current polynomial with new polynomial");
                System.out.println("clear       - Clears current Polynomial");
                System.out.println("exit        - Exits the Program");
            }

            System.out.print(promptStr);
        }
    }
}
