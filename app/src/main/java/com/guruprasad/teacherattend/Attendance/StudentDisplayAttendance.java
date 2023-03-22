package com.guruprasad.teacherattend.Attendance;

import static com.guruprasad.teacherattend.Constants.info_toast;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.content.Intent;
import android.os.Bundle;

import com.firebase.ui.database.FirebaseRecyclerOptions;
import com.google.firebase.database.FirebaseDatabase;
import com.guruprasad.teacherattend.R;
import com.guruprasad.teacherattend.adapter.AttendanceRecordAdapter;
import com.guruprasad.teacherattend.adapter.lab_manual_adapter;
import com.guruprasad.teacherattend.model.combine_model;
import com.guruprasad.teacherattend.submission.lab_manual_submission_activity;

public class StudentDisplayAttendance extends AppCompatActivity {
    AttendanceRecordAdapter adapter ;
    RecyclerView recyclerView ;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_student_display_attendance);

        recyclerView = findViewById(R.id.show_student_rec);

        Intent intent = getIntent();
        String Year = intent.getStringExtra("sub_year");
        String division = intent.getStringExtra("sub_div");
        String department = intent.getStringExtra("sub_department");


        FirebaseRecyclerOptions<combine_model> options = new FirebaseRecyclerOptions.Builder<combine_model>().setQuery(FirebaseDatabase.getInstance().
                getReference("Students").child(department).child(Year).child(division), combine_model.class).build();
        adapter = new AttendanceRecordAdapter(options);
        adapter.startListening();
        recyclerView.setAdapter(adapter);
        info_toast(getApplicationContext(),"Please Wait Fetching the data");

        recyclerView.setLayoutManager(new LinearLayoutManager(StudentDisplayAttendance.this));
    }

    @Override
    public void onBackPressed() {
        super.onBackPressed();
    }
}