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

    @Test public void testCostOfRoof() throws Exception {
        assertEquals(costBuilding.calcCostOfRoof(3500), 315000);
        assertEquals(costBuilding.calcCostOfRoof(225), 20250);
        assertEquals(costBuilding.calcCostOfRoof(2400), 216000);
        try{
            costBuilding.calcCostOfRoof(0);
            fail("exc not catch");
        } catch (IllegalArgumentException e){
            assertEquals(e.getMessage(), "Arguments have to be greater than 0!");
        }
    }

    @Test public void testCostOfElectronic() throws Exception {
        assertEquals(costBuilding.calcCostOfElectronic(3500), 455000);
        assertEquals(costBuilding.calcCostOfElectronic(225), 29250);
        assertEquals(costBuilding.calcCostOfElectronic(2400), 312000);
        try{
            costBuilding.calcCostOfElectronic(0);
            fail("exc not catch");
        } catch (IllegalArgumentException e){
            assertEquals(e.getMessage(), "Arguments have to be greater than 0!");
        }
    }

    @Test public void testCostOfInstallation() throws Exception {
        assertEquals(costBuilding.calcCostOfInstallation(3500), 66500);
        assertEquals(costBuilding.calcCostOfInstallation(225), 4275);
        assertEquals(costBuilding.calcCostOfInstallation(2400), 45600);
        try{
            costBuilding.calcCostOfInstallation(0);
            fail("exc not catch");
        } catch (IllegalArgumentException e){
            assertEquals(e.getMessage(), "Arguments have to be greater than 0!");
        }
    }

    @Test public void testCostMaterialFloor() throws Exception {
        assertEquals(costBuilding.calcCostMaterialFloor(3500), 140000);
        assertEquals(costBuilding.calcCostMaterialFloor(225), 9000);
        assertEquals(costBuilding.calcCostMaterialFloor(2400), 96000);
        try{
            costBuilding.calcCostMaterialFloor(0);
            fail("exc not catch");
        } catch (IllegalArgumentException e){
            assertEquals(e.getMessage(), "Arguments have to be greater than 0!");
        }
    }

    @Test public void testCostMaterialAreaWalls() throws Exception {
        assertEquals(costBuilding.calcCostMaterialAreaWalls(70, 50, 8), 99840);
        assertEquals(costBuilding.calcCostMaterialAreaWalls(12,12, 3), 7488);
        assertEquals(costBuilding.calcCostMaterialAreaWalls(50,40,12), 112320);
        try{
            costBuilding.calcCostMaterialAreaWalls(80, 0,8);
            fail("exc not catch");
        } catch (IllegalArgumentException e){
            assertEquals(e.getMessage(), "Arguments have to be greater than 0!");
        }
        try{
            costBuilding.calcCostMaterialAreaWalls(0, 40,3);
            fail("exc not catch");
        } catch (IllegalArgumentException e){
            assertEquals(e.getMessage(), "Arguments have to be greater than 0!");
        }
        try{
            costBuilding.calcCostMaterialAreaWalls(80, -5,0);
            fail("exc not catch");
        } catch (IllegalArgumentException e){
            assertEquals(e.getMessage(), "Arguments have to be greater than 0!");
        }
        assertEquals(costBuilding.calcCostMaterialAreaWalls(70,20,0), 9360);
    }










}