package dao;

import java.sql.*;
import model.Account;

public class AccountDAO extends DBcontext {

    public Account login(String username, String password) {

        String sql = "SELECT * FROM Users WHERE username=? AND password=?";

        try (Connection conn = getConnection(); PreparedStatement ps = conn.prepareStatement(sql)) {

            ps.setString(1, username);
            ps.setString(2, password);

            ResultSet rs = ps.executeQuery();

            if (rs.next()) {
                Account acc = new Account();

                acc.setUserId(rs.getInt("user_id"));
                acc.setUsername(rs.getString("username"));
                acc.setFullname(rs.getString("fullname"));
                acc.setPhone(rs.getString("phone"));
                acc.setEmail(rs.getString("email"));

                return acc;
            }

        } catch (Exception e) {
            e.printStackTrace();
        }

        return null;
    }

    public void register(String username, String password, String fullname, String phone, String email) {

        String sql = "INSERT INTO Users(username,password,fullname,phone,email) VALUES(?,?,?,?,?)";

        try (Connection conn = getConnection(); PreparedStatement ps = conn.prepareStatement(sql)) {

            ps.setString(1, username);
            ps.setString(2, password);
            ps.setString(3, fullname);
            ps.setString(4, phone);
            ps.setString(5, email);

            ps.executeUpdate();

        } catch (Exception e) {
            e.printStackTrace();
        }

    }

    public void updateProfile(int userId, String fullname, String phone, String email) {

        String sql = "UPDATE Users SET fullname=?, phone=?, email=? WHERE user_id=?";

        try (Connection conn = getConnection(); PreparedStatement ps = conn.prepareStatement(sql)) {

            ps.setString(1, fullname);
            ps.setString(2, phone);
            ps.setString(3, email);
            ps.setInt(4, userId);

            ps.executeUpdate();

        } catch (Exception e) {
            e.printStackTrace();
        }

    }

    public boolean checkUsernameExist(String username) {
//
//    String sql = "SELECT * FROM accounts WHERE username=?";
//
//    try{
////        PreparedStatement ps = Connection().prepareStatement(sql);
//        ps.setString(1, username);
//
//        ResultSet rs = ps.executeQuery();
//
//        if(rs.next()){
//            return true;
//        }
//
//    }catch(Exception e){
//        e.printStackTrace();
//    }
//
    return false;
    }

}
