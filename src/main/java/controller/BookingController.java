package controller;

import dao.BookingDAO;
import model.Account;

import jakarta.servlet.*;
import jakarta.servlet.http.*;
import java.io.IOException;

public class BookingController extends HttpServlet {

    protected void processRequest(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {

        if (request.getMethod().equalsIgnoreCase("POST")) {

            int motorbikeId = Integer.parseInt(request.getParameter("motorbikeId"));
            int rentalDays = Integer.parseInt(request.getParameter("rentalDays"));

            Account acc = (Account) request.getSession().getAttribute("account");

            BookingDAO dao = new BookingDAO();
            int bookingId = dao.createBooking(acc.getUserId(), motorbikeId, rentalDays);

            response.sendRedirect("payment?bookingId=" + bookingId);
        }

    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp)
            throws ServletException, IOException {
        processRequest(req, resp);
    }

}