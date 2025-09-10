package rocket;

import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

class RocketStage4Test {
    @Test
    void testMissionSummary_SuccessfulLaunch() {
        Rocket rocket = new Rocket("Explorer-1", 25000, 100, new AlphaEngine());
        rocket.startLiftoff();
        String summary = rocket.getMissionSummary();
        assertTrue(summary.contains("LAUNCHED"));
        assertTrue(summary.toUpperCase().contains("SUCCESS"));
    }

    @Test
    void testMissionSummary_FailedLaunch_NotReady() {
        Rocket rocket = new Rocket("Explorer-1", 25000, 80, new AlphaEngine());
        rocket.startLiftoff();
        String summary = rocket.getMissionSummary();
        assertTrue(summary.contains("FAILED"));
    }

    @Test
    void testMissionSummary_FailedLaunch_TooHeavy() {
        Rocket rocket = new Rocket("Explorer-1", 50000, 100, new AlphaEngine());
        rocket.startLiftoff();
        String summary = rocket.getMissionSummary();
        assertTrue(summary.contains("FAILED"));
    }

    @Test
    void testMissionSummary_ContainsAllDetails() {
        Rocket rocket = new Rocket("Explorer-1", 25000, 100, new AlphaEngine());
        rocket.loadItem(10000);
        rocket.startLiftoff();
        String summary = rocket.getMissionSummary();
        assertTrue(summary.contains("Explorer-1"));
        assertTrue(summary.contains("Alpha"));
        assertTrue(summary.contains("Cargo Mass: 10000"));
        assertTrue(summary.contains("Launch Mass: 40000"));
        assertTrue(summary.contains("Status: LAUNCHED"));
    }

    @Test
    void testMissionSummary_BeforeLaunch() {
        Rocket rocket = new Rocket("Explorer-1", 25000, 100, new AlphaEngine());
        String summary = rocket.getMissionSummary();
        assertTrue(summary.contains("READY"));
    }
}
