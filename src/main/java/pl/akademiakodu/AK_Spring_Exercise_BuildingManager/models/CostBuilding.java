package pl.akademiakodu.AK_Spring_Exercise_BuildingManager.models;

import org.springframework.stereotype.Service;
import java.math.BigInteger;

/**
 * to calculate build cost of building.
 */
@Service
public class CostBuilding {
    /**
     * mainly material cost variable holders, example of real costs specified in specific period of time.
     */
    private double areaMinimumIndicator = 1.2;
    private double undergroundLevelIndicator = 1.3;
    private int costMaterialFloorPerAreaMeter = 40;
    private int costMaterialRoofPerAreaMeter = 90;
    private int costMaterialWallPerMeter = 52;
    private int costInstallationPerAreaMeter = 19;
    private int costElectronicsPerAreaMeter = 130;
    private double costFoundationPerFloor = 1.2;
    private int costGroundPerMeter = 1500;
    private int costLicenceBuilding = 35000;
    private int costEnvironmentPerLevel = 2400;
    private int limitOfFloors = 25;
    private int limitOfUndergroundFloors = 7;
    private int limitOfArea = 35000;

    /**
     *
     * @param width given one of key variable to calculate cost of potential building
     * @param length given one of key variable to calculate cost of potential building
     * @param floors given one of key variable to calculate cost of potential building
     * @param undergroundFloors given one of key variable to calculate cost of potential building
     * @return total cost of potential building, including materials, scalable levels
     */
    public BigInteger calcTotalCostOfBuilding(int width, int length, int floors, int undergroundFloors){
        BigInteger totalCost = new BigInteger("0");
        int areaLevel = width * length;
        totalCost = totalCost.add(BigInteger.valueOf(getCostLicenceBuilding()));
        System.out.println("licence: " + getCostLicenceBuilding());
        totalCost = totalCost.add(BigInteger.valueOf(calcCostOfGround(calcBuildingArea(areaLevel))));
        System.out.println("ground cost: " + calcCostOfGround(calcBuildingArea(areaLevel)));
        totalCost = totalCost.add(BigInteger.valueOf(calcCostOfEnvironmentLevel(floors + undergroundFloors)));
        System.out.println("envi cost: " + calcCostOfEnvironmentLevel(floors + undergroundFloors));
        totalCost = totalCost.add(BigInteger.valueOf(calcCostOfRoof(areaLevel)));
        System.out.println("Roof cost: " + calcCostOfRoof(areaLevel));
        totalCost = totalCost.add(BigInteger.valueOf(calcCostOfFoundation(areaLevel, floors)));
        System.out.println("Foundation: " + calcCostOfFoundation(areaLevel, floors));
        totalCost = totalCost.add(BigInteger.valueOf(calcCostOfElectronic(areaLevel) * floors));
        System.out.println("Electronics: " + calcCostOfElectronic(areaLevel));
        totalCost = totalCost.add(BigInteger.valueOf(calcCostOfInstallation(areaLevel) * floors));
        System.out.println("Installation: " + calcCostOfInstallation(areaLevel)*floors);
        totalCost = totalCost.add(BigInteger.valueOf(calcCostMaterialFloor(areaLevel) * floors));
        System.out.println("Floor cost: " + calcCostMaterialFloor(areaLevel)*floors);
        totalCost = totalCost.add(BigInteger.valueOf(calcCostMaterialAreaWalls(width, length, floors)));
        System.out.println("Walls cost: " + calcCostMaterialAreaWalls(width, length, floors));
        totalCost = totalCost.add(BigInteger.valueOf(calcTotalCostUndergroundLevel(width, length, undergroundFloors)));
        System.out.println("Underground cost: " + calcTotalCostUndergroundLevel(width, length, undergroundFloors));
        return totalCost;
    }

    /**
     * larger and taller building need bigger and more solid foundation, in that case cost is scalable per building size
     * @param areaLevel given level area of building
     * @param floors given levels of building
     * @return scalable cost of foundation
     */
    public int calcCostOfFoundation(int areaLevel, int floors){
        if (floors<0 || areaLevel<1 || !checkArea(areaLevel) || !checkFloors(floors)){
            throw new IllegalArgumentException("Arguments have to be greater than 0!");
        }
        if (!checkArea(areaLevel) || !checkFloors(floors)){
            throw new IllegalArgumentException("Arguments over limits!");
        }
        if (floors==0){
            return areaLevel * getCostMaterialFloorPerAreaMeter();
        }
        double potentialCost = areaLevel * getCostMaterialFloorPerAreaMeter();
        double fouCos = getCostFoundationPerFloor();
        for (int i = 1; i <= floors; i++) {
            fouCos*=getCostFoundationPerFloor();
        }
        return (int)(potentialCost * fouCos);

    }

    /**
     * 
     * @param areaLevel
     * @return
     */
    public int calcBuildingArea(int areaLevel){
        if (areaLevel<1){
            throw new IllegalArgumentException("Arguments have to be greater than 0!");
        }
        if (!checkArea(areaLevel)){
            throw new IllegalArgumentException("Arguments over limits!");
        }
        return (int)(areaLevel * getAreaMinimumIndicator());
    }

    public int calcCostOfGround(int buildingArea){
        if (buildingArea<1){
            throw new IllegalArgumentException("Arguments have to be greater than 0!");
        }
        return buildingArea * getCostGroundPerMeter();
    }

    public int calcCostOfEnvironmentLevel(int floors){
        if (floors<0){
            throw new IllegalArgumentException("Arguments have to be greater than 0!");
        }
        if (!checkFloors(floors)){
            throw new IllegalArgumentException("Arguments over limits!");
        }
        return getCostEnvironmentPerLevel() * floors;
    }

    public int calcCostOfRoof(int areaLevel){
        if (areaLevel<1){
            throw new IllegalArgumentException("Arguments have to be greater than 0!");
        }
        if (!checkArea(areaLevel)){
            throw new IllegalArgumentException("Arguments over limits!");
        }
        return areaLevel * getCostMaterialRoofPerAreaMeter();
    }

    public int calcCostOfElectronic(int areaLevel){
        if (areaLevel<1){
            throw new IllegalArgumentException("Arguments have to be greater than 0!");
        }
        if (!checkArea(areaLevel)){
            throw new IllegalArgumentException("Arguments over limits!");
        }
        return areaLevel * getCostElectronicsPerAreaMeter();
    }

    public int calcCostOfInstallation(int areaLevel){
        if (areaLevel<1){
            throw new IllegalArgumentException("Arguments have to be greater than 0!");
        }
        if (!checkArea(areaLevel)){
            throw new IllegalArgumentException("Arguments over limits!");
        }
        return areaLevel * getCostInstallationPerAreaMeter();
    }

    public int calcCostMaterialFloor(int areaLevel){
        if (areaLevel<1){
            throw new IllegalArgumentException("Arguments have to be greater than 0!");
        }
        if (!checkArea(areaLevel)){
            throw new IllegalArgumentException("Arguments over limits!");
        }
        return areaLevel * getCostMaterialFloorPerAreaMeter();
    }

    public int calcCostMaterialAreaWalls(int width, int length, int floors){
        if (width<1 || length<1 || floors<0){
            throw new IllegalArgumentException("Arguments have to be greater than 0!");
        }
        if (!checkArea(width * length) || !checkFloors(floors)){
            throw new IllegalArgumentException("Arguments over limits!");
        }
        if (floors==0){
            return ((width + length) * 2 ) * getCostMaterialWallPerMeter();
        }
        return (((width*2) + (length*2)) * floors) * getCostMaterialWallPerMeter();
    }

    public int calcTotalCostUndergroundLevel(int width, int length, int undergroundFloors){
        int areaLevel = width * length;
        if (undergroundFloors<0 || areaLevel<1){
            throw new IllegalArgumentException("Arguments have to be greater than 0!");
        }
        if (!checkArea(areaLevel) || !checkUndergroundFloors(undergroundFloors)){
            throw new IllegalArgumentException("Arguments over limits!");
        }
        if (undergroundFloors==0){
            return 0;
        }
        double potentialUndergroundCost = calcCostMaterialAreaWalls(width, length, 0) + calcCostMaterialFloor(areaLevel);
        double fouCos = getUndergroundLevelIndicator();
        for (int i = 1; i <= undergroundFloors; i++) {
            fouCos*=getCostFoundationPerFloor();
            potentialUndergroundCost*=fouCos;
        }
        return (int)(potentialUndergroundCost * fouCos);
    }

    public boolean checkArea(int areaLevel){
        return areaLevel > getLimitOfArea() ? false : true;
    }

    public boolean checkFloors(int floor){
        return floor > getLimitOfFloors() ? false : true;
    }

    public boolean checkUndergroundFloors(int undergroundFloor){
        return undergroundFloor > getLimitOfUndergroundFloors() ? false : true;
    }


    /**
     * @getters variable holders
     */
    public double getAreaMinimumIndicator() {
        return areaMinimumIndicator;
    }

    public double getUndergroundLevelIndicator() {
        return undergroundLevelIndicator;
    }

    public int getCostMaterialFloorPerAreaMeter() {
        return costMaterialFloorPerAreaMeter;
    }

    public int getCostMaterialRoofPerAreaMeter() {
        return costMaterialRoofPerAreaMeter;
    }

    public int getCostMaterialWallPerMeter() {
        return costMaterialWallPerMeter;
    }

    public int getCostInstallationPerAreaMeter() {
        return costInstallationPerAreaMeter;
    }

    public int getCostElectronicsPerAreaMeter() {
        return costElectronicsPerAreaMeter;
    }

    public double getCostFoundationPerFloor() {
        return costFoundationPerFloor;
    }

    public int getCostGroundPerMeter() {
        return costGroundPerMeter;
    }

    public int getCostLicenceBuilding() {
        return costLicenceBuilding;
    }

    public int getCostEnvironmentPerLevel() {
        return costEnvironmentPerLevel;
    }

    public int getLimitOfFloors() {
        return limitOfFloors;
    }

    public int getLimitOfUndergroundFloors() {
        return limitOfUndergroundFloors;
    }

    public int getLimitOfArea() {
        return limitOfArea;
    }
}
