package controller;

import dao.AccountDAO;
import model.Account;

import jakarta.servlet.*;
import jakarta.servlet.http.*;
import java.io.IOException;
import util.EmailUtil;
import util.OTPUtil;

public class AuthController extends HttpServlet {

    protected void processRequest(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {

        String path = request.getServletPath();

        // LOGIN
        if (path.equals("/login")) {

            if (request.getMethod().equalsIgnoreCase("GET")) {

                request.getRequestDispatcher("/view/login.jsp").forward(request, response);

            } else {

                String username = request.getParameter("username");
                String password = request.getParameter("password");

                AccountDAO dao = new AccountDAO();
                Account acc = dao.login(username, password);

                if (acc != null) {

                    request.getSession().setAttribute("account", acc);

                    response.sendRedirect(request.getContextPath() + "/motorbikes");

                } else {

                    request.setAttribute("error", "Login failed");

                    request.getRequestDispatcher("/view/login.jsp").forward(request, response);

                }
            }
        }

        if (path.equals("/register")) {

    if (request.getMethod().equalsIgnoreCase("GET")) {

        request.getRequestDispatcher("/view/register.jsp").forward(request, response);

    } else {

        String username = request.getParameter("username");
        String password = request.getParameter("password");
        String fullname = request.getParameter("fullname");
        String phone = request.getParameter("phone");
        String email = request.getParameter("email");

        AccountDAO dao = new AccountDAO();

        // check username
        if (dao.checkUsernameExist(username)) {

            request.setAttribute("error", "Username already exists");
            request.getRequestDispatcher("/view/register.jsp").forward(request, response);
            return;

        }

        // password validation
        if (password.length() < 6 || 
            !password.matches(".*[a-zA-Z].*") || 
            !password.matches(".*[0-9].*")) {

            request.setAttribute("error", "Password must be at least 6 characters and contain letters and numbers");

            request.getRequestDispatcher("/view/register.jsp").forward(request, response);
            return;
        }

        // generate OTP
        String otp = OTPUtil.generateOTP();

        // save data to session
        HttpSession session = request.getSession();

        session.setAttribute("otp", otp);
        session.setAttribute("reg_username", username);
        session.setAttribute("reg_password", password);
        session.setAttribute("reg_fullname", fullname);
        session.setAttribute("reg_phone", phone);
        session.setAttribute("reg_email", email);

        // send OTP
        EmailUtil.sendOTP(email, otp);

        response.sendRedirect(request.getContextPath() + "/verifyOTP");
    }
}

        // LOGOUT
        if (path.equals("/logout")) {

            request.getSession().invalidate();

            response.sendRedirect(request.getContextPath() + "/login");

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

        // processRequest(req, resp);
        


    }
}
