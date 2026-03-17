package dao;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class DBcontext {

    protected Connection connection;

    public DBcontext() {
        String url = "jdbc:sqlserver://localhost:1433;databaseName=PRJ302_Project_Group3_IS2003;trustServerCertificate=true";
        String user = "sa";
        String pass = "123";

        try {
            // Load driver
            Class.forName("com.microsoft.sqlserver.jdbc.SQLServerDriver");
            System.out.println("Driver loaded successfully!");

            // Connect DB
            connection = DriverManager.getConnection(url, user, pass);
            System.out.println("Connection established!");

        } catch (ClassNotFoundException e) {
            System.out.println("❌ SQL Server Driver not found!");
            e.printStackTrace();

        } catch (SQLException e) {
            System.out.println("❌ SQL Exception occurred!");

            // In lỗi chi tiết
            System.out.println("Message: " + e.getMessage());
            System.out.println("SQLState: " + e.getSQLState());
            System.out.println("Error Code: " + e.getErrorCode());

            // In toàn bộ stack trace
            e.printStackTrace();
        }
    }

    public Connection getConnection() {
        return connection;
    }

    public static void main(String[] args) {
        DBcontext db = new DBcontext();
        Connection conn = db.getConnection();

        if (conn != null) {
            System.out.println("✅ Connected to database successfully!");
        } else {
            System.out.println("❌ Failed to connect to database!");
        }
    }
}