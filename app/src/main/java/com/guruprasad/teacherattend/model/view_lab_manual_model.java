package com.guruprasad.teacherattend.model;

public class view_lab_manual_model {

    String lab_manual_name , lab_manual_marks , status ;

    public view_lab_manual_model(String lab_manual_name, String lab_manual_marks, String status) {
        this.lab_manual_name = lab_manual_name;
        this.lab_manual_marks = lab_manual_marks;
        this.status = status;
    }

    public view_lab_manual_model() {
    }

    public String getLab_manual_name() {
        return lab_manual_name;
    }

    public void setLab_manual_name(String lab_manual_name) {
        this.lab_manual_name = lab_manual_name;
    }

    public String getLab_manual_marks() {
        return lab_manual_marks;
    }

    public void setLab_manual_marks(String lab_manual_marks) {
        this.lab_manual_marks = lab_manual_marks;
    }

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }
}
