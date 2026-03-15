package controller;

import dao.AccountDAO;
import model.Account;

import jakarta.servlet.*;
import jakarta.servlet.http.*;
import java.io.IOException;

public class AccountController extends HttpServlet {

    protected void processRequest(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {

    }

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
//        processRequest(req, resp);
        if (request.getMethod().equalsIgnoreCase("GET")) {

            request.getRequestDispatcher("view/profile.jsp")
                    .forward(request, response);
        }

        if (request.getMethod().equalsIgnoreCase("POST")) {

            Account acc = (Account) request.getSession().getAttribute("account");

            String fullname = request.getParameter("fullname");
            String phone = request.getParameter("phone");
            String email = request.getParameter("email");

            AccountDAO dao = new AccountDAO();
            dao.updateProfile(acc.getUserId(), fullname, phone, email);

            response.sendRedirect("profile");
        }
    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp)
            throws ServletException, IOException {
        processRequest(req, resp);
    }

}
