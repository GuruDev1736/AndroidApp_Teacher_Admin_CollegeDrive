package com.guruprasad.teacherattend.model;

public class attendance_model {

    String name , department ,phone_no , division , year , attendance , date , id ;

    public attendance_model(String name, String department, String phone_no, String division, String year, String attendance, String date , String id) {
        this.name = name;
        this.department = department;
        this.phone_no = phone_no;
        this.division = division;
        this.year = year;
        this.id = id;
        this.attendance = attendance;
        this.date = date;
    }

    public attendance_model() {
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getDepartment() {
        return department;
    }

    public void setDepartment(String department) {
        this.department = department;
    }

    public String getPhone_no() {
        return phone_no;
    }

    public void setPhone_no(String phone_no) {
        this.phone_no = phone_no;
    }

    public String getDivision() {
        return division;
    }

    public void setDivision(String division) {
        this.division = division;
    }

    public String getYear() {
        return year;
    }

    public void setYear(String year) {
        this.year = year;
    }

    public String getAttendance() {
        return attendance;
    }

    public void setAttendance(String attendance) {
        this.attendance = attendance;
    }

    public String getDate() {
        return date;
    }

    public void setDate(String date) {
        this.date = date;
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }
}
