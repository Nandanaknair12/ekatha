package com.example.ekathapro;

public class AttendanceClass {

    String Date;
    Boolean present;

    public AttendanceClass() {
    }

    public AttendanceClass(String date, Boolean present) {
        Date = date;
        this.present = present;
    }

    public String getDate() {
        return Date;
    }

    public void setDate(String date) {
        Date = date;
    }

    public Boolean getPresent() {
        return present;
    }

    public void setPresent(Boolean present) {
        this.present = present;
    }
}
