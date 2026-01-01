package dao;

import model.Attendance;
import util.DBConnection;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.Statement;

public class AttendanceDAO {

    public void addAttendance(Attendance a) {
        try {
            Connection con = DBConnection.getConnection();
            String sql = "INSERT INTO attendance(name, date, status, feedback) VALUES (?,?,?,?)";
            PreparedStatement ps = con.prepareStatement(sql);
            ps.setString(1, a.getName());
            ps.setDate(2, java.sql.Date.valueOf(a.getDate()));
            ps.setString(3, a.getStatus());
            ps.setString(4, a.getFeedback());
            ps.executeUpdate();
            System.out.println("Attendance added successfully!");
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public void viewAttendance() {
        try {
            Connection con = DBConnection.getConnection();
            Statement st = con.createStatement();
            ResultSet rs = st.executeQuery("SELECT * FROM attendance");

            System.out.println("\n--- Attendance Records ---");
            while (rs.next()) {
                System.out.println(
                        rs.getInt("id") + " | " +
                        rs.getString("name") + " | " +
                        rs.getDate("date") + " | " +
                        rs.getString("status") + " | " +
                        rs.getString("feedback")
                );
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
