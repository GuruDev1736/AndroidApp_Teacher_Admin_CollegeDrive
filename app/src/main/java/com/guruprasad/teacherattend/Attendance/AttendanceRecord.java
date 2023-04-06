package com.guruprasad.teacherattend.Attendance;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.view.WindowManager;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.Spinner;

import com.guruprasad.teacherattend.R;
import com.guruprasad.teacherattend.databinding.ActivityAttendanceRecordBinding;
import com.guruprasad.teacherattend.submission.lab_manual_submission_activity;

import java.util.Objects;

public class AttendanceRecord extends AppCompatActivity implements AdapterView.OnItemSelectedListener {

    ActivityAttendanceRecordBinding binding ;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        binding = ActivityAttendanceRecordBinding.inflate(getLayoutInflater());
        setContentView(binding.getRoot());
        Objects.requireNonNull(getSupportActionBar()).setTitle("Student Attendance");
        getWindow().setFlags(WindowManager.LayoutParams.FLAG_FULLSCREEN,WindowManager.LayoutParams.FLAG_FULLSCREEN);
        getSupportActionBar().setDisplayHomeAsUpEnabled(true);
        getSupportActionBar().setDisplayShowHomeEnabled(true);


        ArrayAdapter<CharSequence> adapter = ArrayAdapter.createFromResource(this, R.array.year, android.R.layout.simple_spinner_item);
        adapter.setDropDownViewResource(androidx.transition.R.layout.support_simple_spinner_dropdown_item);
        binding.spinnerAttendanceYear.setAdapter(adapter);
        binding.spinnerAttendanceYear.setOnItemSelectedListener(this);

        ArrayAdapter<CharSequence> adapter2 = ArrayAdapter.createFromResource(this, R.array.division, android.R.layout.simple_spinner_item);
        adapter2.setDropDownViewResource(androidx.transition.R.layout.support_simple_spinner_dropdown_item);
        binding.spinnerAttendanceDivision.setAdapter(adapter2);
        binding.spinnerAttendanceDivision.setOnItemSelectedListener(this);

        ArrayAdapter<CharSequence> dep = ArrayAdapter.createFromResource(this, R.array.department_type, android.R.layout.simple_spinner_item);
        dep.setDropDownViewResource(androidx.transition.R.layout.support_simple_spinner_dropdown_item);
        binding.spinnerAttendanceDepartment.setAdapter(dep);
        binding.spinnerAttendanceDepartment.setOnItemSelectedListener(this);

        binding.submit.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                String department = binding.spinnerAttendanceDepartment.getSelectedItem().toString();
                String year = binding.spinnerAttendanceYear.getSelectedItem().toString();
                String division = binding.spinnerAttendanceDivision.getSelectedItem().toString();

                Intent intent = new Intent(getApplicationContext(),ShowAttendance.class);
                intent.putExtra("dep",department);
                intent.putExtra("yea",year);
                intent.putExtra("div",division);
                startActivity(intent);


            }
        });





    }

    @Override
    public void onItemSelected(AdapterView<?> adapterView, View view, int i, long l) {

    }

    @Override
    public void onNothingSelected(AdapterView<?> adapterView) {

    }
}