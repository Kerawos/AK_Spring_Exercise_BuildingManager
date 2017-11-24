package pl.akademiakodu.AK_Spring_Exercise_BuildingManager.models;

public class CostExploration {

    private double taxPerMeterArea = 0.5;
    private int chargesMonthlyPerToilet = 240;
    private double chargesMonthlyPerAreaMeter = 0.6;
    private int chargesMonthlyMediaPerAreaMeter = 1;
    private int chargesMonthlyPowerConsumptionPerWorker = 12;
    private double chargesMonthlyPowerConsumptionPerMeterArea = 0.2;
    private int chargesMonthlyGastroPerWorker = -20;

    public int calcTotalChargesMonthly(int totalToilets, int totalBuildingArea, int totalWorkers){
        int totalChargesMonthly = 0;
        totalChargesMonthly+=calcTaxPerMeterArea(totalBuildingArea);
        totalChargesMonthly+=calcChargesMonthlyPerToilet(totalToilets);
        totalChargesMonthly+=calcChargesMonthlyPerAreaMeter(totalBuildingArea);
        totalChargesMonthly+=calcChargesMonthlyMedia(totalBuildingArea);
        totalChargesMonthly+=calcChargesMonthlyPowerConsumptionPerWorker(totalWorkers);
        totalChargesMonthly+=calcChargesMonthlyPowerConsumptionPerMeterArea(totalBuildingArea);
        totalChargesMonthly+=calcChargesMonthlyGastroPerWorker(totalWorkers);
        return totalChargesMonthly;
    }

    public int calcTaxPerMeterArea(int totalBuildingArea){
        if (totalBuildingArea<1){
            throw new IllegalArgumentException("Arguments have to be greater than 0!");
        }
        return (int)(totalBuildingArea * getTaxPerMeterArea());
    }

    public int calcChargesMonthlyPerToilet(int toilets){
        if (toilets<1){
            throw new IllegalArgumentException("Arguments have to be greater than 0!");
        }
        return toilets * getChargesMonthlyPerToilet();
    }

    public int calcChargesMonthlyPerAreaMeter(int totalBuildingArea){
        if (totalBuildingArea<1){
            throw new IllegalArgumentException("Arguments have to be greater than 0!");
        }
        return (int)(totalBuildingArea * getChargesMonthlyPerAreaMeter());
    }

    public int calcChargesMonthlyMedia(int totalBuildingArea){
        if (totalBuildingArea<1){
            throw new IllegalArgumentException("Arguments have to be greater than 0!");
        }
        return totalBuildingArea * getChargesMonthlyMediaPerAreaMeter();
    }

    public int calcChargesMonthlyPowerConsumptionPerWorker(int totalWorkers){
        if (totalWorkers<1){
            throw new IllegalArgumentException("Arguments have to be greater than 0!");
        }
        return totalWorkers * getChargesMonthlyPowerConsumptionPerWorker();
    }

    public int calcChargesMonthlyPowerConsumptionPerMeterArea(int totalBuildingArea){
        if (totalBuildingArea<1){
            throw new IllegalArgumentException("Arguments have to be greater than 0!");
        }
        return (int)(totalBuildingArea * getChargesMonthlyPowerConsumptionPerMeterArea());
    }

    public int calcChargesMonthlyGastroPerWorker(int totalWorkers){
        if (totalWorkers<1){
            throw new IllegalArgumentException("Arguments have to be greater than 0!");
        }
        return totalWorkers * getChargesMonthlyGastroPerWorker();
    }

    //Getters
    public int getChargesMonthlyPerToilet() {
        return chargesMonthlyPerToilet;
    }

    public double getChargesMonthlyPerAreaMeter() {
        return chargesMonthlyPerAreaMeter;
    }

    public int getChargesMonthlyMediaPerAreaMeter() {
        return chargesMonthlyMediaPerAreaMeter;
    }

    public int getChargesMonthlyPowerConsumptionPerWorker() {
        return chargesMonthlyPowerConsumptionPerWorker;
    }

    public double getChargesMonthlyPowerConsumptionPerMeterArea() {
        return chargesMonthlyPowerConsumptionPerMeterArea;
    }

    public int getChargesMonthlyGastroPerWorker() {
        return chargesMonthlyGastroPerWorker;
    }

    public double getTaxPerMeterArea() {
        return taxPerMeterArea;
    }
}
