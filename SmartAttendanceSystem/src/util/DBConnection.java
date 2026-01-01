package util;

import java.sql.Connection;
import java.sql.DriverManager;

public class DBConnection {

    public static Connection getConnection() throws Exception {
    	
        String url = "jdbc:mysql://localhost:3306/attendance_db";
        String user = "root";
        String password = "Coolie@123"; 

        return DriverManager.getConnection(url, user, password);
    }
}