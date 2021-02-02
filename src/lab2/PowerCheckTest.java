package lab2;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class PowerCheckTest {

    @Test
    public void isPowerOfTwoTest() {
        int[] testCases =    { 1,    2,    4,    128,  262144, -1,    0,     3,     12,    17,    51,    2621442 };
        boolean[] expected = { true, true, true, true, true,   false, false, false, false, false, false, false };

        for (int i = 0; i < testCases.length; i++) {
            assertEquals(PowerCheck.isPowerOfTwo(testCases[i]), expected[i]);
        }
    }
}