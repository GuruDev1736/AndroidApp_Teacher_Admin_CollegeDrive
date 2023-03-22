package com.guruprasad.teacherattend.Attendance;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.Spinner;

import com.guruprasad.teacherattend.R;
import com.guruprasad.teacherattend.submission.lab_manual_submission_activity;

public class AttendanceRecord extends AppCompatActivity implements AdapterView.OnItemSelectedListener {
    Spinner y , division  , depart ;
    Button submit ;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_attendance_record);

        y = findViewById(R.id.spinner_attendance_year);
        division = findViewById(R.id.spinner_attendance_division);
        depart = findViewById(R.id.spinner_attendance_department);

        submit = findViewById(R.id.submit);

        ArrayAdapter<CharSequence> adapter = ArrayAdapter.createFromResource(this, R.array.year, android.R.layout.simple_spinner_item);
        adapter.setDropDownViewResource(androidx.transition.R.layout.support_simple_spinner_dropdown_item);
        y.setAdapter(adapter);
        y.setOnItemSelectedListener(this);

        ArrayAdapter<CharSequence> adapter2 = ArrayAdapter.createFromResource(this, R.array.division, android.R.layout.simple_spinner_item);
        adapter2.setDropDownViewResource(androidx.transition.R.layout.support_simple_spinner_dropdown_item);
        division.setAdapter(adapter2);
        division.setOnItemSelectedListener(this);

        ArrayAdapter<CharSequence> dep = ArrayAdapter.createFromResource(this, R.array.department_type, android.R.layout.simple_spinner_item);
        dep.setDropDownViewResource(androidx.transition.R.layout.support_simple_spinner_dropdown_item);
        depart.setAdapter(dep);
        depart.setOnItemSelectedListener(this);

        submit.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                String sub_year = y.getSelectedItem().toString();
                String sub_div = division.getSelectedItem().toString();
                String sub_department = depart.getSelectedItem().toString();


                Intent intent = new Intent(getApplicationContext(), StudentDisplayAttendance.class);
                intent.putExtra("sub_year",sub_year);
                intent.putExtra("sub_div",sub_div);
                intent.putExtra("sub_department",sub_department);
                startActivity(intent);
            }
        });


    }

    @Override
    public void onBackPressed() {
        super.onBackPressed();
    }

    @Override
    public void onItemSelected(AdapterView<?> adapterView, View view, int i, long l) {

    }

    @Override
    public void onNothingSelected(AdapterView<?> adapterView) {

    }
}