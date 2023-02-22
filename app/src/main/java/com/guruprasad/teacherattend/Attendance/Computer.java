package com.guruprasad.teacherattend.Attendance;

import static com.guruprasad.teacherattend.Constants.error_toast;

import androidx.appcompat.app.AppCompatActivity;

import android.annotation.SuppressLint;
import android.content.Intent;
import android.icu.text.SimpleDateFormat;
import android.os.Build;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.ImageButton;
import android.widget.Spinner;
import android.widget.TextView;

import com.google.android.material.datepicker.CalendarConstraints;
import com.google.android.material.datepicker.DateValidatorPointBackward;
import com.google.android.material.datepicker.MaterialDatePicker;
import com.google.android.material.datepicker.MaterialPickerOnPositiveButtonClickListener;
import com.guruprasad.teacherattend.R;
import com.guruprasad.teacherattend.adapter.attendance_adapter;
import com.guruprasad.teacherattend.attendance_student;

import java.util.Date;
import java.util.Locale;

import es.dmoral.toasty.Toasty;

public class Computer extends AppCompatActivity implements AdapterView.OnItemSelectedListener {
        Spinner year , division ;
        Button submit ;
        TextView date ;
        ImageButton button ;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_computer2);

        year = findViewById(R.id.computer_spinner_attendance_year);
        division = findViewById(R.id.computer_spinner_attendance_division);
        submit = findViewById(R.id.submit_attendance);
        button = findViewById(R.id.calender);
        date = findViewById(R.id.date);


        ArrayAdapter<CharSequence> adapter = ArrayAdapter.createFromResource(this, R.array.year, android.R.layout.simple_spinner_item);
        adapter.setDropDownViewResource(androidx.transition.R.layout.support_simple_spinner_dropdown_item);
        year.setAdapter(adapter);
        year.setOnItemSelectedListener(this);

        ArrayAdapter<CharSequence> adapter2 = ArrayAdapter.createFromResource(this, R.array.division, android.R.layout.simple_spinner_item);
        adapter2.setDropDownViewResource(androidx.transition.R.layout.support_simple_spinner_dropdown_item);
        division.setAdapter(adapter2);
        division.setOnItemSelectedListener(this);


        String Date = null;
        if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.N) {
            Date = new SimpleDateFormat("dd-MM-yyyy", Locale.getDefault()).format(new Date());
        }

        date.setText(Date);



        submit.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                String Year = year.getSelectedItem().toString();
                String div  = division.getSelectedItem().toString();
                String Date = date.getText().toString();

                Intent intent = new Intent(getApplicationContext(), attendance_student.class);
                intent.putExtra("year",Year);
                intent.putExtra("div",div);
                intent.putExtra("date",Date);
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