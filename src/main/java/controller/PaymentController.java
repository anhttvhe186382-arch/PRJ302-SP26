package controller;

import dao.PaymentDAO;

import jakarta.servlet.*;
import jakarta.servlet.http.*;
import java.io.IOException;

public class PaymentController extends HttpServlet {

    protected void processRequest(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {

        if (request.getMethod().equalsIgnoreCase("GET")) {

            request.getRequestDispatcher("view/payment.jsp")
                    .forward(request, response);
        }

        if (request.getMethod().equalsIgnoreCase("POST")) {

            int bookingId = Integer.parseInt(request.getParameter("bookingId"));
            double amount = Double.parseDouble(request.getParameter("amount"));
            String method = request.getParameter("method");

            PaymentDAO dao = new PaymentDAO();
            dao.payDeposit(bookingId, amount, method);

            response.sendRedirect("orders");
        }

    }

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp)
            throws ServletException, IOException {
        processRequest(req, resp);
    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp)
            throws ServletException, IOException {
        processRequest(req, resp);
    }

}
