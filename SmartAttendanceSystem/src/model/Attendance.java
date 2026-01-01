package model;

import java.time.LocalDate;

public class Attendance {
    private String name;
    private LocalDate date;
    private String status;
    private String feedback;

    public Attendance(String name, LocalDate date, String status, String feedback) {
        this.name = name;
        this.date = date;
        this.status = status;
        this.feedback = feedback;
    }

    public String getName() {
        return name;
    }

    public LocalDate getDate() {
        return date;
    }

    public String getStatus() {
        return status;
    }

    public String getFeedback() {
        return feedback;
    }
}
