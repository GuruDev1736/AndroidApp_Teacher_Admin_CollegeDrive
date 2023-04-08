package com.guruprasad.teacherattend.model;

public class attendance_combine_model {

    String name , department ,phone_no , division , year , attendance , date , id ;
    String stud_name , parent_no , stud_no ,stud_email , stud_enroll;

    public attendance_combine_model(String name, String department, String phone_no, String division, String year, String attendance, String date, String id, String stud_name, String parent_no, String stud_no, String stud_email, String stud_enroll) {
        this.name = name;
        this.department = department;
        this.phone_no = phone_no;
        this.division = division;
        this.year = year;
        this.attendance = attendance;
        this.date = date;
        this.id = id;
        this.stud_name = stud_name;
        this.parent_no = parent_no;
        this.stud_no = stud_no;
        this.stud_email = stud_email;
        this.stud_enroll = stud_enroll;
    }

    public attendance_combine_model() {
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

    public String getStud_name() {
        return stud_name;
    }

    public void setStud_name(String stud_name) {
        this.stud_name = stud_name;
    }

    public String getParent_no() {
        return parent_no;
    }

    public void setParent_no(String parent_no) {
        this.parent_no = parent_no;
    }

    public String getStud_no() {
        return stud_no;
    }

    public void setStud_no(String stud_no) {
        this.stud_no = stud_no;
    }

    public String getStud_email() {
        return stud_email;
    }

    public void setStud_email(String stud_email) {
        this.stud_email = stud_email;
    }

    public String getStud_enroll() {
        return stud_enroll;
    }

    public void setStud_enroll(String stud_enroll) {
        this.stud_enroll = stud_enroll;
    }
}
