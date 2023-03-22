package com.guruprasad.teacherattend.model;

public class view_micro_project_model {

    String micro_project_name , micro_project_marks , status ;

    public view_micro_project_model(String micro_project_name, String micro_project_marks, String status) {
        this.micro_project_name = micro_project_name;
        this.micro_project_marks = micro_project_marks;
        this.status = status;
    }

    public view_micro_project_model() {
    }

    public String getMicro_project_name() {
        return micro_project_name;
    }

    public void setMicro_project_name(String micro_project_name) {
        this.micro_project_name = micro_project_name;
    }

    public String getMicro_project_marks() {
        return micro_project_marks;
    }

    public void setMicro_project_marks(String micro_project_marks) {
        this.micro_project_marks = micro_project_marks;
    }

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }
}
