package DAO;

import model.Admin;

public interface AdminDAO {

    Admin login(String email, String password);

}