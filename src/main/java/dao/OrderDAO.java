package dao;

import java.sql.*;
import java.util.*;
import model.Booking;

public class OrderDAO extends DBcontext {

    public List<Booking> getOrdersByUser(int userId) {

        List<Booking> list = new ArrayList<>();

        String sql = "SELECT * FROM Bookings WHERE user_id=?";

        try (Connection conn = getConnection();
             PreparedStatement ps = conn.prepareStatement(sql)) {

            ps.setInt(1, userId);

            ResultSet rs = ps.executeQuery();

            while (rs.next()) {

                Booking b = new Booking();

                b.setId(rs.getInt("booking_id"));
                b.setUserId(rs.getInt("user_id"));
                b.setMotorbikeId(rs.getInt("motorbike_id"));
                b.setRentalDays(rs.getInt("rental_days"));
                b.setStatus(rs.getString("status"));

                list.add(b);
            }

        } catch (Exception e) {
            e.printStackTrace();
        }

        return list;
    }

    public Booking getOrderById(int id) {

        String sql = "SELECT * FROM Bookings WHERE booking_id=?";

        try (Connection conn = getConnection();
             PreparedStatement ps = conn.prepareStatement(sql)) {

            ps.setInt(1, id);

            ResultSet rs = ps.executeQuery();

            if (rs.next()) {

                Booking b = new Booking();

                b.setId(rs.getInt("booking_id"));
                b.setUserId(rs.getInt("user_id"));
                b.setMotorbikeId(rs.getInt("motorbike_id"));
                b.setRentalDays(rs.getInt("rental_days"));
                b.setStatus(rs.getString("status"));

                return b;
            }

        } catch (Exception e) {
            e.printStackTrace();
        }

        return null;
    }

}