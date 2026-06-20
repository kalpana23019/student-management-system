package daoImpl;

import DAO.StudentDAO;
import model.Student;
import util.DBConnection;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class StudentDAOImpl implements StudentDAO {
    //add student
    @Override
    public boolean addStudent(Student student) {

        Connection con = DBConnection.getConnetion();
        try {
            PreparedStatement ps = con.prepareStatement("insert into students (first_name ,last_name,email,phone,gender,course,address,photo)" +
                    "values (?,?,?,?,?,?,?,?)");

            ps.setString(1, student.getFirstName());
            ps.setString(2, student.getLastName());
            ps.setString(3, student.getEmail());
            ps.setString(4, student.getPhone());
            ps.setString(5, student.getGender());
            ps.setString(6, student.getCourse());
            ps.setString(7, student.getAddress());
            ps.setString(8, student.getPhoto());

            int rows = ps.executeUpdate();

            if (rows > 0) {
                return true;
            }


        } catch (SQLException ex) {
            throw new RuntimeException(ex);
        }

        return false;
    }

    //get all student
    @Override
    public List<Student> getAllStudent() {

        List<Student> students = new ArrayList<>();

        Connection con = DBConnection.getConnetion();
        try {
            PreparedStatement ps = con.prepareStatement("Select * from students order by student_id");
            ResultSet rs = ps.executeQuery();

            while (rs.next()) {
                Student student = new Student();

                student.setStudentId(rs.getInt("student_id"));
                student.setFirstName(rs.getString("first_name"));
                student.setLastName(rs.getString("last_name"));
                student.setEmail(rs.getString("email"));
                student.setPhone(rs.getString("phone"));
                student.setGender(rs.getString("gender"));
                student.setCourse(rs.getString("course"));
                student.setAddress(rs.getString("address"));
                student.setPhoto(rs.getString("photo"));

                students.add(student);

            }
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
        return students;
    }


    //get student by its id
    @Override
    public Student getStudentByID(int id) {

        Student student = null;

        Connection con = DBConnection.getConnetion();
        try {
            PreparedStatement ps = con.prepareStatement("select * from students where student_id=?");
            ps.setInt(1, id);
            ResultSet rs = ps.executeQuery();

            if (rs.next()) {
                student = new Student();

                student.setStudentId(rs.getInt("student_id"));
                student.setFirstName(rs.getString("first_name"));
                student.setLastName(rs.getString("last_name"));
                student.setEmail(rs.getString("email"));
                student.setPhone(rs.getString("phone"));
                student.setGender(rs.getString("gender"));
                student.setCourse(rs.getString("course"));
                student.setAddress(rs.getString("address"));
                student.setPhoto(rs.getString("photo"));

            }
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }


        return student;
    }

    //update student
    @Override
    public boolean updateStudent(Student student) {

        Connection con = DBConnection.getConnetion();
        try {
            PreparedStatement ps = con.prepareStatement(" UPDATE students  SET first_name=?,last_name=? ,email=? ," +
                    " phone=?,gender=?,course=?," +
                    "address=?,photo=? where student_id=?");


            ps.setString(1, student.getFirstName());
            ps.setString(2, student.getLastName());
            ps.setString(3, student.getEmail());
            ps.setString(4, student.getPhone());
            ps.setString(5, student.getGender());
            ps.setString(6, student.getCourse());
            ps.setString(7, student.getAddress());
            ps.setString(8, student.getPhoto());
            ps.setInt(9, student.getStudentId());

            int rows = ps.executeUpdate();
            if (rows > 0) {
                return true;
            }
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }


        return false;
    }

    //delete student by id
    @Override
    public boolean deleteStudent(int id) {

        Connection con = DBConnection.getConnetion();
        try {
            PreparedStatement ps = con.prepareStatement("delete from students where student_id=?");
            ps.setInt(1, id);

            int rows = ps.executeUpdate();

            if (rows > 0) {
                return true;
            }


        } catch (SQLException e) {
            throw new RuntimeException(e);
        }

        return false;
    }

    @Override
    public List<Student> searchStudent(String keyword) {

        List<Student> students = new ArrayList<>();

        Connection con = DBConnection.getConnetion();
        try {
            PreparedStatement ps = con.prepareStatement("select * from students " +
                    "where first_name ILIKE ? or last_name ILIKE ?" +
                    " or course ILIKE ?");

            String search = "%" + keyword + "%";

            ps.setString(1, search);
            ps.setString(2, search);
            ps.setString(3, search);

            ResultSet rs = ps.executeQuery();

            while (rs.next()) {
                Student student = new Student();

                student.setStudentId(rs.getInt("student_id"));
                student.setFirstName(rs.getString("first_name"));
                student.setLastName(rs.getString("last_name"));
                student.setEmail(rs.getString("email"));
                student.setPhone(rs.getString("phone"));
                student.setGender(rs.getString("gender"));
                student.setCourse(rs.getString("course"));
                student.setAddress(rs.getString("address"));
                student.setPhoto(rs.getString("photo"));

                students.add(student);

            }

        } catch (SQLException e) {
            throw new RuntimeException(e);
        }


        return students;
    }


}
