package controller;

import daoImpl.StudentDAOImpl;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import jakarta.servlet.http.HttpSession;
import model.Student;

import java.io.IOException;

@WebServlet("/editStudent")
public class EditStudentServlet extends HttpServlet {

    protected void doGet(HttpServletRequest request,
                         HttpServletResponse response)
            throws ServletException, IOException {

        HttpSession session = request.getSession(false);

        if (session == null || session.getAttribute("admin") == null) {

            response.sendRedirect(request.getContextPath() + "/jsp/login.jsp");
            return;
        }

        int id =
                Integer.parseInt(
                        request.getParameter("id")
                );

        StudentDAOImpl dao =
                new StudentDAOImpl();

        Student student =
                dao.getStudentByID(id);

        request.setAttribute("student",
                student);

        request.getRequestDispatcher(
                        "/jsp/editStudent.jsp")
                .forward(request, response);
    }
}
