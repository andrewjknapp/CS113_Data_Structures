package homework2.edu.miracosta.cs113;

/**
 * EliminationClue.java : Your job is to ask your AssistantJack and get the correct
 * answer in <= 20 tries. EliminationClue starts its theory with the first person,
 * location and weapon. The feedback from checkAnswer tells us one of the categories
 * that was incorrect. That value is removed from the possible answers. This elimination
 * continues until the correct answer is found.
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

public class EliminationClue {

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
     *      ELSE IF solution == 1 remove that weapon index
     *      ELSE IF solution == 2 remove that location index
     *      ELSE remove that murderer index
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
            mIndex = 0, wIndex = 0, lIndex = 0;
        Theory answer;
        AssistantJack jack;
        Scanner keyboard = new Scanner(System.in);

        int WEAPON_MAX = TheoryItem.TOTAL_WEAPONS,
                MURDERER_MAX = TheoryItem.TOTAL_MURDERS,
                LOCATION_MAX = TheoryItem.TOTAL_LOCATIONS;

        ArrayList<Integer> weapons = new ArrayList<>(),
                           murderers = new ArrayList<>(),
                           locations = new ArrayList<>();

        for (int i = 0; i < LOCATION_MAX; i++) {
            if (i < WEAPON_MAX) {
                weapons.add(i+1);
            }
            if (i < MURDERER_MAX) {
                murderers.add(i+1);
            }

            locations.add(i+1);
        }

        // INPUT
        System.out.print("Which theory would like you like to test? (1, 2, 3[random]): ");
        answerSet = keyboard.nextInt();
        keyboard.close();

        // PROCESSING
        jack = new AssistantJack(answerSet);

        do {
            solution = jack.checkAnswer(weapons.get(wIndex), locations.get(lIndex), murderers.get(mIndex));

            if (solution == 0) {
                break;
            }
            else if (solution == 1) {
                weapons.remove(wIndex);
            } else if (solution == 2) {
                locations.remove(lIndex);
            } else {
                murderers.remove(mIndex);
            }

        } while (true);

        answer = new Theory(weapons.get(wIndex), locations.get(lIndex), murderers.get(mIndex));

        // OUTPUT
        System.out.println("Total Checks = " + jack.getTimesAsked() + ", Solution " + answer);

        if (jack.getTimesAsked() > 20) {
            System.out.println("FAILED!! You're a horrible Detective...");
        } else {
            System.out.println("WOW! You might as well be called Batman!");
        }

    }

}