package controller;

import daoImpl.AdminDAOImpl;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import jakarta.servlet.http.HttpSession;
import model.Admin;

import java.io.IOException;

@WebServlet("/login")
public class LoginServlet extends HttpServlet {

    @Override
    protected void doPost(HttpServletRequest request,
                          HttpServletResponse response)
            throws ServletException, IOException {

        String email = request.getParameter("email");
        String password = request.getParameter("password");

        AdminDAOImpl dao = new AdminDAOImpl();

        Admin admin = dao.login(email, password);

        if (admin != null) {

            HttpSession session = request.getSession();

            session.setAttribute("admin", admin);

            response.sendRedirect(request.getContextPath() + "/jsp/dashboard.jsp");

        } else {

            request.setAttribute(
                    "error",
                    "Invalid Email or Password"
            );

            request.getRequestDispatcher("/jsp/login.jsp")
                    .forward(request, response);
        }

    }
}