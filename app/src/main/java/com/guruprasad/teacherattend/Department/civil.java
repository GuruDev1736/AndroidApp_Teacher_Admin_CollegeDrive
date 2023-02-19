package com.guruprasad.teacherattend.Department;



import static com.guruprasad.teacherattend.Constants.error_toast;

import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.Spinner;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import com.firebase.ui.database.FirebaseRecyclerOptions;
import com.google.firebase.database.FirebaseDatabase;
import com.guruprasad.teacherattend.R;
import com.guruprasad.teacherattend.adapter.student_adapter;
import com.guruprasad.teacherattend.model.student_model;

public class civil extends AppCompatActivity implements AdapterView.OnItemSelectedListener {
    student_adapter adapter ;
    Spinner spinner ;
    RecyclerView recyclerView ;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_civil);

        spinner = findViewById(R.id.civil_spinner);
        recyclerView = findViewById(R.id.civil_rec);

        ArrayAdapter<CharSequence> adapter = ArrayAdapter.createFromResource(this, R.array.choice, android.R.layout.simple_spinner_item);
        adapter.setDropDownViewResource(androidx.transition.R.layout.support_simple_spinner_dropdown_item);
        spinner.setAdapter(adapter);
        spinner.setOnItemSelectedListener(this);



    }

    @Override
    public void onItemSelected(AdapterView<?> adapterView, View view, int i, long l) {
        String choice = spinner.getSelectedItem().toString();

        switch (choice)
        {
            case "Teacher":
                recyclerView.setLayoutManager(new LinearLayoutManager(civil.this));
                FirebaseRecyclerOptions<student_model> options = new FirebaseRecyclerOptions.Builder<student_model>().setQuery(FirebaseDatabase.getInstance().
                        getReference("Teachers").child("Civil"), student_model.class).build();

                adapter = new student_adapter(options);
                adapter.startListening();
                recyclerView.setAdapter(adapter);
                break;

            case "Student" :

                break;
            default:
                error_toast(civil.this,"Invalid Input");
        }
    }

    @Override
    public void onNothingSelected(AdapterView<?> adapterView) {

    }
}