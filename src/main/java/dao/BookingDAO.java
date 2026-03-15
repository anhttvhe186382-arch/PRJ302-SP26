package dao;

import java.sql.*;

public class BookingDAO extends DBcontext{

    public int createBooking(int userId, int motorbikeId, int rentalDays) {

        String sql = "INSERT INTO Bookings(user_id,motorbike_id,rental_days,status) VALUES(?,?,?,?)";

        try (Connection conn = getConnection();
             PreparedStatement ps = conn.prepareStatement(sql, Statement.RETURN_GENERATED_KEYS)) {

            ps.setInt(1, userId);
            ps.setInt(2, motorbikeId);
            ps.setInt(3, rentalDays);
            ps.setString(4, "Pending");

            ps.executeUpdate();

            ResultSet rs = ps.getGeneratedKeys();

            if (rs.next()) {
                return rs.getInt(1);
            }

        } catch (Exception e) {
            e.printStackTrace();
        }

        return -1;
    }

}