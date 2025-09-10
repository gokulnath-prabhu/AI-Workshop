package rocket;

import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

class RocketStage2Test {
    @Test
    void testLaunchMassWithAlphaEngine() {
        Engine alpha = new AlphaEngine();
        Rocket rocket = new Rocket("Explorer-1", 25000, 100, alpha);
        assertEquals(30000, rocket.getLaunchMass());
    }

    @Test
    void testLaunchMassWithBetaEngine() {
        Engine beta = new BetaEngine();
        Rocket rocket = new Rocket("Explorer-1", 25000, 100, beta);
        assertEquals(35000, rocket.getLaunchMass());
    }

    @Test
    void testStartLiftoff_NotReady() {
        Engine alpha = new AlphaEngine();
        Rocket rocket = new Rocket("Explorer-1", 25000, 80, alpha);
        assertFalse(rocket.startLiftoff());
        assertEquals(Rocket.Status.FAILED, rocket.getStatus());
    }

    @Test
    void testStartLiftoff_TooHeavy() {
        Engine alpha = new AlphaEngine();
        Rocket rocket = new Rocket("Explorer-1", 49000, 100, alpha); // 49000+5000=54000 > 50000
        assertFalse(rocket.startLiftoff());
        assertEquals(Rocket.Status.FAILED, rocket.getStatus());
    }

    @Test
    void testStartLiftoff_SuccessAlpha() {
        Engine alpha = new AlphaEngine();
        Rocket rocket = new Rocket("Explorer-1", 20000, 100, alpha);
        assertTrue(rocket.startLiftoff());
        assertEquals(Rocket.Status.LAUNCHED, rocket.getStatus());
    }

    @Test
    void testStartLiftoff_SuccessBeta() {
        Engine beta = new BetaEngine();
        Rocket rocket = new Rocket("Explorer-1", 100000, 100, beta); // 100000+10000=110000 < 150000
        assertTrue(rocket.startLiftoff());
        assertEquals(Rocket.Status.LAUNCHED, rocket.getStatus());
    }
}
