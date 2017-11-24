package pl.akademiakodu.AK_Spring_Exercise_BuildingManager.models;

import org.junit.AfterClass;
import org.junit.BeforeClass;
import org.junit.Test;

import static org.junit.Assert.*;

public class CostBuildingTest {

    private static CostBuilding costBuilding;

    @BeforeClass public static void start() {
        costBuilding = new CostBuilding();
    }

    @AfterClass public static void stop() throws Exception {
        costBuilding = null;
    }

    @Test public void testCostFoundation() throws Exception {
        assertEquals(costBuilding.calcCostOfFoundation(3500, 8), 810854);
        assertEquals(costBuilding.calcCostOfFoundation(2400, 12), 4315554);
        assertEquals(costBuilding.calcCostOfFoundation(400, 5), 33262);
        try{
            costBuilding.calcCostOfFoundation(0, 12);
            fail("exc not catch");
        } catch (IllegalArgumentException e){
            assertEquals(e.getMessage(), "Arguments have to be greater than 0!");
        }
        try{
            costBuilding.calcCostOfFoundation(555, -2);
            fail("exc not catch");
        } catch (IllegalArgumentException e){
            assertEquals(e.getMessage(), "Arguments have to be greater than 0!");
        }
        assertEquals(costBuilding.calcCostOfFoundation(120, 0), 4800);
    }

    @Test public void testBuildingArea() throws Exception {
        assertEquals(costBuilding.calcBuildingArea(3500), 4200);
        assertEquals(costBuilding.calcBuildingArea(420), 504);
        try{
            costBuilding.calcBuildingArea(0);
            fail("exc not catch");
        } catch (IllegalArgumentException e){
            assertEquals(e.getMessage(), "Arguments have to be greater than 0!");
        }
    }

    @Test public void testGroundCost() throws Exception {
        assertEquals(costBuilding.calcCostOfGround(4200), 6300000);
        assertEquals(costBuilding.calcCostOfGround(504), 756000);
        assertEquals(costBuilding.calcCostOfGround(1600), 2400000);
        assertEquals(costBuilding.calcCostOfGround(225), 337500);
        try{
            costBuilding.calcCostOfGround(0);
            fail("exc not catch");
        } catch (IllegalArgumentException e){
            assertEquals(e.getMessage(), "Arguments have to be greater than 0!");
        }
    }

    @Test public void testCostOfEnvironment() throws Exception {
        assertEquals(costBuilding.calcCostOfEnvironmentLevel(8), 19200);
        assertEquals(costBuilding.calcCostOfEnvironmentLevel(25), 60000);
        assertEquals(costBuilding.calcCostOfEnvironmentLevel(0), 0);
        try{
            costBuilding.calcCostOfEnvironmentLevel(-5);
            fail("exc not catch");
        } catch (IllegalArgumentException e){
            assertEquals(e.getMessage(), "Arguments have to be greater than 0!");
        }
    }

    






}