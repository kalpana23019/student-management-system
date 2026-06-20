package controller;

import daoImpl.StudentDAOImpl;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.*;

import model.Student;

import java.io.IOException;
import java.util.List;

@WebServlet("/searchStudent")
public class SearchStudentServlet extends HttpServlet {

    protected void doGet(HttpServletRequest request,
                         HttpServletResponse response)
            throws ServletException, IOException {

        String keyword =
                request.getParameter("keyword");

        StudentDAOImpl dao =
                new StudentDAOImpl();

        List<Student> students =
                dao.searchStudent(keyword);

        request.setAttribute(
                "students",
                students
        );

        request.getRequestDispatcher(
                "/jsp/viewStudents.jsp"
        ).forward(request,response);
    }
}