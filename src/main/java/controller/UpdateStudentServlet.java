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
@WebServlet("/updateStudent")
public class UpdateStudentServlet extends HttpServlet {

    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws IOException {


        Student student = new Student();

        student.setStudentId(Integer.parseInt(request.getParameter("studentId")));

        student.setFirstName(request.getParameter("firstName"));

        student.setLastName(request.getParameter("lastName"));

        student.setEmail(request.getParameter("email"));

        student.setPhone(request.getParameter("phone"));

        student.setGender(request.getParameter("gender"));

        student.setCourse(request.getParameter("course"));

        student.setAddress(request.getParameter("address"));

        Part filePart = null;
        try {
            filePart = request.getPart("photo");
            String fileName = filePart.getSubmittedFileName();

            String oldphoto = request.getParameter("oldPhoto");

            String uploadpath = getServletContext().getRealPath("") + "images";

            File uploadDir = new File(uploadpath);

            if (!uploadDir.exists()) {
                uploadDir.mkdir();
            }

            if (fileName != null && !fileName.isEmpty()) {
                filePart.write(uploadpath + File.separator + fileName);

                student.setPhoto(fileName);
            } else {
                student.setPhoto(oldphoto);
            }


        } catch (ServletException e) {

            System.out.println("file not found");

        }


        StudentDAOImpl dao = new StudentDAOImpl();

        dao.updateStudent(student);

        response.sendRedirect(request.getContextPath() + "/viewStudents");
    }
}