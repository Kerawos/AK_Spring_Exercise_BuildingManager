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

    @Test public void testElevatorNeed() throws Exception {
        assertEquals(buildingManager.elevatorNeeds(3500, 8), 7);
        assertEquals(buildingManager.elevatorNeeds(5200, 25), 10);
        assertEquals(buildingManager.elevatorNeeds(1200, 5), 2);
        assertEquals(buildingManager.elevatorNeeds(20, 0), 0);
        try {
            buildingManager.elevatorNeeds(-5,-4);
            fail("exc not catch");
        } catch (IllegalArgumentException e){
            assertEquals(e.getMessage(), "Arguments have to be greater than 0!");
        }
    }

    @Test public void testAreaCalculator() throws Exception {
        assertEquals(buildingManager.calculateLevelArea(50,70), 3500);
        try {
            buildingManager.calculateLevelArea(10,-4);
            fail("exc not catch");
        } catch (IllegalArgumentException e){
            assertEquals(e.getMessage(), "Arguments have to be greater than 0!");
        }
    }

    @Test public void testStraitsNeed() throws Exception {
        assertEquals(buildingManager.straitsNeed(3500, 8), 4);
        assertEquals(buildingManager.straitsNeed(1200, 5), 1);
        assertEquals(buildingManager.straitsNeed(4500, 33), 6);
        assertEquals(buildingManager.straitsNeed(880, 0), 0);
        try {
            buildingManager.straitsNeed(345,-1);
            fail("exc not catch");
        } catch (IllegalArgumentException e){
            assertEquals(e.getMessage(), "Arguments have to be greater than 0!");
        }
        try {
            buildingManager.straitsNeed(0,4);
            fail("exc not catch");
        } catch (IllegalArgumentException e){
            assertEquals(e.getMessage(), "Arguments have to be greater than 0!");
        }
    }

    @Test
    public void testRoomCalculator() throws Exception {
        assertEquals(buildingManager.roomCalculator(3500, 6, 2, 2), 62);
        assertEquals(buildingManager.roomCalculator(2000, 8, 4, 4), 31);
        assertEquals(buildingManager.roomCalculator(240, 1, 1, 1), 3);
        assertEquals(buildingManager.roomCalculator(100, 0, 1, 0), 1);
        try {
            buildingManager.roomCalculator(0,4, 5, 5);
            fail("exc not catch");
        } catch (IllegalArgumentException e){
            assertEquals(e.getMessage(), "Arguments have to be greater than 0!");
        }
        try {
            buildingManager.roomCalculator(450,-20, 2, 0);
            fail("exc not catch");
        } catch (IllegalArgumentException e){
            assertEquals(e.getMessage(), "Arguments have to be greater than 0!");
        }
    }

    @Test public void testParkingLevelNeed() throws Exception {
        assertEquals(buildingManager.parkingLevelNeed(8), 2);
        assertEquals(buildingManager.parkingLevelNeed(2), 0);
        assertEquals(buildingManager.parkingLevelNeed(15), 5);
        try {
            buildingManager.parkingLevelNeed(-4);
            fail("exc not catch");
        } catch (IllegalArgumentException e){
            assertEquals(e.getMessage(), "Arguments have to be greater than 0!");
        }
    }

    @Test public void testServiceLevelNeed() throws Exception {
        assertEquals(buildingManager.serviceLevelNeed(8), 1);
        assertEquals(buildingManager.serviceLevelNeed(2), 0);
        assertEquals(buildingManager.serviceLevelNeed(15), 3);
        try {
            buildingManager.serviceLevelNeed(-1);
            fail("exc not catch");
        } catch (IllegalArgumentException e){
            assertEquals(e.getMessage(), "Arguments have to be greater than 0!");
        }
    }

    @Test public void testGastroLevelNeed() throws Exception {
        assertEquals(buildingManager.gastroLevelNeed(8), 1);
        assertEquals(buildingManager.gastroLevelNeed(2), 0);
        assertEquals(buildingManager.gastroLevelNeed(15), 2);
        try {
            buildingManager.gastroLevelNeed(-123);
            fail("exc not catch");
        } catch (IllegalArgumentException e){
            assertEquals(e.getMessage(), "Arguments have to be greater than 0!");
        }
    }
}