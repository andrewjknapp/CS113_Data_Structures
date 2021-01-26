package lab2;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class PowerCheckTest {
    @BeforeEach
    public void setup() {

    }

    @Test
    public void isPowerOfTwoCheck() {
        assertEquals(PowerCheck.isPowerOfTwo(2), true);
        assertEquals(PowerCheck.isPowerOfTwo(4), true);
        assertEquals(PowerCheck.isPowerOfTwo(128), true);
        assertEquals(PowerCheck.isPowerOfTwo(3), false);
        assertEquals(PowerCheck.isPowerOfTwo(51), false);
    }
}