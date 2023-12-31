package com.guruprasad.teacherattend.Department;



import static com.guruprasad.teacherattend.Constants.error_toast;
import static com.guruprasad.teacherattend.Constants.info_toast;

import android.os.Bundle;
import android.view.View;
import android.view.WindowManager;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.Spinner;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import com.firebase.ui.database.FirebaseRecyclerOptions;
import com.google.firebase.database.FirebaseDatabase;
import com.guruprasad.teacherattend.R;
import com.guruprasad.teacherattend.adapter.student_adapter;
import com.guruprasad.teacherattend.model.student_model;

import java.util.Objects;

public class civil extends AppCompatActivity implements AdapterView.OnItemSelectedListener {
    student_adapter adapter ;
    Spinner year , div ;
    RecyclerView recyclerView ;
    Button button ;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_civil);
        Objects.requireNonNull(getSupportActionBar()).setTitle("Civil Department ");
        getWindow().setFlags(WindowManager.LayoutParams.FLAG_FULLSCREEN,WindowManager.LayoutParams.FLAG_FULLSCREEN);
        getSupportActionBar().setDisplayHomeAsUpEnabled(true);
        getSupportActionBar().setDisplayShowHomeEnabled(true);

        year = findViewById(R.id.year_spinner);
        div = findViewById(R.id.div_spinner);
        recyclerView = findViewById(R.id.civil_rec);
        button = findViewById(R.id.submit);


        ArrayAdapter<CharSequence> adapter = ArrayAdapter.createFromResource(this, R.array.year, android.R.layout.simple_spinner_item);
        adapter.setDropDownViewResource(androidx.transition.R.layout.support_simple_spinner_dropdown_item);
        year.setAdapter(adapter);
        year.setOnItemSelectedListener(this);

        ArrayAdapter<CharSequence> adapter2 = ArrayAdapter.createFromResource(this, R.array.division, android.R.layout.simple_spinner_item);
        adapter2.setDropDownViewResource(androidx.transition.R.layout.support_simple_spinner_dropdown_item);
        div.setAdapter(adapter2);
        div.setOnItemSelectedListener(this);

        button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                display_student();
                info_toast(getApplicationContext(),"Please Wait Fetching the data");
            }
        });

        recyclerView.setLayoutManager(new LinearLayoutManager(civil.this));



    }

    @Override
    public void onItemSelected(AdapterView<?> adapterView, View view, int i, long l) {


    }

    @Override
    public void onNothingSelected(AdapterView<?> adapterView) {
        error_toast(getApplicationContext(),"Invalid Input");

    }

    @Override
    public void onBackPressed() {
        super.onBackPressed();
    }

    public void display_student()
    {

        String Year  =year.getSelectedItem().toString();
        String division = div.getSelectedItem().toString();

        FirebaseRecyclerOptions<student_model> options = new FirebaseRecyclerOptions.Builder<student_model>().setQuery(FirebaseDatabase.getInstance().
                getReference("Students").child("Civil").child(Year).child(division), student_model.class).build();
        adapter = new student_adapter(options);
        adapter.startListening();
        recyclerView.setAdapter(adapter);



    }
}