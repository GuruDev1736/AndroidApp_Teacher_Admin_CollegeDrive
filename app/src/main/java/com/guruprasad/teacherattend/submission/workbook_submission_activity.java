package com.guruprasad.teacherattend.submission;

import static com.guruprasad.teacherattend.Constants.info_toast;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.view.WindowManager;
import android.widget.Button;

import com.firebase.ui.database.FirebaseRecyclerOptions;
import com.google.firebase.database.FirebaseDatabase;
import com.guruprasad.teacherattend.Department.computer;
import com.guruprasad.teacherattend.R;
import com.guruprasad.teacherattend.adapter.student_adapter;
import com.guruprasad.teacherattend.adapter.workbook_adapter;
import com.guruprasad.teacherattend.model.combine_model;
import com.guruprasad.teacherattend.model.student_model;

import java.util.Objects;

public class workbook_submission_activity extends AppCompatActivity {

    workbook_adapter adapter ;
    RecyclerView recyclerView ;

        @Override
        protected void onCreate(Bundle savedInstanceState) {
            super.onCreate(savedInstanceState);
            setContentView(R.layout.activity_workbook_submission);
            Objects.requireNonNull(getSupportActionBar()).setTitle("Students");
            getWindow().setFlags(WindowManager.LayoutParams.FLAG_FULLSCREEN,WindowManager.LayoutParams.FLAG_FULLSCREEN);
            getSupportActionBar().setDisplayHomeAsUpEnabled(true);
            getSupportActionBar().setDisplayShowHomeEnabled(true);

            recyclerView = findViewById(R.id.workbook_rec);

            Intent intent = getIntent();
            String Year = intent.getStringExtra("sub_year");
            String division = intent.getStringExtra("sub_div");
            String department = intent.getStringExtra("sub_department");
            String subject= intent.getStringExtra("sub_subject");

            FirebaseRecyclerOptions<combine_model> options = new FirebaseRecyclerOptions.Builder<combine_model>().setQuery(FirebaseDatabase.getInstance().
                    getReference("Students").child(department).child(Year).child(division), combine_model.class).build();
            adapter = new workbook_adapter(options ,subject);
            adapter.startListening();
            recyclerView.setAdapter(adapter);
            info_toast(getApplicationContext(),"Please Wait Fetching the data");

            recyclerView.setLayoutManager(new LinearLayoutManager(workbook_submission_activity.this));
        }

    @Override
    public void onBackPressed() {
        super.onBackPressed();
    }
}