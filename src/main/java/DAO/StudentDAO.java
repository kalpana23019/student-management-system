package DAO;

import model.Student;

import java.util.List;

public interface StudentDAO { // what to do


    boolean addStudent(Student student);

    List<Student> getAllStudent();

    Student getStudentByID(int id);

    boolean updateStudent(Student student);

    boolean deleteStudent(int id);

    List<Student> searchStudent(String keyword);
}
