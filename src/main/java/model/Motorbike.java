package model;

public class Motorbike {

    private int id;
    private String modelName;
    private String brand;
    private double dailyPrice;
    private double depositPrice;
    private String description;

    public Motorbike() {
    }

    public Motorbike(int id, String modelName, String brand, double dailyPrice, double depositPrice, String description) {
        this.id = id;
        this.modelName = modelName;
        this.brand = brand;
        this.dailyPrice = dailyPrice;
        this.depositPrice = depositPrice;
        this.description = description;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }


    public String getModelName() {
        return modelName;
    }

    public void setModelName(String modelName) {
        this.modelName = modelName;
    }

    public String getBrand() {
        return brand;
    }

    public void setBrand(String brand) {
        this.brand = brand;
    }

    public double getDailyPrice() {
        return dailyPrice;
    }

    public void setDailyPrice(double dailyPrice) {
        this.dailyPrice = dailyPrice;
    }

    public double getDepositPrice() {
        return depositPrice;
    }

    public void setDepositPrice(double depositPrice) {
        this.depositPrice = depositPrice;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

}