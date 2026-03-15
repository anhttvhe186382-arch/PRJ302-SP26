package model;

public class Booking {

    private int id;
    private int userId;
    private int motorbikeId;
    private int rentalDays;
    private double totalPrice;
    private String status;

    public Booking() {
    }

    public Booking(int id, int userId, int motorbikeId, int rentalDays, double totalPrice, String status) {
        this.id = id;
        this.userId = userId;
        this.motorbikeId = motorbikeId;
        this.rentalDays = rentalDays;
        this.totalPrice = totalPrice;
        this.status = status;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }


    public int getUserId() {
        return userId;
    }

    public void setUserId(int userId) {
        this.userId = userId;
    }

    public int getMotorbikeId() {
        return motorbikeId;
    }

    public void setMotorbikeId(int motorbikeId) {
        this.motorbikeId = motorbikeId;
    }

    public int getRentalDays() {
        return rentalDays;
    }

    public void setRentalDays(int rentalDays) {
        this.rentalDays = rentalDays;
    }

    public double getTotalPrice() {
        return totalPrice;
    }

    public void setTotalPrice(double totalPrice) {
        this.totalPrice = totalPrice;
    }

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }

}
