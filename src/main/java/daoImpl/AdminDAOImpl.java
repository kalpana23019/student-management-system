package daoImpl;

import DAO.AdminDAO;
import model.Admin;
import util.DBConnection;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

public class AdminDAOImpl implements AdminDAO {
    @Override
    public Admin login(String email, String password) {
        Admin admin = null;

        Connection con = DBConnection.getConnection();

        try {

            PreparedStatement ps = con.prepareStatement(
                    "SELECT * FROM admin WHERE email=? AND password=?");


            ps.setString(1, email);
            ps.setString(2, password);

            ResultSet rs = ps.executeQuery();

            if (rs.next()) {

                admin = new Admin();

                admin.setId(rs.getInt("id"));
                admin.setName(rs.getString("name"));
                admin.setEmail(rs.getString("email"));
                admin.setPassword(rs.getString("password"));
            }

        } catch (SQLException e) {
            throw new RuntimeException(e);
        }

        return admin;
    }

}
