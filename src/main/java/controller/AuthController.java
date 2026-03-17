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

    }

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {

//        processRequest(req, resp);
        String path = request.getServletPath();

        if (path.equals("/login")) {

            if (request.getMethod().equalsIgnoreCase("GET")) {

                request.getRequestDispatcher("/view/login.jsp").forward(request, response);

            }
        }

        if (path.equals("/register")) {

            if (request.getMethod().equalsIgnoreCase("GET")) {

                request.getRequestDispatcher("/view/register.jsp").forward(request, response);

            }
        }
        // LOGOUT
        if (path.equals("/logout")) {

            request.getSession().invalidate();

            response.sendRedirect(request.getContextPath() + "/login");

        }

    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {

        // processRequest(req, resp);
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
                    
                    HttpSession session = request.getSession();
                    session.setAttribute("account", acc);
                    session.setMaxInactiveInterval(30 * 60);
                    // Thay vì: response.sendRedirect("/viewMotorbike");
                    response.sendRedirect(request.getContextPath() + "/viewMotorbike");

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
                String cccd = request.getParameter("cccd");
//                String email = request.getParameter("email");

                System.out.println("sau khi nhận parameter: " + phone);
                AccountDAO dao = new AccountDAO();

                // check username
                if (dao.checkUsernameExist(username)) {

                    request.setAttribute("error", "Username already exists");
                    request.getRequestDispatcher("/view/register.jsp").forward(request, response);
                    return;

                }

                // password validation
                if (password.length() < 6
                        || !password.matches(".*[a-zA-Z].*")
                        || !password.matches(".*[0-9].*")) {

                    request.setAttribute("error", "Password must be at least 6 characters and contain letters and numbers");

                    request.getRequestDispatcher("/view/register.jsp").forward(request, response);
                    return;
                }
                System.out.println("trước khi gọi dao " + phone);
                //luu data dang ki vao db
                boolean success = dao.register(username, password, fullname, phone, cccd);

                if (!success) {
                    request.setAttribute("error", "Register failed (phone or username may exist)");
                    request.getRequestDispatcher("/view/register.jsp").forward(request, response);
                    return;
                }

                // generate OTP
//                String otp = OTPUtil.generateOTP();
                // save data to session
                HttpSession session = request.getSession();

//                session.setAttribute("otp", otp);
                session.setAttribute("reg_username", username);
                session.setAttribute("reg_password", password);
                session.setAttribute("reg_fullname", fullname);
                session.setAttribute("reg_phone", phone);
//                session.setAttribute("reg_email", email);

                // send OTP
//                EmailUtil.sendOTP(email, otp);
//                response.sendRedirect(request.getContextPath() + "/verifyOTP");
                response.sendRedirect(
                        request.getContextPath() + "/login?username=" + username + "&password=" + password
                );
            }
        }

        // LOGOUT
        if (path.equals("/logout")) {

            request.getSession().invalidate();

            response.sendRedirect(request.getContextPath() + "/login");

        }

    }
}
