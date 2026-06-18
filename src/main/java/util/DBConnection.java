package util;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class DBConnection {


    public static Connection getConnetion(){

        try {
            Class.forName("org.postgresql.Driver");
           Connection con = DriverManager.getConnection("jdbc:postgresql://localhost:5432/student_db","postgres","12345");

            return con;
        } catch (ClassNotFoundException |SQLException e) {
            throw new RuntimeException(e);
        }

    }
}