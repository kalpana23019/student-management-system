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
import java.util.List;

@WebServlet("/viewStudents")
public class ViewStudentServlet extends HttpServlet {

    protected void doGet(HttpServletRequest request,
                         HttpServletResponse response)
            throws ServletException, IOException {

        HttpSession session = request.getSession(false);

        if (session == null || session.getAttribute("admin") == null) {

            response.sendRedirect(request.getContextPath() + "/jsp/login.jsp");
            return;
        }


        //Current page
        int page = 1;
        //students per page
        int recordPerPage = 5;

        //if user click page 2 0r 3
        if (request.getParameter("page") != null) {

            page = Integer.parseInt(request.getParameter("page"));
        }

        //calculate starting row
        int offset = (page - 1) * recordPerPage;


        StudentDAOImpl dao = new StudentDAOImpl();

        //get student for current page
        List<Student> students = dao.getStudentByPage(offset, recordPerPage);

        //total student for current page
        int totalStudent = dao.getStudentCount();

        //total pages
        int totalPages = (int) Math.ceil((double) totalStudent / recordPerPage);

        request.setAttribute("students", students);
        request.setAttribute("currentPage", page);
        request.setAttribute("totalPages", totalPages);

        request.getRequestDispatcher("/jsp/viewStudents.jsp")
                .forward(request, response);
    }
}