package com.guruprasad.teacherattend;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.widget.TextView;

public class student_profile extends AppCompatActivity {
    TextView name , department , email ,password , phone ,year , div ;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_student_profile);

        name = findViewById(R.id.t_name);
        department = findViewById(R.id.t_department);
        email = findViewById(R.id.t_email);
        password = findViewById(R.id.t_password);
        phone = findViewById(R.id.t_phone);
        year = findViewById(R.id.t_year);
        div = findViewById(R.id.t_div);

        Intent intent = getIntent();
        String t_name  = intent.getStringExtra("name");
        String t_department  = intent.getStringExtra("department");
        String t_year  = intent.getStringExtra("year");
        String t_phone  = intent.getStringExtra("stud_no");
        String t_email  = intent.getStringExtra("email");
        String t_password  = intent.getStringExtra("parent_no");
        String t_div  = intent.getStringExtra("div");

        name.setText(t_name);
        department.setText(t_department);
        email.setText(t_email);
        password.setText(t_password);
        phone.setText(t_phone);
        year.setText(t_year);
        div.setText(t_div);

    }
}