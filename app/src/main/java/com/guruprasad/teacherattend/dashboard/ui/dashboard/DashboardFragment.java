package com.guruprasad.teacherattend.dashboard.ui.dashboard;

import static com.guruprasad.teacherattend.Constants.error_toast;
import static com.guruprasad.teacherattend.Constants.info_toast;

import android.annotation.SuppressLint;
import android.content.Intent;
import android.os.Build;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;

import androidx.annotation.NonNull;
import androidx.fragment.app.Fragment;

import com.google.android.material.datepicker.CalendarConstraints;
import com.google.android.material.datepicker.DateValidatorPointBackward;
import com.google.android.material.datepicker.MaterialDatePicker;
import com.google.android.material.datepicker.MaterialPickerOnPositiveButtonClickListener;
import com.guruprasad.teacherattend.Attendance.ShowAttendance;
import com.guruprasad.teacherattend.R;
import com.guruprasad.teacherattend.attendance_student;
import com.guruprasad.teacherattend.databinding.FragmentDashboardBinding;

import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;
import java.util.Locale;
import java.util.TimeZone;

import es.dmoral.toasty.Toasty;

public class DashboardFragment extends Fragment implements AdapterView.OnItemSelectedListener {

    private FragmentDashboardBinding binding;


    public View onCreateView(@NonNull LayoutInflater inflater,
                             ViewGroup container, Bundle savedInstanceState) {

        binding = FragmentDashboardBinding.inflate(inflater, container, false);
        View root = binding.getRoot();


        ArrayAdapter<CharSequence> adapter = ArrayAdapter.createFromResource(binding.getRoot().getContext(), R.array.year, android.R.layout.simple_spinner_item);
        adapter.setDropDownViewResource(androidx.transition.R.layout.support_simple_spinner_dropdown_item);
        binding.spinnerAttendanceYear.setAdapter(adapter);
        binding.spinnerAttendanceYear.setOnItemSelectedListener(this);

        ArrayAdapter<CharSequence> adapter2 = ArrayAdapter.createFromResource(binding.getRoot().getContext(), R.array.division, android.R.layout.simple_spinner_item);
        adapter2.setDropDownViewResource(androidx.transition.R.layout.support_simple_spinner_dropdown_item);
        binding.spinnerAttendanceDivision.setAdapter(adapter2);
        binding.spinnerAttendanceDivision.setOnItemSelectedListener(this);

//        ArrayAdapter<CharSequence> sub = ArrayAdapter.createFromResource(binding.getRoot().getContext(), R.array.computer_subjects, android.R.layout.simple_spinner_item);
//        sub.setDropDownViewResource(androidx.transition.R.layout.support_simple_spinner_dropdown_item);
//        binding.spinnerAttendanceSubject.setAdapter(sub);
//        binding.spinnerAttendanceSubject.setOnItemSelectedListener(this);

        ArrayAdapter<CharSequence> dep = ArrayAdapter.createFromResource(binding.getRoot().getContext(), R.array.department_type, android.R.layout.simple_spinner_item);
        dep.setDropDownViewResource(androidx.transition.R.layout.support_simple_spinner_dropdown_item);
        binding.spinnerAttendanceDepartment.setAdapter(dep);
        binding.spinnerAttendanceDepartment.setOnItemSelectedListener(this);

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
                    materialDatePicker.show(getActivity().getSupportFragmentManager(), "MATERIAL_DATE_PICKER");
                }
            });

            materialDatePicker.addOnPositiveButtonClickListener(
                    new MaterialPickerOnPositiveButtonClickListener() {
                        @SuppressLint("SetTextI18n")
                        @Override
                        public void onPositiveButtonClick(Object selection) {

                            Calendar calendar  = Calendar.getInstance(TimeZone.getTimeZone("UTC"));
                            calendar.setTimeInMillis((Long) selection);
                            java.text.SimpleDateFormat format = new SimpleDateFormat("dd MM yyyy");
                            String formatteddate = format.format(calendar.getTime());


                            binding.dateAttend.setText(formatteddate);

                        }
                    });

            materialDatePicker.addOnNegativeButtonClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View view) {
                    info_toast(getContext(),"Date is required");
                }
            });

        } catch (Exception e) {
            Toasty.error(getContext(),"Error : "+e.getMessage(),Toasty.LENGTH_LONG,true).show();
        }



        return root;
    }

    @Override
    public void onDestroyView() {
        super.onDestroyView();
        binding = null;
    }

    @Override
    public void onItemSelected(AdapterView<?> adapterView, View view, int i, long l) {


        String department = binding.spinnerAttendanceDepartment.getSelectedItem().toString();
        String year= binding.spinnerAttendanceYear.getSelectedItem().toString();

        binding.getSub.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                if (department.equals("Computer") && year.equals("First Year"))
                {
                    ArrayAdapter<CharSequence> sub = ArrayAdapter.createFromResource(binding.getRoot().getContext(), R.array.first_comp, android.R.layout.simple_spinner_item);
                    sub.setDropDownViewResource(androidx.transition.R.layout.support_simple_spinner_dropdown_item);
                    binding.spinnerAttendanceSubject.setAdapter(sub);

                }

                if (department.equals("Computer") && year.equals("Second Year"))
                {
                    ArrayAdapter<CharSequence> sub = ArrayAdapter.createFromResource(binding.getRoot().getContext(), R.array.second_comp, android.R.layout.simple_spinner_item);
                    sub.setDropDownViewResource(androidx.transition.R.layout.support_simple_spinner_dropdown_item);
                    binding.spinnerAttendanceSubject.setAdapter(sub);

                }

                if (department.equals("Computer") && year.equals("Third Year"))
                {
                    ArrayAdapter<CharSequence> sub = ArrayAdapter.createFromResource(binding.getRoot().getContext(), R.array.third_comp, android.R.layout.simple_spinner_item);
                    sub.setDropDownViewResource(androidx.transition.R.layout.support_simple_spinner_dropdown_item);
                    binding.spinnerAttendanceSubject.setAdapter(sub);

                }

                if (department.equals("Mechanical") && year.equals("First Year"))
                {
                    ArrayAdapter<CharSequence> sub = ArrayAdapter.createFromResource(binding.getRoot().getContext(), R.array.first_mech, android.R.layout.simple_spinner_item);
                    sub.setDropDownViewResource(androidx.transition.R.layout.support_simple_spinner_dropdown_item);
                    binding.spinnerAttendanceSubject.setAdapter(sub);

                }

                 if (department.equals("Mechanical") && year.equals("Second Year"))
                {
                    ArrayAdapter<CharSequence> sub = ArrayAdapter.createFromResource(binding.getRoot().getContext(), R.array.second_mech, android.R.layout.simple_spinner_item);
                    sub.setDropDownViewResource(androidx.transition.R.layout.support_simple_spinner_dropdown_item);
                    binding.spinnerAttendanceSubject.setAdapter(sub);

                }

                 if (department.equals("Mechanical") && year.equals("Third Year"))
                {
                    ArrayAdapter<CharSequence> sub = ArrayAdapter.createFromResource(binding.getRoot().getContext(), R.array.third_mech, android.R.layout.simple_spinner_item);
                    sub.setDropDownViewResource(androidx.transition.R.layout.support_simple_spinner_dropdown_item);
                    binding.spinnerAttendanceSubject.setAdapter(sub);

                }

                 if (department.equals("Civil") && year.equals("First Year"))
                {
                    ArrayAdapter<CharSequence> sub = ArrayAdapter.createFromResource(binding.getRoot().getContext(), R.array.first_civil, android.R.layout.simple_spinner_item);
                    sub.setDropDownViewResource(androidx.transition.R.layout.support_simple_spinner_dropdown_item);
                    binding.spinnerAttendanceSubject.setAdapter(sub);

                }

                 if (department.equals("Civil") && year.equals("Second Year"))
                {
                    ArrayAdapter<CharSequence> sub = ArrayAdapter.createFromResource(binding.getRoot().getContext(), R.array.second_civil, android.R.layout.simple_spinner_item);
                    sub.setDropDownViewResource(androidx.transition.R.layout.support_simple_spinner_dropdown_item);
                    binding.spinnerAttendanceSubject.setAdapter(sub);

                }
                 if (department.equals("Civil") && year.equals("Third Year"))
                {
                    ArrayAdapter<CharSequence> sub = ArrayAdapter.createFromResource(binding.getRoot().getContext(), R.array.third_civil, android.R.layout.simple_spinner_item);
                    sub.setDropDownViewResource(androidx.transition.R.layout.support_simple_spinner_dropdown_item);
                    binding.spinnerAttendanceSubject.setAdapter(sub);

                }
                   if (department.equals("E amd TC") && year.equals("First Year"))
                {
                    ArrayAdapter<CharSequence> sub = ArrayAdapter.createFromResource(binding.getRoot().getContext(), R.array.first_E_and_TC, android.R.layout.simple_spinner_item);
                    sub.setDropDownViewResource(androidx.transition.R.layout.support_simple_spinner_dropdown_item);
                    binding.spinnerAttendanceSubject.setAdapter(sub);

                }
                   if (department.equals("E amd TC") && year.equals("Second Year"))
                {
                    ArrayAdapter<CharSequence> sub = ArrayAdapter.createFromResource(binding.getRoot().getContext(), R.array.second_E_and_TC, android.R.layout.simple_spinner_item);
                    sub.setDropDownViewResource(androidx.transition.R.layout.support_simple_spinner_dropdown_item);
                    binding.spinnerAttendanceSubject.setAdapter(sub);

                }
                   if (department.equals("E amd TC") && year.equals("Third Year"))
                {
                    ArrayAdapter<CharSequence> sub = ArrayAdapter.createFromResource(binding.getRoot().getContext(), R.array.third_E_and_TC, android.R.layout.simple_spinner_item);
                    sub.setDropDownViewResource(androidx.transition.R.layout.support_simple_spinner_dropdown_item);
                    binding.spinnerAttendanceSubject.setAdapter(sub);

                }
                   if (department.equals("IT") && year.equals("First Year"))
                {
                    ArrayAdapter<CharSequence> sub = ArrayAdapter.createFromResource(binding.getRoot().getContext(), R.array.first_IT, android.R.layout.simple_spinner_item);
                    sub.setDropDownViewResource(androidx.transition.R.layout.support_simple_spinner_dropdown_item);
                    binding.spinnerAttendanceSubject.setAdapter(sub);

                }
                   if (department.equals("IT") && year.equals("Second Year"))
                {
                    ArrayAdapter<CharSequence> sub = ArrayAdapter.createFromResource(binding.getRoot().getContext(), R.array.second_IT, android.R.layout.simple_spinner_item);
                    sub.setDropDownViewResource(androidx.transition.R.layout.support_simple_spinner_dropdown_item);
                    binding.spinnerAttendanceSubject.setAdapter(sub);

                }
                   if (department.equals("IT") && year.equals("Third Year"))
                {
                    ArrayAdapter<CharSequence> sub = ArrayAdapter.createFromResource(binding.getRoot().getContext(), R.array.third_IT, android.R.layout.simple_spinner_item);
                    sub.setDropDownViewResource(androidx.transition.R.layout.support_simple_spinner_dropdown_item);
                    binding.spinnerAttendanceSubject.setAdapter(sub);

                }
                   if (department.equals("Pharmacy") && year.equals("First Year"))
                {
                    ArrayAdapter<CharSequence> sub = ArrayAdapter.createFromResource(binding.getRoot().getContext(), R.array.first_pharmacy, android.R.layout.simple_spinner_item);
                    sub.setDropDownViewResource(androidx.transition.R.layout.support_simple_spinner_dropdown_item);
                    binding.spinnerAttendanceSubject.setAdapter(sub);

                }
                   if (department.equals("Pharmacy") && year.equals("Second Year"))
                {
                    ArrayAdapter<CharSequence> sub = ArrayAdapter.createFromResource(binding.getRoot().getContext(), R.array.second_pharmacy, android.R.layout.simple_spinner_item);
                    sub.setDropDownViewResource(androidx.transition.R.layout.support_simple_spinner_dropdown_item);
                    binding.spinnerAttendanceSubject.setAdapter(sub);

                }
                   if (department.equals("Pharmacy") && year.equals("Third Year"))
                {
                    ArrayAdapter<CharSequence> sub = ArrayAdapter.createFromResource(binding.getRoot().getContext(), R.array.third_pharmacy, android.R.layout.simple_spinner_item);
                    sub.setDropDownViewResource(androidx.transition.R.layout.support_simple_spinner_dropdown_item);
                    binding.spinnerAttendanceSubject.setAdapter(sub);

                }











                binding.submitAttendance.setOnClickListener(new View.OnClickListener() {
                    @Override
                    public void onClick(View view) {

                        if (binding.dateAttend.getText().toString().equals("DATE"))
                        {
                            error_toast(getContext(),"Date Required");
                            return;
                        }

                        String Year = binding.spinnerAttendanceYear.getSelectedItem().toString();
                        String div  = binding.spinnerAttendanceDivision.getSelectedItem().toString();
                        String Date = binding.dateAttend.getText().toString();
                        String sub = binding.spinnerAttendanceSubject.getSelectedItem().toString();
                        String dep = binding.spinnerAttendanceDepartment.getSelectedItem().toString();
                        String sub_no = String.valueOf(binding.numberPicker.getValue());

                        Intent intent = new Intent(binding.getRoot().getContext(), attendance_student.class);
                        intent.putExtra("year",Year);
                        intent.putExtra("div",div);
                        intent.putExtra("date",Date);
                        intent.putExtra("sub",sub);
                        intent.putExtra("sub_no",sub_no);
                        intent.putExtra("dep",dep);
                        startActivity(intent);
                    }
                });
            }
        });



    }

    @Override
    public void onNothingSelected(AdapterView<?> adapterView) {

    }
}