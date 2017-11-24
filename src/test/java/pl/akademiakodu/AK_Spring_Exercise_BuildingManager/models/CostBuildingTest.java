package pl.akademiakodu.AK_Spring_Exercise_BuildingManager.models;

import org.junit.AfterClass;
import org.junit.BeforeClass;

import static org.junit.Assert.*;

public class CostBuildingTest {

    private static CostBuilding costBuilding;

    @BeforeClass
    public static void start() {
        costBuilding = new CostBuilding();
    }

    @AfterClass
    public static void stop() throws Exception {
        costBuilding = null;
    }
}