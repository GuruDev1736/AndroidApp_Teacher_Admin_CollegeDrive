package com.guruprasad.teacherattend.submission;

import static com.guruprasad.teacherattend.Constants.info_toast;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.content.Intent;
import android.os.Bundle;
import android.view.WindowManager;

import com.firebase.ui.database.FirebaseRecyclerOptions;
import com.google.firebase.database.FirebaseDatabase;
import com.guruprasad.teacherattend.R;
import com.guruprasad.teacherattend.adapter.assignment_adapter;
import com.guruprasad.teacherattend.adapter.workbook_adapter;
import com.guruprasad.teacherattend.model.combine_model;

import java.util.Objects;

public class assignment_submission_activity extends AppCompatActivity {

    assignment_adapter adapter ;
    RecyclerView recyclerView ;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_assignment_submission);
        Objects.requireNonNull(getSupportActionBar()).setTitle("Students");
        getWindow().setFlags(WindowManager.LayoutParams.FLAG_FULLSCREEN,WindowManager.LayoutParams.FLAG_FULLSCREEN);
        getSupportActionBar().setDisplayHomeAsUpEnabled(true);
        getSupportActionBar().setDisplayShowHomeEnabled(true);

        recyclerView = findViewById(R.id.assignment_rec);

        Intent intent = getIntent();
        String Year = intent.getStringExtra("sub_year");
        String division = intent.getStringExtra("sub_div");
        String department = intent.getStringExtra("sub_department");
        String subject= intent.getStringExtra("sub_subject");

        FirebaseRecyclerOptions<combine_model> options = new FirebaseRecyclerOptions.Builder<combine_model>().setQuery(FirebaseDatabase.getInstance().
                getReference("Students").child(department).child(Year).child(division), combine_model.class).build();
        adapter = new assignment_adapter(options ,subject);
        adapter.startListening();
        recyclerView.setAdapter(adapter);
        info_toast(getApplicationContext(),"Please Wait Fetching the data");

        recyclerView.setLayoutManager(new LinearLayoutManager(assignment_submission_activity.this));
    }

    @Override
    public void onBackPressed() {
        super.onBackPressed();
    }
}