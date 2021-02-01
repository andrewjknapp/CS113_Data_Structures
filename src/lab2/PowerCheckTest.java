package lab2;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class PowerCheckTest {

    @Test
    public void Should_Recognize_Powers_Of_Two() {
        assertTrue(PowerCheck.isPowerOfTwo(1));
        assertTrue(PowerCheck.isPowerOfTwo(2));
        assertTrue(PowerCheck.isPowerOfTwo(4));
        assertTrue(PowerCheck.isPowerOfTwo(128));
        assertTrue(PowerCheck.isPowerOfTwo(262144));
    }

    @Test
    public void Should_Recognize_Non_Powers_Of_Two() {
        assertFalse(PowerCheck.isPowerOfTwo(0));
        assertFalse(PowerCheck.isPowerOfTwo(3));
        assertFalse(PowerCheck.isPowerOfTwo(51));
    }
}