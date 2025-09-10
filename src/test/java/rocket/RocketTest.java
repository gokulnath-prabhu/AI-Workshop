package rocket;

import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

class RocketTest {
    @Test
    void testRocketInitialization() {
        Rocket rocket = new Rocket("Explorer-1", 25000, 0);
        assertEquals("Explorer-1", rocket.getModel());
        assertEquals(25000, rocket.getBaseMass());
        assertEquals(0, rocket.getFuelLevel());
    }

    @Test
    void testVerifyReadiness_FuelNotFull() {
        Rocket rocket = new Rocket("Explorer-1", 25000, 80);
        assertFalse(rocket.verifyReadiness());
    }

    @Test
    void testVerifyReadiness_FuelFull() {
        Rocket rocket = new Rocket("Explorer-1", 25000, 100);
        assertTrue(rocket.verifyReadiness());
    }

    @Test
    void testVerifyReadiness_EdgeCases() {
        Rocket rocketZero = new Rocket("Explorer-1", 25000, 0);
        assertFalse(rocketZero.verifyReadiness());

        Rocket rocketNinetyNine = new Rocket("Explorer-1", 25000, 99);
        assertFalse(rocketNinetyNine.verifyReadiness());

        Rocket rocketHundred = new Rocket("Explorer-1", 25000, 100);
        assertTrue(rocketHundred.verifyReadiness());
    }
}
