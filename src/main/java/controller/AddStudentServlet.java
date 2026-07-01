package controller;

import daoImpl.StudentDAOImpl;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.MultipartConfig;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.*;
import model.Student;

import java.io.File;
import java.io.IOException;

@MultipartConfig
@WebServlet("/addStudent")
public class AddStudentServlet extends HttpServlet {


    protected void doPost(HttpServletRequest request,
                          HttpServletResponse response)
            throws ServletException, IOException {

        HttpSession session = request.getSession(false);

        if (session == null || session.getAttribute("admin") == null) {

            response.sendRedirect(request.getContextPath() + "/jsp/login.jsp");
            return;
        }


        //receives uploaded image from form
        Part filePart = request.getPart("photo");

        //	Gets the file name (e.g., profile.jpg).
        String fileName = filePart.getSubmittedFileName();

        //	Finds the physical path of the images folder.
        String uploadPath = getServletContext().getRealPath("") + "images";

        //Creates a File object pointing to the images folder
        File uploadDir = new File(uploadPath);

        //Creates the folder if it doesn't exist.
        if (!uploadDir.exists()) {
            uploadDir.mkdir();
        }

        //Saves the image into the images folder.
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
        student.setPhoto(fileName); //•	Stores only the image filename in PostgreSQL. 

        StudentDAOImpl dao = new StudentDAOImpl();

        if (dao.addStudent(student)) {

            response.sendRedirect(request.getContextPath() + "/viewStudents");

        } else {

            response.getWriter().println("Student Save Failed");
        }
    }


}
