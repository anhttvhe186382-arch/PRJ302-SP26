package model;

public class AccountProfile {

    private int userId;
    private String fullname;
    private String phone;
    private String email;

    public AccountProfile() {
    }

    public AccountProfile(int userId, String fullname, String phone, String email) {
        this.userId = userId;
        this.fullname = fullname;
        this.phone = phone;
        this.email = email;
    }

    public int getUserId() {
        return userId;
    }

    public void setUserId(int userId) {
        this.userId = userId;
    }

    public String getFullname() {
        return fullname;
    }

    public void setFullname(String fullname) {
        this.fullname = fullname;
    }

    public String getPhone() {
        return phone;
    }

    public void setPhone(String phone) {
        this.phone = phone;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }
}