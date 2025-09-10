package rocket;

import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

class RocketStage3Test {
    @Test
    void testLoadSingleCargoItem() {
        Rocket rocket = new Rocket("Explorer-1", 25000, 100, new AlphaEngine());
        rocket.loadItem(5000);
        assertEquals(5000, rocket.getCargoMass());
    }

    @Test
    void testLoadMultipleCargoItems() {
        Rocket rocket = new Rocket("Explorer-1", 25000, 100, new AlphaEngine());
        rocket.loadItem(3000);
        rocket.loadItem(2000);
        assertEquals(5000, rocket.getCargoMass());
    }

    @Test
    void testLoadInvalidCargoItem() {
        Rocket rocket = new Rocket("Explorer-1", 25000, 100, new AlphaEngine());
        assertThrows(IllegalArgumentException.class, () -> rocket.loadItem(0));
        assertThrows(IllegalArgumentException.class, () -> rocket.loadItem(-100));
        assertEquals(0, rocket.getCargoMass());
    }

    @Test
    void testLaunchMassWithCargo() {
        Rocket rocket = new Rocket("Explorer-1", 25000, 100, new AlphaEngine());
        rocket.loadItem(10000);
        assertEquals(25000 + 5000 + 10000, rocket.getLaunchMass());
    }

    @Test
    void testStartLiftoff_SuccessWithCargo() {
        Rocket rocket = new Rocket("Explorer-1", 25000, 100, new AlphaEngine());
        rocket.loadItem(10000); // launch mass = 40000 < 50000
        assertTrue(rocket.startLiftoff());
        assertEquals(Rocket.Status.LAUNCHED, rocket.getStatus());
    }

    @Test
    void testStartLiftoff_FailWithExcessCargo() {
        Rocket rocket = new Rocket("Explorer-1", 25000, 100, new AlphaEngine());
        rocket.loadItem(30000); // launch mass = 60000 > 50000
        assertFalse(rocket.startLiftoff());
        assertEquals(Rocket.Status.FAILED, rocket.getStatus());
    }

    @Test
    void testStartLiftoff_ExactLiftLimitWithCargo() {
        Rocket rocket = new Rocket("Explorer-1", 25000, 100, new AlphaEngine());
        rocket.loadItem(20000); // launch mass = 25000 + 5000 + 20000 = 50000
        assertTrue(rocket.startLiftoff());
        assertEquals(Rocket.Status.LAUNCHED, rocket.getStatus());
    }

    @Test
    void testStartLiftoff_NoCargo() {
        Rocket rocket = new Rocket("Explorer-1", 25000, 100, new AlphaEngine());
        assertTrue(rocket.startLiftoff());
        assertEquals(Rocket.Status.LAUNCHED, rocket.getStatus());
    }

    @Test
    void testLoadCargoAfterLaunch() {
        Rocket rocket = new Rocket("Explorer-1", 25000, 100, new AlphaEngine());
        rocket.startLiftoff();
        assertThrows(IllegalStateException.class, () -> rocket.loadItem(1000));
    }
}
