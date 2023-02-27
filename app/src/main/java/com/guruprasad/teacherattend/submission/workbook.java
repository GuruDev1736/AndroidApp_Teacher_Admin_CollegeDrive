package com.guruprasad.teacherattend.submission;

import static com.guruprasad.teacherattend.Constants.error_toast;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.ImageButton;
import android.widget.Spinner;

import com.guruprasad.teacherattend.R;

public class workbook extends AppCompatActivity implements AdapterView.OnItemSelectedListener {
    Spinner year , division , subject , department ;
    ImageButton get_sub ;
    Button submit ;



    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_workbook);

        year = findViewById(R.id.spinner_attendance_year);
        division = findViewById(R.id.spinner_attendance_division);
        subject = findViewById(R.id.spinner_attendance_subject);
        department = findViewById(R.id.spinner_attendance_department);
        get_sub = findViewById(R.id.get_sub);
        submit = findViewById(R.id.submit_workbook);


        ArrayAdapter<CharSequence> adapter = ArrayAdapter.createFromResource(this, R.array.year, android.R.layout.simple_spinner_item);
        adapter.setDropDownViewResource(androidx.transition.R.layout.support_simple_spinner_dropdown_item);
        year.setAdapter(adapter);
        year.setOnItemSelectedListener(this);

        ArrayAdapter<CharSequence> adapter2 = ArrayAdapter.createFromResource(this, R.array.division, android.R.layout.simple_spinner_item);
        adapter2.setDropDownViewResource(androidx.transition.R.layout.support_simple_spinner_dropdown_item);
        division.setAdapter(adapter2);
        division.setOnItemSelectedListener(this);

        ArrayAdapter<CharSequence> dep = ArrayAdapter.createFromResource(this, R.array.department_type, android.R.layout.simple_spinner_item);
        dep.setDropDownViewResource(androidx.transition.R.layout.support_simple_spinner_dropdown_item);
        department.setAdapter(dep);
        department.setOnItemSelectedListener(this);




    }

    @Override
    public void onItemSelected(AdapterView<?> adapterView, View view, int i, long l) {

        get_sub.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                String depart = department.getSelectedItem().toString();

                if (depart.equals("Computer"))
                {
                    ArrayAdapter<CharSequence> sub = ArrayAdapter.createFromResource(view.getContext(), R.array.computer_subjects, android.R.layout.simple_spinner_item);
                    sub.setDropDownViewResource(androidx.transition.R.layout.support_simple_spinner_dropdown_item);
                    subject.setAdapter(sub);

                }
            }
        });

        submit.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                String sub_year = year.getSelectedItem().toString();
                String sub_div = division.getSelectedItem().toString();
                String sub_subject = subject.getSelectedItem().toString();
                String sub_department = department.getSelectedItem().toString();


                Intent intent = new Intent(getApplicationContext(),workbook_submission_activity.class);
                intent.putExtra("sub_year",sub_year);
                intent.putExtra("sub_div",sub_div);
                intent.putExtra("sub_subject",sub_subject);
                intent.putExtra("sub_department",sub_department);
                startActivity(intent);
            }
        });




    }

    @Override
    public void onNothingSelected(AdapterView<?> adapterView) {

    }

    @Override
    public void onBackPressed() {
        super.onBackPressed();
    }
}