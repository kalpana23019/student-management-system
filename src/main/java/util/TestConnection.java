package util;

import java.sql.Connection;

public class TestConnection {
    public static void main(String[] args) {

        Connection con =DBConnection.getConnetion();

        if(con !=null){
            System.out.println("connected");
        }else {
            System.out.println("not Connected");
        }
    }
}
