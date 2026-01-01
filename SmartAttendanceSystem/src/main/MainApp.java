package main;

import dao.AttendanceDAO;
import model.Attendance;

import java.time.LocalDate;
import java.util.Scanner;

public class MainApp {

    public static void main(String[] args) {

        AttendanceDAO dao = new AttendanceDAO();
        Scanner sc = new Scanner(System.in);

        while (true) {
            System.out.println("\n=== Smart Attendance System ===");
            System.out.println("1. Mark Attendance");
            System.out.println("2. View Attendance");
            System.out.println("3. Exit");
            System.out.print("Enter choice: ");

            int choice = sc.nextInt();
            sc.nextLine();

            if (choice == 1) {
                System.out.print("Enter Student Name: ");
                String name = sc.nextLine();

                System.out.print("Status (Present/Absent): ");
                String status = sc.nextLine();

                System.out.print("Feedback Emoji (😊 😐 😞): ");
                String feedback = sc.nextLine();

                Attendance a = new Attendance(
                        name,
                        LocalDate.now(),
                        status,
                        feedback
                );

                dao.addAttendance(a);

            } else if (choice == 2) {
                dao.viewAttendance();

            } else if (choice == 3) {
                System.out.println("Thank you!");
                break;

            } else {
                System.out.println("Invalid choice!");
            }
        }
        sc.close();
    }
}
