package dao;

import java.sql.*;
import java.util.*;
import model.Motorbike;

public class MotorbikeDAO extends DBcontext {

    public List<Motorbike> getAllMotorbikes() {

        List<Motorbike> list = new ArrayList<>();

        String sql = "SELECT * FROM Motorbikes";

        try (Connection conn = getConnection();
             PreparedStatement ps = conn.prepareStatement(sql);
             ResultSet rs = ps.executeQuery()) {

            while (rs.next()) {

                Motorbike m = new Motorbike();

                m.setId(rs.getInt("motorbike_id"));
                m.setModelName(rs.getString("model_name"));
                m.setBrand(rs.getString("brand"));
                m.setDailyPrice(rs.getDouble("daily_price"));
                m.setDepositPrice(rs.getDouble("deposit_price"));
                m.setDescription(rs.getString("description"));

                list.add(m);
            }

        } catch (Exception e) {
            e.printStackTrace();
        }

        return list;
    }

    public Motorbike getMotorbikeById(int id) {

        String sql = "SELECT * FROM Motorbikes WHERE motorbike_id=?";

        try (Connection conn = getConnection();
             PreparedStatement ps = conn.prepareStatement(sql)) {

            ps.setInt(1, id);

            ResultSet rs = ps.executeQuery();

            if (rs.next()) {

                Motorbike m = new Motorbike();

                m.setId(rs.getInt("motorbike_id"));
                m.setModelName(rs.getString("model_name"));
                m.setBrand(rs.getString("brand"));
                m.setDailyPrice(rs.getDouble("daily_price"));
                m.setDepositPrice(rs.getDouble("deposit_price"));
                m.setDescription(rs.getString("description"));

                return m;
            }

        } catch (Exception e) {
            e.printStackTrace();
        }

        return null;
    }

}