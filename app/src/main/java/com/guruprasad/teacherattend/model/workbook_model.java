package com.guruprasad.teacherattend.model;

public class workbook_model {

    String name , department , year , division , assignment ;
    Boolean status ;

    public workbook_model(String name, String department, String year, String division, String assignment , Boolean status ) {
        this.name = name;
        this.department = department;
        this.year = year;
        this.division = division;
        this.assignment = assignment;
        this.status = status;
    }

    public workbook_model() {
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

    public String getYear() {
        return year;
    }

    public void setYear(String year) {
        this.year = year;
    }

    public String getDivision() {
        return division;
    }

    public void setDivision(String division) {
        this.division = division;
    }

    public String getAssignment() {
        return assignment;
    }

    public void setAssignment(String assignment) {
        this.assignment = assignment;
    }

    public Boolean getStatus() {
        return status;
    }

    public void setStatus(Boolean status) {
        this.status = status;
    }
}
