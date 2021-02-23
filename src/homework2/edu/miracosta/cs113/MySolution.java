package homework2.edu.miracosta.cs113;

/**
 * MySolution.java : Your job is to ask your AssistantJack and get the correct
 * answer in <= 20 tries.  MySolution is ONE solution to the problem,
 * where a set of random numbers is generated every attempt until all three
 * random numbers match the solution from the AssistantJack object.
 *
 * This is a sample solution, a driver using random number implementation.
 * You can use this file as a guide to create your own SEPARATE driver for
 * your implementation that can solve it in <= 20 times consistently.
 *
 * @author Nery Chapeton-Lamas (material from Kevin Lewis)
 * @version 1.0
 *
 */

import java.util.ArrayList;
import java.util.Random;
import java.util.Scanner;
import homework2.model.Theory;
import homework2.model.AssistantJack;
import homework2.model.TheoryItem;

public class MySolution {

    /*
     * ALGORITHM:
     *
     * PROMPT "Which theory to test? (1, 2, 3[random]): "
     * READ answerSet
     * INSTANTIATE jack = new AssistantJack(answerSet)
     *             WEAPON_MAX from TheoryItem
     *             MURDERER_MAX from TheoryItem
     *             ROOM_MAX from TheoryItem
     *             weapon = 1
     *             murderer = 1
     *             room = 1
     * DO
     *      solution = jack.checkAnswer(weapon, location, murder)
     *      IF solution == 0 break
     *      room++
     *      IF (room > ROOM_MAX)
     *          room = 1
     *          murderer++
     *      IF(murderer > MURDERER_MAX)
     *          murderer = 1
     *          weapon++
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
            if (solution == 0) break;

            lIndex++;
            if (lIndex >= locations.size()) {
                lIndex = 1;
                mIndex++;
            }
            if (mIndex >= murderers.size()) {
                mIndex = 1;
                wIndex++;
            }

        } while (wIndex < weapons.size());

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