package homework2.edu.miracosta.cs113;

/**
 * SlidingPointerClue.java : Your job is to ask your AssistantJack and get the correct
 * answer in <= 20 tries. SlidingPointerClue starts its theory with the first person,
 * location and weapon. The feedback from checkAnswer tells us one of the categories
 * that was incorrect. That index is incremented and the comparison is made again
 *
 * @author Andrew Knapp
 * @version 1.0
 *
 */

import java.util.ArrayList;
import java.util.Scanner;
import homework2.model.Theory;
import homework2.model.AssistantJack;
import homework2.model.TheoryItem;

public class SlidingPointerClue {

    /*
     * ALGORITHM:
     *
     * PROMPT "Which theory to test? (1, 2, 3[random]): "
     * READ answerSet
     * INSTANTIATE jack = new AssistantJack(answerSet)
     *             WEAPON_MAX from TheoryItem
     *             MURDERER_MAX from TheoryItem
     *             ROOM_MAX from TheoryItem
     *             wIndex = 0
     *             mIndex = 0
     *             lIndex = 0
     * DO
     *      solution = jack.checkAnswer(weapon, location, murder)
     *      IF solution == 0 break
     *
     *      ELSE IF solution == 1 increment weapon index
     *      ELSE IF solution == 2 increment location index
     *      ELSE increment murderer index
     *
     * WHILE weapon <= WEAPON_MAX
     *
     * OUTPUT "Total checks = " + jack.getTimesAsked()
     * IF jack.getTimesAsked() is greater than 20 THEN
     *      OUTPUT "FAILED"
     * ELSE
     *      OUTPUT "PASSED"
     * END IF
     */

    /**
     * Driver method for random guessing approach
     *
     * @param args not used for driver
     */
    public static void main(String[] args) {
        // DECLARATION + INITIALIZATION
        int answerSet, solution,
            person = 1, weapon = 0, location = 0;
        Theory answer;
        AssistantJack jack;
        Scanner keyboard = new Scanner(System.in);

        // INPUT
        System.out.print("Which theory would like you like to test? (1, 2, 3[random]): ");
        answerSet = keyboard.nextInt();
        keyboard.close();

        // PROCESSING
        jack = new AssistantJack(answerSet);

        do {
            solution = jack.checkAnswer(weapon, location, person);

            if (solution == 0) {
                break;
            }
            else if (solution == 1) {
                weapon++;
            } else if (solution == 2) {
                location++;
            } else {
                person++;
            }

        } while (true);

        answer = new Theory(weapon, location, person);

        // OUTPUT
        System.out.println("Total Checks = " + jack.getTimesAsked() + ", Solution " + answer);

        if (jack.getTimesAsked() > 20) {
            System.out.println("FAILED!! You're a horrible Detective...");
        } else {
            System.out.println("WOW! You might as well be called Batman!");
        }

    }

}