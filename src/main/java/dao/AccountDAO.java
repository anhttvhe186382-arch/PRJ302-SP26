package dao;

import java.sql.*;
import model.Account;

public class AccountDAO extends DBcontext {

    public Account login(String username, String password) {

        String sql = "SELECT * FROM accounts WHERE username=? AND password=?";

        try (Connection conn = getConnection(); PreparedStatement ps = conn.prepareStatement(sql)) {

            ps.setString(1, username);
            ps.setString(2, password);

            ResultSet rs = ps.executeQuery();

            if (rs.next()) {
                Account acc = new Account();

                acc.setUserId(rs.getInt("user_id"));
                acc.setUsername(rs.getString("username"));
//                acc.setFullname(rs.getString("fullname"));
//                acc.setPhone(rs.getString("phone"));
//                acc.setEmail(rs.getString("email"));

                return acc;
            }

        } catch (Exception e) {
            e.printStackTrace();
        }

        return null;
    }

    public boolean register(String username, String password, String fullname, String phone, String is_cart_no) {

        String sqlProfile
                = "INSERT INTO account_profiles(full_name, phone, gender, id_card_no) VALUES(?,?,?,?)";

        String sqlAccount
                = "INSERT INTO accounts(username,password,role,user_id) VALUES(?,?,?,?)";

        try (Connection conn = getConnection()) {

            conn.setAutoCommit(false);

            PreparedStatement ps1
                    = conn.prepareStatement(sqlProfile, Statement.RETURN_GENERATED_KEYS);

            ps1.setString(1, fullname);
            ps1.setString(2, phone);
            ps1.setString(3, "Other");
            ps1.setString(4, is_cart_no);

            int row1 = ps1.executeUpdate();

            if (row1 == 0) {
                conn.rollback();
                return false;
            }

            ResultSet rs = ps1.getGeneratedKeys();

            int profileId = 0;

            if (rs.next()) {
                profileId = rs.getInt(1);
            }

            if (profileId == 0) {
                conn.rollback();
                return false;
            }

            PreparedStatement ps2 = conn.prepareStatement(sqlAccount);

            ps2.setString(1, username);
            ps2.setString(2, password);
            ps2.setString(3, "Customer");
            ps2.setInt(4, profileId);

            int row2 = ps2.executeUpdate();

            if (row2 == 0) {
                conn.rollback();
                return false;
            }

            conn.commit();
            return true;

        } catch (Exception e) {
            e.printStackTrace();
        }

        return false;
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
        String sql = "SELECT * FROM accounts WHERE username=?";

        try {
            PreparedStatement ps = getConnection().prepareStatement(sql);
            ps.setString(1, username);

            ResultSet rs = ps.executeQuery();

            if (rs.next()) {
                return true;
            }

        } catch (Exception e) {
            e.printStackTrace();
        }
//
        return false;
    }

    public Account getAccountProfile(String username) {
    // 1. Thêm đầy đủ các cột từ bảng account_profiles (p)
    String sql = """
        SELECT a.user_id, a.username, a.password, a.role,
               p.full_name, p.phone, p.gender, p.id_card_no, p.address
        FROM accounts a
        JOIN account_profiles p ON a.user_id = p.id
        WHERE a.username = ?
    """;

    try {
        PreparedStatement ps = connection.prepareStatement(sql);
        ps.setString(1, username);
        ResultSet rs = ps.executeQuery();

        if (rs.next()) {
            Account acc = new Account();
            // Gán dữ liệu từ bảng accounts
            acc.setUserId(rs.getInt("user_id"));
            acc.setUsername(rs.getString("username"));
            acc.setPassword(rs.getString("password"));
            acc.setRole(rs.getString("role"));

            // Gán dữ liệu từ bảng account_profiles (Quan trọng: Phải có đủ các dòng này)
            acc.setFullname(rs.getNString("full_name"));
            acc.setPhone(rs.getString("phone"));
            acc.setGender(rs.getString("gender"));
            acc.setIdCardNo(rs.getString("id_card_no"));
            // Nếu bạn có thêm trường address trong model thì thêm vào:
            // acc.setAddress(rs.getNString("address")); 

            return acc;
        }
    } catch (Exception e) {
        e.printStackTrace();
    }
    return null;
}
    public static void main(String[] args) {
        // 1. Khởi tạo DAO
        AccountDAO dao = new AccountDAO();

        // 2. Nhập một username đang có trong Database của bạn
        String usernameToTest = "customer3"; // <--- Thay đổi giá trị này cho đúng DB của bạn

        System.out.println("========== ĐANG KIỂM TRÊN PROFILE: " + usernameToTest + " ==========");

        // 3. Gọi hàm lấy thông tin
        Account acc = dao.getAccountProfile(usernameToTest);

        // 4. Kiểm tra và in chi tiết từng trường dữ liệu
        if (acc != null) {
            System.out.println("[KẾT QUẢ: THÀNH CÔNG]");
            System.out.println("-------------------------------------------");
            System.out.println("1. User ID:      " + acc.getUserId());
            System.out.println("2. Username:     " + acc.getUsername());
            System.out.println("3. Role:         " + acc.getRole());
            
            System.out.println("\n--- THÔNG TIN CHI TIẾT (Từ bảng account_profiles) ---");
            System.out.println("4. Họ và Tên:    " + acc.getFullname());
            System.out.println("5. Số điện thoại: " + acc.getPhone());
            System.out.println("6. Giới tính:    " + acc.getGender());
            System.out.println("7. Số CCCD:      " + acc.getIdCardNo());
            System.out.println("-------------------------------------------");
            
            // Kiểm tra xem có trường nào bị null không
            if (acc.getFullname() == null || acc.getPhone() == null) {
                System.out.println(">>> CẢNH BÁO: Một số thông tin profile bị NULL.");
                System.out.println("Gợi ý: Kiểm tra xem bảng account_profiles đã có dữ liệu ứng với ID này chưa.");
            }
            
        } else {
            System.out.println("[KẾT QUẢ: THẤT BẠI]");
            System.out.println("Lý do: Không tìm thấy username '" + usernameToTest + "' hoặc lỗi kết nối SQL.");
        }
    }
}
