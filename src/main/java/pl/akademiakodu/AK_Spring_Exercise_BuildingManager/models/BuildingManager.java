package pl.akademiakodu.AK_Spring_Exercise_BuildingManager.models;

public class BuildingManager {

    private int installationSpace = 4;
    private int toiletsSpace = 30;
    private int straitsSpace = 20;
    private int roomSpace = 40;
    private double elevatorNeedPerLevel = 0.01;
    private double elevatorNeedPerArea10 = 0.02;

    public int calculateLevelArea(int width, int length){
        if (width<1 || length<1){
            throw new IllegalArgumentException("Arguments have to be greater than 0!");
        }
        return width * length;
    }

    public int roomCalculator(int levelArea, int elevators, int toilets, int straits){
        return 0;
    }

    public int elevatorNeeds(int levelArea, int floors){
        if (floors<1){
            return 0;
        }
        if (levelArea<1){
            throw new IllegalArgumentException("Arguments have to be greater than 0!");
        }
        return (int)(((double)levelArea/10) * getElevatorNeedPerArea10() + ((double)floors*getElevatorNeedPerLevel()));
    }


    //getters
    public int getInstallationSpace() {
        return installationSpace;
    }

    public int getToiletsSpace() {
        return toiletsSpace;
    }

    public int getStraitsSpace() {
        return straitsSpace;
    }

    public int getRoomSpace() {
        return roomSpace;
    }

    public double getElevatorNeedPerLevel() {
        return elevatorNeedPerLevel;
    }

    public double getElevatorNeedPerArea10() {
        return elevatorNeedPerArea10;
    }
}
