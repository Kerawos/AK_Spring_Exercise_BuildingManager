package pl.akademiakodu.AK_Spring_Exercise_BuildingManager.models;

public class Building {

    private int width;
    private int length;
    private int floors;
    private int undergroundFloors;
    private int parkingLevel;
    private int officeLevel;
    private int serviceLevel;
    private int gastroLevel;
    private int elevator;

    public Building() {
    }

    public Building(int width, int length, int floors, int undergroundFloors, int parkingLevel, int officeLevel, int serviceLevel, int gastroLevel, int elevator) {
        this.width = width;
        this.length = length;
        this.floors = floors;
        this.undergroundFloors = undergroundFloors;
        this.parkingLevel = parkingLevel;
        this.officeLevel = officeLevel;
        this.serviceLevel = serviceLevel;
        this.gastroLevel = gastroLevel;
        this.elevator = elevator;
    }

    public int getWidth() {
        return width;
    }

    public void setWidth(int width) {
        this.width = width;
    }

    public int getLength() {
        return length;
    }

    public void setLength(int length) {
        this.length = length;
    }

    public int getFloors() {
        return floors;
    }

    public void setFloors(int floors) {
        this.floors = floors;
    }

    public int getUndergroundFloors() {
        return undergroundFloors;
    }

    public void setUndergroundFloors(int undergroundFloors) {
        this.undergroundFloors = undergroundFloors;
    }

    public int getParkingLevel() {
        return parkingLevel;
    }

    public void setParkingLevel(int parkingLevel) {
        this.parkingLevel = parkingLevel;
    }

    public int getOfficeLevel() {
        return officeLevel;
    }

    public void setOfficeLevel(int officeLevel) {
        this.officeLevel = officeLevel;
    }

    public int getServiceLevel() {
        return serviceLevel;
    }

    public void setServiceLevel(int serviceLevel) {
        this.serviceLevel = serviceLevel;
    }

    public int getGastroLevel() {
        return gastroLevel;
    }

    public void setGastroLevel(int gastroLevel) {
        this.gastroLevel = gastroLevel;
    }

    public int getElevator() {
        return elevator;
    }

    public void setElevator(int elevator) {
        this.elevator = elevator;
    }
}
