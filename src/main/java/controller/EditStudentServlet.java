package controller;

import daoImpl.StudentDAOImpl;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.*;

import model.Student;

import java.io.IOException;

@WebServlet("/editStudent")
public class EditStudentServlet extends HttpServlet {

    protected void doGet(HttpServletRequest request,
                         HttpServletResponse response)
            throws ServletException, IOException {

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
                .forward(request,response);
    }
}
