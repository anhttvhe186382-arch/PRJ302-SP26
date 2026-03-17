package dao;

import java.sql.*;

public class BookingDAO extends DBcontext {

    public int createBooking(int userId, int motorbikeId, int rentalDays) {

        String sql = "INSERT INTO Bookings(user_id,motorbike_id,rental_days,status) VALUES(?,?,?,?)";

        try (Connection conn = getConnection(); PreparedStatement ps = conn.prepareStatement(sql, Statement.RETURN_GENERATED_KEYS)) {

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

    public boolean processBooking(int userId, int motorbikeId, int branchId, double dailyPrice, double depositPrice, int rentalDays, String startDate, String endDate) {
        String insertBooking = "INSERT INTO bookings (branch_id, user_id, booking_type, total_deposit_price, total_price, status) VALUES (?, ?, 'Pre-book', ?, ?, 'Pending')";
        String insertDetail = "INSERT INTO booking_details (booking_id, motorbike_id, daily_price, rental_days, deposit_price, planning_start_time, planning_end_time) VALUES (?, ?, ?, ?, ?, ?, ?)";
        String updateBike = "UPDATE motorbikes SET status = 'Reserved' WHERE id = ?";

        Connection conn = null;
        try {
            conn = getConnection();
            conn.setAutoCommit(false); // Bắt đầu giao dịch

            // 1. Lưu vào bảng bookings
            PreparedStatement psB = conn.prepareStatement(insertBooking, Statement.RETURN_GENERATED_KEYS);
            psB.setInt(1, branchId);
            psB.setInt(2, userId);
            psB.setDouble(3, depositPrice);
            psB.setDouble(4, dailyPrice * rentalDays);
            psB.executeUpdate();

            ResultSet rs = psB.getGeneratedKeys();
            int bookingId = 0;
            if (rs.next()) {
                bookingId = rs.getInt(1);
            }

            // 2. Lưu vào bảng booking_details
            PreparedStatement psD = conn.prepareStatement(insertDetail);
            psD.setInt(1, bookingId);
            psD.setInt(2, motorbikeId);
            psD.setDouble(3, dailyPrice);
            psD.setInt(4, rentalDays);
            psD.setDouble(5, depositPrice);
            psD.setString(6, startDate);
            psD.setString(7, endDate);
            psD.executeUpdate();

            // 3. Cập nhật trạng thái xe
            PreparedStatement psU = conn.prepareStatement(updateBike);
            psU.setInt(1, motorbikeId);
            psU.executeUpdate();

            conn.commit(); // Hoàn tất
            return true;
        } catch (Exception e) {
            if (conn != null) try {
                conn.rollback();
            } catch (SQLException ex) {
            }
            e.printStackTrace();
            return false;
        }
    }
}
