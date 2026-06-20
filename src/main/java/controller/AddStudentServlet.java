package controller;

import daoImpl.StudentDAOImpl;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.MultipartConfig;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import jakarta.servlet.http.Part;
import model.Student;

import java.io.File;
import java.io.IOException;

@MultipartConfig
@WebServlet("/addStudent")
public class AddStudentServlet extends HttpServlet {


    protected void doPost(HttpServletRequest request,
                          HttpServletResponse response)
            throws ServletException, IOException {

        //read uploaded file
        Part filePart = request.getPart("photo");

        String fileName = filePart.getSubmittedFileName();

        String uploadPath = getServletContext().getRealPath("") + "images";

        //save image
        File uploadDir = new File(uploadPath);

        if (!uploadDir.exists()) {
            uploadDir.mkdir();
        }

        filePart.write(uploadPath + File.separator + fileName);


        String firstName = request.getParameter("firstName");
        String lastName = request.getParameter("lastName");
        String email = request.getParameter("email");
        String phone = request.getParameter("phone");
        String gender = request.getParameter("gender");
        String course = request.getParameter("course");
        String address = request.getParameter("address");


        Student student = new Student();

        student.setFirstName(firstName);
        student.setLastName(lastName);
        student.setEmail(email);
        student.setPhone(phone);
        student.setGender(gender);
        student.setCourse(course);
        student.setAddress(address);
        student.setPhoto(fileName);

        StudentDAOImpl dao = new StudentDAOImpl();

        if (dao.addStudent(student)) {

            response.sendRedirect(request.getContextPath() + "/viewStudents");

        } else {

            response.getWriter().println("Student Save Failed");
        }
    }


}
