package model;
import model.motobikeModel; 

public class Motorbike {

   private int id;
    private motobikeModel model; // Chứa thông tin từ bảng motorbike_models
    private int branchId;
    private double dailyPrice;
    private double depositPrice;
    private String licensePlate;
    private String status;
    private boolean isDeleted;

    public Motorbike() {
    }

    public Motorbike(int id, motobikeModel model, int branchId, double dailyPrice, double depositPrice, String licensePlate, String status, boolean isDeleted) {
        this.id = id;
        this.model = model;
        this.branchId = branchId;
        this.dailyPrice = dailyPrice;
        this.depositPrice = depositPrice;
        this.licensePlate = licensePlate;
        this.status = status;
        this.isDeleted = isDeleted;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public motobikeModel getModel() {
        return model;
    }

    public void setModel(motobikeModel model) {
        this.model = model;
    }

    public int getBranchId() {
        return branchId;
    }

    public void setBranchId(int branchId) {
        this.branchId = branchId;
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

    public String getLicensePlate() {
        return licensePlate;
    }

    public void setLicensePlate(String licensePlate) {
        this.licensePlate = licensePlate;
    }

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }

    public boolean isIsDeleted() {
        return isDeleted;
    }

    public void setIsDeleted(boolean isDeleted) {
        this.isDeleted = isDeleted;
    }

   
}