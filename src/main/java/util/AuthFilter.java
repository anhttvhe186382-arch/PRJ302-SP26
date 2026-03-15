 
package util;

import jakarta.servlet.*;
import jakarta.servlet.annotation.WebFilter;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import jakarta.servlet.http.HttpSession;
import java.io.IOException;

@WebFilter("/*")
public class AuthFilter implements Filter {

    @Override
    public void doFilter(ServletRequest request, ServletResponse response, FilterChain chain)
            throws IOException, ServletException {

        HttpServletRequest req = (HttpServletRequest) request;
        HttpServletResponse res = (HttpServletResponse) response;

        HttpSession session = req.getSession(false);

        String uri = req.getRequestURI();

        boolean loggedIn = (session != null && session.getAttribute("account") != null);

        boolean publicPage =
                uri.contains("login") ||
                uri.contains("register") ||
                uri.contains("static");

        if (loggedIn || publicPage) {

            chain.doFilter(request, response);

        } else {

            res.sendRedirect(req.getContextPath() + "/login");

        }
    }

}