package model;

public class BookingDetail {

    private int bookingId;
    private String modelName;
    private int rentalDays;
    private double totalPrice;
    private String status;

    public BookingDetail() {
    }

    public BookingDetail(int bookingId, String modelName, int rentalDays, double totalPrice, String status) {
        this.bookingId = bookingId;
        this.modelName = modelName;
        this.rentalDays = rentalDays;
        this.totalPrice = totalPrice;
        this.status = status;
    }

    public int getBookingId() {
        return bookingId;
    }

    public void setBookingId(int bookingId) {
        this.bookingId = bookingId;
    }

    public String getModelName() {
        return modelName;
    }

    public void setModelName(String modelName) {
        this.modelName = modelName;
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
