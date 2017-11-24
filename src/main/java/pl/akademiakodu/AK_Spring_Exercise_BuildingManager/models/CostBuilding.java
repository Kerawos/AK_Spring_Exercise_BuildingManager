package pl.akademiakodu.AK_Spring_Exercise_BuildingManager.models;

public class CostBuilding {

    private double areaMinimumIndicator = 1.2;
    private double undergroundLevelIndicator = 1.8;
    private int costMaterialFloorPerAreaMeter = 40;
    private int costMaterialRoofPerAreaMeter = 90;
    private int costMaterialWallPerMeter = 52;
    private int costInstallationPerAreaMeter = 19;
    private int costElectronicsPerAreaMeter = 130;
    private double costFoundationPerFloor = 1.05;
    private int costGroundPerMeter = 1500;
    private int costLicenceBuilding = 35000;
    private int costEnvironmentPerLevel = 2400;

    public int calcTotalCostOfBuilding(int width, int length, int floors, int undergroundFloors){
        int totalCost = 0;
        int areaLevel = width * length;
        totalCost = getCostLicenceBuilding();
        totalCost += calcCostOfGround(calcBuildingArea(areaLevel));
        totalCost += calcCostOfEnvironmentLevel(floors + undergroundFloors);
        totalCost += calcCostOfRoof(areaLevel);
        totalCost += calcCostOfFoundation(areaLevel, floors);
        totalCost += calcCostOfElectronic(areaLevel);
        totalCost += calcCostOfInstallation(areaLevel);
        totalCost += calcCostMaterialFloor(areaLevel);
        totalCost += calcCostMaterialAreaWalls(width, length, floors);
        totalCost += calcCostUndergroundLevel(undergroundFloors);
        return totalCost;
    }

    public int calcCostOfFoundation(int areaLevel, int floors){
        if (floors<0 || areaLevel<1){
            throw new IllegalArgumentException("Arguments have to be greater than 0!");
        }
        if (floors==0){
            return areaLevel * getCostMaterialFloorPerAreaMeter();
        }
        double potentialCost = areaLevel * getCostMaterialFloorPerAreaMeter();
        double fouCos = getCostFoundationPerFloor();
        for (int i = 1; i <= floors; i++) {
            potentialCost*=fouCos;
            fouCos*=getCostFoundationPerFloor();
        }
        return (int)potentialCost;

    }

    public int calcBuildingArea(int areaLevel){
        if (areaLevel<1){
            throw new IllegalArgumentException("Arguments have to be greater than 0!");
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
        return getCostEnvironmentPerLevel() * floors;
    }

    public int calcCostOfRoof(int areaLevel){
        if (areaLevel<1){
            throw new IllegalArgumentException("Arguments have to be greater than 0!");
        }
        return areaLevel * getCostMaterialRoofPerAreaMeter();
    }

    public int calcCostOfElectronic(int areaLevel){
        if (areaLevel<1){
            throw new IllegalArgumentException("Arguments have to be greater than 0!");
        }
        return areaLevel * getCostElectronicsPerAreaMeter();
    }

    public int calcCostOfInstallation(int areaLevel){
        if (areaLevel<1){
            throw new IllegalArgumentException("Arguments have to be greater than 0!");
        }
        return areaLevel * getCostInstallationPerAreaMeter();
    }

    public int calcCostMaterialFloor(int areaLevel){
        if (areaLevel<1){
            throw new IllegalArgumentException("Arguments have to be greater than 0!");
        }
        return areaLevel * getCostMaterialFloorPerAreaMeter();
    }

    public int calcCostMaterialAreaWalls(int width, int length, int floors){
        if (width<1 || length<1 || floors<0){
            throw new IllegalArgumentException("Arguments have to be greater than 0!");
        }
        if (floors==0){
            return ((width + length) * 2 ) * getCostMaterialWallPerMeter();
        }
        return (((width*2) + (length*2)) * floors) * getCostMaterialWallPerMeter();
    }

    public int calcCostUndergroundLevel(int undergroundFloors){
        if (undergroundFloors<0){
            throw new IllegalArgumentException("Arguments have to be greater than 0!");
        }
        return (int) (undergroundFloors * getUndergroundLevelIndicator());
    }


    //getters
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
}
