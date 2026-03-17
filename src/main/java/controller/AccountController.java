package controller;

import dao.AccountDAO;
import model.Account;

import jakarta.servlet.*;
import jakarta.servlet.http.*;
import java.io.IOException;
import model.AccountProfile;

public class AccountController extends HttpServlet {

    protected void processRequest(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {

    }

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
//        processRequest(req, resp);

        HttpSession session = request.getSession(false);

        if (session == null) {
            response.sendRedirect("login");
            return;
        }
        Account auth = (session != null) ? (Account) session.getAttribute("account") : null;

        if (auth == null) {
            response.sendRedirect("login");
            return;
        }

        String username = auth.getUsername();

        AccountDAO dao = new AccountDAO();

        Account acc = dao.getAccountProfile(username);
        System.out.println("user name từ session : " + username);
        request.setAttribute("account", acc);
        request.getRequestDispatcher("view/profile.jsp").forward(request, response);

    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp)
            throws ServletException, IOException {
        processRequest(req, resp);
    }

}
