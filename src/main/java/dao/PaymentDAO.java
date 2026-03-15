package dao;

import java.sql.*;

public class PaymentDAO extends DBcontext {

    public void payDeposit(int bookingId, double amount, String method) {

        String sql = "INSERT INTO Payments(booking_id,amount,method) VALUES(?,?,?)";

        try (Connection conn = getConnection();
             PreparedStatement ps = conn.prepareStatement(sql)) {

            ps.setInt(1, bookingId);
            ps.setDouble(2, amount);
            ps.setString(3, method);

            ps.executeUpdate();

        } catch (Exception e) {
            e.printStackTrace();
        }

    }

}
