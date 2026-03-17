package controller;

import dao.BookingDAO;
import dao.MotorbikeDAO;
import model.Account;

import jakarta.servlet.*;
import jakarta.servlet.http.*;
import java.io.IOException;
import model.Motorbike;

public class BookingController extends HttpServlet {

    protected void processRequest(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {

    }

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {

        // 1. Lấy ID từ request (gửi từ nút "Đặt ngay")
        String idRaw = request.getParameter("motorbikeId");

        try {
            int id = Integer.parseInt(idRaw);
            MotorbikeDAO dao = new MotorbikeDAO();

            // 2. Lấy thông tin chi tiết xe
            Motorbike bike = dao.getMotorbikeById(id);

            if (bike != null) {
                // 3. Đẩy dữ liệu sang trang booking.jsp
                request.setAttribute("bike", bike);
                request.getRequestDispatcher("view/booking.jsp").forward(request, response);
            } else {
                response.sendRedirect("viewMotorbike"); // Không tìm thấy xe thì quay lại danh sách
            }
        } catch (NumberFormatException e) {
            response.sendRedirect("viewMotorbike");
        }
    }

    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        // Giả sử Account đã được lưu trong Session khi Login
        // Account acc = (Account) request.getSession().getAttribute("account");
        // int userId = acc.getUserId(); 
        int userId = 1; // Test cứng nếu chưa có Login logic

        int bikeId = Integer.parseInt(request.getParameter("bikeId"));
        String startDate = request.getParameter("startDate");
        String endDate = request.getParameter("endDate");

        // Tính số ngày thuê
        long days = java.time.temporal.ChronoUnit.DAYS.between(
            java.time.LocalDate.parse(startDate), 
            java.time.LocalDate.parse(endDate)
        );
        int rentalDays = (days <= 0) ? 1 : (int) days;

        MotorbikeDAO dao = new MotorbikeDAO();
        Motorbike bike = dao.getMotorbikeById(bikeId);
        BookingDAO bookingDao = new BookingDAO();

        if (bike != null) {
            boolean isSuccess = bookingDao.processBooking(userId, bikeId, bike.getBranchId(), 
                                bike.getDailyPrice(), bike.getDepositPrice(), 
                                rentalDays, startDate, endDate);

            if (isSuccess) {
                request.setAttribute("bike", bike);
                request.setAttribute("rentalDays", rentalDays);
                request.setAttribute("totalPrice", bike.getDailyPrice() * rentalDays);
                request.getRequestDispatcher("view/booking_detail.jsp").forward(request, response);
            } else {
                response.sendRedirect("error.jsp");
            }
        }
    }

}
