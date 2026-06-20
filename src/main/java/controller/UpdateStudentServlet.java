package controller;

import daoImpl.StudentDAOImpl;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import model.Student;

import java.io.IOException;

@WebServlet("/updateStudent")
public class UpdateStudentServlet extends HttpServlet {

    protected void doPost(HttpServletRequest request,
                          HttpServletResponse response)
            throws IOException {

        Student student = new Student();

        student.setStudentId(
                Integer.parseInt(
                        request.getParameter("studentId")));

        student.setFirstName(
                request.getParameter("firstName"));

        student.setLastName(
                request.getParameter("lastName"));

        student.setEmail(
                request.getParameter("email"));

        student.setPhone(
                request.getParameter("phone"));

        student.setGender(
                request.getParameter("gender"));

        student.setCourse(
                request.getParameter("course"));

        student.setAddress(
                request.getParameter("address"));


        StudentDAOImpl dao =
                new StudentDAOImpl();

        dao.updateStudent(student);

        response.sendRedirect(
                request.getContextPath()
                        + "/viewStudents");
    }
}