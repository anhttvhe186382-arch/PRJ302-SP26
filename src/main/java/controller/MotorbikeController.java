package controller;

import dao.MotorbikeDAO;
import model.Motorbike;

import jakarta.servlet.*;
import jakarta.servlet.http.*;
import java.io.IOException;
import java.util.List;

public class MotorbikeController extends HttpServlet {

    protected void processRequest(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {

        String path = request.getServletPath();
        MotorbikeDAO dao = new MotorbikeDAO();

        if (path.equals("/motorbikes")) {

            List<Motorbike> list = dao.getAllMotorbikes();

            request.setAttribute("motorbikes", list);
            request.getRequestDispatcher("view/motorbikes.jsp")
                    .forward(request, response);
        }

        if (path.equals("/motorbike-detail")) {

            int id = Integer.parseInt(request.getParameter("id"));

//            Motorbike m = dao.getMotorbikeById(id);

//            request.setAttribute("motorbike", m);
            request.getRequestDispatcher("view/motorbike-detail.jsp")
                    .forward(request, response);
        }

    }

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp)
            throws ServletException, IOException {
        processRequest(req, resp);
    }

}