package pl.akademiakodu.AK_Spring_Exercise_BuildingManager.models;

import org.junit.AfterClass;
import org.junit.BeforeClass;
import org.junit.Test;

import static org.junit.Assert.*;

public class BuildingManagerTest {

    private static BuildingManager buildingManager;

    @BeforeClass
    public static void start() {
        buildingManager = new BuildingManager();
    }

    @AfterClass
    public static void stop() throws Exception {
        buildingManager = null;
    }

    @Test
    public void testElevatorNeed() throws Exception {
        assertEquals(buildingManager.elevatorNeeds(3500, 8), 7);
        assertEquals(buildingManager.elevatorNeeds(5200, 25), 10);
        assertEquals(buildingManager.elevatorNeeds(1200, 5), 2);
    }
}