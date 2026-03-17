package dao;

import java.sql.*;
import java.util.*;
import model.Motorbike;
import model.motobikeModel;

public class MotorbikeDAO extends DBcontext {

    public List<Motorbike> getAllMotorbikes() {
        List<Motorbike> list = new ArrayList<>();

        // Sử dụng INNER JOIN để lấy thông tin từ cả 2 bảng
        String sql = "SELECT m.id, m.model_id, m.branch_id, m.daily_price, m.deposit_price, "
                + "m.license_plate, m.status, m.is_deleted, "
                + "mm.model_name, mm.description, mm.brand, mm.image_path, mm.is_deleted AS model_is_deleted "
                + "FROM motorbikes m "
                + "INNER JOIN motorbike_models mm ON m.model_id = mm.id "
                + "WHERE m.is_deleted = 0"; // Chỉ lấy những xe chưa bị xóa

        try (Connection conn = getConnection(); PreparedStatement ps = conn.prepareStatement(sql); ResultSet rs = ps.executeQuery()) {

            while (rs.next()) {
                // 1. Tạo đối tượng motobikeModel trước
                motobikeModel mbModel = new motobikeModel();
                mbModel.setId(rs.getInt("model_id"));
                mbModel.setModelName(rs.getNString("model_name"));
                mbModel.setDescription(rs.getNString("description"));
                mbModel.setBrand(rs.getNString("brand"));
                mbModel.setImagePath(rs.getString("image_path"));
                mbModel.setIsDeleted(rs.getBoolean("model_is_deleted"));

                // 2. Tạo đối tượng Motorbike và gắn mbModel vào
                Motorbike motorbike = new Motorbike();
                motorbike.setId(rs.getInt("id"));
                motorbike.setModel(mbModel); // Gắn đối tượng model vào đây
                motorbike.setBranchId(rs.getInt("branch_id"));
                motorbike.setDailyPrice(rs.getDouble("daily_price"));
                motorbike.setDepositPrice(rs.getDouble("deposit_price"));
                motorbike.setLicensePlate(rs.getString("license_plate"));
                motorbike.setStatus(rs.getString("status"));
                motorbike.setIsDeleted(rs.getBoolean("is_deleted"));

                list.add(motorbike);
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
        return list;
    }

//    public Motorbike getMotorbikeById(int id) {
//
//        String sql = "SELECT * FROM Motorbikes WHERE motorbike_id=?";
//
//        try (Connection conn = getConnection(); PreparedStatement ps = conn.prepareStatement(sql)) {
//
//            ps.setInt(1, id);
//
//            ResultSet rs = ps.executeQuery();
//
//            if (rs.next()) {
//
//                Motorbike m = new Motorbike();
//
//                m.setId(rs.getInt("motorbike_id"));
//                m.setModelName(rs.getString("model_name"));
//                m.setBrand(rs.getString("brand"));
//                m.setDailyPrice(rs.getDouble("daily_price"));
//                m.setDepositPrice(rs.getDouble("deposit_price"));
//                m.setDescription(rs.getString("description"));
//
//                return m;
//            }
//
//        } catch (Exception e) {
//            e.printStackTrace();
//        }
//
//        return null;
//    }
    public Motorbike getMotorbikeById(int id) {
        String sql = "SELECT m.id, m.model_id, m.branch_id, m.daily_price, m.deposit_price, "
                + "m.license_plate, m.status, m.is_deleted, "
                + "mm.model_name, mm.description, mm.brand, mm.image_path, mm.is_deleted AS model_deleted "
                + "FROM motorbikes m "
                + "JOIN motorbike_models mm ON m.model_id = mm.id "
                + "WHERE m.id = ?";
        try {
            PreparedStatement ps = connection.prepareStatement(sql);
            ps.setInt(1, id);
            ResultSet rs = ps.executeQuery();
            if (rs.next()) {
                motobikeModel mm = new motobikeModel();
                mm.setId(rs.getInt("model_id"));
                mm.setModelName(rs.getNString("model_name"));
                mm.setDescription(rs.getNString("description"));
                mm.setBrand(rs.getNString("brand"));
                mm.setImagePath(rs.getString("image_path"));
                mm.setIsDeleted(rs.getBoolean("model_deleted"));

                Motorbike m = new Motorbike();
                m.setId(rs.getInt("id"));
                m.setModel(mm);
                m.setBranchId(rs.getInt("branch_id"));
                m.setDailyPrice(rs.getDouble("daily_price"));
                m.setDepositPrice(rs.getDouble("deposit_price"));
                m.setLicensePlate(rs.getString("license_plate"));
                m.setStatus(rs.getString("status"));
                m.setIsDeleted(rs.getBoolean("is_deleted"));
                return m;
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
        return null;
    }


        public static void main(String[] args) {
            // 1. Khởi tạo DAO
            MotorbikeDAO dao = new MotorbikeDAO();

            // 2. Nhập một ID xe đang có trong DB của bạn (ví dụ: ID = 1)
            int testId = 1;

            System.out.println("========== KIỂM TRA XE ID: " + testId + " ==========");

            // 3. Gọi hàm lấy thông tin
            Motorbike m = dao.getMotorbikeById(testId);

            // 4. Kiểm tra và in chi tiết
            if (m != null) {
                System.out.println("[KẾT QUẢ: ĐÃ TÌM THẤY XE]");
                System.out.println("-------------------------------------------");
                System.out.println("Hãng xe:      " + m.getModel().getBrand());
                System.out.println("Tên Model:    " + m.getModel().getModelName());

                // ĐÂY LÀ DÒNG QUAN TRỌNG NHẤT ĐỂ KIỂM TRA MÔ TẢ
                System.out.println("Mô tả:        " + m.getModel().getDescription());

                System.out.println("Biển số:      " + m.getLicensePlate());
                System.out.println("Giá thuê:     " + m.getDailyPrice());
                System.out.println("Tiền cọc:     " + m.getDepositPrice());
                System.out.println("Ảnh:          " + m.getModel().getImagePath());
                System.out.println("-------------------------------------------");

                // Kiểm tra xem mô tả có bị null hoặc rỗng không
                if (m.getModel().getDescription() == null || m.getModel().getDescription().trim().isEmpty()) {
                    System.out.println(">>> CẢNH BÁO: Mô tả đang bị NULL hoặc TRỐNG trong Database.");
                }
            } else {
                System.out.println("[KẾT QUẢ: THẤT BẠI]");
                System.out.println("Lý do: Không tìm thấy xe với ID = " + testId + " hoặc lỗi kết nối.");
            }
        }
    }
