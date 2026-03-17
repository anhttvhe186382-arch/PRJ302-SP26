package model;

public class Account {

    private int userId;
    private String username;
    private String password;
    private String fullname;
    private String phone;
    private String gender;
    private String idCardNo;
    private String role;

    public Account() {
    }

    public Account(int userId, String username, String password, String fullname, String phone, String gender, String idCardNo, String role) {
        this.userId = userId;
        this.username = username;
        this.password = password;
        this.fullname = fullname;
        this.phone = phone;
        this.gender = gender;
        this.idCardNo = idCardNo;
        this.role = role;
    }

    public int getUserId() {
        return userId;
    }

    public void setUserId(int userId) {
        this.userId = userId;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
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

    public String getGender() {
        return gender;
    }

    public void setGender(String gender) {
        this.gender = gender;
    }

    public String getIdCardNo() {
        return idCardNo;
    }

    public void setIdCardNo(String idCardNo) {
        this.idCardNo = idCardNo;
    }

    public String getRole() {
        return role;
    }

    public void setRole(String role) {
        this.role = role;
    }

    

}
