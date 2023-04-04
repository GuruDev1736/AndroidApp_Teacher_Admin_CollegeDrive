package com.guruprasad.teacherattend.submission;

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

public class Assignment extends AppCompatActivity implements AdapterView.OnItemSelectedListener {
    Spinner y , division , subject , depart ;
    ImageButton get_sub ;
    Button submit ;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_assignment);

        y = findViewById(R.id.spinner_attendance_year);
        division = findViewById(R.id.spinner_attendance_division);
        subject = findViewById(R.id.spinner_attendance_subject);
        depart = findViewById(R.id.spinner_attendance_department);
        get_sub = findViewById(R.id.get_sub);
        submit = findViewById(R.id.submit_assignment);

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



    }

    @Override
    public void onBackPressed() {
        super.onBackPressed();
    }

    @Override
    public void onItemSelected(AdapterView<?> adapterView, View view, int i, long l) {
        get_sub.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                String department = depart.getSelectedItem().toString();
                String year = y.getSelectedItem().toString();

                if (department.equals("Computer") && year.equals("First Year"))
                {
                    ArrayAdapter<CharSequence> sub = ArrayAdapter.createFromResource(view.getContext(), R.array.first_comp, android.R.layout.simple_spinner_item);
                    sub.setDropDownViewResource(androidx.transition.R.layout.support_simple_spinner_dropdown_item);
                    subject.setAdapter(sub);

                }

                if (department.equals("Computer") && year.equals("Second Year"))
                {
                    ArrayAdapter<CharSequence> sub = ArrayAdapter.createFromResource(view.getContext(), R.array.second_comp, android.R.layout.simple_spinner_item);
                    sub.setDropDownViewResource(androidx.transition.R.layout.support_simple_spinner_dropdown_item);
                    subject.setAdapter(sub);

                }

                if (department.equals("Computer") && year.equals("Third Year"))
                {
                    ArrayAdapter<CharSequence> sub = ArrayAdapter.createFromResource(view.getContext(), R.array.third_comp, android.R.layout.simple_spinner_item);
                    sub.setDropDownViewResource(androidx.transition.R.layout.support_simple_spinner_dropdown_item);
                    subject.setAdapter(sub);

                }

                if (department.equals("Mechanical") && year.equals("First Year"))
                {
                    ArrayAdapter<CharSequence> sub = ArrayAdapter.createFromResource(view.getContext(), R.array.first_mech, android.R.layout.simple_spinner_item);
                    sub.setDropDownViewResource(androidx.transition.R.layout.support_simple_spinner_dropdown_item);
                    subject.setAdapter(sub);

                }

                if (department.equals("Mechanical") && year.equals("Second Year"))
                {
                    ArrayAdapter<CharSequence> sub = ArrayAdapter.createFromResource(view.getContext(), R.array.second_mech, android.R.layout.simple_spinner_item);
                    sub.setDropDownViewResource(androidx.transition.R.layout.support_simple_spinner_dropdown_item);
                    subject.setAdapter(sub);

                }

                if (department.equals("Mechanical") && year.equals("Third Year"))
                {
                    ArrayAdapter<CharSequence> sub = ArrayAdapter.createFromResource(view.getContext(), R.array.third_mech, android.R.layout.simple_spinner_item);
                    sub.setDropDownViewResource(androidx.transition.R.layout.support_simple_spinner_dropdown_item);
                    subject.setAdapter(sub);

                }

                if (department.equals("Civil") && year.equals("First Year"))
                {
                    ArrayAdapter<CharSequence> sub = ArrayAdapter.createFromResource(view.getContext(), R.array.first_civil, android.R.layout.simple_spinner_item);
                    sub.setDropDownViewResource(androidx.transition.R.layout.support_simple_spinner_dropdown_item);
                    subject.setAdapter(sub);

                }

                if (department.equals("Civil") && year.equals("Second Year"))
                {
                    ArrayAdapter<CharSequence> sub = ArrayAdapter.createFromResource(view.getContext(), R.array.second_civil, android.R.layout.simple_spinner_item);
                    sub.setDropDownViewResource(androidx.transition.R.layout.support_simple_spinner_dropdown_item);
                    subject.setAdapter(sub);

                }
                if (department.equals("Civil") && year.equals("Third Year"))
                {
                    ArrayAdapter<CharSequence> sub = ArrayAdapter.createFromResource(view.getContext(), R.array.third_civil, android.R.layout.simple_spinner_item);
                    sub.setDropDownViewResource(androidx.transition.R.layout.support_simple_spinner_dropdown_item);
                    subject.setAdapter(sub);

                }
                if (department.equals("E amd TC") && year.equals("First Year"))
                {
                    ArrayAdapter<CharSequence> sub = ArrayAdapter.createFromResource(view.getContext(), R.array.first_E_and_TC, android.R.layout.simple_spinner_item);
                    sub.setDropDownViewResource(androidx.transition.R.layout.support_simple_spinner_dropdown_item);
                    subject.setAdapter(sub);

                }
                if (department.equals("E amd TC") && year.equals("Second Year"))
                {
                    ArrayAdapter<CharSequence> sub = ArrayAdapter.createFromResource(view.getContext(), R.array.second_E_and_TC, android.R.layout.simple_spinner_item);
                    sub.setDropDownViewResource(androidx.transition.R.layout.support_simple_spinner_dropdown_item);
                    subject.setAdapter(sub);

                }
                if (department.equals("E amd TC") && year.equals("Third Year"))
                {
                    ArrayAdapter<CharSequence> sub = ArrayAdapter.createFromResource(view.getContext(), R.array.third_E_and_TC, android.R.layout.simple_spinner_item);
                    sub.setDropDownViewResource(androidx.transition.R.layout.support_simple_spinner_dropdown_item);
                    subject.setAdapter(sub);

                }
                if (department.equals("IT") && year.equals("First Year"))
                {
                    ArrayAdapter<CharSequence> sub = ArrayAdapter.createFromResource(view.getContext(), R.array.first_IT, android.R.layout.simple_spinner_item);
                    sub.setDropDownViewResource(androidx.transition.R.layout.support_simple_spinner_dropdown_item);
                    subject.setAdapter(sub);

                }
                if (department.equals("IT") && year.equals("Second Year"))
                {
                    ArrayAdapter<CharSequence> sub = ArrayAdapter.createFromResource(view.getContext(), R.array.second_IT, android.R.layout.simple_spinner_item);
                    sub.setDropDownViewResource(androidx.transition.R.layout.support_simple_spinner_dropdown_item);
                    subject.setAdapter(sub);

                }
                if (department.equals("IT") && year.equals("Third Year"))
                {
                    ArrayAdapter<CharSequence> sub = ArrayAdapter.createFromResource(view.getContext(), R.array.third_IT, android.R.layout.simple_spinner_item);
                    sub.setDropDownViewResource(androidx.transition.R.layout.support_simple_spinner_dropdown_item);
                    subject.setAdapter(sub);

                }
                if (department.equals("Pharmacy") && year.equals("First Year"))
                {
                    ArrayAdapter<CharSequence> sub = ArrayAdapter.createFromResource(view.getContext(), R.array.first_pharmacy, android.R.layout.simple_spinner_item);
                    sub.setDropDownViewResource(androidx.transition.R.layout.support_simple_spinner_dropdown_item);
                    subject.setAdapter(sub);

                }
                if (department.equals("Pharmacy") && year.equals("Second Year"))
                {
                    ArrayAdapter<CharSequence> sub = ArrayAdapter.createFromResource(view.getContext(), R.array.second_pharmacy, android.R.layout.simple_spinner_item);
                    sub.setDropDownViewResource(androidx.transition.R.layout.support_simple_spinner_dropdown_item);
                    subject.setAdapter(sub);

                }
                if (department.equals("Pharmacy") && year.equals("Third Year"))
                {
                    ArrayAdapter<CharSequence> sub = ArrayAdapter.createFromResource(view.getContext(), R.array.third_pharmacy, android.R.layout.simple_spinner_item);
                    sub.setDropDownViewResource(androidx.transition.R.layout.support_simple_spinner_dropdown_item);
                    subject.setAdapter(sub);

                }




            }
        });

        submit.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                String sub_year = y.getSelectedItem().toString();
                String sub_div = division.getSelectedItem().toString();
                String sub_subject = subject.getSelectedItem().toString();
                String sub_department = depart.getSelectedItem().toString();


                Intent intent = new Intent(getApplicationContext(),assignment_submission_activity.class);
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
}