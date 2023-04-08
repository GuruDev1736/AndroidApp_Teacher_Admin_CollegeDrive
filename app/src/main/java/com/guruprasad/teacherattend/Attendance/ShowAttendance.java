package com.guruprasad.teacherattend.Attendance;

import static com.guruprasad.teacherattend.Constants.error_toast;
import static com.guruprasad.teacherattend.Constants.info_toast;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;

import android.annotation.SuppressLint;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.view.WindowManager;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.Toast;

import com.firebase.ui.database.FirebaseRecyclerOptions;
import com.google.android.material.datepicker.CalendarConstraints;
import com.google.android.material.datepicker.DateValidatorPointBackward;
import com.google.android.material.datepicker.MaterialDatePicker;
import com.google.android.material.datepicker.MaterialPickerOnPositiveButtonClickListener;
import com.google.firebase.database.FirebaseDatabase;
import com.guruprasad.teacherattend.R;
import com.guruprasad.teacherattend.adapter.AttendanceRecordAdapter;
import com.guruprasad.teacherattend.attendance_student;
import com.guruprasad.teacherattend.databinding.ActivityShowAttendanceBinding;
import com.guruprasad.teacherattend.model.attendance_combine_model;
import com.guruprasad.teacherattend.model.attendance_model;

import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Objects;
import java.util.TimeZone;

import es.dmoral.toasty.Toasty;

public class ShowAttendance extends AppCompatActivity implements AdapterView.OnItemSelectedListener {

    ActivityShowAttendanceBinding binding ;
    AttendanceRecordAdapter adapter ;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        binding = ActivityShowAttendanceBinding.inflate(getLayoutInflater());
        setContentView(binding.getRoot());
        Objects.requireNonNull(getSupportActionBar()).setTitle("Attendance");
        getWindow().setFlags(WindowManager.LayoutParams.FLAG_FULLSCREEN,WindowManager.LayoutParams.FLAG_FULLSCREEN);
        getSupportActionBar().setDisplayHomeAsUpEnabled(true);
        getSupportActionBar().setDisplayShowHomeEnabled(true);


                try {
                    CalendarConstraints.Builder calendarConstraintBuilder = new CalendarConstraints.Builder();
                    calendarConstraintBuilder.setValidator(DateValidatorPointBackward.now());

                    MaterialDatePicker.Builder materialDateBuilder = MaterialDatePicker.Builder.datePicker();
                    long today = MaterialDatePicker.todayInUtcMilliseconds();
                    materialDateBuilder.setSelection(today);
                    materialDateBuilder.setTitleText("SELECT ATTENDANCE DATE");

                    materialDateBuilder.setCalendarConstraints(calendarConstraintBuilder.build());
                    final MaterialDatePicker materialDatePicker = materialDateBuilder.build();

                    binding.datePicker.setOnClickListener(new View.OnClickListener() {
                        @Override
                        public void onClick(View view) {
                            materialDatePicker.show(getSupportFragmentManager(), "MATERIAL_DATE_PICKER");
                        }
                    });

                    materialDatePicker.addOnPositiveButtonClickListener(
                            new MaterialPickerOnPositiveButtonClickListener() {
                                @SuppressLint("SetTextI18n")
                                @Override
                                public void onPositiveButtonClick(Object selection) {

                                    Calendar calendar  = Calendar.getInstance(TimeZone.getTimeZone("UTC"));
                                    calendar.setTimeInMillis((Long) selection);
                                    SimpleDateFormat format = new SimpleDateFormat("dd MM yyyy");
                                    String formatteddate = format.format(calendar.getTime());


//                                    binding.dateAttend.setText(materialDatePicker.getHeaderText());
                                    binding.dateAttend.setText(formatteddate);

                                }
                            });

                    materialDatePicker.addOnNegativeButtonClickListener(new View.OnClickListener() {
                        @Override
                        public void onClick(View view) {
                            info_toast(getApplicationContext(),"Date Required");
                        }
                    });

                } catch (Exception e) {
                    Toasty.error(ShowAttendance.this,"Error : "+e.getMessage(),Toasty.LENGTH_LONG,true).show();
                }



        Intent intent = getIntent() ;

        String department  = intent.getStringExtra("dep");
        String year  = intent.getStringExtra("yea");
        String division  = intent.getStringExtra("div");




        if (department.equals("Computer") && year.equals("First Year"))
        {
            ArrayAdapter<CharSequence> sub = ArrayAdapter.createFromResource(ShowAttendance.this, R.array.first_comp, android.R.layout.simple_spinner_item);
            sub.setDropDownViewResource(androidx.transition.R.layout.support_simple_spinner_dropdown_item);
            binding.spinnerAttendanceSubject.setAdapter(sub);

        }

        if (department.equals("Computer") && year.equals("Second Year"))
        {
            ArrayAdapter<CharSequence> sub = ArrayAdapter.createFromResource(ShowAttendance.this, R.array.second_comp, android.R.layout.simple_spinner_item);
            sub.setDropDownViewResource(androidx.transition.R.layout.support_simple_spinner_dropdown_item);
            binding.spinnerAttendanceSubject.setAdapter(sub);

        }

        if (department.equals("Computer") && year.equals("Third Year"))
        {
            ArrayAdapter<CharSequence> sub = ArrayAdapter.createFromResource(ShowAttendance.this, R.array.third_comp, android.R.layout.simple_spinner_item);
            sub.setDropDownViewResource(androidx.transition.R.layout.support_simple_spinner_dropdown_item);
            binding.spinnerAttendanceSubject.setAdapter(sub);

        }

        if (department.equals("Mechanical") && year.equals("First Year"))
        {
            ArrayAdapter<CharSequence> sub = ArrayAdapter.createFromResource(ShowAttendance.this, R.array.first_mech, android.R.layout.simple_spinner_item);
            sub.setDropDownViewResource(androidx.transition.R.layout.support_simple_spinner_dropdown_item);
            binding.spinnerAttendanceSubject.setAdapter(sub);

        }

        if (department.equals("Mechanical") && year.equals("Second Year"))
        {
            ArrayAdapter<CharSequence> sub = ArrayAdapter.createFromResource(ShowAttendance.this, R.array.second_mech, android.R.layout.simple_spinner_item);
            sub.setDropDownViewResource(androidx.transition.R.layout.support_simple_spinner_dropdown_item);
            binding.spinnerAttendanceSubject.setAdapter(sub);

        }

        if (department.equals("Mechanical") && year.equals("Third Year"))
        {
            ArrayAdapter<CharSequence> sub = ArrayAdapter.createFromResource(ShowAttendance.this, R.array.third_mech, android.R.layout.simple_spinner_item);
            sub.setDropDownViewResource(androidx.transition.R.layout.support_simple_spinner_dropdown_item);
            binding.spinnerAttendanceSubject.setAdapter(sub);

        }

        if (department.equals("Civil") && year.equals("First Year"))
        {
            ArrayAdapter<CharSequence> sub = ArrayAdapter.createFromResource(ShowAttendance.this, R.array.first_civil, android.R.layout.simple_spinner_item);
            sub.setDropDownViewResource(androidx.transition.R.layout.support_simple_spinner_dropdown_item);
            binding.spinnerAttendanceSubject.setAdapter(sub);

        }

        if (department.equals("Civil") && year.equals("Second Year"))
        {
            ArrayAdapter<CharSequence> sub = ArrayAdapter.createFromResource(ShowAttendance.this, R.array.second_civil, android.R.layout.simple_spinner_item);
            sub.setDropDownViewResource(androidx.transition.R.layout.support_simple_spinner_dropdown_item);
            binding.spinnerAttendanceSubject.setAdapter(sub);

        }
        if (department.equals("Civil") && year.equals("Third Year"))
        {
            ArrayAdapter<CharSequence> sub = ArrayAdapter.createFromResource(ShowAttendance.this, R.array.third_civil, android.R.layout.simple_spinner_item);
            sub.setDropDownViewResource(androidx.transition.R.layout.support_simple_spinner_dropdown_item);
            binding.spinnerAttendanceSubject.setAdapter(sub);

        }
        if (department.equals("E amd TC") && year.equals("First Year"))
        {
            ArrayAdapter<CharSequence> sub = ArrayAdapter.createFromResource(ShowAttendance.this, R.array.first_E_and_TC, android.R.layout.simple_spinner_item);
            sub.setDropDownViewResource(androidx.transition.R.layout.support_simple_spinner_dropdown_item);
            binding.spinnerAttendanceSubject.setAdapter(sub);

        }
        if (department.equals("E amd TC") && year.equals("Second Year"))
        {
            ArrayAdapter<CharSequence> sub = ArrayAdapter.createFromResource(ShowAttendance.this, R.array.second_E_and_TC, android.R.layout.simple_spinner_item);
            sub.setDropDownViewResource(androidx.transition.R.layout.support_simple_spinner_dropdown_item);
            binding.spinnerAttendanceSubject.setAdapter(sub);

        }
        if (department.equals("E amd TC") && year.equals("Third Year"))
        {
            ArrayAdapter<CharSequence> sub = ArrayAdapter.createFromResource(ShowAttendance.this, R.array.third_E_and_TC, android.R.layout.simple_spinner_item);
            sub.setDropDownViewResource(androidx.transition.R.layout.support_simple_spinner_dropdown_item);
            binding.spinnerAttendanceSubject.setAdapter(sub);

        }
        if (department.equals("IT") && year.equals("First Year"))
        {
            ArrayAdapter<CharSequence> sub = ArrayAdapter.createFromResource(ShowAttendance.this, R.array.first_IT, android.R.layout.simple_spinner_item);
            sub.setDropDownViewResource(androidx.transition.R.layout.support_simple_spinner_dropdown_item);
            binding.spinnerAttendanceSubject.setAdapter(sub);

        }
        if (department.equals("IT") && year.equals("Second Year"))
        {
            ArrayAdapter<CharSequence> sub = ArrayAdapter.createFromResource(ShowAttendance.this, R.array.second_IT, android.R.layout.simple_spinner_item);
            sub.setDropDownViewResource(androidx.transition.R.layout.support_simple_spinner_dropdown_item);
            binding.spinnerAttendanceSubject.setAdapter(sub);

        }
        if (department.equals("IT") && year.equals("Third Year"))
        {
            ArrayAdapter<CharSequence> sub = ArrayAdapter.createFromResource(ShowAttendance.this, R.array.third_IT, android.R.layout.simple_spinner_item);
            sub.setDropDownViewResource(androidx.transition.R.layout.support_simple_spinner_dropdown_item);
            binding.spinnerAttendanceSubject.setAdapter(sub);

        }
        if (department.equals("Pharmacy") && year.equals("First Year"))
        {
            ArrayAdapter<CharSequence> sub = ArrayAdapter.createFromResource(ShowAttendance.this, R.array.first_pharmacy, android.R.layout.simple_spinner_item);
            sub.setDropDownViewResource(androidx.transition.R.layout.support_simple_spinner_dropdown_item);
            binding.spinnerAttendanceSubject.setAdapter(sub);

        }
        if (department.equals("Pharmacy") && year.equals("Second Year"))
        {
            ArrayAdapter<CharSequence> sub = ArrayAdapter.createFromResource(ShowAttendance.this, R.array.second_pharmacy, android.R.layout.simple_spinner_item);
            sub.setDropDownViewResource(androidx.transition.R.layout.support_simple_spinner_dropdown_item);
            binding.spinnerAttendanceSubject.setAdapter(sub);

        }
        if (department.equals("Pharmacy") && year.equals("Third Year"))
        {
            ArrayAdapter<CharSequence> sub = ArrayAdapter.createFromResource(ShowAttendance.this, R.array.third_pharmacy, android.R.layout.simple_spinner_item);
            sub.setDropDownViewResource(androidx.transition.R.layout.support_simple_spinner_dropdown_item);
            binding.spinnerAttendanceSubject.setAdapter(sub);

        }


        binding.submitAttend.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                String date = binding.dateAttend.getText().toString();
                String subject = binding.spinnerAttendanceSubject.getSelectedItem().toString();


                if (date.equals("DATE"))
                {
                    error_toast(getApplicationContext(),"Please Select the Date");

                }
                else
                {
                    String sub_no = String.valueOf(binding.numberPicker.getValue());
                    binding.showAttend.setLayoutManager(new LinearLayoutManager(ShowAttendance.this));
                    FirebaseRecyclerOptions<attendance_model> options = new FirebaseRecyclerOptions.Builder<attendance_model>().setQuery(FirebaseDatabase.getInstance().
                            getReference("Attendance").child(department).child(year).child(division).child(date).child(subject).child(sub_no), attendance_model.class).build();
                    adapter = new AttendanceRecordAdapter(options);
                    adapter.startListening();
                    binding.showAttend.setAdapter(adapter);

                }
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