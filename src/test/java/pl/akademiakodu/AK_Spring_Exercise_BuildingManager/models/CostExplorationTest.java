package pl.akademiakodu.AK_Spring_Exercise_BuildingManager.models;

import org.junit.AfterClass;
import org.junit.BeforeClass;
import org.junit.Test;

import static org.junit.Assert.*;

public class CostExplorationTest {

    private static CostExploration costExploration;

    @BeforeClass public static void start() {
        costExploration = new CostExploration();
    }

    @AfterClass public static void stop() throws Exception {
        costExploration = null;
    }

    @Test public void testTaxPerMeterArea() throws Exception {
        assertEquals(costExploration.calcTaxPerMeterArea(28000), 14000);
        assertEquals(costExploration.calcTaxPerMeterArea(9520), 4760);
        assertEquals(costExploration.calcTaxPerMeterArea(120), 60);
        try {
            costExploration.calcTaxPerMeterArea(0);
            fail("exc not catch");
        } catch (IllegalArgumentException e){
            assertEquals(e.getMessage(), "Arguments have to be greater than 0!");
        }
    }
    
}