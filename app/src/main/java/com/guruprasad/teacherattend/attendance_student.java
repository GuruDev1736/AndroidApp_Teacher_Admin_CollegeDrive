package com.guruprasad.teacherattend;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.content.Intent;
import android.os.Bundle;
import android.widget.TextView;

import com.firebase.ui.database.FirebaseRecyclerOptions;
import com.google.firebase.database.FirebaseDatabase;
import com.guruprasad.teacherattend.Department.computer;
import com.guruprasad.teacherattend.adapter.attendance_adapter;
import com.guruprasad.teacherattend.adapter.student_adapter;
import com.guruprasad.teacherattend.model.student_model;

import org.w3c.dom.Text;

public class attendance_student extends AppCompatActivity {
        TextView date , year , division ;
        attendance_adapter adapter ;
        RecyclerView recyclerView ;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_attendance_student);

        date = findViewById(R.id.attendance_date);
        year = findViewById(R.id.attendance_year);
        division = findViewById(R.id.attendance_div);
        recyclerView = findViewById(R.id.attendance_rec);


        Intent intent = getIntent();

        date.setText(intent.getStringExtra("date"));
        year.setText(intent.getStringExtra("year"));
        division.setText(intent.getStringExtra("div"));

        recyclerView.setLayoutManager(new LinearLayoutManager(attendance_student.this));
        FirebaseRecyclerOptions<student_model> options = new FirebaseRecyclerOptions.Builder<student_model>().setQuery(FirebaseDatabase.getInstance().
                getReference("Students").child("Computer").child(year.getText().toString()).child(division.getText().toString()), student_model.class).build();
        adapter = new attendance_adapter(options);
        adapter.startListening();
        recyclerView.setAdapter(adapter);


    }
}