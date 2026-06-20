package controller;

import daoImpl.StudentDAOImpl;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import model.Student;

import java.io.IOException;
import java.util.List;

@WebServlet("/viewStudents")
public class ViewStudentServlet extends HttpServlet {

    protected void doGet(HttpServletRequest request,
                         HttpServletResponse response)
            throws ServletException, IOException {

        StudentDAOImpl dao = new StudentDAOImpl();


        List<Student> students = dao.getAllStudent();

        System.out.println("Students Count = " + students.size());

        request.setAttribute("students", students);

        request.getRequestDispatcher("/jsp/viewStudents.jsp")
                .forward(request, response);
    }
}