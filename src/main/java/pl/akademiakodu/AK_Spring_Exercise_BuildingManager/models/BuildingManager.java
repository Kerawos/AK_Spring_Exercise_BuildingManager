package pl.akademiakodu.AK_Spring_Exercise_BuildingManager.models;

public class BuildingManager {

    private int installationSpace = 4;
    private int toiletsSpace = 30;
    private int straitsSpace = 20;
    private int roomSpace = 40;
    private int elevatorSpace = 5;

    private double elevatorNeedPerLevel = 0.01;
    private double elevatorNeedPerArea10 = 0.02;
    private double straitsNeedPerArea50 = 0.07;
    private double emptyAreaNeedPerArea = 0.25;
    private int parkingNeedPerOfficeLevel = 3;
    private int servicesNeedPerOfficeLevel = 5;
    private int gastroNeedPerLevel = 7;

    public int calculateLevelArea(int width, int length){
        if (width<1 || length<1){
            throw new IllegalArgumentException("Arguments have to be greater than 0!");
        }
        return width * length;
    }

    public int roomCalculator(int levelArea, int elevators, int toilets, int straits){
        if (levelArea<1 || elevators<0 || toilets<1 || straits<0){
            throw new IllegalArgumentException("Arguments have to be greater than 0!");
        }
        int remainingSpace = levelArea;
        remainingSpace -= levelArea * getEmptyAreaNeedPerArea();
        remainingSpace -= elevators * getElevatorSpace();
        remainingSpace -= toilets * getToiletsSpace();
        remainingSpace -= straits * getStraitsSpace();
        return remainingSpace / getRoomSpace();
    }

    public int elevatorNeeds(int levelArea, int floors){
        if (floors==0){
            return 0;
        }
        if (levelArea<1 || floors<0){
            throw new IllegalArgumentException("Arguments have to be greater than 0!");
        }
        return (int)(((double)levelArea/10) * getElevatorNeedPerArea10() + ((double)floors*getElevatorNeedPerLevel()));
    }

    public int straitsNeed(int levelArea, int floors){
        if (floors==0){
            return 0;
        }
        if (levelArea<1 || floors<0){
            throw new IllegalArgumentException("Arguments have to be greater than 0!");
        }
        return (int)(((double)levelArea/50) * getStraitsNeedPerArea50() + ((double)floors * getElevatorNeedPerLevel()));
    }

    public int parkingLevelNeed(int officeLevel){
        if (officeLevel<1){
            throw new IllegalArgumentException("Arguments have to be greater than 0!");
        }

        return officeLevel / getParkingNeedPerOfficeLevel();
    }

    public int serviceLevelNeed(int officeLevel){
        if (officeLevel<1){
            throw new IllegalArgumentException("Arguments have to be greater than 0!");
        }
        return officeLevel / getServicesNeedPerOfficeLevel();
    }

    public int gastroLevelNeed(int floors){
        if (floors<0){
            throw new IllegalArgumentException("Arguments have to be greater than 0!");
        }
        return floors / getGastroNeedPerLevel();
    }

    public Building totalCostCalculator(int levelArea, int floors, int undergroundFlors){
        return null;
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

    public int getElevatorSpace() {
        return elevatorSpace;
    }

    public double getStraitsNeedPerArea50() {
        return straitsNeedPerArea50;
    }

    public double getEmptyAreaNeedPerArea() {
        return emptyAreaNeedPerArea;
    }

    public int getParkingNeedPerOfficeLevel() {
        return parkingNeedPerOfficeLevel;
    }

    public int getServicesNeedPerOfficeLevel() {
        return servicesNeedPerOfficeLevel;
    }

    public int getGastroNeedPerLevel() {
        return gastroNeedPerLevel;
    }
}
