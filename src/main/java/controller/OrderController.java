package controller;

import dao.OrderDAO;
import model.Account;
import model.Booking;

import jakarta.servlet.*;
import jakarta.servlet.http.*;
import java.io.IOException;
import java.util.List;

public class OrderController extends HttpServlet {

    protected void processRequest(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {

        String path = request.getServletPath();

        OrderDAO dao = new OrderDAO();

        Account acc = (Account) request.getSession().getAttribute("account");

        if (path.equals("/orders")) {

            List<Booking> list = dao.getOrdersByUser(acc.getUserId());

            request.setAttribute("orders", list);
            request.getRequestDispatcher("view/orders.jsp")
                    .forward(request, response);
        }

        if (path.equals("/order-detail")) {

            int id = Integer.parseInt(request.getParameter("id"));

            Booking b = dao.getOrderById(id);

            request.setAttribute("order", b);
            request.getRequestDispatcher("view/order-detail.jsp")
                    .forward(request, response);
        }

    }

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp)
            throws ServletException, IOException {
        processRequest(req, resp);
    }

}
