package com.guruprasad.teacherattend.model;

public class workbook_model {

    String name , department , year , division , assignment_1 , assignment_2
            , assignment_3 , assignment_4 , assignment_5
            ,assignment_6 ;

    public workbook_model(String name, String department, String year, String division, String assignment_1, String assignment_2, String assignment_3, String assignment_4, String assignment_5, String assignment_6) {
        this.name = name;
        this.department = department;
        this.year = year;
        this.division = division;
        this.assignment_1 = assignment_1;
        this.assignment_2 = assignment_2;
        this.assignment_3 = assignment_3;
        this.assignment_4 = assignment_4;
        this.assignment_5 = assignment_5;
        this.assignment_6 = assignment_6;
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

    public String getAssignment_1() {
        return assignment_1;
    }

    public void setAssignment_1(String assignment_1) {
        this.assignment_1 = assignment_1;
    }

    public String getAssignment_2() {
        return assignment_2;
    }

    public void setAssignment_2(String assignment_2) {
        this.assignment_2 = assignment_2;
    }

    public String getAssignment_3() {
        return assignment_3;
    }

    public void setAssignment_3(String assignment_3) {
        this.assignment_3 = assignment_3;
    }

    public String getAssignment_4() {
        return assignment_4;
    }

    public void setAssignment_4(String assignment_4) {
        this.assignment_4 = assignment_4;
    }

    public String getAssignment_5() {
        return assignment_5;
    }

    public void setAssignment_5(String assignment_5) {
        this.assignment_5 = assignment_5;
    }

    public String getAssignment_6() {
        return assignment_6;
    }

    public void setAssignment_6(String assignment_6) {
        this.assignment_6 = assignment_6;
    }
}
